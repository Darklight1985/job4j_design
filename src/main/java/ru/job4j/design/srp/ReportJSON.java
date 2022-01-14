package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        final Gson gson = new GsonBuilder().create();
        StringBuilder text = new StringBuilder();
        List<Employee> list = store.findBy(filter);
            text.append(gson.toJson(list));
        return text.toString();
    }

}
