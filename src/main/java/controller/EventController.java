package controller;

import java.awt.Color;
import model.Team;
import model.Event;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.NotificationTypes;
import util.DataStorage;

public class EventController {

    private DataStorage storage = DataStorage.getInstance();
    private static int eventIdCounter = 1;
    private NotificationController notifController = NotificationController.getInstance();

    public boolean createEvent(String title, String desc, String team, LocalDate date, Color color, LocalTime startTime, LocalTime endTime, model.User loggedUser) {
        try {
            Event event = new model.Event(eventIdCounter++, title, desc, team, date, color, startTime, endTime);
            storage.events.add(event);
            storage.saveToFile();

            String message = "New event created: " + title + " For " + team + " on " + date + " By " + loggedUser.getName();
            notifController.notifyOwnerAndTeam(message, team, NotificationTypes.EVENT_CREATED);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateEvent(int id, String title, String desc, String team, LocalDate date, Color color, LocalTime startTime, LocalTime endTime) {
        try {
            for (Event e : storage.events) {
                if (e.getId() == id) {
                    e.setTitle(title);
                    e.setDesc(desc);
                    e.setTeam(team);
                    e.setDate(date);
                    e.setStartTime(startTime);
                    e.setEndTime(endTime);

                    if (color != null) {
                        e.setColor(color);
                    } else if (e.getColor() == null) {
                        controller.TeamController teamController = new controller.TeamController();
                        for (Team t : teamController.getAllTeams()) {
                            if (t.getName().equalsIgnoreCase(team)) {
                                e.setColor(t.getColor());
                                break;
                            }
                        }
                    }
                    
                    String message = "Event updated: " + title + " For " + team + " on " + date;
                    notifController.notifyOwnerAndTeam(message, team, NotificationTypes.EVENT_UPDATED);
                    return true;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    public List<Event> getAllEvents() {
        return new java.util.ArrayList<>(storage.events);
    }

    public List<Event> getAllDeletedEvents() {
        return new java.util.ArrayList<>(storage.deletedEvents);
    }

    public List<Event> getEventsByDate(LocalDate date) {
        List<Event> result = new ArrayList<>();
        for (Event event : storage.events) {
            if (event.getDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    public boolean deleteEvent(int eventId, model.User loggedUser) {
        for (int i = 0; i < storage.events.size(); i++) {
            if (storage.events.get(i).getId() == eventId) {
                Event deletedEvent = storage.events.remove(i);
                storage.deletedEvents.add(deletedEvent);
                storage.saveToFile();
                
                String message = "event deleted: " + deletedEvent.getTitle() + " For " + deletedEvent.getTeam() + " By " + loggedUser.getName();
                notifController.notifyOwrner(message, NotificationTypes.EVENT_DELETED);
                return true;
            }
        }
        return false;
    }

    public boolean restoreEvent(int eventId, model.User loggedUser) {
        for (int i = 0; i < storage.deletedEvents.size(); i++) {
            if (storage.deletedEvents.get(i).getId() == eventId) {
                Event restoredEvent = storage.deletedEvents.remove(i);
                storage.events.add(restoredEvent);
                storage.saveToFile();
                
                String message = "event restored: " + restoredEvent.getTitle() + " By " + loggedUser.getName();
                notifController.notifyOwrner(message, NotificationTypes.EVENT_RESTORED);
                
                return true;
            }
        }
        return false;
    }

    public boolean permanentlyDeleteEvent(int eventId) {
        for (int i = 0; i < storage.deletedEvents.size(); i++) {
            if (storage.deletedEvents.get(i).getId() == eventId) {
                storage.deletedEvents.remove(i);
                storage.saveToFile();
                return true;
            }
        }
        return false;
    }

    public Event getEventById(int eventId) {
        for (Event event : storage.events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getEventsByDateAndTeam(LocalDate date, String teamName) {
        List<Event> result = new ArrayList<>();
        for (Event event : storage.events) {
            if (event.getDate().equals(date) && event.getTeam().equalsIgnoreCase(teamName)) {
                result.add(event);
            }
        }
        return result;
    }
}
