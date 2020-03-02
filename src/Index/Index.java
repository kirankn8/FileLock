package Index;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Index extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public Index() {
        initComponents();
        try {
            conn = Connect.ConnectDB();
            Update_table();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        heading = new javax.swing.JPanel();
        app_name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        index = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        signin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        signup = new javax.swing.JPanel();
        susername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        guest_user = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPasswordField4 = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        window = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        filepath = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Filelock = new javax.swing.JTable();
        txt_location = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        window1 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        filepath1 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(50, 50));

        heading.setBackground(new java.awt.Color(0, 102, 255));
        heading.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        app_name.setBackground(new java.awt.Color(255, 204, 0));
        app_name.setFont(new java.awt.Font("Cooper Black", 3, 48)); // NOI18N
        app_name.setText("FILE LOCK");
        app_name.setOpaque(true);
        heading.add(app_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 310, 57));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Index/IMG_20160208_234046.jpg"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        heading.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 120));

        getContentPane().add(heading, java.awt.BorderLayout.PAGE_START);

        body.setPreferredSize(new java.awt.Dimension(740, 423));
        body.setLayout(new java.awt.CardLayout());

        index.setBackground(new java.awt.Color(0, 102, 255));
        index.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setText("next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        index.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 323, 109, 39));

        jTextPane1.setBackground(new java.awt.Color(0, 102, 255));
        jTextPane1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, body, org.jdesktop.beansbinding.ELProperty.create("File Lock software is a light weight portable locker  that protects your privacy by helping you encrypt files of any format on your desktop system. "), jTextPane1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(jTextPane1);

        index.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 490, -1));

        body.add(index, "card4");

        signin.setBackground(new java.awt.Color(0, 102, 255));
        signin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Username");
        signin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 89, 158, 28));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("SignIn");
        signin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 11, 103, -1));

        jButton2.setBackground(new java.awt.Color(51, 255, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("SignIn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        signin.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 196, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Do not have an account yet ???  Then ");
        signin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 241, 33));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("SignUp");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        signin.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Login as Guest User");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        signin.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("or");
        signin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 34, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Password");
        signin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 160, 30));
        signin.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 91, 333, 28));
        signin.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 330, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        signin.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 580, 20));

        body.add(signin, "card3");

        signup.setBackground(new java.awt.Color(0, 102, 255));
        signup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        susername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                susernameActionPerformed(evt);
            }
        });
        signup.add(susername, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 320, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Username (Email)");
        signup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 150, 30));

        jButton5.setText("Sign Up");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        signup.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 160, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("SignUp");
        signup.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 180, 40));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("Name");
        signup.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 100, 30));

        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        signup.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 320, 30));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        signup.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 320, 30));
        signup.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 320, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        signup.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 490, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Password");
        signup.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 120, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Confirm Password");
        signup.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 20));

        jButton19.setBackground(new java.awt.Color(255, 0, 0));
        jButton19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton19.setText("Back");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        signup.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 80, 30));

        body.add(signup, "card2");

        guest_user.setBackground(new java.awt.Color(0, 102, 255));
        guest_user.setPreferredSize(new java.awt.Dimension(750, 403));
        guest_user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Guest User");
        guest_user.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 200, 40));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("Password : ");
        guest_user.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 150, 60));

        jPasswordField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField4ActionPerformed(evt);
            }
        });
        guest_user.add(jPasswordField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 350, 40));

        jButton6.setBackground(new java.awt.Color(51, 255, 0));
        jButton6.setText("Login In");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        guest_user.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 180, 40));

        jButton17.setBackground(new java.awt.Color(255, 0, 0));
        jButton17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton17.setText("Back");
        guest_user.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 80, 30));

        jButton18.setBackground(new java.awt.Color(255, 0, 0));
        jButton18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton18.setText("Back");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        guest_user.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 80, 30));

        body.add(guest_user, "card5");

        window.setBackground(new java.awt.Color(255, 255, 255));
        window.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("Add Files");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        window.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        jButton10.setText("Lock");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        window.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 190, 50));

        filepath.setBackground(new java.awt.Color(0, 255, 51));
        filepath.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        filepath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        window.add(filepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 490, 40));

        jButton11.setText("Unlock");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        window.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 200, 50));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        window.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 450, 40));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Locked Files");
        window.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 180, 30));

        jButton15.setBackground(new java.awt.Color(255, 0, 0));
        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton15.setText("Logout");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        window.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 80, 30));

        Filelock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Filelock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilelockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Filelock);

        window.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 610, 120));

        txt_location.setForeground(new java.awt.Color(255, 255, 255));
        txt_location.setBorder(null);
        window.add(txt_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 70, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        window.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 450, 40));

        body.add(window, "card6");

        window1.setBackground(new java.awt.Color(255, 255, 255));
        window1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setText("Add Files");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        window1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jButton13.setText("Lock");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        window1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 190, 50));

        filepath1.setBackground(new java.awt.Color(0, 255, 51));
        filepath1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        filepath1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        window1.add(filepath1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 490, 40));

        jButton16.setBackground(new java.awt.Color(255, 0, 0));
        jButton16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton16.setText("Logout");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        window1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 80, 30));

        body.add(window1, "card6");

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            body.removeAll();
            body.add(signin);
            body.repaint();
            body.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField4ActionPerformed
        
    }//GEN-LAST:event_jPasswordField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        body.removeAll();
        body.add(signup);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        body.removeAll();
        body.add(guest_user);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String u = username1.getText().trim();
            String p = new String(password.getPassword());
            if(u.equalsIgnoreCase("") || p.equalsIgnoreCase("")) 
                throw new Exception();
            dboperations db = new dboperations();
            if(db.validate(u,p))
            {
                body.removeAll();
                body.add(window);
                body.repaint();
                body.revalidate();
                jLabel16.setText("Welcome , "+db.getname(u).toUpperCase());
                jLabel18.setText(u);
            }
            else
            { 
                JOptionPane.showMessageDialog(null ,"Username or Password is invalid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null ,"You are not a member yet. Signup or Login as Guest User");
            //Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null ,"Oops! You forgot to enter username and password");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser chooser = new JFileChooser("C:\\");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        filepath.setText(filename);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try
        {
            String loc = filepath.getText();
            String response = JOptionPane.showInputDialog(null,"<html>Password"+ "<br>Enter your Password:",JOptionPane.QUESTION_MESSAGE);
            String username = username1.getText().trim();
            String pass = new String(password.getPassword());
            //JOptionPane.showMessageDialog(null ,pass);
            
            encdec ed = new encdec(loc,username,response,pass);
            boolean msg = ed.normaltokkk();
            dboperations db = new dboperations();
            if(msg == true)
            {
                db.insert_info(username, loc);
                JOptionPane.showMessageDialog(null ,"File Locked Successfully");
            }
            filepath.setText("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,"You did not choose a file");
            e.printStackTrace();
        }
        Update_table();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void Update_table(){
        try{
            //JOptionPane.showMessageDialog(null ,username1.getText());
        String sql="select location AS Location from user_files where username = ?";
        pst=conn.prepareStatement(sql);
        String u = jLabel18.getText();
        pst.setString(1, u );
        rs=pst.executeQuery();
        Filelock.setModel(DbUtils.resultSetToTableModel(rs));       }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e){
                
            }
        }
    }
    
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try{
            String loc = txt_location.getText();
            String username = username1.getText().trim();
            String pass = new String(password.getPassword());
            encdec ed = new encdec(loc,username,"Dummy_passowrd",pass);
            if(ed.Isusernamecorrect() && ed.Ispasswordcorrect())
            {
                boolean msg = ed.kkktonormal();
                if(msg == true)
                {
                    //JOptionPane.showMessageDialog(null ,loc);
                    dboperations db = new dboperations();
                    db.delete_info(loc);
                    Update_table();
                    JOptionPane.showMessageDialog(null ,"File Successfully Unlocked");
                }
                filepath.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null ,"You are not Authenticated to Unlock the file");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,"You did not choose a file");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String name = sname.getText();
            String username  = susername.getText();
            if(!validateemail(username))throw new Exception("You have entered an incorrect email");
            String p = new String(jPasswordField1.getPassword());
            String cp = new String(jPasswordField2.getPassword());
            if(name.equalsIgnoreCase("") || username.equalsIgnoreCase("") || p.equalsIgnoreCase("") || cp.equalsIgnoreCase("")) 
                throw new Exception("You have left one or more field blank");
            dboperations d = new dboperations();
            if(p.compareTo(cp)==0)
            {
                    d.insert_users(username,name, p);
                    jLabel8.setText("Successfully Registered");
            }
            else
                JOptionPane.showMessageDialog(null ,"Password don't match...Try again");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,ex.getMessage());
            //Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public boolean validateemail(final String hex)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try
        {
            char[] pass = jPasswordField4.getPassword();
            String p = new String(pass);
            if(p.equalsIgnoreCase("") || p.equalsIgnoreCase(null) || p.equalsIgnoreCase(" "))
                throw new Exception();
            body.removeAll();
            body.add(window1);
            body.repaint();
            body.revalidate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,"Please enter the password");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        filepath1.setText(filename);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
        try
        {
            String loc = filepath1.getText();
            char[] pass = jPasswordField4.getPassword();
            jPasswordField4.setText("");
            String p = new String(pass);
            encdec ed = new encdec(loc,"qwertyGuEstUseruiop",p);
            boolean msg = ed.normaltokkk();
            if(msg == true)
            {
                JOptionPane.showMessageDialog(null ,"File Locked Successfully");
            }
            filepath1.setText(null);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null ,"You did not choose a file");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void susernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_susernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_susernameActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        body.removeAll();
        body.add(signin);
        body.repaint();
        body.revalidate();
        username1.setText("");
        password.setText("");
        sname.setText("");
        susername.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        filepath.setText("");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        body.removeAll();
        body.add(signin);
        body.repaint();
        body.revalidate();
        username1.setText("");
        password.setText("");
        sname.setText("");
        susername.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        jPasswordField4.setText("");
        filepath.setText("");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        body.removeAll();
        body.add(signin);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        body.removeAll();
        body.add(signin);
        body.repaint();
        body.revalidate();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void FilelockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilelockMouseClicked
        try{
            String location=Filelock.getValueAt(Filelock.getSelectedRow(),0).toString();
            txt_location.setText(location);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_FilelockMouseClicked


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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Filelock;
    private javax.swing.JLabel app_name;
    private javax.swing.JPanel body;
    private javax.swing.JLabel filepath;
    private javax.swing.JLabel filepath1;
    private javax.swing.JPanel guest_user;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel index;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPasswordField password;
    private javax.swing.JPanel signin;
    private javax.swing.JPanel signup;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField susername;
    private javax.swing.JTextField txt_location;
    private javax.swing.JTextField username1;
    private javax.swing.JPanel window;
    private javax.swing.JPanel window1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
