package view;

import view.panels.HelpPanel;
import view.panels.NotificationPanel;
import view.panels.TeamPanel;
import view.panels.ProfilePanel;
import view.panels.TrashPanel;
import view.panels.MonthlyCalendarPanel;
import view.dialogs.CreateTeamDialog;
import view.dialogs.CreateEventDialog;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import model.Role;
import model.User;
import view.auth.Login;
import view.panels.UsersPanel;

public class HomeAdminView extends javax.swing.JFrame {

    private User loggedUser;

    public HomeAdminView(User user) {
        this.loggedUser = user;
        initComponents();
        setContentPanel(new MonthlyCalendarPanel(this, loggedUser));
        setupShortcuts();
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
        aside = new javax.swing.JPanel();
        actionsAside = new javax.swing.JPanel();
        createTeamBtn = new javax.swing.JButton();
        createEventBtn = new javax.swing.JButton();
        navigationAside = new javax.swing.JPanel();
        FieldName1 = new javax.swing.JLabel();
        teamsBtn = new javax.swing.JButton();
        trashBtn = new javax.swing.JButton();
        teamCalendarBtn = new javax.swing.JButton();
        AllUsersBtn = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTable = new javax.swing.JTable();

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
        header.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 590, 40));

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

        aside.setBackground(new java.awt.Color(255, 255, 255));
        aside.setPreferredSize(new java.awt.Dimension(250, 0));
        aside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actionsAside.setBackground(new java.awt.Color(255, 255, 255));
        actionsAside.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        actionsAside.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        actionsAside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        if (this.loggedUser.getRole() != Role.OWRNER) {
            createTeamBtn.setVisible(false);
        }
        createTeamBtn.setBackground(new java.awt.Color(74, 144, 226));
        createTeamBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createTeamBtn.setForeground(new java.awt.Color(255, 255, 255));
        createTeamBtn.setText("Create Team");
        createTeamBtn.setBorderPainted(false);
        createTeamBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        createTeamBtn.setFocusable(false);
        createTeamBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createTeamBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createTeamBtnMouseExited(evt);
            }
        });
        createTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTeamBtnActionPerformed(evt);
            }
        });
        actionsAside.add(createTeamBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        createEventBtn.setBackground(new java.awt.Color(74, 144, 226));
        createEventBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        createEventBtn.setForeground(new java.awt.Color(255, 255, 255));
        createEventBtn.setText("Create Event");
        createEventBtn.setBorderPainted(false);
        createEventBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        createEventBtn.setFocusable(false);
        createEventBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createEventBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createEventBtnMouseExited(evt);
            }
        });
        createEventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEventBtnActionPerformed(evt);
            }
        });
        actionsAside.add(createEventBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 180, 30));

        aside.add(actionsAside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 110));

        navigationAside.setBackground(new java.awt.Color(255, 255, 255));
        navigationAside.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        navigationAside.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        navigationAside.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FieldName1.setBackground(new java.awt.Color(255, 255, 255));
        FieldName1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FieldName1.setForeground(new java.awt.Color(102, 102, 102));
        FieldName1.setText("NAVIGATION");
        navigationAside.add(FieldName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 0, 170, 30));

        teamsBtn.setBackground(new java.awt.Color(204, 204, 204));
        teamsBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        teamsBtn.setForeground(new java.awt.Color(51, 51, 51));
        teamsBtn.setText("Teams");
        teamsBtn.setBorderPainted(false);
        teamsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        teamsBtn.setFocusable(false);
        teamsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teamsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teamsBtnMouseExited(evt);
            }
        });
        teamsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamsBtnActionPerformed(evt);
            }
        });
        navigationAside.add(teamsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 30));

        trashBtn.setBackground(new java.awt.Color(204, 204, 204));
        trashBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        trashBtn.setForeground(new java.awt.Color(51, 51, 51));
        trashBtn.setText("Trash");
        trashBtn.setBorderPainted(false);
        trashBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        trashBtn.setFocusable(false);
        trashBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trashBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trashBtnMouseExited(evt);
            }
        });
        trashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trashBtnActionPerformed(evt);
            }
        });
        navigationAside.add(trashBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, 30));

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

        AllUsersBtn.setBackground(new java.awt.Color(204, 204, 204));
        AllUsersBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AllUsersBtn.setForeground(new java.awt.Color(51, 51, 51));
        AllUsersBtn.setText("Users");
        AllUsersBtn.setBorderPainted(false);
        AllUsersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AllUsersBtn.setFocusable(false);
        AllUsersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AllUsersBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AllUsersBtnMouseExited(evt);
            }
        });
        AllUsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllUsersBtnActionPerformed(evt);
            }
        });
        navigationAside.add(AllUsersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, 30));

        aside.add(navigationAside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 350));

        getContentPane().add(aside, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 450));

        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Calendar Management System");
        content.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 50));

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

    private void createTeamBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createTeamBtnMouseEntered
        createTeamBtn.setBackground(new Color(33, 123, 255));
        createTeamBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_createTeamBtnMouseEntered

    private void createTeamBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createTeamBtnMouseExited
        createTeamBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_createTeamBtnMouseExited

    private void createTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTeamBtnActionPerformed
        openCreateTeamDialog();

    }//GEN-LAST:event_createTeamBtnActionPerformed

    private void createEventBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createEventBtnMouseEntered
        createEventBtn.setBackground(new Color(33, 123, 255));
        createEventBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_createEventBtnMouseEntered

    private void createEventBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createEventBtnMouseExited
        createEventBtn.setBackground(new Color(74, 144, 226));
    }//GEN-LAST:event_createEventBtnMouseExited

    private void createEventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEventBtnActionPerformed
        openCreateEventDialog();
    }//GEN-LAST:event_createEventBtnActionPerformed

    private void teamCalendarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamCalendarBtnMouseEntered
        teamCalendarBtn.setBackground(new Color(160, 160, 160));
        teamCalendarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_teamCalendarBtnMouseEntered

    private void teamCalendarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamCalendarBtnMouseExited
        teamCalendarBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_teamCalendarBtnMouseExited

    private void teamCalendarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamCalendarBtnActionPerformed
        setContentPanel(new MonthlyCalendarPanel(this, loggedUser));
    }//GEN-LAST:event_teamCalendarBtnActionPerformed

    private void teamsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamsBtnMouseEntered
        teamsBtn.setBackground(new Color(160, 160, 160));
        teamsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_teamsBtnMouseEntered

    private void teamsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamsBtnMouseExited
        teamsBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_teamsBtnMouseExited

    private void teamsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamsBtnActionPerformed
        setContentPanel(new TeamPanel(this, loggedUser));
    }//GEN-LAST:event_teamsBtnActionPerformed

    private void trashBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trashBtnMouseEntered
        trashBtn.setBackground(new Color(160, 160, 160));
        trashBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_trashBtnMouseEntered

    private void trashBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trashBtnMouseExited
        trashBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_trashBtnMouseExited

    private void trashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trashBtnActionPerformed
        setContentPanel(new TrashPanel(this, loggedUser));
    }//GEN-LAST:event_trashBtnActionPerformed

    private void AllUsersBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllUsersBtnMouseEntered
        AllUsersBtn.setBackground(new Color(160, 160, 160));
        AllUsersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_AllUsersBtnMouseEntered

    private void AllUsersBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllUsersBtnMouseExited
        AllUsersBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_AllUsersBtnMouseExited

    private void AllUsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllUsersBtnActionPerformed
        setContentPanel(new UsersPanel(this, loggedUser));
    }//GEN-LAST:event_AllUsersBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllUsersBtn;
    private javax.swing.JLabel FieldName1;
    private javax.swing.JPanel actionsAside;
    private javax.swing.JPanel aside;
    private javax.swing.JPanel content;
    private javax.swing.JButton createEventBtn;
    private javax.swing.JButton createTeamBtn;
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
    private javax.swing.JButton teamsBtn;
    private javax.swing.JLabel title;
    private javax.swing.JButton trashBtn;
    // End of variables declaration//GEN-END:variables
