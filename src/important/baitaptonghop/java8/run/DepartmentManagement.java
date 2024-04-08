package important.baitaptonghop.java8.run;

import important.baitaptonghop.java8.bussiness.config.ShopConfig;
import important.baitaptonghop.java8.bussiness.design.IDepartment;
import important.baitaptonghop.java8.bussiness.impl.DepartmentImpl;

public class DepartmentManagement {

    public static IDepartment iDepartment = new DepartmentImpl();

    public void displayDepartmentMenu() {

        while (true) {
            boolean isExit = false;
            System.out.println("---------DEPARTMENT__MANAGEMENT-----------");
            System.out.println("1. Hiển thị danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Chỉnh sửa tên phòng ban");
            System.out.println("4. Hiển thị danh sách nhân viên của phòng ban theo mã phòng");
            System.out.println("5. Xóa phòng ban (chỉ xóa khi ko có nhân viên nào)");
            System.out.println("6. Thoat");
            byte choice = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
            switch (choice) {
                case 1:
                    iDepartment.displayAllData();
                    break;
                case 2:
                    iDepartment.addElement();
                    break;
                case 3:
                    iDepartment.editElement();
                    break;
                case 4:
                    iDepartment.displayEmployeeByDepartmentId();
                    break;
                case 5:
                    iDepartment.deleteElement();
                    break;
                case 6:
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
