import experis.Import;
import model.Person;
import model.Phone;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ImportTest {

    @Test
    public void testIfParserGivesExpectedValues(){
        /*
            P|Tyrion|Lannister
            T|0723-456789|021-454545
            A|King's Landing|Westeros|12345
         */
        final Phone phone1 = new Phone();
        phone1.setMobilePhone("0712-345345");
        phone1.setPhone("031-343434");

        final Person person1 = new Person();
        person1.setFirstName("Jaime");
        person1.setLastName("Lannister");
        person1.setPhone(phone1);
        person1.setStreet("King's Landing");
        person1.setCity("Westeros");
        person1.setPostalCode("12345");
        person1.setYearOfBirth("1970");
        person1.setFirstName2("Jaime");

        final Phone phone2 = new Phone();
        phone2.setMobilePhone("0723-456789");
        phone2.setPhone("021-454545");

        final Person person2 = new Person();
        person2.setFirstName("Tyrion");
        person2.setLastName("Lannister");
        person2.setPhone(phone2);
        person2.setStreet("King's Landing");
        person2.setCity("Westeros");
        person2.setPostalCode("12345");

        final Person person3 = new Person();
        person3.setFirstName("Sansa");
        person3.setLastName("Stark");
        person3.setStreet("Winterfell");
        person3.setCity("The North");
        person3.setPostalCode("23456");
        person3.setFirstName2("Sansa");
        person3.setYearOfBirth("1996");

        Import importer = new Import();
        List<Person> personList = importer.importFromFile();

        Assert.assertEquals(personList.get(0).getFirstName(), person1.getFirstName());
        Assert.assertEquals(personList.get(0).getLastName(), person1.getLastName());
        Assert.assertEquals(personList.get(0).getCity(), person1.getCity());
        Assert.assertEquals(personList.get(0).getFirstName2(), person1.getFirstName2());
        Assert.assertEquals(personList.get(0).getPhone().getPhone(), person1.getPhone().getPhone());
        Assert.assertEquals(personList.get(0).getPhone().getMobilePhone(), person1.getPhone().getMobilePhone());
        Assert.assertEquals(personList.get(0).getYearOfBirth(), person1.getYearOfBirth());
        Assert.assertEquals(personList.get(0).getStreet(), person1.getStreet());
        Assert.assertEquals(personList.get(0).getPostalCode(), person1.getPostalCode());

        Assert.assertEquals(personList.get(1).getFirstName(), person2.getFirstName());
        Assert.assertEquals(personList.get(1).getLastName(), person2.getLastName());
        Assert.assertEquals(personList.get(1).getCity(), person2.getCity());
        Assert.assertEquals(personList.get(1).getPhone().getPhone(), person2.getPhone().getPhone());
        Assert.assertEquals(personList.get(1).getPhone().getMobilePhone(), person2.getPhone().getMobilePhone());
        Assert.assertEquals(personList.get(1).getStreet(), person2.getStreet());
        Assert.assertEquals(personList.get(1).getPostalCode(), person2.getPostalCode());

        Assert.assertEquals(personList.get(2).getFirstName(), person3.getFirstName());
        Assert.assertEquals(personList.get(2).getLastName(), person3.getLastName());
        Assert.assertEquals(personList.get(2).getCity(), person3.getCity());
        Assert.assertEquals(personList.get(2).getStreet(), person3.getStreet());
        Assert.assertEquals(personList.get(2).getPostalCode(), person3.getPostalCode());
        Assert.assertEquals(personList.get(2).getFirstName2(), person3.getFirstName2());
        Assert.assertEquals(personList.get(2).getYearOfBirth(), person3.getYearOfBirth());



    }
}
