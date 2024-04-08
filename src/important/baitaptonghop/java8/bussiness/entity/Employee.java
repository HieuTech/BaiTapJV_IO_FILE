package important.baitaptonghop.java8.bussiness.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

    private String employeeId, employeeName;
    private LocalDate birthday;
    private boolean gender;
    private double salary;
    private Employee manager;
    private String departmentId;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean gender, double salary, Employee manager, String departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.gender = gender;
        this.salary = salary;
        this.manager = manager;
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
