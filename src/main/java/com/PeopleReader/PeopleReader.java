package com.PeopleReader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public class PeopleReader {
    private boolean isFileRead;
    private ArrayList<Person> people;

    public boolean getIsFileRead() {
        return isFileRead;
    }

    public PeopleReader() {
        isFileRead = false;
    }

    public PeopleReader(String fileName) {
        ReadFile(fileName);
    }

    public boolean ReadFile(String fileName) {
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName))))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(';')
                        .build())
                .build()
        ) {
            List<String[]> rows = reader.readAll();
            people = new ArrayList<Person>(10000);
            rows.removeFirst();
            for (String[] row : rows) {
                people.add(new Person(Integer.parseInt(row[0]), row[1], row[2],
                        row[4], Double.parseDouble(row[5]),
                        LocalDate.parse(row[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
            }
        } catch (Exception _) {
            return false;
        }
        isFileRead = true;
        return true;
    }

    public ArrayList<Person> getPeople() {
        if (isFileRead)
            return people;
        else
            return null;
    }
}
