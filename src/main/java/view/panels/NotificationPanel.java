package view.panels;

import controller.NotificationController;
import controller.UserController;
import model.Notification;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Role;

public class NotificationPanel extends javax.swing.JPanel {

    private java.awt.Frame parent;
    private model.User currentUser;
    private NotificationController notifController;
    private UserController userController;

    public NotificationPanel(java.awt.Frame parent, model.User user) {
        this.currentUser = user;
        initComponents();
        notifController = NotificationController.getInstance();
        userController = new UserController();
        setupTable();
        loadNotifications();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationsTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Notification");

        notificationsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(notificationsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable notificationsTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
private void setupTable() {
        String[] columns = {"Message", "Time"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        notificationsTable.setModel(model);

        notificationsTable.getColumnModel().getColumn(0).setPreferredWidth(400);
        notificationsTable.getColumnModel().getColumn(1).setPreferredWidth(200);

    }

    private void loadNotifications() {
        DefaultTableModel model = (DefaultTableModel) notificationsTable.getModel();
        model.setRowCount(0);

        List<Notification> notifications = notifController.getNotificationsForUser(currentUser.getId());

        for (Notification notif : notifications) {
            if(!currentUser.getRole().equals(Role.OWRNER) && currentUser.getTeam() != null && !userController.getUserById(notif.getRecipientUserId()).getTeam().equals(currentUser.getTeam())) {continue;}
            Object[] row = {
                notif.getMessage(),
                notif.getTimestamp().format(DateTimeFormatter.BASIC_ISO_DATE.ofPattern("yyyy-MM-dd HH:mm")),};
            model.addRow(row);
        }
    }

    public void refreshNotifications() {
        loadNotifications();
    }
}
