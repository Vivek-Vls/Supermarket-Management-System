/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.gui;

import emart.dao.OrdersDAO;
import emart.dao.ProductDAO;
import emart.pojo.ProductPojo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vivek
 */
public class BillingFrame extends javax.swing.JFrame {
   ArrayList<ProductPojo> pList =new ArrayList<ProductPojo>();
   DefaultTableModel tm;
   double total=0;
    public BillingFrame() {
        initComponents();
        setLocationRelativeTo(null);
        tm=(DefaultTableModel)jtProductDetails.getModel();
        txtProductId.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnGenerateBill = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        panel.setBackground(new java.awt.Color(204, 0, 0));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Billing Option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jtProductDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtProductDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Product Company", "Product Price ", "Our Price", "Quantity", "Tax", "Total"
            }
        ));
        jtProductDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductDetails);
        if (jtProductDetails.getColumnModel().getColumnCount() > 0) {
            jtProductDetails.getColumnModel().getColumn(6).setResizable(false);
            jtProductDetails.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Id");

        txtProductId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIdActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(204, 0, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(204, 0, 0));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(30, 30, 30)
                        .addComponent(btnLogOut)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(48, 48, 48)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogOut)
                            .addComponent(btnBack))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(7, 7, 7))
        );

        btnGenerateBill.setBackground(new java.awt.Color(204, 0, 0));
        btnGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnGenerateBill.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total :");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 391, Short.MAX_VALUE)
                        .addComponent(btnGenerateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGenerateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        LoginFrame lf=new LoginFrame();
        lf.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void txtProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIdActionPerformed
         if(txtProductId.getText().trim().isEmpty())
         {
            JOptionPane.showMessageDialog(null,"Please enter product id!","Incomplete data!",JOptionPane.INFORMATION_MESSAGE);
            return;
         }
         loadItemList(txtProductId.getText().trim());
         txtProductId.setText("");
    }//GEN-LAST:event_txtProductIdActionPerformed

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        try
        {
          boolean res=ProductDAO.updateStocks(pList);
          if(!res)
          {
              JOptionPane.showMessageDialog(null,"Try again","Error!",JOptionPane.ERROR_MESSAGE);    
          }
          
          String oId=OrdersDAO.getNextOrderId();
          OrdersDAO.updateOrders(pList, oId);
          clearText();
        }
        catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null,"DB Error","Error!",JOptionPane.ERROR_MESSAGE);    
             ex.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
          ReceptionistOptionFrame rf =new ReceptionistOptionFrame();
          rf.setVisible(true);
          dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
           int row =jtProductDetails.getSelectedRow();
           if(row==-1)
           {
             JOptionPane.showMessageDialog(null,"Please select a row !","Error",JOptionPane.INFORMATION_MESSAGE);
             return;
           }
           total=total-Double.parseDouble(jtProductDetails.getValueAt(row,7).toString());
           lblTotal.setText(String.format("%.2f",total));
           tm.removeRow(row);
           pList.remove(row);
           btnDelete.setEnabled(false);   
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jtProductDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductDetailsMouseClicked
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_jtProductDetailsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductDetails;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtProductId;
    // End of variables declaration//GEN-END:variables

    private void loadItemList(String pId) {
       try
       {
          ProductPojo pj=ProductDAO.getProductsDetails(pId);
          if(pj==null)
          {
            JOptionPane.showMessageDialog(null,"Please enter a valid product id!","Error",JOptionPane.INFORMATION_MESSAGE);
            return;
          }
          
          int count=0;
          for(ProductPojo p1:pList)
          {
             if(p1.getpId().equals(pj.getpId()))
             {   
                pj.setQuantity(p1.getQuantity()+1);
                pj.setTotal((pj.getOurPrice()+(pj.getOurPrice()*pj.getTax()/100))*pj.getQuantity());
                total-=p1.getTotal();
                total+=pj.getTotal();
                pList.set(count,pj);
                tm.setValueAt(pj.getQuantity(),count,5);
                tm.setValueAt(pj.getTotal(),count,7);
                lblTotal.setText(String.format("%.2f",total));
                return;
                
             }
             count++;
          }
         pj.setQuantity(1);
         pj.setTotal(pj.getOurPrice()+(pj.getOurPrice()*pj.getTax()/100));
         total+=pj.getTotal();
         pList.add(pj); 
         Object [] row=new Object[8];
            row[0]=pj.getpId();
            row[1]=pj.getProductName();
            row[2]=pj.getProductCompany();
            row[3]=pj.getProductPrice();
            row[4]=pj.getOurPrice();
            row[5]=pj.getQuantity();
            row[6]=pj.getTax()+"%";
            row[7]=pj.getTotal();
            tm.addRow(row);
            lblTotal.setText(String.format("%.2f",total));
          
       }
       catch(SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"DB Error","Error!",JOptionPane.ERROR_MESSAGE);    
             ex.printStackTrace();
        }
    }

    private void clearText() {
          tm.setRowCount(0);
          pList.removeAll(pList);
          total=0;
          lblTotal.setText("");
          btnDelete.setEnabled(false);
          txtProductId.requestFocus();
    }
}