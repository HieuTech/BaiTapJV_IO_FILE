package important.baitaptonghop.java8.run;

import important.baitaptonghop.java8.bussiness.config.ShopConfig;

public class SearchManagement {


    public void displaySearchMenu() {

        while (true) {
            boolean isExit = false;
            System.out.println("---------SEARCH__MANAGEMENT-----------");
            System.out.println("1. Tìm ra 5 phòng có số lượng nhân viên đông nhất");
            System.out.println("2. Tìm ra người quản lý nhiều nhân viên nhất");
            System.out.println("3. Tìm ra 5 nhân viên có tuổi cao nhất công ty");
            System.out.println("4. Tìm ra 5 nhân viên hưởng lương cao nhất");
            System.out.println("5. Thoat");
            byte choice = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
            switch (choice) {
                case 1:
                    EmployeeManagement.employeeImpl.findDepartmentCrowndedEmployee();
                    break;
                case 2:
                    EmployeeManagement.employeeImpl.findManagerManageMostEmployee();
                    break;
                case 3:
                    EmployeeManagement.employeeImpl.findEmployeeHighestAge();
                    break;
                case 4:
                    EmployeeManagement.employeeImpl.findEmployeeHighestSalary();
                    break;
                case 5:
                    isExit = true;
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
