package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.ListSelectionModel;
import model.Team;
import model.User;
import util.MsgHandler;

public class UpdateTeamDialog extends javax.swing.JDialog {

    private Team team;
    private List<User> allUsers;
    private List<User> displayedUsers;
    private controller.TeamController teamController;
    private controller.UserController userController;
    private User loggedUser;

    public UpdateTeamDialog(java.awt.Frame parent, Team team, User user) {
        super(parent, true);
        initComponents();
        this.loggedUser = user;
        this.teamController = new controller.TeamController();
        this.userController = new controller.UserController();
        this.team = team;
        this.selectedColor = team.getColor();
        setupUsersList();
        fillTeamData();
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
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update team");
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

        updateBtn.setBackground(new java.awt.Color(74, 144, 226));
        updateBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.setBorderPainted(false);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        updateBtn.setFocusable(false);
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtnMouseExited(evt);
            }
        });
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
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
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseEntered
        updateBtn.setBackground(new Color(33, 123, 255));
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_updateBtnMouseEntered

    private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseExited
        updateBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_updateBtnMouseExited

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        handleUpdateTeam();
    }//GEN-LAST:event_updateBtnActionPerformed

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
    private javax.swing.JPanel form;
    private javax.swing.JLabel inputTitle;
    private javax.swing.JLabel inputTitle1;
    private javax.swing.JLabel inputTitle2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField teamNameField;
    private javax.swing.JButton updateBtn;
    private javax.swing.JList<String> usersListFiled;
    // End of variables declaration//GEN-END:variables
    private void setupUsersList() {
        allUsers = userController.getAllUsers();
        displayedUsers = new ArrayList<>();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (User user : allUsers) {
            if(user.getRole() == model.Role.OWRNER) continue;
            displayedUsers.add(user);
            listModel.addElement(user.getEmail());
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

    private void handleUpdateTeam() {
        String newName = teamNameField.getText().trim();
        List<User> newDevs = getSelectedUsers();

        if (selectedColor == null) {
            MsgHandler.showError(this, "Please pick a color");
            return;
        }

        if (newName.isEmpty()) {
            MsgHandler.showError(this, "Please enter a team name");
            return;
        }

        if (newDevs.isEmpty()) {
            MsgHandler.showError(this, "Select at least one user");
            return;
        }

        boolean success = teamController.updateTeam(team.getId(), newName, newDevs, selectedColor, loggedUser);

        if (success) {
            MsgHandler.showSuccess(this, "Team updated successfully!");
            refreshParentView();
            dispose();
        } else {
            MsgHandler.showError(this, "Failed to update team");
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

    private void fillTeamData() {
        teamNameField.setText(team.getName());
        colorBox.setBackground(team.getColor());

        List<User> teamDevs = team.getDevs();
        List<String> teamEmails = new ArrayList<>();
        for (User user : teamDevs) {
            teamEmails.add(user.getEmail());
        }

        int[] indices = allUsers.stream()
                .filter(u -> teamEmails.contains(u.getEmail()))
                .mapToInt(allUsers::indexOf)
                .toArray();

        usersListFiled.setSelectedIndices(indices);
    }

}
