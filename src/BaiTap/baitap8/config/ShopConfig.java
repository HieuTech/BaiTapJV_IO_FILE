package BaiTap.baitap8.config;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopConfig {

    public static float getFloat(){
        while (true){
            try{
                return Float.parseFloat(getInput());
            }catch (NumberFormatException e) {
                System.err.println("Input not match");
            }
        }
    }

    public static byte getByte(){
        while (true){
            try{
                return Byte.parseByte(getInput());
            }catch (NumberFormatException e) {
                System.err.println("Input not match");
            }
        }
    }

    public static String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



}
