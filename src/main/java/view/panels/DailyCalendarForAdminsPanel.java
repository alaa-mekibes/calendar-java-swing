package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import controller.EventController;
import controller.TeamController;
import model.User;
import model.Event;
import model.Role;
import model.Team;
import view.dialogs.ShowEventDetailsDialog;

public class DailyCalendarForAdminsPanel extends JPanel {
    private java.awt.Frame parent;
    private EventController eventController;
    private TeamController teamController;
    private LocalDate currentDate;
    private JLabel dateLabel;
    private JPanel timeSlotPanel;
    private User currentUser;

    public DailyCalendarForAdminsPanel(java.awt.Frame parent, User user) {
        this.parent = parent;
        this.currentUser = user;
        this.eventController = new EventController();
        this.teamController = new TeamController();
        this.currentDate = LocalDate.now();

        initComponents();
        setupCalendar();
        loadCalendar();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
    }

    private void setupCalendar() {
        add(createNavigationPanel(), BorderLayout.NORTH);
        add(createTimeSlotScrollPanel(), BorderLayout.CENTER);
    }

    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        navPanel.setBackground(Color.WHITE);

        JButton prevBtn = createStyledButton("Previous Day", new Color(74, 144, 226));
        prevBtn.addActionListener(e -> changeDay(-1));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        updateDateLabel();

        JButton nextBtn = createStyledButton("Next Day", new Color(74, 144, 226));
        nextBtn.addActionListener(e -> changeDay(1));

        JButton todayBtn = createStyledButton("Today", new Color(52, 168, 83));
        todayBtn.addActionListener(e -> goToToday());

        navPanel.add(prevBtn);
        navPanel.add(dateLabel);
        navPanel.add(nextBtn);
        navPanel.add(todayBtn);

        return navPanel;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private JScrollPane createTimeSlotScrollPanel() {
        timeSlotPanel = new JPanel();
        timeSlotPanel.setLayout(new BoxLayout(timeSlotPanel, BoxLayout.Y_AXIS));
        timeSlotPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(timeSlotPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        return scrollPane;
    }

    private void updateDateLabel() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        dateLabel.setText(currentDate.format(formatter));
    }

    private void changeDay(int offset) {
        currentDate = currentDate.plusDays(offset);
        updateDateLabel();
        loadCalendar();
    }

    private void goToToday() {
        currentDate = LocalDate.now();
        updateDateLabel();
        loadCalendar();
    }

