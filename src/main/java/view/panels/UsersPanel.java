package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Role;
import model.User;
import model.Team;
import util.MsgHandler;
import view.dialogs.UpdateUserDialog;

public class UsersPanel extends javax.swing.JPanel {

    private java.awt.Frame parent;
    private User loggedUser;

    public UsersPanel(java.awt.Frame parent, User user) {
        this.parent = parent;
        this.loggedUser = user;
        initComponents();
        userController = new controller.UserController();
        teamController = new controller.TeamController();
        setupTable();
        loadUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("All users");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 50));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(usersTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 400));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
    private controller.UserController userController;
    private controller.TeamController teamController;

    private void setupTable() {
        String[] columns = {"ID", "username", "email", "Role", "Team"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        usersTable.setModel(model);

        usersTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        usersTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        usersTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        usersTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        usersTable.getColumnModel().getColumn(4).setPreferredWidth(100);

        usersTable.setFont(new Font("Arial", Font.PLAIN, 12));
        usersTable.setRowHeight(30);
        usersTable.getTableHeader().setFont(new Font("Arial", java.awt.Font.BOLD, 12));
        usersTable.getTableHeader().setBackground(new Color(74, 144, 226));
        usersTable.getTableHeader().setForeground(Color.WHITE);
        if (loggedUser.getRole() == Role.OWRNER) {
            usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        showTablePopup(evt);
                    }
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    if (evt.isPopupTrigger()) {
                        showTablePopup(evt);
                    }
                }
            });
        }
    }
    private JPopupMenu popup;

    private void showTablePopup(java.awt.event.MouseEvent evt) {
        int row = usersTable.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            usersTable.setRowSelectionInterval(row, row);

            JPopupMenu popup = new JPopupMenu();

            JMenuItem editItem = new JMenuItem("Edit");
            editItem.addActionListener(e -> updateSelectedUser());
            popup.add(editItem);

            JMenuItem deleteItem = new JMenuItem("Delete");
            deleteItem.addActionListener(e -> deleteSelectedUser());
            popup.add(deleteItem);

            popup.show(evt.getComponent(), evt.getX(), evt.getY());

        }
    }

    private void updateSelectedUser() {
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        int userId = (int) usersTable.getValueAt(selectedRow, 0);
        String userTeam = (String) usersTable.getValueAt(selectedRow, 4);
        User user = userController.getUserById(userId);
        Team team = teamController.getTeamByName(userTeam);
        if (user == null) {
            return;
        }
        if (user.getRole().equals(Role.OWRNER)) {
            MsgHandler.showError(this, "You can't update the owrner!");
            return;
        }

        UpdateUserDialog dialog = new UpdateUserDialog((java.awt.Frame) parent, user, team);
        dialog.setVisible(true);
        loadUsers();
    }

    private void deleteSelectedUser() {
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow != -1) {
            int userId = (int) usersTable.getValueAt(selectedRow, 0);
            String userName = (String) usersTable.getValueAt(selectedRow, 1);
            String userRole = (String) usersTable.getValueAt(selectedRow, 3);

            if (userRole.equals(Role.OWRNER.name())) {
                MsgHandler.showError(this, "You can't remove the owrner!");
                return;
            }

            int choice = JOptionPane.showConfirmDialog(this,
                    "Delete user '" + userName + "'?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                userController.deleteUser(userId);
                loadUsers();
            }
        }
    }

    private void loadUsers() {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();

        model.setRowCount(0);

        List<User> users = userController.getAllUsers();

        for (User user : users) {
            if(loggedUser.getRole() != Role.OWRNER && loggedUser.getTeam() != user.getTeam()) {continue;}
            Object[] row = {
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                (user.getTeam() != null) ? user.getTeam().getName() : "no team"
            };
            model.addRow(row);
        }
    }

    public void refreshUsers() {
        loadUsers();
    }
}
