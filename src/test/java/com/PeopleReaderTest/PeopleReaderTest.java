package com.PeopleReaderTest;
import org.junit.Test;
import org.junit.Assert;
import com.CSVRead.PeopleReader;

public class PeopleReaderTest {

    @Test
    public void PeopleReaderReadFileTest() {
        boolean result;
        //Correct expressions
        PeopleReader peopleReader = new PeopleReader("foreign_names.csv");
        result = peopleReader.getIsFileRead();

        //Incorrect expressions
        result =  result && !(peopleReader.ReadFile("foreign_names.txt"));

        Assert.assertTrue(result);
    }
}
