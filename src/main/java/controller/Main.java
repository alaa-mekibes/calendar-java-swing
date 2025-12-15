package controller;

import model.Role;
import util.DataStorage;
import view.auth.Login;
import javax.swing.UIManager;

public class Main {
    static AuthController auth = new AuthController();
    
    public static void main(String[] args) {
        // Set Nimbus Look and Feel FIRST
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        // Initialize DataStorage
        DataStorage storage = DataStorage.getInstance();
        
        // Create admin user if no users exist
        if (storage != null && storage.users != null && storage.users.isEmpty()) {
            model.User admin = auth.register("admin", "admin@gmail.com", "admin123", Role.OWRNER);
            if (admin != null) {
                System.out.println("Admin user created successfully");
                storage.saveToFile(); // Save immediately after creating admin
            } else {
                System.err.println("Failed to create admin user");
            }
        } else {
            System.out.println("Users already exist. Count: " + storage.users.size());
        }
        
        // Launch the Login window
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
        
        // Save data on shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Saving data before shutdown...");
            storage.saveToFile();
        }));
    }
}