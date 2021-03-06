package com.IdczakI.contactbook.io;

import com.IdczakI.contactbook.model.Contact;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTool {

    private final static String FILE_NAME = "src/main/resources/csv/contact_book.csv";

    private final static File file = new File(FILE_NAME);

    private static List<Contact> contactList = new ArrayList<>();

    public static List<Contact> getContactList() {
        return contactList;
    }

    private static void createFile() throws IOException {
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
        }
    }

    public static void readFile() {
        try {
            createFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            contactList = reader.lines()
                    .map(CsvTool::readContact)
                    .collect(Collectors.toList());
            reader.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    static private Contact readContact(String s) {
        String[] c = s.split(",");
        return new Contact(c[0], c[1], c[2], c[3].trim());
    }

    public static void writeFile(ObservableList<Contact> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            createFile();
            for (Contact c : list) {
                writer.write(c.toCsv());
                writer.newLine();
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}