private void openCreateEventDialog() {
        CreateEventDialog dialog = new CreateEventDialog(this, true, loggedUser);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openCreateTeamDialog() {
        CreateTeamDialog dialog = new CreateTeamDialog(this, true, loggedUser);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void refreshEvents() {
        if (content.getComponentCount() > 0) {
            java.awt.Component comp = content.getComponent(0);
            if (comp instanceof MonthlyCalendarPanel) {
                ((MonthlyCalendarPanel) comp).refreshEvents();
            }
        }
    }

    public void refreshTeams() {
        if (content.getComponentCount() > 0) {
            java.awt.Component comp = content.getComponent(0);
            if (comp instanceof TeamPanel) {
                ((TeamPanel) comp).refreshTeams();
            }
        }
    }

    public void refreshUsers() {
        if (content.getComponentCount() > 0) {
            java.awt.Component comp = content.getComponent(0);
            if (comp instanceof UsersPanel) {
                ((UsersPanel) comp).refreshUsers();
            }
        }
    }

    private void openLoginFrame() {
        new Login().setVisible(true);
        dispose();
    }

    private void setContentPanel(javax.swing.JPanel panel) {
        content.removeAll();
        content.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));
        content.revalidate(); // for sizes - positions
        content.repaint(); // for screen
    }

    private void setupShortcuts() {
        JRootPane rootPane = getRootPane();

        KeyStroke createEventKey = KeyStroke.getKeyStroke("control N");
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(createEventKey, "createEvent");
        rootPane.getActionMap().put("createEvent", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                openCreateEventDialog();
            }
        });

        KeyStroke createTeamKey = KeyStroke.getKeyStroke("control T");
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(createTeamKey, "createTeam");
        rootPane.getActionMap().put("createTeam", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (loggedUser.getRole() == Role.OWRNER) {
                    openCreateTeamDialog();
                }
            }
        });
    }
}
