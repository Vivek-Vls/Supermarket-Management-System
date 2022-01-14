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
public class ProductPojo {

    private String pId;
    private String productName;
    private String productCompany;
    private double productPrice;
    private double ourPrice;
    private int quantity;
    private int tax;
    private double total;

    public ProductPojo(String pId, String productName, String productCompany, double productPrice, double ourPrice, int quantity, int tax,double total) {
        this.pId = pId;
        this.productName = productName;
        this.productCompany = productCompany;
        this.productPrice = productPrice;
        this.ourPrice = ourPrice;
        this.quantity = quantity;
        this.tax = tax;
        this.total=total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public ProductPojo()
    {
    
    }
    
    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public String getpId() {
        return pId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public int getTax() {
        return tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }
   
}
