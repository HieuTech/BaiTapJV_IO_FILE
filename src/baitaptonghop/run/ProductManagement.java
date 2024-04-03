package baitaptonghop.run;

import BaiTap.baitap8.config.ShopConfig;
import BaiTap.baitap8.design.IProductDesign;
import BaiTap.baitap8.designImpl.IProductDesignImpl;
import baitaptonghop.design.IProduct;
import baitaptonghop.designImpl.ProductDesignImpl;

public class ProductManagement {
    private static IProduct iProductDesign = new ProductDesignImpl();

    public void displayProductMenu(){
        while (true) {
            System.out.println("************PRODUCT MENU************\n");
            System.out.println("1. Nhập thông tin các sản phẩm ");
            System.out.println("2. Hiển thị thông tin các sản phẩm" );
            System.out.println("3. Cập nhật thông tin sản phẩm ");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp các sản phẩm theo giá");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Sign out ");
            byte choice = ShopConfig.getByte();
            boolean isExist = false;
            switch (choice) {
                case 1:
                    iProductDesign.addNew();
                    break;
                case 2:
                    iProductDesign.displayData();
                    System.out.println("------READ_DATA---------");
                    break;
                case 3:
                    iProductDesign.editElement();
                    break;
                case 4:
                    iProductDesign.deleteElement();
                    break;
                case 5:
                    iProductDesign.sortByPrice();
                    break;
                case 6:
                    iProductDesign.findProductByName();
                    break;
                case 7:
                    iProductDesign.findProductByRangePrice();
                    break;
                case 8:
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
