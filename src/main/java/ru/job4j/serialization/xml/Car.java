package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class Car {
    @XmlAttribute
    private String color;
    @XmlAttribute
    private int power;

    public Car() {
    }

    public Car(String color, int power) {
        this.color = color;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{"
                + "color='" + color + '\''
                + ", power=" + power
                + '}';
    }
}
