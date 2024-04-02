package BaiTap;

import java.io.*;

public class BaiTap1 {

    public static void main(String[] args) {
        String data = "Viết chương trình đọc nội dung từ file text và hiển thị số lượng từ trong file đó.  \n ";
        FileOutputStream out = null;
        try{
            out = new FileOutputStream("baitap1.txt");
            byte[] text = data.getBytes();
            out.write(text);
            System.out.println("Write successfully");

            System.out.println(readFile());
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            if(out != null){
                try{
                    out.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        }

//
    }
    public static String readFile(){
            try{
                FileReader in = new FileReader("baitap1.txt");
                StringBuilder content = new StringBuilder();
                int data1 ;
                while( (data1 = in.read()) != -1){
                    content.append((char) data1);
                }
                return content.toString();
//                System.out.println("Noi dung tep la" + content);
//                System.out.printf("%d", in.read());
            } catch (IOException e){
                throw new RuntimeException(e);
            }
    }
}
