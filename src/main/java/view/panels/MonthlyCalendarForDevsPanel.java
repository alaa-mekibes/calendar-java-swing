package view.panels;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import controller.EventController;
import controller.TeamController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.TransferHandler;
import model.User;
import model.Event;
import model.Team;

import java.awt.Color;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import util.MsgHandler;
import view.dialogs.ShowEventDetailsDialog;

public class MonthlyCalendarForDevsPanel extends javax.swing.JPanel {

    private java.awt.Frame parent;
    private EventController eventController;
    private TeamController teamController;
    private YearMonth currentMonth;
    private javax.swing.JLabel monthYearLabel;
    private javax.swing.JPanel calendarGrid;
    private User currentUser;
    private DailyCalendarForDevsPanel dailyPanel;
    private JPanel monthlyPanel;
    private String currentMode = "Monthly";

    public MonthlyCalendarForDevsPanel(java.awt.Frame parent, User user) {
        this.parent = parent;
        this.currentUser = user;
        initComponents();
        eventController = new controller.EventController();
        teamController = new controller.TeamController();
        currentMonth = YearMonth.now();
        
        changeMode.addActionListener(e -> switchCalendarMode());
        
        setupCalendar();
        loadCalendar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        calendarContainer = new javax.swing.JPanel();
        changeMode = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Calendar Management System");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 380, 50));

        calendarContainer.setLayout(new java.awt.BorderLayout());
        add(calendarContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 850, 410));

