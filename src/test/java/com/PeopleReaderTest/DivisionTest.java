package com.PeopleReaderTest;
import org.junit.Test;
import org.junit.Assert;
import com.PeopleReader.Division;

import java.util.Objects;

public class DivisionTest {
    @Test
    public void PeopleReaderReadFileTest() {
        boolean result;

        Division division = new Division("I");
        result = division.getId() == 0 && division.getName().equals("I");

        division = new Division("K");
        result = result && division.getId() == 1 && division.getName().equals("K");

        Assert.assertTrue(result);
    }
}
