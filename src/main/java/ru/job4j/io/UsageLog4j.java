package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        int age = 25;
        double weight = 99.9;
        byte three = 3;
        short chislo = 2000;
        float height = 178.2f;
        boolean pravda = true;
        long rasstoyanie = 2562L;
        char symbol = 'D';
        LOG.info("User {} , {} age old, with height = {}, weight = {},"
                + " have {} cars, and living {} km from Mexico,"
                + " its {}, this {}", symbol, age, height, weight,
                three, rasstoyanie, pravda, chislo);
    }
}
