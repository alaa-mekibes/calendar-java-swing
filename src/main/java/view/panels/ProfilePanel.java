package view.panels;

import controller.UserController;
import controller.AuthController;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Role;
import model.User;
import util.MsgHandler;

public class ProfilePanel extends javax.swing.JPanel {

    private java.awt.Frame parent;
    private User loggedUser;
    private UserController userController;
    private AuthController authController;

    public ProfilePanel(java.awt.Frame parent, User user) {
        initComponents();
        this.parent = parent;
        this.loggedUser = user;
        authController = new AuthController();
        userController = new UserController();
        profileHandler();
        imgContainer.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                scaleImageToLabel(imgContainer, "/assets/user.png");
                imgContainer.removeComponentListener(this);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        pfpContainer = new javax.swing.JPanel();
        profilePicContainer = new javax.swing.JPanel();
        imgContainer = new javax.swing.JLabel();
        profileName = new javax.swing.JLabel();
        profileRole = new javax.swing.JLabel();
        profileEmail = new javax.swing.JLabel();
        personalInfoContainer = new javax.swing.JPanel();
        box = new javax.swing.JPanel();
        inputTitle = new javax.swing.JLabel();
        userEmailField = new javax.swing.JTextField();
        box2 = new javax.swing.JPanel();
        inputTitle2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        box3 = new javax.swing.JPanel();
        inputTitle3 = new javax.swing.JLabel();
        userOldPassField = new javax.swing.JPasswordField();
        box4 = new javax.swing.JPanel();
        inputTitle4 = new javax.swing.JLabel();
        userNewPassField = new javax.swing.JPasswordField();
        changePassBtn = new javax.swing.JButton();
        title1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Profile");

        pfpContainer.setBackground(new java.awt.Color(255, 255, 255));

        imgContainer.setIcon(util.ImageLoader.loadImage("/assets/user.png"));

        javax.swing.GroupLayout profilePicContainerLayout = new javax.swing.GroupLayout(profilePicContainer);
        profilePicContainer.setLayout(profilePicContainerLayout);
        profilePicContainerLayout.setHorizontalGroup(
            profilePicContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        profilePicContainerLayout.setVerticalGroup(
            profilePicContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePicContainerLayout.createSequentialGroup()
                .addComponent(imgContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        profileName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profileName.setForeground(new java.awt.Color(51, 51, 51));
        profileName.setText("Alaa Mekibes");

        profileRole.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profileRole.setForeground(new java.awt.Color(51, 51, 51));
        profileRole.setText("Project Manager");

        profileEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        profileEmail.setForeground(new java.awt.Color(74, 144, 226));
        profileEmail.setText("mekibes.al@gmail.com");

        javax.swing.GroupLayout pfpContainerLayout = new javax.swing.GroupLayout(pfpContainer);
        pfpContainer.setLayout(pfpContainerLayout);
        pfpContainerLayout.setHorizontalGroup(
            pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pfpContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePicContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap(543, Short.MAX_VALUE))
        );
        pfpContainerLayout.setVerticalGroup(
            pfpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pfpContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileEmail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pfpContainerLayout.createSequentialGroup()
                .addComponent(profilePicContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        personalInfoContainer.setBackground(new java.awt.Color(255, 255, 255));

        box.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle.setText("Email");

        userEmailField.setText("Alaa");
        userEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout boxLayout = new javax.swing.GroupLayout(box);
        box.setLayout(boxLayout);
        boxLayout.setHorizontalGroup(
            boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userEmailField)
                    .addComponent(inputTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
        boxLayout.setVerticalGroup(
            boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle)
                .addGap(10, 10, 10)
                .addComponent(userEmailField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        box2.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle2.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle2.setText("Username");

        userNameField.setText("Mekibes");
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout box2Layout = new javax.swing.GroupLayout(box2);
        box2.setLayout(box2Layout);
        box2Layout.setHorizontalGroup(
            box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameField)
                    .addComponent(inputTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        box2Layout.setVerticalGroup(
            box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle2)
                .addGap(10, 10, 10)
                .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        saveBtn.setBackground(new java.awt.Color(74, 144, 226));
        saveBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorderPainted(false);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveBtn.setFocusable(false);
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveBtnMouseExited(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        box3.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle3.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle3.setText("old Password");

        userOldPassField.setText("jPasswordField1");

        javax.swing.GroupLayout box3Layout = new javax.swing.GroupLayout(box3);
        box3.setLayout(box3Layout);
        box3Layout.setHorizontalGroup(
            box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(userOldPassField))
                .addContainerGap())
        );
        box3Layout.setVerticalGroup(
            box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userOldPassField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        box4.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle4.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle4.setText("New Password");

        userNewPassField.setText("jPasswordField2");

        javax.swing.GroupLayout box4Layout = new javax.swing.GroupLayout(box4);
        box4.setLayout(box4Layout);
        box4Layout.setHorizontalGroup(
            box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userNewPassField)
                    .addComponent(inputTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        box4Layout.setVerticalGroup(
            box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNewPassField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        changePassBtn.setBackground(new java.awt.Color(74, 144, 226));
        changePassBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changePassBtn.setForeground(new java.awt.Color(255, 255, 255));
        changePassBtn.setText("Chnage password");
        changePassBtn.setBorderPainted(false);
        changePassBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        changePassBtn.setFocusable(false);
        changePassBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePassBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePassBtnMouseExited(evt);
            }
        });
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personalInfoContainerLayout = new javax.swing.GroupLayout(personalInfoContainer);
        personalInfoContainer.setLayout(personalInfoContainerLayout);
        personalInfoContainerLayout.setHorizontalGroup(
            personalInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoContainerLayout.createSequentialGroup()
                .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(personalInfoContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalInfoContainerLayout.createSequentialGroup()
                        .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(personalInfoContainerLayout.createSequentialGroup()
                        .addGroup(personalInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveBtn)
                            .addComponent(changePassBtn))
                        .addGap(0, 664, Short.MAX_VALUE)))
                .addContainerGap())
        );
        personalInfoContainerLayout.setVerticalGroup(
            personalInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalInfoContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(personalInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        title1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        title1.setForeground(new java.awt.Color(51, 51, 51));
        title1.setText("Personal Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfpContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(personalInfoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 24, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(pfpContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personalInfoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 399, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmailFieldActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseEntered
        saveBtn.setBackground(new Color(33, 123, 255));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_saveBtnMouseEntered

    private void saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseExited
        saveBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_saveBtnMouseExited

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        saveHandler();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void changePassBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassBtnMouseEntered
        changePassBtn.setBackground(new Color(33, 123, 255));
        changePassBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_changePassBtnMouseEntered

    private void changePassBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassBtnMouseExited
        changePassBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_changePassBtnMouseExited

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        changePasswordHandler();
    }//GEN-LAST:event_changePassBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box;
    private javax.swing.JPanel box2;
    private javax.swing.JPanel box3;
    private javax.swing.JPanel box4;
    private javax.swing.JButton changePassBtn;
    private javax.swing.JLabel imgContainer;
    private javax.swing.JLabel inputTitle;
    private javax.swing.JLabel inputTitle2;
    private javax.swing.JLabel inputTitle3;
    private javax.swing.JLabel inputTitle4;
    private javax.swing.JPanel personalInfoContainer;
    private javax.swing.JPanel pfpContainer;
    private javax.swing.JLabel profileEmail;
    private javax.swing.JLabel profileName;
    private javax.swing.JPanel profilePicContainer;
    private javax.swing.JLabel profileRole;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField userEmailField;
    private javax.swing.JTextField userNameField;
    private javax.swing.JPasswordField userNewPassField;
    private javax.swing.JPasswordField userOldPassField;
    // End of variables declaration//GEN-END:variables
public void profileHandler() {
        profileName.setText(loggedUser.getName());
        profileRole.setText(loggedUser.getRole().name());
        profileEmail.setText(loggedUser.getEmail());
        userEmailField.setText(loggedUser.getEmail());
        userNameField.setText(loggedUser.getName());

    }

    public void saveHandler() {
        String userEmail = userEmailField.getText();
        String userName = userNameField.getText();

        if (userName.isEmpty() || (userName.length() > 10 && userName.length() < 5)) {
            MsgHandler.showError(this, "Please enter a valid username 5 - 10 caracters");
            return;
        }

        String emailRegex = "^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (userEmail.isEmpty() || !userEmail.matches(emailRegex)) {
            MsgHandler.showError(this, "Please enter a valid email");
            return;
        }

        if (authController.emailExists(userEmail)) {
            MsgHandler.showError(this, "This email is already registered");
            return;
        }

        boolean updatedUser = userController.updateUserEmailUsername(loggedUser.getId(), userEmail, userName);

        if (updatedUser) {
            MsgHandler.showSuccess(this, "Account updated successfully!");
            profileHandler();
        } else {
            MsgHandler.showError(this, "update failed. Please try again.");
        }
    }

    public void changePasswordHandler() {
        String oldPass = userOldPassField.getText();
        String newPass = userNewPassField.getText();

        if (!loggedUser.getPassword().equals(oldPass)) {
            MsgHandler.showError(this, "Your old password is incorrect");
            return;
        }

        if (newPass.isEmpty() || newPass.length() < 8) {
            MsgHandler.showError(this, "The password must be at least 8 caracters");
            return;
        }

        boolean updatedUser = userController.updateUserPassword(loggedUser.getId(), newPass);

        if (updatedUser) {
            MsgHandler.showSuccess(this, "Password updated successfully!");
            profileHandler();
        } else {
            MsgHandler.showError(this, "Update failed. Please try again.");
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
