package Home;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MARIAM
 */
public class ProInfo extends javax.swing.JInternalFrame {
String urlstring = "jdbc:mysql://localhost:3306/Tasty's";
    String driverName = "com.mysql.cj.jdbc.Driver";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement stmt = null;
    public ProInfo() {
        initComponents();
        
        this.setLocation(330,40);
      updateTable();
    }
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
                        v.add(rs.getString("qty"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchtable = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        catalogtable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Product Information");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Product Information");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Search ID:");

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

        catalogtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Category", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(catalogtable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchtable, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(155, 155, 155)))
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(searchtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    v.add(rs.getString(5));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable catalogtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField searchtable;
    // End of variables declaration//GEN-END:variables
}
