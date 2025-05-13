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

/**
 * A class for reading and parsing person data from CSV files.
 * The expected CSV format should use semicolon (;) as delimiter and contain the following columns:
 * 0: ID, 1: Name, 2: Gender, 3: Birthdate (dd.MM.yyyy), 4: Division, 5: Salary
 */
public class PeopleReader {
    private boolean isFileRead;
    private ArrayList<Person> people;

    /**
     * Returns whether the file has been successfully read.
     * @return true if file was read successfully, false otherwise
     */
    public boolean getIsFileRead() {
        return isFileRead;
    }

    /**
     * Constructs a new PeopleReader with no initial file loaded.
     */
    public PeopleReader() {
        isFileRead = false;
    }

    /**
     * Constructs a new PeopleReader and immediately attempts to read the specified file.
     * @param fileName the path to the CSV file in resources folder
     */
    public PeopleReader(String fileName) {
        ReadFile(fileName);
    }

    /**
     * Reads and parses person data from a CSV file in the resources folder.
     * The CSV must use semicolon (;) delimiter and have columns in this order:
     * ID, Name, Gender, Birthdate (dd.MM.yyyy), Division, Salary
     *
     * @param fileName the path to the CSV file in resources folder
     * @return true if file was read and parsed successfully, false otherwise
     */
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

    /**
     * Returns the list of parsed Person objects.
     * @return ArrayList of Person objects if file was read successfully, null otherwise
     */
    public ArrayList<Person> getPeople() {
        if (isFileRead)
            return people;
        else
            return null;
    }
}
