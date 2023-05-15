package vmp;

import java.sql.Connection;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class intvm1 extends javax.swing.JFrame {

    public intvm1() {
        initComponents();
        Connect();
        Fetch();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private final String uName = "root";
    private final String uPass = "";
    private final String host = "jdbc:mysql://localhost:3306/vmachine";

    private void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try {
                con = (Connection) DriverManager.getConnection(host,uName,uPass);
            } catch (SQLException ex) {
                Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void Fetch()
    {
        try
        {
            int q;
        
            pst = con.prepareStatement("SELECT * FROM product_tb");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
        
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next())
            {
                Vector v2 = new Vector();
                for(int a = 1; a <= q; a++)
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("price"));
                    
                }
                df.addRow(v2);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpid = new javax.swing.JTextField();
        txtpname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        udBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Product Price:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel3.setText("Product Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel4.setText("Product id:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        getContentPane().add(txtpid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 100, -1));

        txtpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 100, -1));
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 100, -1));

        newBtn.setText("Clear all");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        udBtn.setText("Update");
        udBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Del");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(newBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(udBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBtn)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBtn)
                    .addComponent(udBtn)
                    .addComponent(delBtn)
                    .addComponent(addBtn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 360, 50));

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 100, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Product", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 330, 220));

        jLabel1.setText("Vending Machine Inventory");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpnameActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try {
            String pname = txtpname.getText();
            String price = txtprice.getText();
            String id = txtpid.getText();
            
            pst = con.prepareStatement("INSERT INTO product_tb (pname, price, id)VALUES(?, ?, ?)");
            
            pst.setString(3, id);
            pst.setString(1, pname);
            pst.setString(2, price);
                        
            int k = pst.executeUpdate();
            
            if(k ==1){
                JOptionPane.showMessageDialog(this, "Record added successfully!");
                txtpname.setText("");
                txtprice.setText("");
                txtpid.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to save!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            String pid = txtpid.getText();
            
            pst = con.prepareStatement("SELECT * FROM product_tb WHERE id=?");
            pst.setString(1, pid);
            rs = pst.executeQuery();
            
            if(rs.next() == true){
                txtpname.setText(rs.getString(2));
                txtprice.setText(rs.getString(3));
                txtpid.setText(rs.getString(4));
            }else{
                JOptionPane.showMessageDialog(this, "No Records Found!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        try {
            try {
                String pid = txtpid.getText();
                try {
                    pst = con.prepareStatement("DELETE FROM product_tb WHERE id=?");
                } catch (SQLException ex) {
                    Logger.getLogger(invm.class.getName()).log(Level.SEVERE, null, ex);
                }
                pst.setString(1, pid);
            } catch (SQLException ex) {
                Logger.getLogger(invm.class.getName()).log(Level.SEVERE, null, ex);
            }
            int k = pst.executeUpdate();
            
            if(k ==1){
                JOptionPane.showMessageDialog(this, "Record hass been deleted.");
                txtpname.setText("");
                txtprice.setText("");
                txtpid.setText("");
                txtpname.requestFocus();
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Record has failed to delete.");
            }
        } catch (SQLException ex) {
                Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_delBtnActionPerformed

    private void udBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_udBtnActionPerformed
        try {
            String pname = txtpname.getText();
            String price = txtprice.getText();
            String id = txtpid.getText();
            
            pst = con.prepareStatement("UPDATE product_tb SET pname=?,price=? WHERE id=?");
            
            pst.setString(3, id);
            pst.setString(1, pname);
            pst.setString(2, price);

                        
            int k = pst.executeUpdate();
            if(k == 1){
                JOptionPane.showMessageDialog(this, "Record has been updated!");
                txtpname.setText("");
                txtprice.setText("");
                txtpid.setText("");
                Fetch();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(intvm1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_udBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
                    txtpname.setText("");
                   txtprice.setText("");
                   txtpid.setText("");
    }//GEN-LAST:event_newBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(intvm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(intvm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(intvm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(intvm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new intvm1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JButton udBtn;
    // End of variables declaration//GEN-END:variables

}
