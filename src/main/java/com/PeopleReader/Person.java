package com.PeopleReader;

import java.time.LocalDate;

/**
 * Represents a person with personal and employment information.
 * Includes id, name, gender, division, salary, and birthdate.
 * Auto-generates ids when not explicitly provided.
 */
public class Person {
    private static int nextId = 0;
    private final int id;
    private final String name;
    private final String gender;
    private final Division division;
    private final double salary;
    private final LocalDate birthdate;

    /**
     * Constructs a new Person with auto-generated id.
     *
     * @param name the name of the person
     * @param gender the gender of the person
     * @param divisionName the name of the division the person belongs to
     * @param salary the person's salary (must be positive)
     * @param birthdate the person's birthdate (cannot be null)
     */
    public Person(String name, String gender, String divisionName, double salary, LocalDate birthdate) {
        id = nextId;
        ++nextId;
        this.name = name;
        this.gender = gender;
        this.division = new Division(divisionName);
        this.salary = salary;
        this.birthdate = LocalDate.from(birthdate);
    }

    /**
     * Constructs a new Person with specified id.
     * Updates the id generator if provided id is higher than current sequence.
     *
     * @param id the unique identifier for the person (must be >= 0)
     * @param name the full name of the person
     * @param gender the gender of the person
     * @param divisionName the name of the division the person belongs to
     * @param salary the person's salary
     * @param birthdate the person's birthdate (cannot be null)
     * @throws IllegalArgumentException if id is negative
     */
    public Person(int id, String name, String gender, String divisionName, double salary, LocalDate birthdate) {
        if (id < 0)
            throw new IllegalArgumentException("id have to be more or equal to 0");
        this.id = id;
        nextId = Math.max(id + 1, nextId);
        this.name = name;
        this.gender = gender;
        this.division = new Division(divisionName);
        this.salary = salary;
        this.birthdate = LocalDate.from(birthdate);
    }

    /**
     * Returns the unique identifier of the person.
     * @return the person's id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the person.
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the gender of the person.
     * @return the person's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the division object the person belongs to.
     * @return the person's division
     */
    public Division getDivision() {
        return division;
    }

    /**
     * Returns the person's salary.
     * @return the salary amount
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns the person's birthdate.
     * @return the birthdate as LocalDate object
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Returns a string representation of the Person object.
     * Format: Person{id=[id], name='[name]', gender='[gender]',
     * division=[division], salary=[salary], birthDate=[birthdate]}
     *
     * @return string representation of the person
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", division=" + division.toString() +
                ", salary=" + salary +
                ", birthDate=" + birthdate.toString() +
                '}';
    }
}
