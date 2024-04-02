package BaiTap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BaiTap3 {
    public static void main(String[] args) {
        String fileName = "baitap3.txt";
        writeData(fileName);
//    List<String> list
        String[] listChar = readData(fileName).split(" ");
        String maxChar = listChar[0];

        for (String item: listChar){
            if(maxChar.length() < item.length()){
                maxChar = item;
            }
        }
        System.out.printf("Ky tu dai nhat: %s | Do dai ki tu: %s ", maxChar, maxChar.length());
    }

    public static String readData(String fileName){
        FileReader fileReader = null;
        try{
             fileReader = new FileReader(fileName);
            StringBuilder stringBuilder = new StringBuilder();
            int scan;
            while((scan = fileReader.read()) != -1){
                stringBuilder.append((char) scan);
            }
            return stringBuilder.toString();

        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileReader != null){
                try{
                    fileReader.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    public static void writeData(String fileName){
        String data = "Viết chương trình đọc nội dung từ file text và tìm và hiển thị các từ có độ dài lớn nhất trong file đó.\n";

        FileOutputStream fos = null;
        try{
             fos = new FileOutputStream(fileName);
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Write successfully");
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
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
