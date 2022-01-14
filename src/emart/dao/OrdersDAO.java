/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductPojo;
import emart.pojo.UserProfile;
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
public class OrdersDAO {
    
    public static String getNextOrderId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(order_id) from orders");
        
        rs.next();
        
         String oid=rs.getString(1);
         if(oid==null)
         return"OR101";    
         int id=Integer.parseInt(oid.substring(2));
         id++;
         return "OR"+id;
    }
    
    public static boolean updateOrders(List<ProductPojo> pList,String oId)throws SQLException
    {
        
           Connection conn=DBConnection.getConnection();
           conn.setAutoCommit(false);
           PreparedStatement ps=conn.prepareStatement("insert into orders values(?,?,?,?)");
           for(ProductPojo p:pList)
           {
             ps.setString(1,oId);
             ps.setString(2,p.getpId());
             ps.setInt(3,p.getQuantity());
             ps.setString(4,UserProfile.getUserId());
             ps.addBatch();
           }
           int []count=ps.executeBatch();
           for(int i:count)
           {
             if(i!=-2)
             {
                conn.rollback();
                return false;
             }
           }
           conn.commit();
           return true;
    
    }
    
    public static List<ProductPojo> getOrdersDetail(String oid)throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select o.p_id,p_name,p_companyname,p_price,our_price,p_tax,o.quantity from products p,orders o where p.p_id=o.p_id and order_id=? order by o.p_id");
       ps.setString(1,oid);
       ResultSet rs= ps.executeQuery();
       ArrayList<ProductPojo> oList=new ArrayList<ProductPojo>();
       while(rs.next())
       {
           ProductPojo p=new ProductPojo();
           p.setpId(rs.getString(1));
           p.setProductName(rs.getString(2));
           p.setProductCompany(rs.getString(3));
           p.setProductPrice(rs.getDouble(4));
           p.setOurPrice(rs.getDouble(5));
           p.setTax(rs.getInt(6));
           p.setQuantity(rs.getInt(7));
           oList.add(p);
       }
       return oList;
    }
    
    public static List<String> getAllOrdersId(String userId)throws SQLException
    {
       
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select distinct order_id from orders where userid=?");
       ps.setString(1,userId);
       ResultSet rs= ps.executeQuery();
       ArrayList<String> oList=new ArrayList<String>();
       while(rs.next())
       {
           oList.add(rs.getString(1));
       }
       return oList;
    }
    
    public static List<String> getAllUsersId()throws SQLException
    {
       
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select distinct userid from orders");
       ResultSet rs= ps.executeQuery();
       ArrayList<String> uList=new ArrayList<String>();
       while(rs.next())
       {
           uList.add(rs.getString(1));
       }
       return uList;
    }
    
}
