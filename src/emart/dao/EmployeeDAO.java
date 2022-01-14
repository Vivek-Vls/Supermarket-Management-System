/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.EmployeePojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vivek
 */
public class EmployeeDAO {
     
    public static String getNextEmpId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        rs.next();
        String empid=rs.getString(1);
        int id=Integer.parseInt(empid.substring(1));
        id++;
        return "E"+id;
    }
    
    public static boolean addEmployee(EmployeePojo e)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setString(1,e.getEmployeeId());
        ps.setString(2,e.getEmployeeName());
        ps.setString(3,e.getJob());
        ps.setDouble(4,e.getSalary());
        int res=ps.executeUpdate();
        return res==1;
    }
    
    public static List<EmployeePojo> getAllEmployees()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by empid");
        ArrayList<EmployeePojo> empList=new ArrayList<EmployeePojo>();
        while(rs.next())
        {
          EmployeePojo e=new EmployeePojo();
          e.setEmployeeId(rs.getString(1));
          e.setEmployeeName(rs.getString(2));
          e.setJob(rs.getString(3));
          e.setSalary(rs.getDouble(4));
          empList.add(e);        
        }
       return empList;
    }
    
    public static List<String> getAllEmpId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select empid from employees order by empid");
        ArrayList<String> idList=new ArrayList<String>();
        while(rs.next())
        {
          idList.add(rs.getString(1));
        }
        return idList;
    }
    
    public static boolean updateEmployee(EmployeePojo e)throws SQLException
    {
      Connection conn =DBConnection.getConnection();
      PreparedStatement ps= conn.prepareStatement("update employees set empname=?,job=?,salary=? where empid=?");
      ps.setString(1,e.getEmployeeName());
      ps.setString(2,e.getJob());
      ps.setDouble(3,e.getSalary());
      ps.setString(4, e.getEmployeeId());
      int res =ps.executeUpdate();
      if(res==0)
      return false;
      else
      {
         boolean x=UserDAO.isUserPresent(e.getEmployeeId());
          if(x==false)
              return true;
          else
          {
            ps= conn.prepareStatement("update users set username=?,usertype=? where empid=?");
            ps.setString(1,e.getEmployeeName());
            ps.setString(2,e.getJob());
            ps.setString(3, e.getEmployeeId());
            int y =ps.executeUpdate();
            return y==1;
          }
      
      }
    }
    
     public static EmployeePojo findEmployeeById(String empId)throws SQLException
    {
      Connection conn =DBConnection.getConnection();
      PreparedStatement ps= conn.prepareStatement("select * from employees where empid=?");
      ps.setString(1,empId);
      ResultSet rs=ps.executeQuery();
      EmployeePojo e=null;
      if(rs.next())
      {
          e=new EmployeePojo();
          e.setEmployeeId(rs.getString(1));
          e.setEmployeeName(rs.getString(2));
          e.setJob(rs.getString(3));
          e.setSalary(rs.getDouble(4));
      }
      return e;
    }
     
    public static String getEmployeeName(String empId) throws SQLException
    {
      Connection conn =DBConnection.getConnection();
      PreparedStatement ps= conn.prepareStatement("select empname from employees where empid=?");
      ps.setString(1,empId);
      ResultSet rs=ps.executeQuery();
      rs.next();
      return rs.getString(1);
    }
    
    public static boolean deleteEmployee(String empId)throws SQLException
    {
      Connection conn =DBConnection.getConnection();
      PreparedStatement ps= conn.prepareStatement("delete from employees where empid=?");
      ps.setString(1,empId);
      int rs=ps.executeUpdate();
      return rs==1;
    }
}
