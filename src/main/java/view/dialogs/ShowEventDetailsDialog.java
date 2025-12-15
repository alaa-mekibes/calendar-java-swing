package view.dialogs;

import java.awt.Color;
import model.Event;
import model.Team;

public class ShowEventDetailsDialog extends javax.swing.JDialog {

    private controller.EventController eventController;
    private controller.TeamController teamController;

    public ShowEventDetailsDialog(java.awt.Frame parent, model.Event event) {
        super(parent, true);
        initComponents();
        eventController = new controller.EventController();
        teamController = new controller.TeamController();
        displayEventInfo(event);
    }

    public ShowEventDetailsDialog(java.awt.Frame parent, boolean b) {
        super(parent, true);
        eventController = new controller.EventController();
        teamController = new controller.TeamController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form = new javax.swing.JPanel();
        box1 = new javax.swing.JPanel();
        textArea1 = new javax.swing.JScrollPane();
        descField = new javax.swing.JTextArea();
        inputTitle1 = new javax.swing.JLabel();
        box = new javax.swing.JPanel();
        inputTitle = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        box4 = new javax.swing.JPanel();
        inputTitle4 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        box5 = new javax.swing.JPanel();
        inputTitle5 = new javax.swing.JLabel();
        teamField = new javax.swing.JTextField();
        colorPanel = new javax.swing.JPanel();
        box6 = new javax.swing.JPanel();
        inputTitle6 = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Event details");
        setBackground(new java.awt.Color(255, 255, 255));

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        box1.setBackground(new java.awt.Color(255, 255, 255));

        descField.setEditable(false);
        descField.setBackground(new java.awt.Color(255, 255, 255));
        descField.setColumns(20);
        descField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descField.setForeground(new java.awt.Color(51, 51, 51));
        descField.setRows(1);
        descField.setCaretColor(new java.awt.Color(51, 51, 51));
        textArea1.setViewportView(descField);

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

        titleField.setEditable(false);
        titleField.setBackground(new java.awt.Color(255, 255, 255));
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
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
                    .addComponent(titleField))
                .addContainerGap())
        );
        boxLayout.setVerticalGroup(
            boxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle)
                .addGap(10, 10, 10)
                .addComponent(titleField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        box4.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle4.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle4.setText("Date");

        dateField.setEditable(false);
        dateField.setBackground(new java.awt.Color(255, 255, 255));
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
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
                    .addComponent(dateField))
                .addContainerGap())
        );
        box4Layout.setVerticalGroup(
            box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        box5.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle5.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle5.setText("team");

        teamField.setEditable(false);
        teamField.setBackground(new java.awt.Color(255, 255, 255));
        teamField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout box5Layout = new javax.swing.GroupLayout(box5);
        box5.setLayout(box5Layout);
        box5Layout.setHorizontalGroup(
            box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(box5Layout.createSequentialGroup()
                        .addComponent(teamField)
                        .addGap(18, 18, 18)
                        .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        box5Layout.setVerticalGroup(
            box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle5)
                .addGap(10, 10, 10)
                .addGroup(box5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teamField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(colorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        box6.setBackground(new java.awt.Color(255, 255, 255));

        inputTitle6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        inputTitle6.setForeground(new java.awt.Color(51, 51, 51));
        inputTitle6.setText("Time");

        timeField.setEditable(false);
        timeField.setBackground(new java.awt.Color(255, 255, 255));
        timeField.setText("time ex: 14:00-14:30");
        timeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout box6Layout = new javax.swing.GroupLayout(box6);
        box6.setLayout(box6Layout);
        box6Layout.setHorizontalGroup(
            box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputTitle6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        box6Layout.setVerticalGroup(
            box6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, box6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTitle6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(8, 8, 8))
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
                    .addComponent(box4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelBtn.setBackground(new java.awt.Color(204, 204, 204));
        cancelBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(51, 51, 51));
        cancelBtn.setText("ok");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
            .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

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

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void teamFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamFieldActionPerformed

    private void timeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box;
    private javax.swing.JPanel box1;
    private javax.swing.JPanel box4;
    private javax.swing.JPanel box5;
    private javax.swing.JPanel box6;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextArea descField;
    private javax.swing.JPanel form;
    private javax.swing.JLabel inputTitle;
    private javax.swing.JLabel inputTitle1;
    private javax.swing.JLabel inputTitle4;
    private javax.swing.JLabel inputTitle5;
    private javax.swing.JLabel inputTitle6;
    private javax.swing.JTextField teamField;
    private javax.swing.JScrollPane textArea1;
    private javax.swing.JTextField timeField;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables

    private void displayEventInfo(Event event) {
        titleField.setText(event.getTitle());
        descField.setText(event.getDesc());
        dateField.setText("" + event.getDate());
        teamField.setText(event.getTeam());
        timeField.setText(event.getStartTime() + "-" + event.getEndTime());

        Color teamColor = getTeamColor(event.getTeam());
        colorPanel.setBackground(teamColor);
    }

    private Color getTeamColor(String teamName) {
        for (Team t : teamController.getAllTeams()) {
            if (t.getName().equalsIgnoreCase(teamName)) {
                return t.getColor();
            }
        }
        return Color.GRAY;
    }
}