        changeMode.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        changeMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly", "Daily" }));
        add(changeMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 0, 110, 40));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarContainer;
    private javax.swing.JComboBox<String> changeMode;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private void switchCalendarMode() {
        String selectedMode = (String) changeMode.getSelectedItem();
        
        if (selectedMode.equals(currentMode)) {
            return; // No change
        }
        
        currentMode = selectedMode;
        calendarContainer.removeAll();
        
        if (selectedMode.equals("Daily")) {
            showDailyCalendar();
        } else {
            showMonthlyCalendar();
        }
        
        calendarContainer.revalidate();
        calendarContainer.repaint();
    }

    private void showDailyCalendar() {
        if (dailyPanel == null) {
            dailyPanel = new DailyCalendarForDevsPanel(parent, currentUser);
        }
        calendarContainer.add(dailyPanel, BorderLayout.CENTER);
    }

    private void showMonthlyCalendar() {
        if (monthlyPanel == null) {
            monthlyPanel = new JPanel(new BorderLayout());
            setupMonthlyCalendar();
        }
        calendarContainer.add(monthlyPanel, BorderLayout.CENTER);
        loadCalendar();
    }

    private void setupCalendar() {
        monthlyPanel = new JPanel(new BorderLayout());
        setupMonthlyCalendar();
        calendarContainer.add(monthlyPanel, BorderLayout.CENTER);
    }

    private void setupMonthlyCalendar() {
        monthlyPanel.removeAll();
        
        JPanel navPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));
        navPanel.setBackground(java.awt.Color.WHITE);

        JButton preBtn = new javax.swing.JButton("Previous");
        preBtn.setBackground(new java.awt.Color(74, 144, 226));
        preBtn.setForeground(java.awt.Color.WHITE);
        preBtn.setFocusPainted(false);
        preBtn.addActionListener(e -> changeMonth(-1));

        monthYearLabel = new JLabel();
        monthYearLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
        updateMonthLabel();

        JButton nextBtn = new JButton("Next");
        nextBtn.setBackground(new java.awt.Color(74, 144, 226));
        nextBtn.setForeground(java.awt.Color.WHITE);
        nextBtn.setFocusPainted(false);
        nextBtn.addActionListener(e -> changeMonth(1));

        navPanel.add(preBtn);
        navPanel.add(monthYearLabel);
        navPanel.add(nextBtn);

        monthlyPanel.add(navPanel, BorderLayout.NORTH);

        calendarGrid = new JPanel(new GridLayout(0, 7, 2, 2));
        calendarGrid.setBackground(Color.WHITE);

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 12));
            dayLabel.setOpaque(true);
            dayLabel.setBackground(new Color(200, 200, 200));
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            calendarGrid.add(dayLabel);
        }

        monthlyPanel.add(calendarGrid, BorderLayout.CENTER);
    }

    private void updateMonthLabel() {
        String monthName = currentMonth.getMonth().toString();
        monthYearLabel.setText(monthName + " " + currentMonth.getYear());
    }

    private void changeMonth(int offset) {
        currentMonth = currentMonth.plusMonths(offset);
        updateMonthLabel();
        loadCalendar();
    }

    private void loadCalendar() {
        if (!currentMode.equals("Monthly") || calendarGrid == null) {
            return;
        }
        
        while (calendarGrid.getComponentCount() > 7) {
            calendarGrid.remove(7);
        }

        LocalDate firstDay = currentMonth.atDay(1);
        int daysInMonth = currentMonth.lengthOfMonth();
        int startDayOfWeek = firstDay.getDayOfWeek().getValue();
        if (startDayOfWeek == 7) {
            startDayOfWeek = 0;
        }

        for (int i = 0; i < startDayOfWeek; i++) {
            javax.swing.JPanel emptyCell = new javax.swing.JPanel();
            emptyCell.setBackground(java.awt.Color.WHITE);
            emptyCell.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.LIGHT_GRAY));
            calendarGrid.add(emptyCell);
        }

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = currentMonth.atDay(day);
            JPanel dayCell = createDayCell(date);
            calendarGrid.add(dayCell);
        }

        int totalCells = calendarGrid.getComponentCount() - 7;
        int rows = (totalCells / 7) + (totalCells % 7 > 0 ? 1 : 0);
        int neededCells = (rows * 7) - totalCells;
        for (int i = 0; i < neededCells; i++) {
            JPanel emptyCell = new JPanel();
            emptyCell.setBackground(java.awt.Color.WHITE);
            emptyCell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            calendarGrid.add(emptyCell);
        }

        calendarGrid.revalidate();
        calendarGrid.repaint();
    }

    private List<Event> filterEventsByUserTeam(List<Event> events) {
    if (currentUser == null || currentUser.getTeam() == null) {
        return new ArrayList<>();
    }
    
    List<Event> filteredEvents = new ArrayList<>();
    String userTeamName = currentUser.getTeam().getName();
    
    for (Event event : events) {
        if (event.getTeam() != null && event.getTeam().equalsIgnoreCase(userTeamName)) {
            filteredEvents.add(event);
        }
    }
    
    return filteredEvents;
}

    private JLabel createEventLabel(Event event) {
        JLabel label = new JLabel(event.getTitle());
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        label.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        label.setForeground(Color.WHITE);

        label.putClientProperty("eventId", event.getId());
        label.putClientProperty("eventDate", event.getDate());

        // Enable drag
        label.setTransferHandler(new TransferHandler("text") {
            @Override
            protected java.awt.datatransfer.Transferable createTransferable(javax.swing.JComponent c) {
                return new java.awt.datatransfer.StringSelection(String.valueOf(event.getId()));
            }

            @Override
            public int getSourceActions(javax.swing.JComponent c) {
                return MOVE;
            }
        });

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                javax.swing.JComponent comp = (javax.swing.JComponent) e.getSource();
                javax.swing.TransferHandler handler = comp.getTransferHandler();
                handler.exportAsDrag(comp, e, javax.swing.TransferHandler.MOVE);
            }
        });

        List<Team> allTeams = teamController.getAllTeams();
        Color teamColor = new java.awt.Color(158, 158, 158);

        for (model.Team t : allTeams) {
            if (t.getName().equalsIgnoreCase(event.getTeam())) {
                teamColor = t.getColor();
                break;
            }
        }

        label.setBackground(teamColor);
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evt.consume();
                showEventDetails(event);
            }
        });

        return label;
    }

    private JPanel createDayCell(LocalDate date) {
    JPanel cell = new JPanel(new BorderLayout());
    cell.setBackground(Color.WHITE);
    cell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

    cell.setTransferHandler(new TransferHandler() {
        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(java.awt.datatransfer.DataFlavor.stringFlavor);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            try {
                String idString = (String) support.getTransferable()
                        .getTransferData(java.awt.datatransfer.DataFlavor.stringFlavor);
                int eventId = Integer.parseInt(idString);
                model.Event event = eventController.getEventById(eventId);
                if (event != null) {
                    eventController.updateEvent(event.getId(), event.getTitle(), event.getDesc(), 
                        event.getTeam(), date, null, event.getStartTime(), event.getEndTime());
                    loadCalendar();
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        }
    });

    JLabel dayLabel = new JLabel(String.valueOf(date.getDayOfMonth()));
    dayLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 14));
    dayLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
    cell.add(dayLabel, BorderLayout.NORTH);

    JPanel eventsPanel = new JPanel();
    eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
    eventsPanel.setBackground(Color.WHITE);
    eventsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    // CHANGED: Filter events to show only user's team events
    List<model.Event> allEvents = eventController.getEventsByDate(date);
    List<model.Event> events = filterEventsByUserTeam(allEvents);

    int maxDisplay = 3;
    for (int i = 0; i < Math.min(events.size(), maxDisplay); i++) {
        model.Event event = events.get(i);
        JLabel eventLabel = createEventLabel(event);
        eventsPanel.add(eventLabel);
        eventsPanel.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 2)));
    }

    if (events.size() > maxDisplay) {
        JLabel moreLabel = new JLabel("+" + (events.size() - maxDisplay) + " more");
        moreLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, 10));
        moreLabel.setForeground(java.awt.Color.GRAY);
        eventsPanel.add(moreLabel);
    }

    JScrollPane scrollPane = new JScrollPane(eventsPanel);
    scrollPane.setBorder(null);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    cell.add(scrollPane, BorderLayout.CENTER);

    final LocalDate finalDate = date;
    cell.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            showDayEvents(finalDate);
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            cell.setBackground(new Color(240, 240, 240));
            cell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            cell.setBackground(Color.WHITE);
        }
    });

    return cell;
}

