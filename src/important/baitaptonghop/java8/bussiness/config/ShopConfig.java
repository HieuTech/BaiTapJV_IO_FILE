package important.baitaptonghop.java8.bussiness.config;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ShopConfig {
    public static Scanner scanner = new Scanner(System.in);
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final String ERROR_VALUE= "Input invalid";
    public static final String REGEX_NUMBER= "\\d+";

    public static final String REGEX_DEPARTMENT_ID = "D\\w{3}";
    public static final String REGEX_TOTAL_MEMBER = "\\d+";
    public static final String REGEX_DEPARTMENT_NAME = "\\w+";
    public static final String ERROR_DEPARTMENT_ID = "Department ID Format D___";
    public static final String ERROR_TOTAL_MEMBER = "Total Member Invalid";
    public static final String ERROR_DEPARTMENT_NAME = "Department Name Is Not Be Empty";


//=================================================

    public static final String REGEX_EMPLOYEE_ID = "E\\w{3}";
    public static final String REGEX_GENDER = "(true|false)";
    public static final String REGEX_SALARY = "\\d+";
    public static final String ERROR_EMPLOYEE_ID = "Employee ID Format E___";
    public static final String ERROR_GENDER = "Gender must true or false";
    public static final String ERROR_SALARY = "Salary must be a number";
    public static final String ERROR_BIRTHDAY = "Birthday format must dd/MM/yyyy";

    //=================================================

    public static boolean getBoolean(String regex, String ERROR){
        return Boolean.parseBoolean(inputFromUser(regex,ERROR));
    }

    public static double getInt(String regex, String ERROR){
        return Integer.parseInt(inputFromUser(regex, ERROR));
    }
    public static byte getByte(String regex, String ERROR){
        return Byte.parseByte(inputFromUser(regex, ERROR));
    }

    public static double getDouble(String regex, String ERROR){
        return Double.parseDouble(inputFromUser(regex, ERROR));
    }

    public static String inputFromUser(String regex, String ERROR) {
        while (true) {
            String value = scanner.nextLine();
            if (isValid(regex, value)) {
                return value;
            } else {
                System.out.println(ERROR);
            }
        }

    }

    public static boolean isValid(String regex, String value) {
        return value.matches(regex);
    }
}
