package experis;

import model.Address;
import model.Person;
import model.Phone;
import model.Name;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Import {

    private final List<Person> personList =
            new ArrayList<>();

    //Algoritmh goes as follows:

    //The characters P,T,A,F is just bogus. Probably there to make you confused.
    // The only thing that you want to keep track on is:

    // --> IF this "iteration" has already been read (P,T,A or F) GOTO next iteration, since duplication of tag is not
    //allowed.
    // Characters has not representation in xml, which therefore makes the characters "useless".

    public List<Person> importFromFile() {
        URI url = null;
        final String fileName = "persondata.txt";
        try {
            //Get location for persondata.txt file on filesystem.
            url = Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(fileName)
                    .toURI();

        } catch (Exception e) {
            //print errors if thrown.
            System.out.println(e.getMessage());
        }

        //Open file content.
        try (Stream<String> stream = Files.lines(Paths.get(url))) {

            //Collecting List<String> from stream.
            final List<String> stringList = stream
                    .collect(Collectors.toList());

            Person person = new Person();
            for (String segment : stringList) {
                if (!segment.isEmpty()) {
                    //Gets the first two character on each file row.
                    final String charAtZero = String
                            .valueOf(segment.charAt(0));
                    final String charAtOne = String
                            .valueOf(segment.charAt(1));

                    if (charAtZero.equals("P") &&
                            charAtOne.equals("|")) {
                        final String[] seg = segment.split("\\|");
                        if (person.getFirstName() != null) {
                            this.personList.add(person);
                            person = new Person();
                        }
                        person.setFirstName(seg[1]);
                        person.setLastName(seg[2]);

                    } else if (charAtZero.equals("T") &&
                            charAtOne.equals("|")) {
                        final String[] seg = segment.split("\\|");
                        if (person.getPhone() != null) {
                            this.personList.add(person);
                            person = new Person();
                        }
                        Phone phone = new Phone();
                        phone.setMobilePhone(seg[1]);
                        phone.setPhone(seg[2]);
                        person.setPhone(phone);

                    } else if (charAtZero.equals("A") &&
                            charAtOne.equals("|")) {
                        final String[] seg = segment.split("\\|");
                        if (person.getAddress() != null) {
                            this.personList.add(person);
                            person = new Person();
                        }

                        Address address = new Address();
                        address.setStreet(seg[1]);
                        address.setCity(seg[2]);
                        address.setPostalCode(seg[3]);
                        person.setAddress(address);

                    } else if (charAtZero.equals("F") &&
                            charAtOne.equals("|")) {
                        final String[] seg = segment.split("\\|");
                        if (person.getName() != null) {
                            this.personList.add(person);
                            person = new Person();
                        }
                        Name name = new Name();
                        name.setName(seg[1]);
                        name.setBorn(seg[2]);
                        person.setName(name);
                    } else {
                        throw new Exception("No operation specified!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        return personList;
    }
}