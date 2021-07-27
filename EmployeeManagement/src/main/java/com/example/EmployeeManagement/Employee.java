package com.example.EmployeeManagement;

public class Employee {
    String name;
    String email;
    int id;
    String country;
    String DOB;
    int salary;
    String project;
    String manager;
    int WorkHours;
    String department;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", DOB='" + DOB + '\'' +
                ", salary=" + salary +
                ", project='" + project + '\'' +
                ", manager='" + manager + '\'' +
                ", WorkHours=" + WorkHours +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee(String name, String d, int s) {
        this.name = name;
        this.department  = d;
        this.salary = s;
    }
    public Employee(int id, String name, String department, int salary) {
        this.name = name;
        this.department  = department;
        this.salary = salary;
        this.id = id;
    }
    public Employee() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getWorkHours() {
        return WorkHours;
    }

    public void setWorkHours(int workHours) {
        WorkHours = workHours;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getCountry() {
        return country;
    }

    public void setName(String n) {
        this.name = n;
    }
    public void setEmail(String n) {
        this.email = n;
    }
    public void setCountry(String n) {
        this.country = n;
    }

}
