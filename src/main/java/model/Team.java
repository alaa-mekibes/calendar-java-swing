package model;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private List<User> devs;
    private Color selectedColor;

    public Team(int id, String name, List<User> devs, Color selectedColor) {
        this.id = id;
        this.name = name;
        this.devs = devs;
        this.selectedColor = selectedColor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getDevs() {
        return devs;
    }

    public Color getColor() {
        return selectedColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevs(List<User> devs) {
        this.devs = devs;
    }

    public void setColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

}
