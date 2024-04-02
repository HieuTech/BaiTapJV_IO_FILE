package BaiTap.baitap7;

import demo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaiTap7 {

    public static void main(String[] args) {
        String filePath = "baitap7.txt";
        Product product = new Product();
        product.setId(1);
        product.setProductDesc("Desc");
        product.setProductName("Java");

        writeData(filePath, product);
        List<Product> list = readData(filePath);

        for (Product productItem : list) {
            System.out.printf("| ID: %d | Name: %s \n ", productItem.getId(), productItem.getProductName());
        }

    }

    public static List<Product> readData(String filePath) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Product> productList = new ArrayList<>();
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);

            while (true) {
                Product product = (Product) ois.readObject();
                productList.add(product);
            }


        } catch (IOException | ClassNotFoundException e) {

        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return productList;
    }


    public static void writeData(String filePath, Product product) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file = new File(filePath);
        try {
            fos = new FileOutputStream(filePath, true);
            if (file.exists() && file.length() > 0) {
                oos = new AppendObjectOutputStream(fos);
            } else {
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(product);
            System.out.println("Write successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
