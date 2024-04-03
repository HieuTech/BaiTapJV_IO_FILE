package BaiTap.baitap9.config;

import java.util.Scanner;

public class ShopConfig {

    public static Scanner scanner = new Scanner(System.in);

    public static byte getByte(){
      while (true){
          try{
              return Byte.parseByte(inputData());
          }catch (NumberFormatException e){
              System.out.println("Number format invalid");
          }
      }

    }

    public static String inputData(){
        return scanner.nextLine();
    }
}
