package BaiTap;

import java.io.*;
import java.util.Arrays;

public class BaiTap2 {
    public static void main(String[] args) {
        writeFile();
        copyFile("baitap2.source.txt","baitap2.target.txt");
    }

    public static void copyFile(String sourceFile, String targetFile ){
        File inputFile = new File(sourceFile);
        File outputFile = new File(targetFile);
        if(!inputFile.exists() && !outputFile.exists()){
            throw new RuntimeException("File source or file target is not exist");
        }
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try{
           fos = new FileOutputStream(targetFile);
           fis =  new FileInputStream(sourceFile);
            int scan;
            while ((scan = fis.read()) != -1 ){
                fos.write(scan);
            }
            System.out.println("Copy successfully");

        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fos != null){
                try{
                    fos.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(fis != null){
                try{
                    fis.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }

    public static void writeFile(){
        String data = "Viết chương trình đọc nội dung từ file text và hiển thị số lượng từ trong file đó.  \n ";
        FileOutputStream out = null;
        try{
            out = new FileOutputStream("baitap2.source.txt");
            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Write successfully");

        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            if(out != null){
                try{
                    out.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
