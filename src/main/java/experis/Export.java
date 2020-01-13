package experis;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import model.Person;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Export {

    public void exportToFile(final List<Person> personList) {

        try {
            //XStream lib (see gradle!)
            XStream xstream = new XStream(new StaxDriver());
            xstream.processAnnotations(Person.class); //Set name on xml element.
            xstream.alias("person", Person.class); //Set name on xml element.
            String dataXml = xstream.toXML(personList);
            Files.write(Paths.get("./result.xml"), dataXml.getBytes());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
