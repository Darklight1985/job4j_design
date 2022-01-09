package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> list = store.findBy(filter);
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        SalaryRubToDollar changeSalary = new SalaryRubToDollar(75.6);
        for (Employee employee : list) {
            text
                    .append(System.lineSeparator())
                  .append(employee.getName()).append(";")
                    .append(changeSalary.changer(employee.getSalary())).append(";");
        }
        return HTMLCreater.stringToHTMLString(text.toString());
    }

}
