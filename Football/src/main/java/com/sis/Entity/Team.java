package com.sis.Entity;

import java.util.Date;

public class Team {

    private String name;
    private String city;
    private String owner;
    private int capacity;
    private int players;
    private Date created;

    public Team() {

    }

    public Team(String name, String city, String owner, int capacity, int players, Date created) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.capacity = capacity;
        this.players = players;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
