package baitaptonghop.designImpl;

import baitaptonghop.config.AppendObjectOutputStream;
import baitaptonghop.config.IOFile;
import baitaptonghop.config.ShopConfig;
import baitaptonghop.design.IProduct;
import baitaptonghop.entity.Categories;
import baitaptonghop.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDesignImpl implements IProduct {
    public static List<Product> productList = new ArrayList<>();

    @Override
    public Product findById(String id) {
        for (Product product : productList) {
            if (product.getProductId().equals(id)) {
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
            Product product = new Product();
            product.inputData(true, CategoriesDesignImpl.categoriesList, productList);
            productList.add(product);
        }
        IOFile.writeData(IOFile.PATH_PRODUCT, productList);

        System.out.println("Add successfully");
    }

    @Override
    public void editElement() {
        System.out.println("input product id");
        String productID = ShopConfig.scanner.nextLine();
        Product product = findById(productID);
        if (product != null) {
            product.inputData(false, CategoriesDesignImpl.categoriesList, productList);
            System.out.println("Update successfully");

        } else {
            System.out.println("Product not found");
        }
         IOFile.writeData(IOFile.PATH_PRODUCT, productList);

    }

    @Override
    public void displayData() {
        productList.forEach(Product::displayData);
        System.out.println("-----READ__DATA-----");
        List<Categories> list =         IOFile.readObjectFromFile(IOFile.PATH_PRODUCT);
        list.forEach(Categories::displayData);
    }

    @Override
    public void deleteElement() {
        System.out.println("input product id");
        String productID = ShopConfig.scanner.nextLine();
        Product product = findById(productID);
        if (product != null) {
            productList.remove(product);
            System.out.println("Delete successfully");
        } else {
            System.out.println("Product not found");
        }
        IOFile.writeData(IOFile.PATH_PRODUCT, productList);

    }



    @Override
    public void sortByPrice() {
        System.out.println("Array after sort");
        productList.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(Product::displayData);
    }


    @Override
    public void findProductByName() {
        System.out.println("Input product Name to search");
        String productName = ShopConfig.scanner.nextLine();
        if (productList.stream().anyMatch(p -> p.getProductName().contains(productName))) {
            productList.stream().filter(p -> p.getProductName().contains(productName)).forEach(Product::displayData);
        } else {
            System.err.println("Product not found");
        }

    }

    @Override
    public void findProductByRangePrice() {
        System.out.println("Input from price");
        float fromPrice = ShopConfig.getFLoat();
        System.out.println("Input to price");
        float toPrice = ShopConfig.getFLoat();
        if (fromPrice < toPrice) {
            if (productList.stream().anyMatch(p -> p.getPrice() > fromPrice && p.getPrice() < toPrice)) {

                productList.stream().filter(p -> p.getPrice() > fromPrice && p.getPrice() < toPrice).forEach(Product::displayData);
            } else {
                System.err.println("Product not found");
            }
        } else {
            System.err.println("From Price must less than To Price");
        }

    }
}
