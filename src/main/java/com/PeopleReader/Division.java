package com.PeopleReader;

public class Division {
    private static int nextId = 0;
    private final int id;
    private final String name;

    public Division(String name) {
        id = nextId;
        ++nextId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\''+
                '}';
    }
}
