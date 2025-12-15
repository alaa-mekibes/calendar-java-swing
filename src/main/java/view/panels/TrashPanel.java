package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import util.MsgHandler;
import model.Event;
import model.Role;
import model.User;

public class TrashPanel extends javax.swing.JPanel {

    private java.awt.Frame parent;
    private User currentUser;

    public TrashPanel(java.awt.Frame parent, User user) {
        initComponents();
        eventController = new controller.EventController();
        this.currentUser = user;
        setupTable();
        loadEvents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deletedEventsTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Trash");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 50));

        deletedEventsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(deletedEventsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 400));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable deletedEventsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
private controller.EventController eventController;

    private void setupTable() {
        String[] columns = {"ID", "Title", "Description", "Team", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        deletedEventsTable.setModel(model);

        deletedEventsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        deletedEventsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        deletedEventsTable.getColumnModel().getColumn(2).setPreferredWidth(250);
        deletedEventsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        deletedEventsTable.getColumnModel().getColumn(4).setPreferredWidth(100);

        deletedEventsTable.setFont(new Font("Arial", java.awt.Font.PLAIN, 12));
        deletedEventsTable.setRowHeight(30);
        deletedEventsTable.getTableHeader().setFont(new Font("Arial", java.awt.Font.BOLD, 12));
        deletedEventsTable.getTableHeader().setBackground(new Color(74, 144, 226));
        deletedEventsTable.getTableHeader().setForeground(java.awt.Color.WHITE);

        deletedEventsTable.addMouseListener(new java.awt.event.MouseAdapter() {
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

    private void showTablePopup(java.awt.event.MouseEvent evt) {
        int row = deletedEventsTable.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            deletedEventsTable.setRowSelectionInterval(row, row);

            JPopupMenu popup = new JPopupMenu();

            JMenuItem restoreItem = new JMenuItem("Restore");
            restoreItem.addActionListener(e -> restoreSelectedEvent());
            popup.add(restoreItem);

            JMenuItem deleteItem = new JMenuItem("Delete Permanently");
            deleteItem.addActionListener(e -> permanentlyDeleteEvent());
            popup.add(deleteItem);

            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void restoreSelectedEvent() {
        int selectedRow = deletedEventsTable.getSelectedRow();
        if (selectedRow != -1) {
            int eventId = (int) deletedEventsTable.getValueAt(selectedRow, 0);
            String eventTitle = (String) deletedEventsTable.getValueAt(selectedRow, 1);

            int choice = JOptionPane.showConfirmDialog(this,
                    "Restore event '" + eventTitle + "'?",
                    "Confirm Restore",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                if (eventController.restoreEvent(eventId, this.currentUser)) {
                    loadEvents();
                    MsgHandler.showSuccess(this, "Event restored successfully!");
                }
            }
        }
    }

    private void permanentlyDeleteEvent() {
        int selectedRow = deletedEventsTable.getSelectedRow();
        if (selectedRow != -1) {
            int eventId = (int) deletedEventsTable.getValueAt(selectedRow, 0);
            String eventTitle = (String) deletedEventsTable.getValueAt(selectedRow, 1);

            int choice = JOptionPane.showConfirmDialog(this,
                    "Permanently delete '" + eventTitle + "'?\nThis cannot be undone!",
                    "Confirm Permanent Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (choice == JOptionPane.YES_OPTION) {
                if (eventController.permanentlyDeleteEvent(eventId)) {
                    loadEvents();
                    MsgHandler.showSuccess(this, "Event permanently deleted!");
                }
            }
        }
    }

    private void loadEvents() {
        DefaultTableModel model = (DefaultTableModel) deletedEventsTable.getModel();

        model.setRowCount(0);

        List<Event> events = eventController.getAllDeletedEvents();

        for (Event event : events) {
            if (!currentUser.getRole().equals(Role.OWRNER) && currentUser.getTeam() != null && !currentUser.getTeam().getName().equals(event.getTeam())) {
                continue;
            }
            Object[] row = {
                event.getId(),
                event.getTitle(),
                event.getDesc(),
                event.getTeam(),
                event.getDate().toString()
            };
            model.addRow(row);
        }
    }

    public void refreshEvents() {
        loadEvents();
    }

}
