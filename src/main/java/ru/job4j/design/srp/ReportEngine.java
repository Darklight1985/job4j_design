package ru.job4j.design.srp;

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
        text.append("<!doctype html>\n");
        text.append("<html lang='en'>\n");

        text.append("<head>\n");
        text.append("<meta charset='utf-8'>\n");
        text.append("<title>Report of Reports</title>\n");
        text.append("</head>\n\n");

        text.append("<body>\n");
        text.append("<h1>List of Reports</h1>\n");

        text.append("<ul>\n");
        text.append("<li>Name; Hired; Fired; Salary</li>\n");
        List<Employee> list = store.findBy(filter);
        for (Employee employee : list) {
            text
                    .append("<li>")
                  .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
            .append("</li>\n");
        }
        text.append("</ul>\n");
        text.append("</body>\n\n");
        text.append("</html>");
        return text.toString();
    }

}
