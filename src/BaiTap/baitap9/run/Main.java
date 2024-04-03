package BaiTap.baitap9.run;

import BaiTap.baitap8.config.ShopConfig;
import BaiTap.baitap9.design.IBookDesign;
import BaiTap.baitap9.designImpl.IBookDesignImpl;
import BaiTap.baitap9.entity.Book;

import java.util.List;

public class Main {
    private static IBookDesign iBookDesign = new IBookDesignImpl();
    public static void main(String[] args) {
        while (true) {

            System.out.println("-------------BOOK_MANAGEMENT-------------");
            System.out.println("1. Add new Book");
            System.out.println("2. Display all Book");
            System.out.println("3. Update  Book");
            System.out.println("4. Delete  Book");
            System.out.println("5. Sign Out");
            byte choice = ShopConfig.getByte();

            switch (choice) {
                case 1:
                    iBookDesign.addNew();
                    iBookDesign.writeData();
                    break;
                case 2:
                    iBookDesign.displayAll();

                    System.out.println("-----READ_DATA----");
                    List<Book> list = iBookDesign.readData();
                    list.forEach(Book::displayData);
                    break;
                case 3:
                    iBookDesign.editElement();
                    iBookDesign.writeData();
                    break;
                case 4:
                    iBookDesign.deleteElement();
                    iBookDesign.writeData();
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
