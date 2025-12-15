package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import model.NotificationTypes;
import model.Team;
import model.User;
import util.DataStorage;

public class TeamController {

    private DataStorage storage = DataStorage.getInstance();
    private static int teamIdCounter = 1;

    public boolean createTeam(String name, List<User> devs, Color selectedColor, User loggedUser) {
        try {
            Team team = new Team(teamIdCounter++, name, devs, selectedColor);
            storage.teams.add(team);
            for (User user : devs) {
                user.setTeam(team);
            }
            storage.saveToFile();
            NotificationController notifController = NotificationController.getInstance();
            String message = "New team created: " + name + " By " + loggedUser.getName();
            notifController.notifyOwrner(message, NotificationTypes.TEAM_CREATED);
            notifController.notifyTeamMembers(message, team.getName(), NotificationTypes.TEAM_CREATED);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateTeam(int id, String name, List<User> devs, Color color, User loggedUser) {
        try {
            for (Team team : storage.teams) {
                if (team.getId() == id) {
                    team.setName(name);
                    team.setDevs(devs);
                    team.setColor(color);

                    for (User user : devs) {
                        user.setTeam(team);
                    }
                    break;
                }
            }
            storage.saveToFile();
            NotificationController notifController = NotificationController.getInstance();
            String message = "team Updated: " + name + " By " + loggedUser.getName();
            notifController.notifyOwrner(message, NotificationTypes.TEAM_UPDTAED);
            notifController.notifyTeamMembers(message, name, NotificationTypes.TEAM_UPDTAED);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteTeam(int teamId) {
        for (int i = 0; i < storage.teams.size(); i++) {
            if (storage.teams.get(i).getId() == teamId) {
                storage.teams.remove(i);
                storage.saveToFile();
                return true;
            }
        }
        return false;
    }

    public List<Team> getAllTeams() {
        return new ArrayList<>(storage.teams);
    }

    public model.Team getTeamById(int teamId) {
        for (model.Team team : storage.teams) {
            if (team.getId() == teamId) {
                return team;
            }
        }
        return null;
    }

    public model.Team getTeamByName(String teamName) {
        for (model.Team team : storage.teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }
}