    private List<Event> filterEventsByUserRole(List<Event> events) {
    if (currentUser != null && currentUser.getRole() == Role.OWRNER) {
        return events;
    }
    
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
private void loadCalendar() {
    timeSlotPanel.removeAll();
    List<Event> allEvents = eventController.getEventsByDate(currentDate);
    List<Event> events = filterEventsByUserRole(allEvents);

    for (int hour = 0; hour < 24; hour++) {
        JPanel hourPanel = createHourPanel(hour, events);
        timeSlotPanel.add(hourPanel);
    }

    timeSlotPanel.revalidate();
    timeSlotPanel.repaint();
}
    private JPanel createHourPanel(int hour, List<Event> allEvents) {
        JPanel hourPanel = new JPanel(new BorderLayout());
        hourPanel.setBackground(Color.WHITE);
        hourPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        hourPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        hourPanel.add(createTimeLabel(hour), BorderLayout.WEST);
        
        JPanel eventsPanel = createEventsPanelForHour(hour, allEvents);
        hourPanel.add(eventsPanel, BorderLayout.CENTER);
        
        addHourPanelHoverEffect(hourPanel);
        setupDropTarget(eventsPanel, hour);

        return hourPanel;
    }

    private JLabel createTimeLabel(int hour) {
        JLabel timeLabel = new JLabel(String.format("%02d:00", hour));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        timeLabel.setForeground(Color.GRAY);
        timeLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        timeLabel.setPreferredSize(new Dimension(80, 60));
        return timeLabel;
    }

    private JPanel createEventsPanelForHour(int hour, List<Event> allEvents) {
        JPanel eventsPanel = new JPanel();
        eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
        eventsPanel.setBackground(Color.WHITE);
        eventsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (Event event : allEvents) {
            if (event.getStartTime() != null && event.getStartTime().getHour() == hour) {
                JPanel eventPanel = createEventPanel(event);
                eventsPanel.add(eventPanel);
                eventsPanel.add(Box.createRigidArea(new Dimension(0, 3)));
            }
        }

        return eventsPanel;
    }

    // hover
    private void addHourPanelHoverEffect(JPanel hourPanel) {
        hourPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hourPanel.setBackground(new Color(245, 245, 245));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hourPanel.setBackground(Color.WHITE);
            }
        });
    }

    private JPanel createEventPanel(Event event) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(true);
        
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        Color teamColor = getTeamColor(event.getTeam());
        panel.setBackground(teamColor);

        panel.add(createEventInfoPanel(event), BorderLayout.CENTER);
        makeEventPanelInteractive(panel, event, teamColor);
        setupDragSource(panel, event);

        return panel;
    }

    private Color getTeamColor(String teamName) {
        List<Team> allTeams = teamController.getAllTeams();
        
        for (Team team : allTeams) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team.getColor();
            }
        }
        
        return new Color(158, 158, 158);
    }

    private JPanel createEventInfoPanel(Event event) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel titleLabel = new JLabel(event.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 12));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setName("titleLabel");
        addDoubleClickEdit(titleLabel, event);

        String timeInfo = formatEventTime(event) + " • " + event.getTeam();
        JLabel detailsLabel = new JLabel(timeInfo);
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        detailsLabel.setForeground(new Color(240, 240, 240));

        textPanel.add(titleLabel);
        textPanel.add(detailsLabel);

        return textPanel;
    }

    // double-click edit
    private void addDoubleClickEdit(JLabel label, Event event) {
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            private long lastClickTime = 0;
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                long currentTime = System.currentTimeMillis();
                
                if (evt.getClickCount() == 2 || (currentTime - lastClickTime < 300)) {
                    showEditDialog(event);
                    lastClickTime = 0;
                } else {
                    lastClickTime = currentTime;
                }
            }
        });
    }

    private void showEditDialog(Event event) {
        String newTitle = JOptionPane.showInputDialog(
            this,
            "Edit event title:",
            event.getTitle()
        );
        
        if (newTitle != null && !newTitle.trim().isEmpty()) {
            eventController.updateEvent(
                event.getId(),
                newTitle.trim(),
                event.getDesc(),
                event.getTeam(),
                event.getDate(),
                event.getColor(),
                event.getStartTime(),
                event.getEndTime()
            );
            loadCalendar();
        }
    }

    private String formatEventTime(Event event) {
        if (event.getStartTime() != null && event.getEndTime() != null) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            return event.getStartTime().format(timeFormatter) + " - " + 
                   event.getEndTime().format(timeFormatter);
        }
        return "";
    }

    // click & hover
    private void makeEventPanelInteractive(JPanel panel, Event event, Color baseColor) {
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Component comp = evt.getComponent().getComponentAt(evt.getPoint());
                if (comp instanceof JLabel && "titleLabel".equals(comp.getName())) {
                    return;
                }
                showEventDetails(event);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(baseColor.darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(baseColor);
            }
        });
    }

    // drag
    private void setupDragSource(JPanel panel, Event event) {
        DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(panel, DnDConstants.ACTION_MOVE, 
            new DragGestureListener() {
                @Override
                public void dragGestureRecognized(DragGestureEvent dge) {
                    try {
                        Transferable transferable = new StringSelection(String.valueOf(event.getId()));
                        dge.startDrag(DragSource.DefaultMoveDrop, transferable);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
    }

    // drop
    private void setupDropTarget(JPanel panel, int targetHour) {
        new DropTarget(panel, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    dtde.acceptDrop(DnDConstants.ACTION_MOVE);
                    Transferable transferable = dtde.getTransferable();
                    String eventIdStr = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                    int eventId = Integer.parseInt(eventIdStr);
                    
                    Event event = findEventById(eventId);
                    if (event != null) {
                        LocalTime newStartTime = LocalTime.of(targetHour, 0);
                        int duration = event.getEndTime().getHour() - event.getStartTime().getHour();
                        LocalTime newEndTime = newStartTime.plusHours(duration);
                        
                        eventController.updateEvent(
                            event.getId(),
                            event.getTitle(),
                            event.getDesc(),
                            event.getTeam(),
                            event.getDate(),
                            event.getColor(),
                            newStartTime,
                            newEndTime
                        );
                        loadCalendar();
                    }
                    dtde.dropComplete(true);
                } catch (Exception ex) {
                    dtde.dropComplete(false);
                    ex.printStackTrace();
                }
            }

            @Override
            public void dragOver(DropTargetDragEvent dtde) {
                panel.setBackground(new Color(230, 240, 255));
            }

            @Override
            public void dragExit(DropTargetEvent dte) {
                panel.setBackground(Color.WHITE);
            }
        });
    }

    private Event findEventById(int id) {
        List<Event> events = eventController.getEventsByDate(currentDate);
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    private void showEventDetails(Event event) {
        ShowEventDetailsDialog dialog = new ShowEventDetailsDialog(parent, event);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        loadCalendar();
    }

    public void refreshEvents() {
        loadCalendar();
    }
}