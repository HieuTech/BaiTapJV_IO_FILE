package baitaptonghop.run;

import BaiTap.baitap8.config.ShopConfig;
import baitaptonghop.entity.Categories;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static CategoriesManagement categoriesManagement = new CategoriesManagement();
  private static ProductManagement productManagement = new ProductManagement();
    public static void main(String[] args) {
        while (true) {
            System.out.println("************SHOP MENU************\n");
            System.out.println("1. Quản lý danh mục sản phẩm ");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Sign out ");
            byte choice = ShopConfig.getByte();
            boolean isExist = false;
            switch (choice) {
                case 1:
                    categoriesManagement.displayCategoriesMenu();
                    break;
                case 2:
                    productManagement.displayProductMenu();
                    break;
                case 3:
                    System.exit(1);
                    break;
                default:
                    System.err.println("Your choice out of range");
                    break;
            }
            if (isExist) {
                break;
            }
        }

    }
}
