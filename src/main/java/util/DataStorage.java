package util;

import java.io.*;
import java.util.*;
import model.*;

public class DataStorage {
    private static final String FILE_PATH = "data.ser";
    private static DataStorage instance;
    
    public List<User> users = new ArrayList<>();
    public List<Team> teams = new ArrayList<>();
    public List<Event> events = new ArrayList<>();
    public List<Event> deletedEvents = new ArrayList<>();
    public List<Notification> notifications = new ArrayList<>();
    
    private DataStorage() {
        loadFromFile();
    }
    
    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }
    
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            users = (List<User>) ois.readObject();
            teams = (List<Team>) ois.readObject();
            events = (List<Event>) ois.readObject();
            deletedEvents = (List<Event>) ois.readObject();
            notifications = (List<Notification>) ois.readObject();
            System.out.println("Data loaded successfully");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found, starting fresh");
        } catch (Exception e) {
            System.out.println("Could not load some data, starting fresh " + e);
        }
    }
    
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
            oos.writeObject(teams);
            oos.writeObject(events);
            oos.writeObject(deletedEvents);
            oos.writeObject(notifications);
            System.out.println("Data saved successfully");
        } catch (IOException e) {
            System.out.println("Failed to save data " + e);
        }
    }
}