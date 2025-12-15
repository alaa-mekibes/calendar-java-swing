package view.auth;

import controller.AuthController;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Role;
import model.User;
import util.MsgHandler;

public class Register extends javax.swing.JFrame {

    private AuthController authController;

    public Register() {
        initComponents();
        authController = new AuthController();
        scaleImageToLabel(imgContainer, "/assets/cloud.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        userEmailField = new javax.swing.JTextField();
        logInBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        RegisterBtn1 = new javax.swing.JButton();
        userPasswordField = new javax.swing.JPasswordField();
        image = new javax.swing.JPanel();
        imgContainer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content.setBackground(new java.awt.Color(74, 144, 226));
        content.setMaximumSize(new java.awt.Dimension(525, 500));
        content.setMinimumSize(new java.awt.Dimension(525, 500));
        content.setPreferredSize(new java.awt.Dimension(525, 500));
        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Join With Us");
        content.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 525, -1));

        userNameField.setText("username");
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        content.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 410, 40));

        userEmailField.setText("email");
        userEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailFieldActionPerformed(evt);
            }
        });
        content.add(userEmailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 410, 40));

        logInBtn.setBackground(new java.awt.Color(51, 51, 51));
        logInBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logInBtn.setForeground(new java.awt.Color(255, 255, 255));
        logInBtn.setText("Log In");
        logInBtn.setBorderPainted(false);
        logInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logInBtn.setFocusable(false);
        logInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logInBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logInBtnMouseExited(evt);
            }
        });
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });
        content.add(logInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 90, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("already have an account? log in");
        content.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        RegisterBtn1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RegisterBtn1.setForeground(new java.awt.Color(51, 51, 51));
        RegisterBtn1.setText("Sign up");
        RegisterBtn1.setBorderPainted(false);
        RegisterBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RegisterBtn1.setFocusable(false);
        RegisterBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegisterBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegisterBtn1MouseExited(evt);
            }
        });
        RegisterBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterBtn1ActionPerformed(evt);
            }
        });
        content.add(RegisterBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 180, 30));

        userPasswordField.setText("password");
        userPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPasswordFieldActionPerformed(evt);
            }
        });
        content.add(userPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 410, 40));

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setMaximumSize(new java.awt.Dimension(525, 500));
        image.setMinimumSize(new java.awt.Dimension(525, 500));
        image.setPreferredSize(new java.awt.Dimension(525, 500));
        image.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgContainer.setIcon(util.ImageLoader.loadImage("/assets/cloud.png"));
        image.add(imgContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void userEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailFieldActionPerformed

    private void logInBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInBtnMouseEntered
        logInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_logInBtnMouseEntered

    private void logInBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInBtnMouseExited

    }//GEN-LAST:event_logInBtnMouseExited

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        openLoginFrame();
    }//GEN-LAST:event_logInBtnActionPerformed

    private void RegisterBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterBtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterBtn1MouseEntered

    private void RegisterBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterBtn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterBtn1MouseExited

    private void RegisterBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterBtn1ActionPerformed
        registerHandler();
    }//GEN-LAST:event_RegisterBtn1ActionPerformed

    private void userPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPasswordFieldActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegisterBtn1;
    private javax.swing.JPanel content;
    private javax.swing.JPanel image;
    private javax.swing.JLabel imgContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logInBtn;
    private javax.swing.JTextField userEmailField;
    private javax.swing.JTextField userNameField;
    private javax.swing.JPasswordField userPasswordField;
    // End of variables declaration//GEN-END:variables
public void registerHandler() {
        String userName = userNameField.getText();
        String email = userEmailField.getText();
        String password = userPasswordField.getText();

        if (userName.equals("username") || userName.isEmpty() || (userName.length() > 10 && userName.length() < 5)) {
            MsgHandler.showError(this, "Please enter a valid username 5 - 10 caracters");
            return;
        }

        String emailRegex = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (email.equals("email") || email.isEmpty() || !email.matches(emailRegex)) {
            MsgHandler.showError(this, "Please enter a valid email");
            return;
        }

        if (password.equals("password") || password.isEmpty() || password.length() < 8) {
            MsgHandler.showError(this, "The password must be at least 8 caracters");
            return;
        }

        if (authController.emailExists(email)) {
            MsgHandler.showError(this, "This email is already registered");
            return;
        }

        User newUser = authController.register(userName, email, password, Role.DEV);

        if (newUser != null) {
            MsgHandler.showSuccess(this, "Account created successfully! Please login.");
            openLoginFrame();
            clearForm();

        } else {
            MsgHandler.showError(this, "Registration failed. Please try again.");
        }
    }

    private void clearForm() {
        userNameField.setText("username");
        userEmailField.setText("email");
        userPasswordField.setText("password");
    }
    private void openLoginFrame() {
        new Login().setVisible(true);
        dispose();
    }
private void scaleImageToLabel(JLabel label, String imagePath) {
    try {
        ImageIcon icon = util.ImageLoader.loadImage(imagePath);
        Image image = icon.getImage();
        
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();
        
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        
        double widthRatio = (double) labelWidth / originalWidth;
        double heightRatio = (double) labelHeight / originalHeight;
        double scale = Math.min(widthRatio, heightRatio);
        
        int newWidth = (int) (originalWidth * scale);
        int newHeight = (int) (originalHeight * scale);
        
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        
        label.setIcon(new ImageIcon(scaledImage));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
