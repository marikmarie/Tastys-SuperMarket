package Tastys;

import Tastys.Product.Product;
import Tastys.Product.ProductCatalog;
import Tastys.Product.SalesPerson;
import Tastys.Product.ShoppingCart;
import barcodescanner.*;
import Product.*;
import Payment.*;
import java.awt.print.PrinterException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class POS extends javax.swing.JFrame {

    String url = "jdbc:mysql://localhost:3306/tasty's";
    String driverName = "com.mysql.cj.jdbc.Driver";
    String userName = "root";
    String password = "";
    Connection con = null;
    PreparedStatement stmt = null;

    public POS() {
        initComponents();
        //this.setLocation(500,120);
        updateTable();
    }

    @SuppressWarnings("unchecked")

    private void updateTable() {
        ProductCatalog product = ProductCatalog.getInstance();
        ArrayList<Product> products = product.getProducts();
        DefaultTableModel DF = (DefaultTableModel) productTable.getModel();
        DF.setRowCount(0);
        for (Product pdt : products) {
            Vector v = new Vector();
            v.add(pdt.getId());
            v.add(pdt.getName());
            v.add(pdt.getPrice());
            v.add(pdt.getCategory());
            DF.addRow(v);
        }
    }

    public void generateReceipt() {
        String total = totalfield.getText();

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) cartTable.getModel();

        txtbill.setText(txtbill.getText() + "************************************\n");
        txtbill.setText(txtbill.getText() + "        TASTY'S SUPERMARKET     \n");
        txtbill.setText(txtbill.getText() + "************************************\n");
        

        for (int i = 0; i < model.getRowCount(); i++) {
            String item = (String) model.getValueAt(i, 0).toString();
            String quantity = (String) model.getValueAt(i, 1).toString();
            String price = (String) model.getValueAt(i, 2).toString();
            txtbill.setText(txtbill.getText()  + "\t" + item + "\t " + quantity + " \t" + price + "\n");
        }
        txtbill.setText(txtbill.getText() + "\n");

        txtbill.setText(txtbill.getText() + " " + "\t" + "SubTotal :" + total + "\n");
        txtbill.setText(txtbill.getText() + "************************************\n");
        txtbill.setText(txtbill.getText() + "      THANK YOU      \n");
    }

    private void clearCart() {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0);
        cartTotal();
    }

    private void cartTotal() {
        int total = 0;
        int quantityColIndex = 1;
        int priceColIndex = 2;
        for (int i = 0; i < cartTable.getRowCount(); i++) {
            int quantity = Integer.parseInt(cartTable.getValueAt(i, quantityColIndex).toString());
            int price = Integer.parseInt(cartTable.getValueAt(i, priceColIndex).toString());
            int totalPrice = quantity * price;
            total += totalPrice;
        }
        totalfield.setText(String.valueOf(total));
    }

    private void barcodescanner(int itemId) {
        Barcodescanner scanner = new Barcodescanner();
        ObserverScanner cart = new ObserverScanner();
        scanner.registerObserver(cart);
        scanner.notifyObserver(itemId);
        int itemCode = cart.getCode();
        int rows = productTable.getRowCount();
        DefaultTableModel DF = (DefaultTableModel) cartTable.getModel();
        Vector v = new Vector();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                int itemcodeInCatalog = parseInt(productTable.getValueAt(i, 0).toString());
                if (itemCode == itemcodeInCatalog) {
                    String name = productTable.getValueAt(i, 1).toString();
                    int price = parseInt(productTable.getValueAt(i, 2).toString());
                    v.add(name);
                    v.add(1);
                    v.add(price);
                    DF.addRow(v);
                    cartTotal();

                    // notify salesperson
                    ShoppingCart notification_cart = new ShoppingCart();
                    SalesPerson salesperson = new SalesPerson("Cashier");
                    notification_cart.registerObserver(salesperson);
                    String notification = notification_cart.notifyObserver();
                    JOptionPane.showMessageDialog(this, notification);
                    break;
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "   No items");
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        searchtable = new java.awt.TextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addtocart = new javax.swing.JButton();
        itemname = new javax.swing.JTextField();
        idtxt = new javax.swing.JTextField();
        ScanBarcode = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        psrch = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        cartPrice = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        increaseQuantity = new javax.swing.JButton();
        removeItemFromCart = new javax.swing.JButton();
        decreaseQuantity = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        receipt = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        PaymentOption = new javax.swing.JComboBox<>();
        payButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        totalfield = new java.awt.TextField();
        gotoPOS = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        print1 = new java.awt.Button();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("TASTY'S SUPERMARKET");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 310, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products available", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(searchtable, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchtable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 420, 450));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Find Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Product ID:");

        addtocart.setBackground(new java.awt.Color(204, 204, 204));
        addtocart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addtocart.setForeground(new java.awt.Color(0, 0, 102));
        addtocart.setText("Add to cart");
        addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartActionPerformed(evt);
            }
        });

        idtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtxtActionPerformed(evt);
            }
        });

        ScanBarcode.setBackground(new java.awt.Color(204, 204, 204));
        ScanBarcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ScanBarcode.setForeground(new java.awt.Color(0, 0, 102));
        ScanBarcode.setText("Scan Barcode");
        ScanBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanBarcodeActionPerformed(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(204, 204, 204));
        searchbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(0, 0, 102));
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        psrch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        psrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psrchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Search ID:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(psrch, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(psrch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ScanBarcode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(searchbtn))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(idtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                            .addComponent(itemname))))
                                .addGap(43, 43, 43)))
                        .addComponent(addtocart)
                        .addGap(22, 22, 22)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScanBarcode)
                    .addComponent(searchbtn)
                    .addComponent(addtocart))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 430, 190));

        cartPrice.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cartTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cartTable.setForeground(new java.awt.Color(204, 204, 204));
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cartTable);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        increaseQuantity.setBackground(new java.awt.Color(204, 204, 204));
        increaseQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        increaseQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tastys/07_plus-20.png"))); // NOI18N
        increaseQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseQuantityMouseClicked(evt);
            }
        });
        increaseQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseQuantityActionPerformed(evt);
            }
        });

        removeItemFromCart.setBackground(new java.awt.Color(204, 204, 204));
        removeItemFromCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removeItemFromCart.setText("Remove ");
        removeItemFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemFromCartActionPerformed(evt);
            }
        });

        decreaseQuantity.setBackground(new java.awt.Color(204, 204, 204));
        decreaseQuantity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        decreaseQuantity.setText("-");
        decreaseQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decreaseQuantityMouseClicked(evt);
            }
        });
        decreaseQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeItemFromCart)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(decreaseQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(increaseQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(increaseQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decreaseQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeItemFromCart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cartPriceLayout = new javax.swing.GroupLayout(cartPrice);
        cartPrice.setLayout(cartPriceLayout);
        cartPriceLayout.setHorizontalGroup(
            cartPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPriceLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cartPriceLayout.setVerticalGroup(
            cartPriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cartPriceLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(cartPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 430, 250));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 270, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 50, 100));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        receipt.setBackground(new java.awt.Color(204, 204, 204));
        receipt.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 15)); // NOI18N
        receipt.setForeground(new java.awt.Color(0, 0, 102));
        receipt.setText("Generate Receipt");
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });
        receipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receiptKeyPressed(evt);
            }
        });

        PaymentOption.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PaymentOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CreditCardPayment", "CashPayment", " " }));
        PaymentOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentOptionActionPerformed(evt);
            }
        });

        payButton.setBackground(new java.awt.Color(204, 204, 204));
        payButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        payButton.setForeground(new java.awt.Color(0, 0, 102));
        payButton.setText("Pay");
        payButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payButtonMouseClicked(evt);
            }
        });
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(PaymentOption, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(payButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentOption, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TOTAL:");

        totalfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalfield, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(receipt)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 870, 100));

        gotoPOS.setBackground(new java.awt.Color(204, 204, 204));
        gotoPOS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gotoPOS.setForeground(new java.awt.Color(0, 0, 102));
        gotoPOS.setText("CART");
        gotoPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotoPOSActionPerformed(evt);
            }
        });
        getContentPane().add(gotoPOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 90, 40));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtbill.setColumns(20);
        txtbill.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtbill.setRows(5);
        jScrollPane3.setViewportView(txtbill);

        print1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        print1.setLabel("Print");
        print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(print1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(print1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 370, 510));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 1250, -1));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 120, -1, 630));

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Receipt");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 370, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeItemFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemFromCartActionPerformed
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        int selectedrow = cartTable.getSelectedRow();
        if (selectedrow >= 0) {
            model.removeRow(selectedrow);
        } else {

            //Empty cart
            if (cartTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Empty Cart");
            } else {
                // if cart is not empty but no item row selected
                JOptionPane.showMessageDialog(this, "Select one item to remove from Cart");
            }
        }
        cartTotal();
    }//GEN-LAST:event_removeItemFromCartActionPerformed

    private void increaseQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseQuantityMouseClicked
        int selectedRow = cartTable.getSelectedRow();
        int currentValue;
        if (selectedRow >= 0) {
            currentValue = parseInt(cartTable.getValueAt(selectedRow, 1).toString());
            currentValue = currentValue + 1;
            cartTable.setValueAt(currentValue, selectedRow, 1);
        }
        cartTotal();
    }//GEN-LAST:event_increaseQuantityMouseClicked

    private void increaseQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_increaseQuantityActionPerformed

    private void gotoPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoPOSActionPerformed
        // TODO add your handling code here:
        this.dispose();
        POS POS = new POS();
        POS.setVisible(true);
    }//GEN-LAST:event_gotoPOSActionPerformed

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
//   clearCart();    
        generateReceipt();

    }//GEN-LAST:event_receiptActionPerformed

    private void payButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payButtonMouseClicked
        int items_available = cartTable.getRowCount();
        if (items_available < 1) {
            JOptionPane.showMessageDialog(this, "cart is empty");
        } else {
            int countRows = cartTable.getRowCount();
            String[] items = new String[countRows];
            String[] itemQuantity = new String[countRows];
            String[] pricePerItem = new String[countRows];
            int total = parseInt(totalfield.getText());

            for (int i = 0; i < countRows; i++) {
                items[i] = cartTable.getValueAt(i, 0).toString();
                itemQuantity[i] = cartTable.getValueAt(i, 1).toString();
                pricePerItem[i] = cartTable.getValueAt(i, 2).toString();
            }

            //now we use the strategy design pattern
            PaymentContext paymentContext = new PaymentContext(new CashPayment());
            String selectedPaymentOption = PaymentOption.getSelectedItem().toString();
            if (selectedPaymentOption.equalsIgnoreCase("CashPayment")) {
                //by default its cash payment
                String paymentMethod = paymentContext.pay();
                try {
                    Class.forName(driverName);
                    try {
                        con = DriverManager.getConnection(url, userName, password);
                        String sql = "INSERT INTO shoppingcart(item, quantity, price, total, paymentMethod) VALUES(?,?,?,?,?)";
                        stmt = con.prepareStatement(sql);
                        stmt.setString(1, Arrays.toString(items));
                        stmt.setString(2, itemQuantity[0]);
                        stmt.setString(3, pricePerItem[0]);
                        stmt.setInt(4, total);
                        stmt.setString(5, paymentMethod);
                        stmt.executeUpdate();
                        con.close();
                    } catch (SQLException ex) {
                        System.out.printf("%s\n",ex.getMessage());
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("Driver not found.");
                }
                JOptionPane.showMessageDialog(this, "Paid");
            }
            if (selectedPaymentOption.equalsIgnoreCase("CreditCardPayment")) {
                String cardNumber = JOptionPane.showInputDialog("Card Number");
                String cvv = JOptionPane.showInputDialog("cvv");
                //we dynamically change the context to creaditcard payment
                CreditCardPayment cardpay = new CreditCardPayment(cardNumber, cvv);
                paymentContext.setPaymentStrategy(cardpay);
                String paymentMethod = paymentContext.pay();
                try {
                    Class.forName(driverName);
                    try {
                        con = DriverManager.getConnection(url, userName, password);
                        String sql = "INSERT INTO shoppingcart(item, quantity, price, total, paymentMethod) VALUES(?,?,?,?,?)";
                        stmt = con.prepareStatement(sql);
                        stmt.setString(1, Arrays.toString(items));
                        stmt.setString(2, itemQuantity[0]);
                        stmt.setString(3, pricePerItem[0]);
                        stmt.setInt(4, total);
                        stmt.setString(5, paymentMethod);
                        stmt.executeUpdate();
                        con.close();
                    } catch (SQLException ex) {
                        System.out.printf("  %s",ex.getMessage());
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("Driver not found.");
                }
                JOptionPane.showMessageDialog(this, "Paid");
                //clearCart();
            }
        }

    }//GEN-LAST:event_payButtonMouseClicked

    private void PaymentOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymentOptionActionPerformed

    private void receiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receiptKeyPressed
        generateReceipt();
    }//GEN-LAST:event_receiptKeyPressed

    private void decreaseQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decreaseQuantityMouseClicked
        int selectedRow = cartTable.getSelectedRow();
        int currentValue;
        if (selectedRow >= 0) {
            currentValue = parseInt(cartTable.getValueAt(selectedRow, 1).toString());
            if (currentValue >= 2) {
                currentValue = currentValue - 1;
                cartTable.setValueAt(currentValue, selectedRow, 1);
            }
        }
        cartTotal();
    }//GEN-LAST:event_decreaseQuantityMouseClicked

    private void decreaseQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_decreaseQuantityActionPerformed

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

                con = DriverManager.getConnection(url, userName, password);
                String sql = "SELECT *FROM catalog WHERE name LIKE '%" + name + "%'";
                stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel DF = (DefaultTableModel) productTable.getModel();
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

    private void totalfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalfieldActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        //Serach btn
        String search = psrch.getText();
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, userName, password);
                String sql = "SELECT *FROM catalog WHERE id ='" + search + "'";
                stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    idtxt.setText(rs.getString("id"));
                    itemname.setText(rs.getString("name"));
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

    private void ScanBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanBarcodeActionPerformed

        int code = parseInt(JOptionPane.showInputDialog("Product Code"));
        barcodescanner(code);
    }//GEN-LAST:event_ScanBarcodeActionPerformed

    private void idtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtxtActionPerformed

    }//GEN-LAST:event_idtxtActionPerformed

    private void addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartActionPerformed
        int itemId = parseInt(idtxt.getText());
        String itemName = itemname.getText();
        int found = 0;
        Product p = null;
        ProductCatalog product = ProductCatalog.getInstance();
        ArrayList<Product> products = product.getProducts();
        DefaultTableModel DF = (DefaultTableModel) cartTable.getModel();
        for (Product pdt : products) {
            if (pdt.getName().equalsIgnoreCase(itemName) && pdt.getId() == itemId) {
                found = 1;
                p = pdt;
                break;
            }
        }
        if (found == 1) {
            Vector v = new Vector();
            v.add(p.getName());
            v.add(1);
            v.add(p.getPrice());
            DF.addRow(v);

            // notify salesperson
            ShoppingCart cart = new ShoppingCart();
            SalesPerson salesperson = new SalesPerson("Cashier");
            cart.registerObserver(salesperson);
            String notification = cart.notifyObserver();
            JOptionPane.showMessageDialog(this, notification);
        } else {
            JOptionPane.showMessageDialog(this, "Item not found");
        }
        cartTotal();
    }//GEN-LAST:event_addtocartActionPerformed

    private void psrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psrchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psrchActionPerformed

    private void print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print1ActionPerformed
        clearCart();
        try {
            // TODO add your handling code here:

            txtbill.print();
        } catch (PrinterException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_print1ActionPerformed

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> PaymentOption;
    private javax.swing.JButton ScanBarcode;
    private javax.swing.JButton addtocart;
    private javax.swing.JPanel cartPrice;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton decreaseQuantity;
    private javax.swing.JButton gotoPOS;
    private javax.swing.JTextField idtxt;
    private javax.swing.JButton increaseQuantity;
    private javax.swing.JTextField itemname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton payButton;
    private java.awt.Button print1;
    private javax.swing.JTable productTable;
    private java.awt.TextField psrch;
    private javax.swing.JButton receipt;
    private javax.swing.JButton removeItemFromCart;
    private javax.swing.JButton searchbtn;
    private java.awt.TextField searchtable;
    private java.awt.TextField totalfield;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
