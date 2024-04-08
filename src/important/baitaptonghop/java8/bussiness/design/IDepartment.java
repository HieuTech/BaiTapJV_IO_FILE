package important.baitaptonghop.java8.bussiness.design;

import important.baitaptonghop.java8.bussiness.entity.Department;

public interface IDepartment extends IGeneric<Department, String, Boolean> {

    void displayEmployeeByDepartmentId();
}