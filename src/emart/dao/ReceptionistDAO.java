/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ReceptionistPojo;
import emart.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author vivek
 */
public class ReceptionistDAO {
    //use in add receptionist frame
    public static HashMap<String,String> getNonRegisteredReceptionist()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select empid,empname from employees where job='Receptionist' and empid not in(select empid from users where usertype='Receptionist') order by empid");
        HashMap<String,String> recepList=new HashMap<String,String>();
        while(rs.next())
        {
          recepList.put(rs.getString(1),rs.getString(2));
        }
        return recepList;
    }
    //use in add receptionist frame
    public static boolean addReceptionist(UserPojo p) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,p.getUserId());
        ps.setString(2,p.getEmpId());
        ps.setString(3,p.getPassword());
        ps.setString(4,p.getUserType());
        ps.setString(5,p.getUserName());
        int res=ps.executeUpdate();
        return res==1;
      
    }
    //use in add receptionist frame 
    public static boolean userIdAvailable(String userId) throws SQLException
    {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select 1 from users where userid=?");
         ps.setString(1,userId);  
         ResultSet rs= ps.executeQuery();
         return !rs.next();
    }
    //use in view all receptionist frame
    public static List<ReceptionistPojo> getAllReceptionist()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select users.empid,empname,userid,job,salary from employees,users where usertype='Receptionist' and employees.empid=users.empid order by empid");
        ArrayList<ReceptionistPojo> rList=new ArrayList<ReceptionistPojo>();
        while(rs.next())
        {
          ReceptionistPojo p=new ReceptionistPojo();
          p.setEmpId(rs.getString(1));
          p.setEmpName(rs.getString(2));
          p.setUserId(rs.getString(3));
          p.setJob(rs.getString(4));
          p.setSalary(rs.getDouble(5));
          rList.add(p);        
        }
       return rList;
    }
    
    //use in update receptionist frame
    public static boolean updateReceptionist(String userId,String password) throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
         ps.setString(1,password);
         ps.setString(2,userId);   
         int x= ps.executeUpdate();
         return x==1;
     }
    //use in remove receptionist frame     
    public static HashMap<String,String> getReceptionist()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select userid,username from users where usertype='Receptionist' order by userid");
        HashMap<String,String> recepList=new HashMap<String,String>();
        while(rs.next())
        {
          recepList.put(rs.getString(1),rs.getString(2));
        }
        return recepList;
    }
     //use in remove receptionist frame      
     public static boolean deleteReceptionist(String userId)throws SQLException
    {
      Connection conn =DBConnection.getConnection();
      PreparedStatement ps= conn.prepareStatement("delete from users where userid=?");
      ps.setString(1,userId);
      int rs=ps.executeUpdate();
      return rs==1;
    }
}
