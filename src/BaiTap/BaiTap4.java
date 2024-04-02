package BaiTap;

import java.io.*;
import java.util.Arrays;

public class BaiTap4 {
    public static void main(String[] args) {
        String fileName = "baitap4.txt";
        String fileName1 = "baitap4.newFile.txt";
        writeData(fileName);
        String[] strArr = readFile(fileName).split(" ");
        int index = strArr.length ;
        String temp;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < index/2; i++) {
            temp = strArr[i];
            strArr[i] = strArr[index - i -1];
            strArr[index -i -1] = temp;
        }
        for (String str: strArr){
            stringBuilder.append(str).append(" ");
        }
        writeNewFile(fileName1, stringBuilder.toString());
    }
    public static void writeNewFile(String fileName1, String strArr){

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(fileName1);
            byte[] bytes = strArr.getBytes();
            fos.write(bytes);
            System.out.println("copy successly");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String readFile(String fileName){
        FileReader fis = null;
        try{
             fis = new FileReader(fileName);
             StringBuilder stringBuilder = new StringBuilder();
            int scan;
            while((scan = fis.read()) != -1){
                stringBuilder.append((char)scan);
            }

            System.out.println("Read Successfully");
            return stringBuilder.toString();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fis != null){
                try{
                    fis.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static void writeData(String fileName){
        String data = "Hoang Le Minh Hieu";
        FileOutputStream fos= null;
        try{
            fos = new FileOutputStream(fileName);
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Write successfully");
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally{
            if(fos != null){
                try{
                    fos.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
