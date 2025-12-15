package controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import model.Notification;
import model.Team;
import model.NotificationTypes;
import model.Role;
import model.User;
import util.DataStorage;

public class NotificationController {

    private DataStorage storage = DataStorage.getInstance();
    private TeamController teamController;

    private static NotificationController instance;

    private NotificationController() {
        this.teamController = new TeamController();
    }

    public static NotificationController getInstance() {
        if (instance == null) {
            instance = new NotificationController();
        }
        return instance;
    }

    public void notifyOwrner(String message, NotificationTypes type) {
        int owrnerId = 1;
        for (User user : storage.users) {
            if (user.getRole() == Role.OWRNER) {
                owrnerId = user.getId();
                break;
            }
        }
        createNotification(message, owrnerId, type);
    }

    public synchronized void createNotification(String message, int recipientUserId, NotificationTypes type) {
        Notification notif = new Notification(message, recipientUserId, LocalDateTime.now(), type);
        storage.notifications.add(notif);
        storage.saveToFile();
    }

    public List<Notification> getNotificationsForUser(int userId) {
        return storage.notifications.stream()
                .filter(n -> n.getRecipientUserId() == userId)
                .collect(Collectors.toList());
    }

    public void notifyTeamMembers(String message, String teamName, NotificationTypes type) {
        Team team = teamController.getTeamByName(teamName);
        if (team != null) {
            for (User dev : team.getDevs()) {
                createNotification(message, dev.getId(), type);
            }
        }
    }

    public void notifyOwnerAndTeam(String message, String teamName, NotificationTypes type) {
        // Notify owner
        notifyOwrner(message, type);
        // Notify team members
        notifyTeamMembers(message, teamName, type);
    }
}