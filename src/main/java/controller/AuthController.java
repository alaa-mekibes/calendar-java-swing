package controller;

import model.Role;
import model.User;
import util.DataStorage;

public class AuthController {

    private DataStorage storage = DataStorage.getInstance();
    private static int userIdCounter = 1;

public AuthController() {
    storage = DataStorage.getInstance();
    if (!storage.users.isEmpty()) {
        userIdCounter = storage.users.stream()
                            .mapToInt(User::getId)
                            .max()
                            .getAsInt() + 1;
    } else {
        userIdCounter = 1;
    }
}
    
    public User register(String name, String email, String password, Role role) {
        if (emailExists(email)) {
            return null;
        }

        User newUser = new User(userIdCounter++, name, email, role, null);
        newUser.setPassword(password);
        storage.users.add(newUser);
        storage.saveToFile();

        return newUser;
    }

    public User login(String email, String password) {
        for (User user : storage.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean emailExists(String email) {
        for (User user : storage.users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}
