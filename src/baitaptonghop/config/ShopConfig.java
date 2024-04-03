package baitaptonghop.config;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ShopConfig {

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Scanner scanner = new Scanner(System.in);
    public static float getFLoat( ){
        while (true){
            try{
                return Float.parseFloat(scanner.nextLine());

            }catch (NumberFormatException e){
                System.err.println("Input invalid");
            }
        }
    }
    public static int getInt( ){
        while (true){
            try{
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Input invalid");
            }
        }
    }
    public static byte getByte( ){
        while (true){
            try{
                return Byte.parseByte(scanner.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Input invalid");
            }
        }
    }
}
