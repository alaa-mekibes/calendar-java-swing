package view.panels;

public class HelpPanel extends javax.swing.JPanel {

    private java.awt.Frame parent;

    public HelpPanel(java.awt.Frame parent) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleH2 = new javax.swing.JLabel();
        titleH1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();
        titleH3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        content1 = new javax.swing.JTextArea();
        titleH4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        content2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        titleH2.setBackground(new java.awt.Color(255, 255, 255));
        titleH2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titleH2.setForeground(new java.awt.Color(74, 144, 226));
        titleH2.setText("Getting Started");

        titleH1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titleH1.setForeground(new java.awt.Color(51, 51, 51));
        titleH1.setText("Help");

        jScrollPane1.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        content.setEditable(false);
        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setColumns(20);
        content.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        content.setForeground(new java.awt.Color(102, 102, 102));
        content.setRows(5);
        content.setText("Welcome to the Calendar Management System! This application helps project managers and developers\ncoordinate events, tasks, and team activities efficiently.");
        content.setAutoscrolls(false);
        content.setBorder(null);
        content.setCaretColor(new java.awt.Color(51, 51, 51));
        content.setFocusable(false);
        content.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(content);

        titleH3.setBackground(new java.awt.Color(255, 255, 255));
        titleH3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titleH3.setForeground(new java.awt.Color(74, 144, 226));
        titleH3.setText("For Developpers");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        content1.setEditable(false);
        content1.setBackground(new java.awt.Color(255, 255, 255));
        content1.setColumns(20);
        content1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        content1.setForeground(new java.awt.Color(102, 102, 102));
        content1.setRows(5);
        content1.setText("* View all assigned events in the calendar\n* Click on events to see detailed information\n* Receive notifications about upcoming events");
        content1.setBorder(null);
        content1.setFocusable(false);
        content1.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(content1);

        titleH4.setBackground(new java.awt.Color(255, 255, 255));
        titleH4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        titleH4.setForeground(new java.awt.Color(74, 144, 226));
        titleH4.setText("For Project Managers");

        jScrollPane3.setAutoscrolls(true);

        content2.setEditable(false);
        content2.setBackground(new java.awt.Color(255, 255, 255));
        content2.setColumns(20);
        content2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        content2.setForeground(new java.awt.Color(102, 102, 102));
        content2.setRows(5);
        content2.setText("* Create and manage teams with assigned developers\n* Schedule events and assign them to specific teams\n* Modify or delete events using right-click context menu\n* Drag and drop events to reschedule them\n* View deleted events in the Trash page\n* Use Ctrl+N keyboard shortcut to quickly create events\n* Use Ctrl+T keyboard shortcut to quickly create Teams");
        content2.setBorder(null);
        content2.setFocusable(false);
        content2.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(content2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleH2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleH3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleH4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleH1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleH2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleH4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(titleH3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(231, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(114, 114, 114)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea content;
    private javax.swing.JTextArea content1;
    private javax.swing.JTextArea content2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel titleH1;
    private javax.swing.JLabel titleH2;
    private javax.swing.JLabel titleH3;
    private javax.swing.JLabel titleH4;
    // End of variables declaration//GEN-END:variables
}