private void showDayEvents(LocalDate date) {
    List<Event> allEvents = eventController.getEventsByDate(date);
    List<Event> events = filterEventsByUserTeam(allEvents);

    if (events.isEmpty()) {
        MsgHandler.showInfo(this, "No events in this day for your team");
        return;
    }

    if (events.size() == 1) {
        showEventDetails(events.get(0));
        return;
    }

    String[] eventTitles = new String[events.size()];
    for (int i = 0; i < events.size(); i++) {
        model.Event event = events.get(i);
        eventTitles[i] = event.getTitle() + " (" + event.getTeam() + ")";
    }

    String selected = (String) javax.swing.JOptionPane.showInputDialog(
            this,
            "Select an event to view details:",
            "Events on " + date,
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null,
            eventTitles,
            eventTitles[0]
    );

    if (selected != null) {
        for (int i = 0; i < eventTitles.length; i++) {
            if (eventTitles[i].equals(selected)) {
                showEventDetails(events.get(i));
                break;
            }
        }
    }
}

    private void showEventDetails(model.Event event) {
        ShowEventDetailsDialog dialog = new ShowEventDetailsDialog(parent, event);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        loadCalendar();
    }

    private void showEventDetails(LocalDate date) {
        showDayEvents(date);
    }

    public void refreshEvents() {
        if (currentMode.equals("Monthly")) {
            loadCalendar();
        } else if (dailyPanel != null) {
            dailyPanel.refreshEvents();
        }
    }
}