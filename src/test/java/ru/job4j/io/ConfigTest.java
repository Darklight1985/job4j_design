package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenAllNorm() {
        String path = "./data/config_norm.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("name"),  is(Matchers.nullValue()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenThrowIllegalArgumentException() {
        String path = "./data/pair_with_exception.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

}
