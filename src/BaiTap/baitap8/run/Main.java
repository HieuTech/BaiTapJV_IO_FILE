package BaiTap.baitap8.run;

import BaiTap.baitap8.config.ShopConfig;
import BaiTap.baitap8.design.IProductDesign;
import BaiTap.baitap8.designImpl.IProductDesignImpl;
import BaiTap.baitap8.entity.Product;

import java.util.List;

public class Main {
    private static IProductDesign iProductDesign = new IProductDesignImpl();

    public static void main(String[] args) {

        while (true) {

            System.out.println("-------------PRODUCT_MANAGEMENT-------------");
            System.out.println("1. Add new product");
            System.out.println("2. Display all product");
            System.out.println("3. Update  product");
            System.out.println("4. Delete  product");
            System.out.println("5. Sign Out");
            byte choice = ShopConfig.getByte();

            switch (choice) {
                case 1:
                    iProductDesign.addNew();
                    iProductDesign.writeData();
                    break;
                case 2:
                    iProductDesign.displayAll();

                    System.out.println("-----READ_DATA----");
                    List<Product> list = iProductDesign.readData();
                    list.forEach(Product::displayData);
                    break;
                case 3:
                    iProductDesign.editElement();
                    iProductDesign.writeData();
                    break;
                case 4:
                    iProductDesign.deleteElement();
                    iProductDesign.writeData();
                    break;
                case 5:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Your choice out of range");
                    break;

            }
        }
    }
}
