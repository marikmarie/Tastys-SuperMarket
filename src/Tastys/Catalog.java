package Tastys;

import Tastys.Product.Item;
import Tastys.Product.ProductFactory;
import ItemWrap.WrappedItem;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Catalog extends javax.swing.JFrame {

    String urlstring = "jdbc:mysql://localhost:3306/Tasty's";
    String driverName = "com.mysql.cj.jdbc.Driver";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement stmt = null;

    public Catalog() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        idtxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        qtytxt = new javax.swing.JTextField();
        categorytxt = new javax.swing.JComboBox<>();
        newItem = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        pricetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        catalogtable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        gotoPOS = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        psrch = new java.awt.TextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchtable = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Catalog");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 170, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Category");

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Qty");

        categorytxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics", "Clothing", "Groceries" }));
        categorytxt.setToolTipText("");
        categorytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorytxtActionPerformed(evt);
            }
        });

        newItem.setBackground(new java.awt.Color(204, 204, 255));
        newItem.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        newItem.setForeground(new java.awt.Color(0, 0, 102));
        newItem.setText("New");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });

        updatebutton.setBackground(new java.awt.Color(204, 204, 255));
        updatebutton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        updatebutton.setForeground(new java.awt.Color(0, 0, 102));
        updatebutton.setText("Update");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        deletebutton.setBackground(new java.awt.Color(204, 204, 255));
        deletebutton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deletebutton.setForeground(new java.awt.Color(0, 0, 102));
        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(204, 204, 255));
        searchbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(0, 0, 102));
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(newItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletebutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                            .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(categorytxt, javax.swing.GroupLayout.Alignment.LEADING, 0, 235, Short.MAX_VALUE)
                                .addComponent(nametxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idtxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(qtytxt)))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categorytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(qtytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deletebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updatebutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 380, 270));
        jPanel1.getAccessibleContext().setAccessibleName("Add Item"); // NOI18N

        catalogtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Category", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(catalogtable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 430, 300));

        gotoPOS.setBackground(new java.awt.Color(204, 204, 204));
        gotoPOS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gotoPOS.setForeground(new java.awt.Color(0, 0, 102));
        gotoPOS.setText("CART");
        gotoPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoPOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(gotoPOS)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gotoPOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 60, 120, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 20, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setText("Catalog");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, 30));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        psrch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Search ID:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Item Info:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psrch, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(psrch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 370, 80));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Search ID:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 90, -1));

        searchtable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtableMouseClicked(evt);
            }
        });
        searchtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtableActionPerformed(evt);
            }
        });
        searchtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtableKeyReleased(evt);
            }
        });
        getContentPane().add(searchtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void updateTable() {
        int count;
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
                String sql = "SELECT * FROM catalog";
                stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                ResultSetMetaData rs_metadata = rs.getMetaData();
                count = rs_metadata.getColumnCount();
                DefaultTableModel DF = (DefaultTableModel) catalogtable.getModel();
                DF.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 0; i <= count; i++) {
                        v.add(rs.getString("id"));
                        v.add(rs.getString("name"));
                        v.add(rs.getString("category"));
                        v.add(rs.getString("price"));
                    }
                    DF.addRow(v);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
    }

    private void gotoPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoPOSActionPerformed
        // TODO add your handling code here:
        this.dispose();
//        POS pos = new POS();
//        pos.setVisible(true);
    }//GEN-LAST:event_gotoPOSActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtableMouseClicked

    }//GEN-LAST:event_searchtableMouseClicked

    private void searchtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtableActionPerformed

    private void searchtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtableKeyReleased
        //Key released

        String name = searchtable.getText();
        try {
            Class.forName(driverName);
            try {

                con = DriverManager.getConnection(urlstring, username, password);
                String sql = "SELECT *FROM catalog WHERE name LIKE '%" + name + "%'";
                stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel DF = (DefaultTableModel) catalogtable.getModel();
                DF.setRowCount(0);
                while (rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getString(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getString(4));
                    DF.addRow(v);
                }
                con.close();

            } catch (SQLException e) {

                updateTable();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");

        }

    }//GEN-LAST:event_searchtableKeyReleased

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed

        String id = psrch.getText();

