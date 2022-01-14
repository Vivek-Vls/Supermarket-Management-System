/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

/**
 *
 * @author vivek
 */
public class EmployeePojo {
   private String employeeId;
   private String employeeName;
   private String job;
   private double salary;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }
}
