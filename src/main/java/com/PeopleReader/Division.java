package com.PeopleReader;

/**
 * Represents a division within the system.
 * Contains information about the division's ID and name.
 */
public class Division {
    private static int nextId = 0;
    private final int id;
    private final String name;

    /**
     * Creates a new Division instance with the specified name.
     * The division ID is auto-generated.
     *
     * @param name the name of the division
     */
    public Division(String name) {
        id = nextId;
        ++nextId;
        this.name = name;
    }

    /**
     * Returns the unique identifier of the division.
     *
     * @return the division ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the division.
     *
     * @return the division name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the Division object.
     * Format: Division{id=[id], name='[name]'}
     *
     * @return string representation of the division
     */
    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\''+
                '}';
    }
}
