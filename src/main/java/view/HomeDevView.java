package view;

import view.panels.MonthlyCalendarForDevsPanel;
import view.panels.HelpPanel;
import view.panels.ProfilePanel;
import view.panels.MonthlyCalendarPanel;
import java.awt.Color;

import model.User;
import view.auth.Login;
import view.panels.NotificationPanel;

public class HomeDevView extends javax.swing.JFrame {

    private User loggedUser;

    public HomeDevView(User user) {
        this.loggedUser = user;
        initComponents();
        setContentPanel(new MonthlyCalendarForDevsPanel(this, loggedUser));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        nav = new javax.swing.JPanel();
        profileBtn = new javax.swing.JButton();
        notificationBtn = new javax.swing.JButton();
        helpBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTable = new javax.swing.JTable();
        aside = new javax.swing.JPanel();
        navigationAside = new javax.swing.JPanel();
        FieldName1 = new javax.swing.JLabel();
        teamCalendarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calendar Management System");
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1050, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(51, 51, 51));
        header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setText("Hi Alaa");
        logo.setText("Hi " + loggedUser.getName());
        header.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 520, 40));

        nav.setBackground(new java.awt.Color(51, 51, 51));
        nav.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 12, 5));

        profileBtn.setBackground(new java.awt.Color(74, 144, 226));
        profileBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(255, 255, 255));
        profileBtn.setText("Profile");
        profileBtn.setBorderPainted(false);
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        profileBtn.setFocusable(false);
        profileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileBtnMouseExited(evt);
            }
        });
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        nav.add(profileBtn);

        notificationBtn.setBackground(new java.awt.Color(74, 144, 226));
        notificationBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        notificationBtn.setForeground(new java.awt.Color(255, 255, 255));
        notificationBtn.setText("Notification");
        notificationBtn.setBorderPainted(false);
        notificationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        notificationBtn.setFocusable(false);
        notificationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificationBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificationBtnMouseExited(evt);
            }
        });
        notificationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationBtnActionPerformed(evt);
            }
        });
        nav.add(notificationBtn);

        helpBtn.setBackground(new java.awt.Color(74, 144, 226));
        helpBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        helpBtn.setForeground(new java.awt.Color(255, 255, 255));
        helpBtn.setText("Help");
        helpBtn.setBorderPainted(false);
        helpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        helpBtn.setFocusable(false);
        helpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpBtnMouseExited(evt);
            }
        });
        helpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBtnActionPerformed(evt);
            }
        });
        nav.add(helpBtn);

        logoutBtn.setBackground(new java.awt.Color(74, 144, 226));
        logoutBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoutBtn.setFocusable(false);
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        nav.add(logoutBtn);

        header.add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 400, -1));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 50));

        content.setMaximumSize(new java.awt.Dimension(850, 450));
        content.setMinimumSize(new java.awt.Dimension(850, 450));
        content.setPreferredSize(new java.awt.Dimension(850, 450));
        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Calendar Management System");
        content.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 50));

        eventsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(eventsTable);

        content.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 400));

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 850, 450));

        aside.setBackground(new java.awt.Color(255, 255, 255));
        aside.setPreferredSize(new java.awt.Dimension(250, 0));
        aside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navigationAside.setBackground(new java.awt.Color(255, 255, 255));
        navigationAside.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        navigationAside.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        navigationAside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FieldName1.setBackground(new java.awt.Color(255, 255, 255));
        FieldName1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FieldName1.setForeground(new java.awt.Color(102, 102, 102));
        FieldName1.setText("NAVIGATION");
        navigationAside.add(FieldName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 0, 170, 30));

        teamCalendarBtn.setBackground(new java.awt.Color(204, 204, 204));
        teamCalendarBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        teamCalendarBtn.setForeground(new java.awt.Color(51, 51, 51));
        teamCalendarBtn.setText("Calendar");
        teamCalendarBtn.setBorderPainted(false);
        teamCalendarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        teamCalendarBtn.setFocusable(false);
        teamCalendarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teamCalendarBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teamCalendarBtnMouseExited(evt);
            }
        });
        teamCalendarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamCalendarBtnActionPerformed(evt);
            }
        });
        navigationAside.add(teamCalendarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 30));

        aside.add(navigationAside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 450));

        getContentPane().add(aside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void helpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBtnActionPerformed
        setContentPanel(new HelpPanel(this));
    }//GEN-LAST:event_helpBtnActionPerformed

    private void helpBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnMouseEntered

        helpBtn.setBackground(new Color(33, 123, 255));
        helpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_helpBtnMouseEntered

    private void helpBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnMouseExited
        helpBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_helpBtnMouseExited

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        logoutBtn.setBackground(new Color(33, 123, 255));
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_logoutBtnMouseEntered

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        logoutBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_logoutBtnMouseExited

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        openLoginFrame();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void notificationBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationBtnMouseEntered
        notificationBtn.setBackground(new Color(33, 123, 255));
        notificationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_notificationBtnMouseEntered

    private void notificationBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationBtnMouseExited
        notificationBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_notificationBtnMouseExited

    private void notificationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationBtnActionPerformed
        setContentPanel(new NotificationPanel(this, loggedUser));
    }//GEN-LAST:event_notificationBtnActionPerformed

    private void profileBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnMouseEntered
        profileBtn.setBackground(new Color(33, 123, 255));
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_profileBtnMouseEntered

    private void profileBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnMouseExited
        profileBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_profileBtnMouseExited

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        setContentPanel(new ProfilePanel(this, loggedUser));
    }//GEN-LAST:event_profileBtnActionPerformed

    private void teamCalendarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamCalendarBtnMouseEntered
        teamCalendarBtn.setBackground(new Color(160, 160, 160));
        teamCalendarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_teamCalendarBtnMouseEntered

    private void teamCalendarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamCalendarBtnMouseExited
        teamCalendarBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_teamCalendarBtnMouseExited

    private void teamCalendarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamCalendarBtnActionPerformed
        setContentPanel(new MonthlyCalendarForDevsPanel(this, loggedUser));
    }//GEN-LAST:event_teamCalendarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FieldName1;
    private javax.swing.JPanel aside;
    private javax.swing.JPanel content;
    private javax.swing.JTable eventsTable;
    private javax.swing.JPanel header;
    private javax.swing.JButton helpBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel navigationAside;
    private javax.swing.JButton notificationBtn;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton teamCalendarBtn;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    public void refreshEvents() {
        if (content.getComponentCount() > 0) {
            java.awt.Component comp = content.getComponent(0);
            if (comp instanceof MonthlyCalendarPanel) {
                ((MonthlyCalendarPanel) comp).refreshEvents();
            }
        }
    }

    private void setContentPanel(javax.swing.JPanel panel) {
        content.removeAll();
        content.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));
        content.revalidate();
        content.repaint();
    }

    private void openLoginFrame() {
        new Login().setVisible(true);
        dispose();
    }

}
