package baitaptonghop.run;

import BaiTap.baitap8.config.ShopConfig;
import baitaptonghop.design.ICategories;
import baitaptonghop.designImpl.CategoriesDesignImpl;

public class CategoriesManagement {
    private static ICategories iCategories = new CategoriesDesignImpl();

    public void displayCategoriesMenu() {
        while (true) {
            System.out.println("************CATEGORIES MENU************\n");
            System.out.println("1. Nhập thông tin các danh mục ");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục ");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Sign out ");
            byte choice = ShopConfig.getByte();
            boolean isExist = false;
            switch (choice) {
                case 1:
                    iCategories.addNew();

                    break;
                case 2:
                    iCategories.displayData();

                    break;
                case 3:
                    iCategories.editElement();

                    break;
                case 4:
                    iCategories.deleteElement();

                    break;
                case 5:
                    iCategories.updateStatus();
                    break;
                case 6:
                    isExist = true;
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
