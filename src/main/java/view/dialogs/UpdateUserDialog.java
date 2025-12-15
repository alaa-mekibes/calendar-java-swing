package view.dialogs;

import controller.TeamController;
import controller.UserController;
import java.awt.Color;
import model.Role;
import model.Team;
import model.User;
import util.MsgHandler;

public class UpdateUserDialog extends javax.swing.JDialog {

    private User user;
    private Team team;
    private UserController userController;
    private TeamController teamController;
    public UpdateUserDialog(java.awt.Frame parent, User user, Team team) {
        super(parent, true);
        initComponents();
        this.user = user;
        this.team = team;
        userController = new UserController();
        teamController = new TeamController();
        setupLists();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        roleBox = new javax.swing.JPanel();
        inputTitle3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rolesSelectField = new javax.swing.JComboBox<>();
        teamBox = new javax.swing.JPanel();
        inputTitle2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teamSelectFiled = new javax.swing.JComboBox<>();
        cancelBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update user");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        roleBox.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle3.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle3.setText("Role");

        rolesSelectField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(rolesSelectField);

        javax.swing.GroupLayout roleBoxLayout = new javax.swing.GroupLayout(roleBox);
        roleBox.setLayout(roleBoxLayout);
        roleBoxLayout.setHorizontalGroup(
            roleBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roleBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roleBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        roleBoxLayout.setVerticalGroup(
            roleBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roleBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        teamBox.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle2.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle2.setText("Team");

        teamSelectFiled.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(teamSelectFiled);

        javax.swing.GroupLayout teamBoxLayout = new javax.swing.GroupLayout(teamBox);
        teamBox.setLayout(teamBoxLayout);
        teamBoxLayout.setHorizontalGroup(
            teamBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(teamBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        teamBoxLayout.setVerticalGroup(
            teamBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teamBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roleBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addComponent(roleBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teamBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        createBtn.setText("Update");
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

    private void cancelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseEntered
        cancelBtn.setBackground(new Color(160, 160, 160));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cancelBtnMouseEntered

    private void cancelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMouseExited
        cancelBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_cancelBtnMouseExited

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
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
        handleUpdateUser();
    }//GEN-LAST:event_createBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JPanel form;
    private javax.swing.JLabel inputTitle2;
    private javax.swing.JLabel inputTitle3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel roleBox;
    private javax.swing.JComboBox<String> rolesSelectField;
    private javax.swing.JPanel teamBox;
    private javax.swing.JComboBox<String> teamSelectFiled;
    // End of variables declaration//GEN-END:variables
    private void setupLists() {

        for (Role role : Role.values()) {
            if(role.equals(Role.OWRNER)) continue;
            rolesSelectField.addItem(role.name());
        }
        rolesSelectField.setSelectedItem(user.getRole().name());

        if (teamController.getAllTeams() != null) {
            for (Team team : teamController.getAllTeams()) {
                teamSelectFiled.addItem(team.getName());
            }
        } else {
            teamSelectFiled.addItem("No teams available");
            teamSelectFiled.setEnabled(false);
            return;
        }

        teamSelectFiled.setSelectedItem(team.getName());
    }

    private void handleUpdateUser() {
        String newRole = (String) rolesSelectField.getSelectedItem();
        String newTeam = (String) teamSelectFiled.getSelectedItem();

        if (newRole.isEmpty()) {
            MsgHandler.showError(this, "Please enter a user role");
            return;
        }

        if (newTeam.isEmpty()) {
            MsgHandler.showError(this, "Select at least one team");
            return;
        }

        Role userRole = Role.valueOf(newRole);
        Team userTeam = teamController.getTeamByName(newTeam);

        boolean success = userController.updateUserByAdmin(user.getId(), userRole, userTeam);

        if (success) {
            MsgHandler.showSuccess(this, "User updated successfully!");
            refreshParentView();
            dispose();
        } else {
            MsgHandler.showError(this, "Failed to update user");
        }
    }

    private void refreshParentView() {
        java.awt.Frame parent = (java.awt.Frame) this.getOwner();
        if (parent instanceof view.HomeAdminView) {
            ((view.HomeAdminView) parent).refreshUsers();
        }
    }

}
