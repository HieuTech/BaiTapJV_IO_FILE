package important.baitaptonghop.java8.run;

import important.baitaptonghop.java8.bussiness.config.ShopConfig;
import important.baitaptonghop.java8.bussiness.design.IEmployee;
import important.baitaptonghop.java8.bussiness.impl.DepartmentImpl;
import important.baitaptonghop.java8.bussiness.impl.EmployeeImpl;

public class EmployeeManagement {
    public static IEmployee employeeImpl = new EmployeeImpl();
    public void displayEmployeeMenu(){

        while (true){
            boolean isExit= false;
            System.out.println("---------EMPLOYEE__MANAGEMENT-----------");
            System.out.println("1. Hiển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)");
            System.out.println("2. Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)");
            System.out.println("3. Thêm mới nhân viên");
            System.out.println("4. Chỉnh sửa thông tin nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("6. Thoat");
            byte choice = ShopConfig.getByte(ShopConfig.REGEX_NUMBER,ShopConfig.ERROR_VALUE);
            switch (choice){
                case 1:
                    employeeImpl.displayEmployeeIdAndName();
                    break;
                case 2:
                    employeeImpl.displayAllData();

                    break;
                case 3:
                    employeeImpl.addElement();
                    break;
                case 4:
                    employeeImpl.editElement();
                    break;
                case 5:
employeeImpl.findEmployeeHighestSalary();
                    break;
                case 6:
                    isExit = true;
                    break;


                default:
                    System.err.println("Your choice out of range");
                    break;



            }
            if(isExit){
                break;
            }
        }

    }
}
