package important.baitaptonghop.java8.run;

import important.baitaptonghop.java8.bussiness.config.ShopConfig;

public class Main {
    static DepartmentManagement departmentManagement = new DepartmentManagement();
    static EmployeeManagement employeeManagement = new EmployeeManagement();
    static SearchManagement searchManagement = new SearchManagement();

    public static void main(String[] args) {
        while (true) {
            boolean isExit = false;
            System.out.println("------------MENU------------");
            System.out.println("1. Quản lí phòng ban");
            System.out.println("2. Quản lí nhân viên");
            System.out.println("3. Search theo yêu cầu");
            System.out.println("4. Thoát");
            byte choice = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
            switch (choice) {
                case 1:
                    departmentManagement.displayDepartmentMenu();
                    break;
                case 2:
                    employeeManagement.displayEmployeeMenu();
                    break;
                case 3:
                    searchManagement.displaySearchMenu();
                    break;
                case 4:
                    System.exit(1);
                    break;

                default:
                    System.err.println("Your choice out of range");
                    break;
            }
            if (isExit) {
                break;
            }
        }
    }
}
