package baitaptonghop.config;

import baitaptonghop.entity.Categories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static final String PATH_CATEGORY = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/baitaptonghop/data/Categories.txt";
    public static final String PATH_PRODUCT = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/baitaptonghop/data/Product.txt";


    public static <T> void writeData(String pathFile, List<T> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(pathFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Write Data Successfully");
        } catch (IOException e) {

        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.err.println("IOException");
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.err.println("IOException");
                }

            }
        }
    }

    public static <T> List<T> readObjectFromFile(String filePath) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<T> list = new ArrayList<>();
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);



//            while (true) {
//                T object = (List<T>) ois.readObject();
//                list.add(object);
//            }
            list = (List<T>) ois.readObject();

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    if (fis != null) {
                        fis.close();
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException");
            }

        }
        return list;
    }
}
