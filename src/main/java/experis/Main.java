package experis;

import model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Person> personList = new Import().importFromFile();
        new Export().exportToFile(personList);
    }
}

//To format the XML in the 'result.xml-file' press CTRL + ALT + L
