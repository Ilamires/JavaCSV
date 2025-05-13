package com.PeopleReaderTest;
import org.junit.Test;
import org.junit.Assert;
import com.PeopleReader.PeopleReader;

public class PeopleReaderTest {

    @Test
    public void PeopleReaderReadFileTest() {
        boolean result;

        PeopleReader peopleReader = new PeopleReader("foreign_names.csv");
        result = peopleReader.getIsFileRead() && peopleReader.getPeople() != null;

        result = result && !(peopleReader.ReadFile("foreign_names.txt")) &&
                peopleReader.getPeople() != null;

        Assert.assertTrue(result);
    }
}