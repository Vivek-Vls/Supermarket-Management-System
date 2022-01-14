/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import emart.dbutil.DBConnection;
import emart.pojo.ProductPojo;
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
public class ProductDAO {
    public static String getNextProductId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(p_id) from products");
        
        rs.next();
        
         String pid=rs.getString(1);
         if(pid==null)
         return"P101";    
         int id=Integer.parseInt(pid.substring(1));
         id++;
         return "P"+id;
       
            
    }
    
    public static boolean addProduct(ProductPojo p) throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?,?,?,'Y')");
       ps.setString(1,p.getpId());
       ps.setString(2,p.getProductName());
       ps.setString(3,p.getProductCompany());
       ps.setDouble(4,p.getProductPrice());
       ps.setDouble(5,p.getOurPrice());
       ps.setInt(6,p.getTax());
       ps.setInt(7,p.getQuantity());
       int x=ps.executeUpdate();
       return x==1;
    }
         
    public static List<ProductPojo> getProductsDetails()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from products where status='Y' order by p_id");
        ArrayList<ProductPojo> pList=new ArrayList<ProductPojo>();
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
          pList.add(p);
        }
       return pList;
    }
    
    
    public static boolean deleteProduct(String pId)throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update products set status='N' where p_id=?");
       ps.setString(1,pId);
       int x=ps.executeUpdate();
       return x==1;
    }
    
      public static boolean updateProduct(ProductPojo p) throws SQLException
      {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update products set p_name=?,p_companyname=?,p_price=?,our_price=?,p_tax=?,quantity=? where p_id=?");
      
       ps.setString(1,p.getProductName());
       ps.setString(2,p.getProductCompany());
       ps.setDouble(3,p.getProductPrice());
       ps.setDouble(4,p.getOurPrice());
       ps.setInt(5,p.getTax());
       ps.setInt(6,p.getQuantity());
       ps.setString(7,p.getpId());
       int x=ps.executeUpdate();
       return x==1;
      }
     
      public static ProductPojo getProductsDetails(String pId)throws SQLException
      {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select * from  products where p_id=? and status='Y'");
         ps.setString(1,pId);
         ResultSet rs=ps.executeQuery();
         ProductPojo p=null;
         if(rs.next())
         {
           p=new ProductPojo();
           p.setpId(rs.getString(1));
           p.setProductName(rs.getString(2));
           p.setProductCompany(rs.getString(3));
           p.setProductPrice(rs.getDouble(4));
           p.setOurPrice(rs.getDouble(5));
           p.setTax(rs.getInt(6));
         }
         return p;
      }
     public static boolean updateStocks(List<ProductPojo> pList)throws SQLException
      {
           Connection conn=DBConnection.getConnection();
           conn.setAutoCommit(false);
           PreparedStatement ps=conn.prepareStatement("update products set quantity=quantity-? where p_id=?");
           for(ProductPojo p:pList)
           {
             ps.setInt(1,p.getQuantity());
             ps.setString(2,p.getpId());
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
 }


