package com.PeopleReader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PeopleReader peopleReader = new PeopleReader("foreign_names.csv");
        ArrayList<Person> people = peopleReader.getPeople();
        if (people != null)
            for (Person person : people) {
                System.out.println(person.toString());
            }
    }
}