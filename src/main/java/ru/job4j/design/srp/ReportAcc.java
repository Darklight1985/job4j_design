package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportAcc implements Report {

    private Store store;

    public ReportAcc(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name");
        List<Employee> list = store.findBy(filter);
        SalaryRubToDollar changeSalary = new SalaryRubToDollar(75.6);
        for (Employee employee : list) {
            text
                    .append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(changeSalary.changer(employee.getSalary())).append(";");
        }
        return text.toString();
    }

}
