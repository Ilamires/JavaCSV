package com.PeopleReaderTest;
import com.PeopleReader.Person;
import org.junit.Test;
import org.junit.Assert;
import com.PeopleReader.Division;

import java.time.LocalDate;
import java.time.Month;

public class PersonTest {
    @Test
    public void PersonCreationTest() {
        boolean result;

        Person person = new Person("Kirill", "Male", "I",
                100000, LocalDate.of(2001, Month.JANUARY, 13));
        result = person.getId() == 0 && person.getName().equals("Kirill") &&
                person.getGender().equals("Male") && person.getSalary() == 100000 &&
                person.getBirthdate().equals(LocalDate.of(2001, Month.JANUARY, 13)) &&
                person.getDivision().getId() == 0 && person.getDivision().getName().equals("I");

        person = new Person(1000, "Ekaterina", "Female", "K",
                100000, LocalDate.of(1999, Month.FEBRUARY, 23));

        result = result && person.toString().equals("Person{" +
                "id=1000, name='Ekaterina', gender='Female', division=Division{id=1, name='K'}," +
                " salary=" + 100000d + ", birthDate=" +
                LocalDate.of(1999, Month.FEBRUARY, 23).toString() + '}');

        Assert.assertTrue(result);
    }
}
