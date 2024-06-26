package BaiTap.baitap8.designImpl;

import BaiTap.baitap8.config.AppendObjectOutputStream;
import BaiTap.baitap8.config.ShopConfig;
import BaiTap.baitap8.design.IProductDesign;
import BaiTap.baitap8.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IProductDesignImpl implements IProductDesign {
    public static List<Product> productList = new ArrayList<>();
    public String filePath = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/BaiTap/baitap8/config/baitap8.txt";

    @Override
    public Product findById(String id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addNew() {
        System.out.println("How many product you want to add");
        byte count = ShopConfig.getByte();
        for (int i = 1; i <= count; i++) {
            System.out.printf("Product Number %d \n", i);
            Product product = new Product();
            product.inputData(true, productList);
            productList.add(product);
        }
        System.out.println("Add successfully");
    }

    @Override
    public void displayAll() {
        if (productList.isEmpty()) {
            System.out.println("product list is empty");
        } else {
            productList.forEach(Product::displayData);

        }
    }

    @Override
    public void editElement() {
        System.out.println("Input ProductID");
        String productID = ShopConfig.getInput();
        Product updateProduct = findById(productID);
        if (updateProduct == null) {
            System.out.println("Product not found");
        } else {
            updateProduct.inputData(false, productList);
            System.out.println("Update successfully");
        }


    }

    @Override
    public void deleteElement() {
        System.out.println("Input ProductID");
        String productID = ShopConfig.getInput();
        Product deleteProduct = findById(productID);
        if (deleteProduct == null) {
            System.out.println("Product not found");
        } else {
            productList.remove(deleteProduct);
            System.out.println("Delete successfully");
        }

    }

    @Override
    public List<Product> readData() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Product> list = new ArrayList<>();
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            while (true) {
                Product product = (Product) ois.readObject();
                list.add(product);
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    @Override
    public void writeData() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file = new File(filePath);
        try {
            fos = new FileOutputStream(filePath);
            if (file.exists() && file.length() > 0) {
                oos = new AppendObjectOutputStream(fos);
            } else {
                oos = new ObjectOutputStream(fos);
            }

            for (Product product : IProductDesignImpl.productList) {
                oos.writeObject(product);
            }
            System.out.println("Write successfully");

        } catch (IOException e) {
            System.err.println("IO exception");
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
