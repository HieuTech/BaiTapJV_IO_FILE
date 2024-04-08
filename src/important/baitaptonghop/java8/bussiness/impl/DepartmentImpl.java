package important.baitaptonghop.java8.bussiness.impl;

import important.baitaptonghop.java8.bussiness.config.IOFile;
import important.baitaptonghop.java8.bussiness.config.ShopConfig;
import important.baitaptonghop.java8.bussiness.design.IDepartment;
import important.baitaptonghop.java8.bussiness.entity.Department;

import java.util.ArrayList;
import java.util.List;


public class DepartmentImpl implements IDepartment {
    public static List<Department> departmentList;

    static {
        departmentList = IOFile.readData(IOFile.DEPARTMENT_PATH);
        System.out.println();
    }

    @Override
    public Department findById(String id) {
        for (Department department : departmentList) {
            if (departmentList.stream().anyMatch(de -> de.getDepartmentId().equals(id))) {
                return department;
            }
        }
        return null;
    }

    @Override
    public void addElement() {
        System.out.println("How many department you want to add");
        byte count = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
        for (int i = 1; i <= count; i++) {
            Department department = new Department();
            System.out.printf("Department number %d \n", i);
            departmentList.add(inputData(true, department));
        }
        IOFile.writeData(IOFile.DEPARTMENT_PATH, departmentList);
        System.out.println("Add successfully");
    }

    @Override
    public void editElement() {
        System.out.println("Input Department ID ");
        String departmentId = ShopConfig.inputFromUser(ShopConfig.REGEX_DEPARTMENT_ID, ShopConfig.ERROR_DEPARTMENT_ID);
        Department department = findById(departmentId);
        if (department != null) {
            inputData(false, department);
            IOFile.writeData(IOFile.DEPARTMENT_PATH, departmentList);

            System.out.println("Update successfully");
        } else {
            System.out.println("Department Not Found");
        }
    }

    @Override
    public void deleteElement() {
        System.out.println("Input Department ID ");
        String departmentId = ShopConfig.inputFromUser(ShopConfig.REGEX_DEPARTMENT_ID, ShopConfig.ERROR_DEPARTMENT_ID);
        Department department = findById(departmentId);
        if (department != null) {
            if (department.getTotalMembers() == 0) {
                departmentList.remove(department);
                IOFile.writeData(IOFile.DEPARTMENT_PATH, departmentList);

                System.out.println("Delete successfully");
            } else {
                System.out.println("Department have Employee, Cant Delete");
            }

        } else {
            System.out.println("Department Not Found");
        }
    }

    @Override
    public void displayAllData() {

        departmentList.forEach(department ->
                System.out.printf("| ID: %-4s | Name: %-10s | Total Member: %-2s \n",
                        department.getDepartmentId(), department.getDepartmentName(),
                        department.getTotalMembers()
                ));
    }


    @Override
    public Department inputData(Boolean isAdd, Department department) {
        if (isAdd) {
            department.setDepartmentId(checkDepartmentId());
        }
        department.setDepartmentName(checkDepartmentName());
        return department;
    }


    private String checkDepartmentId() {

        while (true) {
            System.out.println("Input DepartmentID");
            String departmentID = ShopConfig.inputFromUser(ShopConfig.REGEX_DEPARTMENT_ID, ShopConfig.ERROR_DEPARTMENT_ID);
            if (departmentList.stream().noneMatch(department -> department.getDepartmentId().equals(departmentID))) {
                return departmentID;
            } else {
                System.out.println("Department ID exist");
            }
        }
    }

    private String checkDepartmentName() {

        while (true) {
            System.out.println("Input Department Name");
            String departmentName = ShopConfig.scanner.nextLine();
            if (departmentList.stream().anyMatch(department -> department.getDepartmentName().equals(departmentName)) && departmentName.isEmpty()) {
                System.out.println("department Name exist or empty");

            } else {
                return departmentName;

            }
        }
    }


    @Override
    public void displayEmployeeByDepartmentId() {
        System.out.println("Input Department ID ");
        String departmentId = ShopConfig.inputFromUser(ShopConfig.REGEX_DEPARTMENT_ID, ShopConfig.ERROR_DEPARTMENT_ID);
        if (EmployeeImpl.employeeList.stream().anyMatch(em -> em.getDepartmentId().equals(departmentId))) {
            EmployeeImpl.employeeList.stream()
                    .filter(em -> em.getDepartmentId().equals(departmentId)).forEach(employee ->
                            System.out.printf("| ID: %-5s | Name: %-8s \n", employee.getEmployeeId(), employee.getEmployeeName()));
        } else {
            System.out.printf("No employee belong to ID: %-4s department \n", departmentId);
        }
    }
}
