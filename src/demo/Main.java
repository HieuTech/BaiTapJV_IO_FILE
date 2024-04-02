package demo;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(2,"hieu ");

        student.id = 1;
        student.name= "test";

        writeStudent("student.txt",student);
        List<Student> list = readStudent("student.txt");
        for (Student student1: list){
            System.out.printf("| ID: %d | Name: %s \n ", student1.id, student1.name);
        }


    }
    //thac tac doc ghi object
    //luu du lieu ra file(Ghi ra file)

    public static <T> void writeStudent(String path, T object)  {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file = new File(path);
        try{
            fos = new FileOutputStream(path, true);

            if(file.exists() && file.length() > 0){
                oos = new AppendObjectOutputStream(fos);
            }else{
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(object);

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }finally{
            try{
                if(fos != null){
                    fos.close();
                }
                if(oos != null){
                    oos.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
    public static <T> List<T> readStudent(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<T> list = new ArrayList<>();
        try{
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            while (true){
                T object = (T) ois.readObject();
                list.add(object);
            }

        }catch (EOFException | ClassNotFoundException e){

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(fis != null){
                    fis.close();
                }
                if(ois != null){
                    ois.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return list;

    }

//    public static  void writeStudent(String path, Student student)  {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        File file = new File(path);
//        try{
//            fos = new FileOutputStream(path, true);
//
//            if(file.exists() && file.length() > 0){
//                oos = new AppendObjectOutputStream(fos);
//            }else{
//                oos = new ObjectOutputStream(fos);
//            }
//            oos.writeObject(student);
//
//        }catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }catch(IOException e){
//            throw new RuntimeException(e);
//        }finally{
//            try{
//                if(fos != null){
//                    fos.close();
//                }
//                if(oos != null){
//                    oos.close();
//                }
//            }catch (IOException e){
//                throw new RuntimeException(e);
//            }
//        }
//    }

//    public static List<Student> readStudent(String path){
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        List<Student> list = new ArrayList<>();
//        try{
//            fis = new FileInputStream(path);
//            ois = new ObjectInputStream(fis);
//            while (true){
//                Student student = (Student) ois.readObject();
//                list.add(student);
//            }
//
//        }catch (EOFException | ClassNotFoundException e){
//
//        }catch (IOException e){
//            e.printStackTrace();
//        } finally {
//            try{
//                if(fis != null){
//                    fis.close();
//                }
//                if(ois != null){
//                    ois.close();
//                }
//            }catch (IOException e){
//                throw new RuntimeException(e);
//            }
//        }
//        return list;
//
//    }

}
