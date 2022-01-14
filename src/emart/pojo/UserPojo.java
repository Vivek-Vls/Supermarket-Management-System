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
public class UserPojo {
    private String userId;
    private String userName;
    private String userType;
    private String empId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getEmpId() {
        return empId;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}
