package important.baitaptonghop.java8.bussiness.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static final String DEPARTMENT_PATH = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/important/baitaptonghop/java8/data/department.txt";
    public static final String EMPLOYEE_PATH = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/important/baitaptonghop/java8/data/employee.txt";

    public static <T> void writeData(String path, List<T> list){
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Write successfully");
        }catch (IOException e) {

        }finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> List<T> readData(String path){
        List<T> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{

            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();

        }catch (EOFException e){

        }catch (IOException e){
            System.out.println("IO Exception");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;

    }

}
