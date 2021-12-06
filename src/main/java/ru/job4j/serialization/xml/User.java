package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean drinks;
    private Car car;
    @XmlElementWrapper
    @XmlElement(name = "hobbyes")
    private String[] hobby;

    public User() { }

    public User(int age, String name, boolean drinks, Car car, String[] hobby) {
        this.age = age;
        this.name = name;
        this.drinks = drinks;
        this.car = car;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{"
                + "age=" + age
                + ", name='" + name + '\''
                + ", drinks=" + drinks
                + ", car=" + car
                + ", hobby=" + Arrays.toString(hobby)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final User user = new User(40, "Vasya", true, new Car("red", 300),
                new String[] {"dominoes", "women", "fighting"});

        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(user, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
                e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            User result = (User) unmarshaller.unmarshal(reader);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
