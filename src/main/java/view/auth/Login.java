package view.auth;

import controller.AuthController;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.JOptionPane;
import model.Role;
import model.User;
import view.HomeAdminView;
import view.HomeDevView;

public class Login extends javax.swing.JFrame {

    private AuthController authController;

    public Login() {
        initComponents();
        authController = new AuthController();
        scaleImageToLabel(imgContainer, "/assets/stars.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        signUpBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LogInBtn = new javax.swing.JButton();
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
        jLabel2.setText("Welcome back !");
        content.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 525, -1));

        emailField.setText("email");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        content.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 410, 40));

        signUpBtn.setBackground(new java.awt.Color(51, 51, 51));
        signUpBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        signUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        signUpBtn.setText("Sign Up");
        signUpBtn.setBorderPainted(false);
        signUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signUpBtn.setFocusable(false);
        signUpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpBtnMouseExited(evt);
            }
        });
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        content.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 90, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Don't have an account? sign up");
        content.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        LogInBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LogInBtn.setForeground(new java.awt.Color(51, 51, 51));
        LogInBtn.setText("Log in");
        LogInBtn.setBorderPainted(false);
        LogInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogInBtn.setFocusable(false);
        LogInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogInBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogInBtnMouseExited(evt);
            }
        });
        LogInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInBtnActionPerformed(evt);
            }
        });
        content.add(LogInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 180, 30));

        userPasswordField.setText("password");
        content.add(userPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 410, 40));

        image.setBackground(new java.awt.Color(255, 255, 255));
        image.setMaximumSize(new java.awt.Dimension(525, 500));
        image.setMinimumSize(new java.awt.Dimension(525, 500));
        image.setPreferredSize(new java.awt.Dimension(525, 500));
        image.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgContainer.setIcon(util.ImageLoader.loadImage("/assets/stars.png"));
        imgContainer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        image.add(imgContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 500));

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

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void signUpBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpBtnMouseEntered
        signUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_signUpBtnMouseEntered

    private void signUpBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpBtnMouseExited

    }//GEN-LAST:event_signUpBtnMouseExited

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        openSignUpFrame();
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void LogInBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInBtnMouseEntered

    private void LogInBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInBtnMouseExited

    private void LogInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInBtnActionPerformed
        logInHandler();
    }//GEN-LAST:event_LogInBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogInBtn;
    private javax.swing.JPanel content;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel image;
    private javax.swing.JLabel imgContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JPasswordField userPasswordField;
    // End of variables declaration//GEN-END:variables
public void logInHandler() {
        String email = emailField.getText();
        String password = userPasswordField.getText();

        String emailRegex = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (email.equals("email") || email.isEmpty() || !email.matches(emailRegex)) {
            showError("Please enter a valid email");
            return;
        }

        if (password.equals("password") || password.isEmpty() || password.length() < 8) {
            showError("The password must be at least 8 caracters");
            return;
        }

        User user = authController.login(email, password);
        if (user != null) {
            redirectToHome(user);
        } else {
            showError("Invalid email or password");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openSignUpFrame() {
        new Register().setVisible(true);
        dispose();
    }

    private void redirectToHome(User user) {
        dispose();

        if (Role.ADMIN.equals(user.getRole()) || Role.OWRNER.equals(user.getRole())) {
            new HomeAdminView(user).setVisible(true);
        } else {
            new HomeDevView(user).setVisible(true);
        }
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