try {
    Class.forName(driverName);
    try (Connection con = DriverManager.getConnection(urlstring, username, password)) {
        String sql = "DELETE FROM catalog WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, id);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            idtxt.setText("");
            nametxt.setText("");
            categorytxt.setSelectedItem(null);
            qtytxt.setText("");
            JOptionPane.showMessageDialog(null, "Item deleted");
        } else {
            JOptionPane.showMessageDialog(null, "Item not found");
        }
    } catch (SQLException e) {
        System.out.printf("Error: %s%n", e.getMessage());
    }
} catch (ClassNotFoundException e) {
    System.out.println("Driver not found.");
}

        updateTable();
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
  ProductFactory factory = new ProductFactory();
Item item = factory.getItemCategory(categorytxt.getSelectedItem().toString());
item.builditem(Integer.parseInt(idtxt.getText()), nametxt.getText(), Integer.parseInt(pricetxt.getText()),Integer.parseInt(qtytxt.getText()));

String id = idtxt.getText();
String name = nametxt.getText();
String category = (String) categorytxt.getSelectedItem();
String price = pricetxt.getText();
String qty = qtytxt.getText();

try {
    Class.forName(driverName);
    try (Connection con = DriverManager.getConnection(urlstring, username, password)) {
        String sql = "UPDATE catalog SET id = ?, name = ?, category = ?, price = ? qty = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(id));
        stmt.setString(2, name);
        stmt.setString(3, category);
        stmt.setString(4, price);
        stmt.setString(5, qty);
        stmt.setInt(6, Integer.parseInt(id));

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Item Updated");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Item not found");
        }
    } catch (SQLException e) {
        System.out.printf("Error: %s%n", e.getMessage());
    }
} catch (ClassNotFoundException e) {
    System.out.println("Driver not found.");
}

        updateTable();
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemActionPerformed
        ProductFactory factory = new ProductFactory();
        Item item = factory.getItemCategory(categorytxt.getSelectedItem().toString());
        item.builditem(parseInt(idtxt.getText()), nametxt.getText(), parseInt(pricetxt.getText()), parseInt(qtytxt.getText()));
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
                String sql = "INSERT INTO catalog(id, name, category, price, qty) VALUES(?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, item.getId());
                stmt.setString(2, item.getName());
                stmt.setString(3, item.getCategory());
                
                //If statement is for decorator pattern such that all electronics are bought at an extra 1000 for wrapping
                if (item.getCategory().equalsIgnoreCase("Electronics")) {
                    Item wrappedProduct = new WrappedItem(item);
                    stmt.setInt(4, wrappedProduct.getPrice());
                } //                else if(item.getCategory().equalsIgnoreCase("Electronics")){
                //                    Item shippedProduct = new ShippedItem(item);
                //                    stmt.setInt(4, shippedProduct.getPrice());
                //                }else if(item.getCategory().equalsIgnoreCase("Clothing")){
                //                    Item shippedProduct = new ShippedItem(item);
                //                    stmt.setInt(4, shippedProduct.getPrice());
                //                }
                else {
                    //wrapping and shipping  not used
                    stmt.setInt(4, item.getPrice());
                }
                stmt.setInt(5, item.getQty());
                
                stmt.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(this, "Item Saved");
                updateTable();
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }

    }//GEN-LAST:event_newItemActionPerformed

    private void categorytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categorytxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        //Serach btn
        String search = psrch.getText();
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
                String sql = "SELECT *FROM catalog WHERE id ='" + search + "'";
                stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    idtxt.setText(rs.getString("id"));
                    nametxt.setText(rs.getString("name"));
                    categorytxt.setSelectedItem(rs.getString("category"));
                    qtytxt.setText(rs.getString("qty"));
                    pricetxt.setText(rs.getString("price"));

                }
                con.close();
            } catch (SQLException e) {
                System.out.println("Failed to create the database connection.");

            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
        updateTable();
    }//GEN-LAST:event_searchbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable catalogtable;
    private javax.swing.JComboBox<String> categorytxt;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton gotoPOS;
    private javax.swing.JTextField idtxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JButton newItem;
    private javax.swing.JTextField pricetxt;
    private java.awt.TextField psrch;
    private javax.swing.JTextField qtytxt;
    private javax.swing.JButton searchbtn;
    private java.awt.TextField searchtable;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables

}
