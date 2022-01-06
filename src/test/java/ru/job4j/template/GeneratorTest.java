package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Ignore
    @Test
    public void produce() {
        Generator generator = new GeneratorStr();
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("name", "Vasya");
        mapStr.put("subject", "cat");
        String template = "I am a ${name}, Who are ${subject}?";
        assertThat(generator.produce(template, mapStr), is("I am a ${name}, Who are ${subject}? "));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNonCorrectTempl() {
        Generator generator = new GeneratorStr();
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("name", "Vasya");
        mapStr.put("job", "cat");
        String template = "I am ${name}, I am ${age} years old and I work as an ${job}";
        String rsl = generator.produce(template, mapStr);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNonCorrectArg() {
        Generator generator = new GeneratorStr();
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("name", "Vasya");
        mapStr.put("subject", "1");
        String template = "I am a ${name}, Who are ${subject}?";
        String rsl = generator.produce(template, mapStr);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenExtraArg() {
        Generator generator = new GeneratorStr();
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("name", "Vasya");
        mapStr.put("subject", "cat");
        mapStr.put("job", "engineer");
        String template = "I am a ${name}, Who are ${subject}?";
        String rsl = generator.produce(template, mapStr);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNullArg() {
        Generator generator = new GeneratorStr();
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("name", "Vasya");
        mapStr.put("age", "null");
        mapStr.put("job", "engineer");
        String template = "I am ${name}, I am ${age} years old and I work as an ${job}";
        String rsl = generator.produce(template, mapStr);
    }
}