package com.PeopleReader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PeopleReader {
    private boolean isFileRead;
    private ArrayList people;

    public boolean getIsFileRead() {
        return isFileRead;
    }

    public PeopleReader() {
        isFileRead = false;
    }
    public PeopleReader(String fileName) {
        people = new ArrayList(10000);
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
            int i = 0;
            for (String[] row : rows) {

            }
        } catch (Exception _) {
            return false;
        }
        isFileRead = true;
        return true;
    }
}
