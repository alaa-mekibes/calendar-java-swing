package view.panels;

import java.awt.Color;
import java.awt.Font;
import view.dialogs.UpdateTeamDialog;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Role;
import model.Team;

public class TeamPanel extends javax.swing.JPanel {

    private java.awt.Frame parent;
    private model.User loggedUser;

    public TeamPanel(java.awt.Frame parent, model.User user) {
        this.parent = parent;
        this.loggedUser = user;
        initComponents();
        setupTable();
        teamController = new controller.TeamController();
        loadTeams();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamsTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Teams");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 50));

        teamsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(teamsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 400));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable teamsTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private controller.TeamController teamController;

    private void setupTable() {
        String[] columns = {"ID", "name", "Devs"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        teamsTable.setModel(model);

        teamsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        teamsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        teamsTable.getColumnModel().getColumn(2).setPreferredWidth(300);

        teamsTable.setFont(new Font("Arial", java.awt.Font.PLAIN, 12));
        teamsTable.setRowHeight(30);
        teamsTable.getTableHeader().setFont(new Font("Arial", java.awt.Font.BOLD, 12));
        teamsTable.getTableHeader().setBackground(new Color(74, 144, 226));
        teamsTable.getTableHeader().setForeground(Color.WHITE);

        teamsTable.addMouseListener(new java.awt.event.MouseAdapter() {
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
    private JPopupMenu popup;

    private void showTablePopup(java.awt.event.MouseEvent evt) {
        int row = teamsTable.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            teamsTable.setRowSelectionInterval(row, row);

            JPopupMenu popup = new JPopupMenu();

            JMenuItem editItem = new JMenuItem("Edit");
            editItem.addActionListener(e -> editSelectedTeam());
            popup.add(editItem);

            JMenuItem deleteItem = new JMenuItem("Delete");
            deleteItem.addActionListener(e -> deleteSelectedTeam());
            popup.add(deleteItem);

            popup.show(evt.getComponent(), evt.getX(), evt.getY());

        }
    }

    private void editSelectedTeam() {
        int selectedRow = teamsTable.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        int teamId = (int) teamsTable.getValueAt(selectedRow, 0);
        Team team = teamController.getTeamById(teamId);
        if (team == null) {
            return;
        }

        // Create a copy of the team to avoid modifying the original
        Team teamCopy = new Team(team.getId(), team.getName(), new java.util.ArrayList<>(team.getDevs()), team.getColor());
        UpdateTeamDialog dialog = new UpdateTeamDialog((java.awt.Frame) parent, teamCopy, loggedUser);
        dialog.setVisible(true);
        loadTeams();
    }

    private void deleteSelectedTeam() {
        if(loggedUser.getRole() != Role.OWRNER) {return;}
        int selectedRow = teamsTable.getSelectedRow();
        if (selectedRow != -1) {
            int teamId = (int) teamsTable.getValueAt(selectedRow, 0);
            String teamName = (String) teamsTable.getValueAt(selectedRow, 1);

            int choice = JOptionPane.showConfirmDialog(this,
                    "Delete team '" + teamName + "'?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                teamController.deleteTeam(teamId);
                loadTeams();
            }
        }
    }

    private void loadTeams() {
        DefaultTableModel model
                = (DefaultTableModel) teamsTable.getModel();

        model.setRowCount(0);

        List<Team> teams = teamController.getAllTeams();

        for (Team team : teams) {
            if(loggedUser.getRole() != Role.OWRNER && loggedUser.getTeam() != team) {continue;}
            Object[] row = {
                team.getId(),
                team.getName(),
                team.getDevs(),
                team.getColor(),};
            model.addRow(row);
            teamsTable.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
                @Override
                public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
                    java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    List<Team> teams = teamController.getAllTeams();
                    if (row < teams.size()) {
                        Color color = teams.get(row).getColor();
                        if (!isSelected) {
                            c.setBackground(color);
                            c.setForeground(Color.BLACK);
                        } else {
                            c.setBackground(table.getSelectionBackground());
                            c.setForeground(table.getSelectionForeground());
                        }
                    }
                    return c;
                }
            });
        }
    }

    public void refreshTeams() {
        loadTeams();
    }
}
