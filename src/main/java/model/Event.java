package model;

import java.awt.Color;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String desc;
    private String team;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Color color;
    private boolean isDeleted;

    public Event() {
    }

    public Event(int id, String title, String desc, String team, LocalDate date, Color color,
                 LocalTime startTime, LocalTime endTime ) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.team = team;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
        this.isDeleted = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTeam() {
        return team;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Color getColor() {
        return color;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getTimeRange() {
        if (startTime == null) {
            return "All day";
        }
        if (endTime == null) {
            return startTime.toString();
        }
        return startTime.toString() + " - " + endTime.toString();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}