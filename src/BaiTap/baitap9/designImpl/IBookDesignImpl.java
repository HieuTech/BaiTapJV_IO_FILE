package BaiTap.baitap9.designImpl;


import BaiTap.baitap8.config.AppendObjectOutputStream;
import BaiTap.baitap8.designImpl.IProductDesignImpl;
import BaiTap.baitap8.entity.Product;
import BaiTap.baitap9.config.ShopConfig;
import BaiTap.baitap9.design.IBookDesign;
import BaiTap.baitap9.entity.Book;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IBookDesignImpl implements IBookDesign {
    private final String  filePath = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/BaiTap/baitap9/config/baitap9.txt";

    private static List<Book> bookList = new ArrayList<>();

    @Override
    public Book findByName(String title) {
        for (Book book: bookList){
            if(title.equals(book.getTitle())){
                return book;
            }
        }
        return null;
    }

    @Override
    public void addNew() {
        System.out.println(" Book Info");
        Book book = new Book();
        book.inputData();
        bookList.add(book);

    }

    @Override
    public void editElement() {
        System.out.println("Input book title to update");
        String title = ShopConfig.inputData();
        Book updateBook = findByName(title);
        if(updateBook == null){
            System.out.println("Book not found");
        }else{
            updateBook.inputData();
            System.out.println("Update successfully");
        }
    }



    @Override
    public void displayAll() {
        bookList.forEach(Book::displayData);
    }

    @Override
    public void deleteElement() {
        System.out.println("Input book title to delete");
        String title = ShopConfig.inputData();
        Book deleteBook = findByName(title);
        if(deleteBook == null){
            System.out.println("Book not found");
        }else{
            bookList.remove(deleteBook);
            System.out.println("Delete successfully");
        }
    }

    @Override
    public List<Book> readData() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> list = new ArrayList<>();
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            while (true) {
                Book book = (Book) ois.readObject();
                list.add(book);
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

            for (Book book : IBookDesignImpl.bookList) {
                oos.writeObject(book);
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
