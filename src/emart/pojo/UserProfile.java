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
public class UserProfile {

    private static String userName;
    private static String userType;
    private static String userId;
    
     public static void setUserName(String UserName) {
        UserProfile.userName = UserName;
    }

    public static void setUserType(String UserType) {
        UserProfile.userType = UserType;
    }

    public static void setUserId(String UserId) {
        UserProfile.userId = UserId;
    }
    
    public static String getUserName() {
        return userName;
    }

    public static String getUserType() {
        return userType;
    }

    public static String getUserId() {
        return userId;
    }
}
