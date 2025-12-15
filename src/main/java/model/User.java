package model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private Team team;

    public User(int id, String username, String email, Role role, Team team) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public Team getTeam() {
        return team;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getTeamName() {
        return team != null ? team.getName() : "No Team";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " (" + role + ")";
    }

}
