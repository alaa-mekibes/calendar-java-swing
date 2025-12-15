package controller;

import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.Team;
import model.User;
import util.DataStorage;

public class UserController {

    private DataStorage storage = DataStorage.getInstance();

    public List<User> getAllUsers() {
        return new ArrayList<>(storage.users);
    }

    public boolean updateUserByAdmin(int id, Role role, Team team) {
        User user = getUserById(id);
        if (user != null) {
            user.setRole(role);
            user.setTeam(team);
            storage.saveToFile();
            return true;
        } else {
            return false;
        }

    }
    
    public boolean updateUserEmailUsername(int userId, String email, String username) {
        for (User user : storage.users) {
            if(user.getId() == userId) {
                user.setEmail(email);
                user.setName(username);
                storage.saveToFile();
                return true;
            }
        }
        return false;
    }
    
        public boolean updateUserPassword(int userId, String password) {
        for (User user : storage.users) {
            if(user.getId() == userId) {
                user.setPassword(password);
                storage.saveToFile();
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int userId) {
        for (int i = 0; i < storage.users.size(); i++) {
            if (storage.users.get(i).getId() == userId) {
                storage.users.remove(i);
                storage.saveToFile();
                return true;
            }
        }
        return false;
    }

    public User getUserById(int userId) {
        for (User user : storage.users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

}
