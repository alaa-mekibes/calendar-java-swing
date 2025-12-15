package view.panels;

import view.dialogs.ShowEventDetailsDialog;
import view.dialogs.CreateEventDialog;
import java.awt.Color;
import java.awt.Frame;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.TransferHandler;
import model.Role;
import model.User;
import model.Event;
import model.Team;

public class MonthlyCalendarPanel extends JPanel {

    private User currentUser;
    private EventController eventController;
    private TeamController teamController;
    private Frame parent;
    private YearMonth currentMonth;
    private JLabel monthYearLabel;
    private JPanel calendarGrid;
    private DailyCalendarForAdminsPanel dailyPanel;
    private JPanel monthlyPanel;
    private String currentMode = "Monthly";

    public MonthlyCalendarPanel(java.awt.Frame parent, model.User user) {
        this.parent = parent;
        this.currentUser = user;
        initComponents();
        eventController = new controller.EventController();
        teamController = new controller.TeamController();
        currentMonth = YearMonth.now();

        // Setup combobox listener
        jComboBox1.addActionListener(e -> switchCalendarMode());

        setupCalendar();
        loadCalendar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        calendarContainer = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("Calendar Management System");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 370, 50));

        calendarContainer.setLayout(new java.awt.BorderLayout());
        add(calendarContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 850, 410));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monthly", "Daily" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 110, 40));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel calendarContainer;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private void switchCalendarMode() {
        String selectedMode = (String) jComboBox1.getSelectedItem();

        if (selectedMode.equals(currentMode)) {
            return;
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
            dailyPanel = new DailyCalendarForAdminsPanel(parent, currentUser);
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

        JButton preBtn = new JButton("Previous");
        preBtn.setBackground(new Color(74, 144, 226));
        preBtn.setForeground(Color.WHITE);
        preBtn.setFocusPainted(false);
        preBtn.addActionListener(e -> changeMonth(-1));

        monthYearLabel = new JLabel();
        monthYearLabel.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
        updateMonthLabel();

        JButton nextBtn = new JButton("Next");
        nextBtn.setBackground(new Color(74, 144, 226));
        nextBtn.setForeground(Color.WHITE);
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

    private JLabel createEventLabel(model.Event event) {
        JLabel label = new JLabel(event.getTitle());
        label.setOpaque(true);
        label.setFont(new Font("Arial", java.awt.Font.PLAIN, 10));
        label.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        label.setForeground(Color.WHITE);

        label.putClientProperty("eventId", event.getId());

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

        List<Team> allTeams = teamController.getAllTeams();
        Color teamColor = new java.awt.Color(158, 158, 158);
        for (Team t : allTeams) {
            if (t.getName().equalsIgnoreCase(event.getTeam())) {
                teamColor = t.getColor();
                break;
            }
        }
        label.setBackground(teamColor);
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            private boolean dragging = false;

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                dragging = false;

                if (e.isPopupTrigger()) {
                    showEventContextMenu(e, event);
                    return;
                }

                if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                    javax.swing.TransferHandler handler = label.getTransferHandler();
                    handler.exportAsDrag(label, e, javax.swing.TransferHandler.MOVE);
                    dragging = true;
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showEventContextMenu(e, event);
                    return;
                }
                dragging = false;
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (!dragging && e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                    e.consume();
                    showEventDetails(event);
                }
            }
        });

        return label;
    }

    // Add this method to filter events based on user role
private List<Event> filterEventsByUserRole(List<Event> events) {
    // Owner sees all events
    if (currentUser != null && currentUser.getRole() == Role.OWRNER) {
        return events;
    }
    
    // Admin sees only their team's events
    if (currentUser == null || currentUser.getTeam() == null) {
        return new java.util.ArrayList<>();
    }
    
    List<Event> filteredEvents = new java.util.ArrayList<>();
    String userTeamName = currentUser.getTeam().getName();
    
    for (Event event : events) {
        if (event.getTeam() != null && event.getTeam().equalsIgnoreCase(userTeamName)) {
            filteredEvents.add(event);
        }
    }
    
    return filteredEvents;
}

// Update the createDayCell method - replace the event loading section (around line 260)
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

                model.Event draggedEvent = eventController.getEventById(eventId);
                if (draggedEvent != null) {
                    eventController.updateEvent(
                            draggedEvent.getId(),
                            draggedEvent.getTitle(),
                            draggedEvent.getDesc(),
                            draggedEvent.getTeam(),
                            date, draggedEvent.getColor(),
                            draggedEvent.getStartTime(),
                            draggedEvent.getEndTime()
                    );
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

    List<model.Event> allEvents = eventController.getEventsByDate(date);
    List<model.Event> events = filterEventsByUserRole(allEvents);

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
            cell.setBackground(new java.awt.Color(240, 240, 240));
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
    List<Event> events = filterEventsByUserRole(allEvents);

    if (events.isEmpty()) {
        String message = (currentUser != null && currentUser.getRole() == Role.OWRNER) 
            ? "No events on " + date + "\nCreate new event?"
            : "No events on " + date + " for your team\nCreate new event?";
            
        int choice = JOptionPane.showConfirmDialog(this,
                message,
                "Day Events",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            openCreateEventDialog(date);
        }
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

    String selected = (String) JOptionPane.showInputDialog(
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

    private void showEventDetails(Event event) {
        ShowEventDetailsDialog dialog = new ShowEventDetailsDialog(parent, event);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        loadCalendar();
    }

    private void showEventDetails(LocalDate date) {
        showDayEvents(date);
    }

    private void showEventContextMenu(java.awt.event.MouseEvent e, Event event) {
        JPopupMenu popup = new JPopupMenu();

        JMenuItem viewItem = new JMenuItem("View Details");
        viewItem.addActionListener(ev -> showEventDetails(event));
        popup.add(viewItem);

        if (currentUser != null
                && (Role.ADMIN.equals(currentUser.getRole()) || Role.OWRNER.equals(currentUser.getRole()))) {
            popup.addSeparator();
            JMenuItem editItem = new JMenuItem("Edit");
            editItem.addActionListener(ev -> editEvent(event));
            popup.add(editItem);
            JMenuItem deleteItem = new JMenuItem("Delete");
            deleteItem.addActionListener(ev -> deleteEvent(event));
            popup.add(deleteItem);
        }

        popup.show(e.getComponent(), e.getX(), e.getY());
    }

    private void editEvent(Event event) {
        view.dialogs.UpdateEventDialog dialog = new view.dialogs.UpdateEventDialog(
                parent,
                true,
                event.getId(),
                event.getTitle(),
                event.getDesc(),
                event.getDate(),
                event.getTeam(),
                event.getStartTime(),
                event.getEndTime(),
                currentUser
        );
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        loadCalendar();
    }

    private void deleteEvent(Event event) {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Delete event '" + event.getTitle() + "'?\nYou can restore it from Trash.",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            if (eventController.deleteEvent(event.getId(), this.currentUser)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Event moved to Trash",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                loadCalendar();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Failed to delete event",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void openCreateEventDialog(LocalDate preSelectedDate) {
        CreateEventDialog dialog = new CreateEventDialog(parent, true, preSelectedDate, currentUser);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        loadCalendar();
    }

    public void refreshEvents() {
        if (currentMode.equals("Monthly")) {
            loadCalendar();
        } else if (dailyPanel != null) {
            dailyPanel.refreshEvents();
        }
    }
}
