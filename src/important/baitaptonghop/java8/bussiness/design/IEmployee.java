package important.baitaptonghop.java8.bussiness.design;

import important.baitaptonghop.java8.bussiness.entity.Employee;

public interface IEmployee extends IGeneric<Employee, String, Boolean>{

    void displayEmployeeIdAndName();
    void avgEmployeeInPerDepartment();
    void findDepartmentCrowndedEmployee();

    void findManagerManageMostEmployee();
    void findEmployeeHighestAge();

    void findEmployeeHighestSalary();
}
