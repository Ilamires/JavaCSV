package com.PeopleReader;

import java.time.LocalDate;

public class Person {
    private static int nextId = 0;
    private final int id;
    private final String name;
    private final String gender;
    private final Division division;
    private final double salary;
    private final LocalDate birthdate;

    public Person(String name, String gender, String divisionName, double salary, LocalDate birthdate) {
        id = nextId;
        ++nextId;
        this.name = name;
        this.gender = gender;
        this.division = new Division(divisionName);
        this.salary = salary;
        this.birthdate = LocalDate.from(birthdate);
    }


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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Division getDivision() {
        return division;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

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
