package view.dialogs;

import controller.TeamController;
import java.awt.Color;
import java.time.LocalTime;
import model.Role;
import model.User;
import util.MsgHandler;

public class CreateEventDialog extends javax.swing.JDialog {

    private controller.TeamController teamController;
    private User loggedUser;

    public CreateEventDialog(java.awt.Frame parent, boolean modal, java.time.LocalDate preSelectedDate, User loggedUser, LocalTime time) {
        super(parent, modal);
        initComponents();
        this.loggedUser = loggedUser;
        eventController = new controller.EventController();
        teamController = new TeamController();
        loadTeams();
        if (preSelectedDate != null) {
            eventDateField.setDate(java.sql.Date.valueOf(preSelectedDate));
        }
    }
    
        public CreateEventDialog(java.awt.Frame parent, boolean modal, java.time.LocalDate preSelectedDate, User loggedUser) {
        super(parent, modal);
        initComponents();
        this.loggedUser = loggedUser;
        eventController = new controller.EventController();
        teamController = new controller.TeamController();
        loadTeams();
        if (preSelectedDate != null) {
            eventDateField.setDate(java.sql.Date.valueOf(preSelectedDate));
        }
    }

    public CreateEventDialog(java.awt.Frame parent, boolean modal, User loggedUser) {
        super(parent, modal);
        initComponents();
        this.loggedUser = loggedUser;
        eventController = new controller.EventController();
        teamController = new controller.TeamController();
        loadTeams();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        box1 = new javax.swing.JPanel();
        textArea1 = new javax.swing.JScrollPane();
        eventDescField = new javax.swing.JTextArea();
        inputTitle1 = new javax.swing.JLabel();
        box = new javax.swing.JPanel();
        inputTitle = new javax.swing.JLabel();
        eventTitleField = new javax.swing.JTextField();
        box2 = new javax.swing.JPanel();
        inputTitle2 = new javax.swing.JLabel();
        eventTeamField = new javax.swing.JComboBox<>();
        box3 = new javax.swing.JPanel();
        inputTitle3 = new javax.swing.JLabel();
        eventDateField = new com.toedter.calendar.JDateChooser();
        cancelBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        box4 = new javax.swing.JPanel();
        inputTitle4 = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Event");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        box1.setBackground(new java.awt.Color(255, 255, 255));

        eventDescField.setColumns(20);
        eventDescField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        eventDescField.setForeground(new java.awt.Color(51, 51, 51));
        eventDescField.setRows(1);
        eventDescField.setText("Event Description");
        eventDescField.setCaretColor(new java.awt.Color(51, 51, 51));
        textArea1.setViewportView(eventDescField);

        inputTitle1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle1.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle1.setText("Description");

        javax.swing.GroupLayout box1Layout = new javax.swing.GroupLayout(box1);
        box1.setLayout(box1Layout);
        box1Layout.setHorizontalGroup(
            box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textArea1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        box1Layout.setVerticalGroup(
            box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        box.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle.setText("Title");

        eventTitleField.setText("Event Title");
        eventTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventTitleFieldActionPerformed(evt);
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
                    .addComponent(eventTitleField))
                .addContainerGap())
        );
        boxLayout.setVerticalGroup(
            boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle)
                .addGap(10, 10, 10)
                .addComponent(eventTitleField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        box2.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle2.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle2.setText("Team");

        eventTeamField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        eventTeamField.setForeground(new java.awt.Color(51, 51, 51));
        eventTeamField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "frontend", "backend", "ui" }));
        eventTeamField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventTeamFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout box2Layout = new javax.swing.GroupLayout(box2);
        box2.setLayout(box2Layout);
        box2Layout.setHorizontalGroup(
            box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventTeamField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        box2Layout.setVerticalGroup(
            box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventTeamField, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        box3.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle3.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle3.setText("Date");

        eventDateField.setBackground(new java.awt.Color(255, 255, 255));
        eventDateField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout box3Layout = new javax.swing.GroupLayout(box3);
        box3.setLayout(box3Layout);
        box3Layout.setHorizontalGroup(
            box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(eventDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        box3Layout.setVerticalGroup(
            box3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle3)
                .addGap(10, 10, 10)
                .addComponent(eventDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(box3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formLayout.createSequentialGroup()
                    .addContainerGap(208, Short.MAX_VALUE)
                    .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(85, 85, 85)))
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

        box4.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle4.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle4.setText("Time");

        timeField.setText("time ex: 14:00-14:30");
        timeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout box4Layout = new javax.swing.GroupLayout(box4);
        box4.setLayout(box4Layout);
        box4Layout.setHorizontalGroup(
            box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        box4Layout.setVerticalGroup(
            box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(box4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eventTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventTitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventTitleFieldActionPerformed

    private void eventTeamFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventTeamFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventTeamFieldActionPerformed

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
        handleCreateEvent();
    }//GEN-LAST:event_createBtnActionPerformed

    private void timeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box;
    private javax.swing.JPanel box1;
    private javax.swing.JPanel box2;
    private javax.swing.JPanel box3;
    private javax.swing.JPanel box4;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton createBtn;
    private com.toedter.calendar.JDateChooser eventDateField;
    private javax.swing.JTextArea eventDescField;
    private javax.swing.JComboBox<String> eventTeamField;
    private javax.swing.JTextField eventTitleField;
    private javax.swing.JPanel form;
    private javax.swing.JLabel inputTitle;
    private javax.swing.JLabel inputTitle1;
    private javax.swing.JLabel inputTitle2;
    private javax.swing.JLabel inputTitle3;
    private javax.swing.JLabel inputTitle4;
    private javax.swing.JScrollPane textArea1;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables
    private controller.EventController eventController;

    private void handleCreateEvent() {
        String eventTitle = eventTitleField.getText().trim();
        String eventDescription = eventDescField.getText().trim();
        String selectedTeam = (String) eventTeamField.getSelectedItem();
        java.util.Date selectedDate = eventDateField.getDate();
        String eventTime = timeField.getText(); 

        if (eventTitle.isEmpty() || eventTitle.equals("Event Title")) {
            MsgHandler.showError(this, "Please enter event title");
            return;
        }

        if (eventDescription.isEmpty() || eventDescription.equals("Event Description")) {
            MsgHandler.showError(this, "Please enter event description");
            return;
        }

        if (selectedDate == null) {
            MsgHandler.showError(this, "Please select a date");
            return;
        }

        if (selectedTeam.equals("No teams available")) {
            MsgHandler.showError(this, "Please create a team");
            return;
        }

        java.time.LocalDate localDate = selectedDate.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
        
        if (eventTime == null || !eventTime.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d-(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
            MsgHandler.showError(this, "Please select a valid time");
            return;
        }
        
        String[] parts = eventTime.split("-");
        LocalTime start = LocalTime.parse(parts[0]);
        LocalTime end = LocalTime.parse(parts[1]);

        boolean success = eventController.createEvent(eventTitle, eventDescription, selectedTeam, localDate, null, start, end, loggedUser);

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
        eventTitleField.setText("Event Title");
        eventDescField.setText("Event Description");
        eventTeamField.setSelectedIndex(0);
        eventDateField.setDate(null);
    }

    private void refreshParentView() {
        java.awt.Frame parent = (java.awt.Frame) this.getOwner();
        if (parent instanceof view.HomeAdminView) {
            ((view.HomeAdminView) parent).refreshEvents();
        }
    }

    private void loadTeams() {
        java.util.List<model.Team> teams = teamController.getAllTeams();

        eventTeamField.removeAllItems();

        if (teams.isEmpty()) {
            eventTeamField.addItem("No teams available");
            eventTeamField.setEnabled(false);
            return;
        }

        for (model.Team team : teams) {
            if(loggedUser.getRole() != Role.OWRNER && loggedUser.getTeam() != team) {continue;}
            eventTeamField.addItem(team.getName());
        }

        eventTeamField.setEnabled(true);
    }

    public void refreshTeams() {
        loadTeams();
    }
}
