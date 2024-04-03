package baitaptonghop.designImpl;

import baitaptonghop.config.AppendObjectOutputStream;
import baitaptonghop.config.IOFile;
import baitaptonghop.config.ShopConfig;
import baitaptonghop.design.ICategories;
import baitaptonghop.entity.Categories;
import baitaptonghop.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDesignImpl implements ICategories {
    public static List<Categories> categoriesList = new ArrayList<>();

    @Override
    public Categories findById(Integer id) {
        for (Categories categories : categoriesList) {
            if (categories.getCatalogId() == id) {
                return categories;
            }
        }
        return null;
    }

    @Override
    public void addNew() {
        System.out.println("How many categories you want to add");
        byte count = ShopConfig.getByte();
        for (int i = 1; i <= count; i++) {
            System.out.printf("Categories %d", i);
            Categories categories = new Categories();
            categories.inputData(true, categoriesList);
            categoriesList.add(categories);
        }
        IOFile.writeData(IOFile.PATH_CATEGORY, categoriesList);
        System.out.println("Add successfully");

    }

    @Override
    public void editElement() {
        System.out.println("Input categories ID");
        int categoriesID = ShopConfig.getInt();
        Categories categories = findById(categoriesID);
        if (categories == null) {
            System.err.println("Categories not found");
        } else {
            categories.inputData(false, categoriesList);
        }
        IOFile.writeData(IOFile.PATH_CATEGORY, categoriesList);
        System.out.println("Update successfully");
    }

    @Override
    public void displayData() {
        categoriesList.forEach(Categories::displayData);
        System.out.println("-----READ__DATA------");
        List<Categories> list = IOFile.readObjectFromFile(IOFile.PATH_CATEGORY);
        list.forEach(Categories::displayData);

    }

    @Override
    public void deleteElement() {
        System.out.println("Input categories ID");
        int categoriesID = ShopConfig.getInt();
        Categories categoriesDelete = findById(categoriesID);
        if (categoriesDelete != null) {
            if (ProductDesignImpl.productList.stream().noneMatch(p -> p.getCatalogId() == categoriesID)) {
                categoriesList.remove(categoriesDelete);
                System.out.println("Delete successfully");
            } else {
                System.out.println("Categories have some products, cant delete");
            }
        } else {
            System.err.println("Categories not found");
        }
        IOFile.writeData(IOFile.PATH_CATEGORY, categoriesList);

    }

    @Override
    public void updateStatus() {
        System.out.println("Input categories ID to update status");
        int categoriesID = ShopConfig.getInt();
        Categories categoriesUpdate = findById(categoriesID);
        if (categoriesUpdate == null) {
            System.err.println("Categories not found");
        } else {
            categoriesUpdate.setCatalogStatus(!categoriesUpdate.isCatalogStatus());
        }
        IOFile.writeData(IOFile.PATH_CATEGORY, categoriesList);
        System.out.println("Update status successfully");
    }


}
