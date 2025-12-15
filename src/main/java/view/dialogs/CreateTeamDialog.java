package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.ListSelectionModel;
import model.User;
import util.MsgHandler;

public class CreateTeamDialog extends javax.swing.JDialog {

    private List<User> displayedUsers;
    private List<User> allUsers;
    private controller.TeamController teamController;
    private controller.UserController userController;
    private User loggedUser;
    public CreateTeamDialog(java.awt.Frame parent, boolean modal, User user) {
        super(parent, modal);
        initComponents();
        this.loggedUser = user;
        userController = new controller.UserController();
        teamController = new controller.TeamController();
        setupUsersList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        box = new javax.swing.JPanel();
        inputTitle = new javax.swing.JLabel();
        teamNameField = new javax.swing.JTextField();
        box2 = new javax.swing.JPanel();
        inputTitle2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersListFiled = new javax.swing.JList<>();
        colorBox = new javax.swing.JPanel();
        inputTitle1 = new javax.swing.JLabel();
        colorBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Team");
        setBackground(new java.awt.Color(255, 255, 255));

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        box.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle.setText("Name");

        teamNameField.setText("Team name");
        teamNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamNameFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout boxLayout = new javax.swing.GroupLayout(box);
        box.setLayout(boxLayout);
        boxLayout.setHorizontalGroup(
            boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teamNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        boxLayout.setVerticalGroup(
            boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle)
                .addGap(10, 10, 10)
                .addComponent(teamNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        box2.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle2.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle2.setText("Team");

        usersListFiled.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(usersListFiled);

        javax.swing.GroupLayout box2Layout = new javax.swing.GroupLayout(box2);
        box2.setLayout(box2Layout);
        box2Layout.setHorizontalGroup(
            box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        box2Layout.setVerticalGroup(
            box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        colorBox.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle1.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle1.setText("color");

        colorBtn.setBackground(new java.awt.Color(74, 144, 226));
        colorBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        colorBtn.setForeground(new java.awt.Color(255, 255, 255));
        colorBtn.setText("pick a color");
        colorBtn.setBorderPainted(false);
        colorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        colorBtn.setFocusable(false);
        colorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                colorBtnMouseExited(evt);
            }
        });
        colorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorBoxLayout = new javax.swing.GroupLayout(colorBox);
        colorBox.setLayout(colorBoxLayout);
        colorBoxLayout.setHorizontalGroup(
            colorBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(colorBoxLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(colorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        colorBoxLayout.setVerticalGroup(
            colorBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cancelBtn.setBackground(new java.awt.Color(204, 204, 204));
        cancelBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(51, 51, 51));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorderPainted(false);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelBtn.setFocusable(false);
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelBtnMouseExited(evt);
            }
        });
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        createBtn.setBackground(new java.awt.Color(74, 144, 226));
        createBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBtn.setText("Create");
        createBtn.setBorderPainted(false);
        createBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        createBtn.setFocusable(false);
        createBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createBtnMouseExited(evt);
            }
        });
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void teamNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamNameFieldActionPerformed

    private void cancelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseEntered
        cancelBtn.setBackground(new Color(160, 160, 160));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cancelBtnMouseEntered

    private void cancelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseExited
        cancelBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_cancelBtnMouseExited

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearForm();
        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBtnMouseEntered
        createBtn.setBackground(new Color(33, 123, 255));
        createBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_createBtnMouseEntered

    private void createBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBtnMouseExited
        createBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_createBtnMouseExited

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        handleCreateTeam();
    }//GEN-LAST:event_createBtnActionPerformed

    private void colorBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_colorBtnMouseEntered

    private void colorBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_colorBtnMouseExited

    private void colorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBtnActionPerformed
        chooseColor();
    }//GEN-LAST:event_colorBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box;
    private javax.swing.JPanel box2;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel colorBox;
    private javax.swing.JButton colorBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JPanel form;
    private javax.swing.JLabel inputTitle;
    private javax.swing.JLabel inputTitle1;
    private javax.swing.JLabel inputTitle2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField teamNameField;
    private javax.swing.JList<String> usersListFiled;
    // End of variables declaration//GEN-END:variables

    private void setupUsersList() {
        allUsers = userController.getAllUsers();
        displayedUsers = new ArrayList<>();
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (User user : allUsers) {
            if (user.getRole() == model.Role.OWRNER) {
                continue;
            }
            displayedUsers.add(user);
            listModel.addElement(user.getName());
        }

        usersListFiled.setModel(listModel);
        usersListFiled.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        usersListFiled.setFont(new Font("Arial", java.awt.Font.PLAIN, 12));
    }

    private List<User> getSelectedUsers() {
        List<User> selectedUsers = new ArrayList<>();

        int[] selectedIndices = usersListFiled.getSelectedIndices();

        for (int index : selectedIndices) {
            selectedUsers.add(displayedUsers.get(index));
        }

        return selectedUsers;
    }

    private void handleCreateTeam() {
        String teamName = teamNameField.getText().trim();
        List<User> teamsDevs = getSelectedUsers();

        if (selectedColor == null) {
            MsgHandler.showError(this, "Please pick a color for the event");
            return;
        }

        if (teamName.isEmpty() || teamName.equals("Team Name")) {
            MsgHandler.showError(this, "Please enter team name");
            return;
        }

        if (teamsDevs.isEmpty()) {
            MsgHandler.showError(this, "Please select at least one user");
            return;
        }

        boolean success = teamController.createTeam(teamName, teamsDevs, selectedColor, loggedUser);

        if (success) {
            MsgHandler.showSuccess(this, "Event created successfully!");
            refreshParentView();
            clearForm();
            dispose();
        } else {
            MsgHandler.showError(this, "Failed to create event");
        }
    }

    private void clearForm() {
        teamNameField.setText("Team Title");
    }
    private Color selectedColor;

    private void chooseColor() {
        Color color = JColorChooser.showDialog(this, "Choose Event Color", Color.WHITE);
        if (color != null) {
            selectedColor = color;
            colorBox.setBackground(color);
        } else {
            MsgHandler.showWarning(this, "No color selected!");
        }
    }

    private void refreshParentView() {
        java.awt.Frame parent = (java.awt.Frame) this.getOwner();
        if (parent instanceof view.HomeAdminView) {
            ((view.HomeAdminView) parent).refreshTeams();
        }
    }
}
