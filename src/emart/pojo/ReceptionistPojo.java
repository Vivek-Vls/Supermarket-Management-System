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
public class ReceptionistPojo {
    private String empId;
    private String empName;
    private String userId;
    private String job;
    private double salary;

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getUserId() {
        return userId;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }
              
}
