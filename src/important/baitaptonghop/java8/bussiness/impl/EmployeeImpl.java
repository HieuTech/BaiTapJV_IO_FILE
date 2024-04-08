package important.baitaptonghop.java8.bussiness.impl;

import baitaptonghop.entity.Product;
import important.baitaptonghop.java8.bussiness.config.IOFile;
import important.baitaptonghop.java8.bussiness.config.ShopConfig;
import important.baitaptonghop.java8.bussiness.design.IEmployee;
import important.baitaptonghop.java8.bussiness.entity.Department;
import important.baitaptonghop.java8.bussiness.entity.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImpl implements IEmployee {
    public static List<Employee> employeeList;

    static {
        employeeList = IOFile.readData(IOFile.EMPLOYEE_PATH);
    }

    @Override
    public Employee findById(String id) {
        for (Employee employee : employeeList) {
            if (employeeList.stream().anyMatch(e -> e.getEmployeeId().equals(id))) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addElement() {
        if (DepartmentImpl.departmentList.isEmpty()) {
            System.err.println("Department is empty, add department first");
            return;
        }
        System.out.println("How many employee you want to add");
        byte count = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
        for (int i = 1; i <= count; i++) {
            System.out.printf("Employee number: \n", count);
            Employee employee = new Employee();
            employeeList.add(inputData(true, employee));
        }
        IOFile.writeData(IOFile.EMPLOYEE_PATH, employeeList);
        IOFile.writeData(IOFile.DEPARTMENT_PATH,DepartmentImpl.departmentList);
        System.out.println("Add successfully");
    }

    @Override
    public void editElement() {

        System.out.println("Input EmployeeID");
        String employeeId = ShopConfig.inputFromUser(ShopConfig.REGEX_EMPLOYEE_ID, ShopConfig.ERROR_EMPLOYEE_ID);
        Employee employee = findById(employeeId);
        if (employee != null) {
            String departmentId = employee.getDepartmentId();
            for (int i = 0; i < DepartmentImpl.departmentList.size(); i++) {
                if (DepartmentImpl.departmentList.get(i).getDepartmentId().equals(departmentId)) {
                    DepartmentImpl.departmentList.get(i).setTotalMembers(DepartmentImpl.departmentList.get(i).getTotalMembers() - 1);
                }
            }

            inputData(false, employee);
            IOFile.writeData(IOFile.EMPLOYEE_PATH, employeeList);
            System.out.println("Update successfully");
        } else {
            System.err.println("Employee not found");
        }
    }

    @Override
    public void deleteElement() {

        System.out.println("Input EmployeeID");
        String employeeId = ShopConfig.inputFromUser(ShopConfig.REGEX_EMPLOYEE_ID, ShopConfig.ERROR_EMPLOYEE_ID);
        Employee employee = findById(employeeId);
        if (employee != null) {
            String departmentId = employee.getDepartmentId();
            for (int i = 0; i < DepartmentImpl.departmentList.size(); i++) {
                if (DepartmentImpl.departmentList.get(i).getDepartmentId().equals(departmentId)) {
                    DepartmentImpl.departmentList.get(i).setTotalMembers(DepartmentImpl.departmentList.get(i).getTotalMembers() - 1);
                }
            }
            employeeList.remove(employee);
            //sai logic
//            for (Department department : DepartmentImpl.departmentList) {
//                if (DepartmentImpl.departmentList.stream().anyMatch(de -> de.getDepartmentId().equals(departmentId))) {
//                    department.setTotalMembers(department.getTotalMembers() - 1);
//
//                }
//            }
            IOFile.writeData(IOFile.EMPLOYEE_PATH, employeeList);
            System.out.println("Delete successfully");
        } else {
            System.err.println("Employee not found");
        }
    }

    @Override
    public void displayAllData() {
        if (employeeList.isEmpty()) {
            System.out.println("employeeList is empty");
        }

        for (Employee em : employeeList) {
            System.out.printf("|ID: %-3s | Name: %-6s | gender : %5s " +
                            "| Manager Name: %-10s | salary: %-3s | birthday: %-10s " +
                            "| Department ID: %-3s \n",
                    em.getEmployeeId(), em.getEmployeeName(),
                    em.isGender(), (em.getManager() != null ? em.getManager().getEmployeeName() : "null"), em.getSalary(),
                    em.getBirthday(), em.getDepartmentId()
            );
        }
    }


    @Override
    public Employee inputData(Boolean isAdd, Employee employee) {
        if (isAdd) {
            employee.setEmployeeId(checkEmployeeId());
        }
        System.out.println("Input Employee Name");
        employee.setEmployeeName(ShopConfig.inputFromUser(ShopConfig.REGEX_DEPARTMENT_NAME, ShopConfig.ERROR_VALUE));
        System.out.println("Input Employee gender");
        employee.setGender(ShopConfig.getBoolean(ShopConfig.REGEX_GENDER, ShopConfig.ERROR_GENDER));
        System.out.println("Input Salary ");
        employee.setSalary(ShopConfig.getDouble(ShopConfig.REGEX_SALARY, ShopConfig.ERROR_SALARY));
        employee.setBirthday(getBirthday());
        employee.setManager(getInputManager());
        employee.setDepartmentId(getInputDepartmentId());
        return employee;
    }

    private String getInputDepartmentId() {

        for (int i = 0; i < DepartmentImpl.departmentList.size(); i++) {
            System.out.printf("|ID: %s | Name: %-10s \n", i + 1, DepartmentImpl.departmentList.get(i).getDepartmentName());
        }

        System.out.println("Input STT Of Department");
        byte choice = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
        while (true) {
            if (choice >= 1 && choice <= DepartmentImpl.departmentList.size()) {
                DepartmentImpl.departmentList.get(choice - 1).setTotalMembers(DepartmentImpl.departmentList.get(choice - 1).getTotalMembers() + 1);
                return DepartmentImpl.departmentList.get(choice - 1).getDepartmentId();
            } else {
                System.err.println("Your choice out of range");
            }
        }

    }

    private Employee getInputManager() {
        while (true) {
            System.out.println("Do you want to select manager?| 1. YES | 2. NO");
            byte choice1 = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
            switch (choice1) {
                case 1:
                    for (int i = 0; i < employeeList.size(); i++) {
                        System.out.printf("| STT: %d | Name: %-10s \n", i + 1, (employeeList.get(i).getManager() != null ? employeeList.get(i).getManager().getEmployeeName() : "null"));
                    }
                    System.out.println("List input Manager, choose by index");
                    byte choice = ShopConfig.getByte(ShopConfig.REGEX_NUMBER, ShopConfig.ERROR_VALUE);
                    if (choice >= 1 && choice <= employeeList.size()) {
                        return employeeList.get(choice - 1);
                    } else {
                        System.err.println("Choice out of range index");
                    }
                    break;
                case 2:
                    return null;
            }

        }
    }

    private LocalDate getBirthday() {
        while (true) {
            System.out.println("Input birthday");
            String birthday = ShopConfig.scanner.nextLine();
            try {
                return LocalDate.parse(birthday, ShopConfig.dtf);
            } catch (DateTimeParseException e) {
                System.err.println(ShopConfig.ERROR_BIRTHDAY);
            }
        }
    }

    private String checkEmployeeId() {
        while (true) {
            System.out.println("Input employeeID");
            String employeeID = ShopConfig.inputFromUser(ShopConfig.REGEX_EMPLOYEE_ID, ShopConfig.ERROR_EMPLOYEE_ID);
            if (employeeList.stream().noneMatch(em -> em.getEmployeeId().equals(employeeID))) {
                return employeeID;
            } else {
                System.err.println("Employee ID exist, try another");
            }
        }
    }


    @Override
    public void displayEmployeeIdAndName() {
        if (employeeList.isEmpty()) {
            System.out.println("employeeList is empty");
        }
        employeeList.forEach(em ->
                System.out.printf("|ID: %-3s | Name: %-10s ",
                        em.getEmployeeId(), em.getEmployeeName()
                ));
    }

    @Override
    public void avgEmployeeInPerDepartment() {
        float avgEmployee = (float) Math.round((float) DepartmentImpl.departmentList.size() / EmployeeImpl.employeeList.size());
        System.out.printf("| Total Department: %s | Total Employee: %s | Average: %s ",
                DepartmentImpl.departmentList.size(), EmployeeImpl.employeeList.size(), avgEmployee);
    }

    @Override
    public void findDepartmentCrowndedEmployee() {
        DepartmentImpl.departmentList.stream().sorted(Comparator.comparing(Department::getTotalMembers)).limit(2)
                .forEach(department ->
                        System.out.printf("| ID: %-4s | Name: %-10s | Total Member: %-2s \n",
                                department.getDepartmentId(), department.getDepartmentName(),
                                department.getTotalMembers()));
    }

    @Override
    public void findManagerManageMostEmployee() {
//        employeeList.stream().max
        Set<String> list = new HashSet<>();
        List<String> list1 = new ArrayList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        for (Employee employee : employeeList){
            if(employee.getManager() != null){
                if(hashMap.containsKey(employee.getManager().getEmployeeName())){
                    hashMap.put(employee.getManager().getEmployeeName() , hashMap.get(employee.getManager().getEmployeeName() + 1));
                }else{
                    hashMap.put(employee.getManager().getEmployeeName() , 1);
                }
            }
        }

        //tim key value lon nhat








    }

    @Override
    public void findEmployeeHighestAge() {
        employeeList.stream().sorted(Comparator.comparing(Employee::getBirthday)).limit(2)
                .forEach(em ->
                        System.out.printf("|ID: %-3s | Name: %-6s | gender : %5s " +
                                        "| Manager Name: %-10s | salary: %-3s | birthday: %-10s " +
                                        "| Department ID: %-3s \n",
                                em.getEmployeeId(), em.getEmployeeName(),
                                em.isGender(), (em.getManager() != null ? em.getManager().getEmployeeName() : "null"), em.getSalary(),
                                em.getBirthday(), em.getDepartmentId()));
    }

    @Override
    public void findEmployeeHighestSalary() {
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(2)
                .forEach(em ->
                        System.out.printf("|ID: %-3s | Name: %-6s | gender : %5s " +
                                        "| Manager Name: %-10s | salary: %-3s | birthday: %-10s " +
                                        "| Department ID: %-3s \n",
                                em.getEmployeeId(), em.getEmployeeName(),
                                em.isGender(), (em.getManager() != null ? em.getManager().getEmployeeName() : "null"), em.getSalary(),
                                em.getBirthday(), em.getDepartmentId()));
    }
}
