package ru.job4j.design.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {

    @Test
    public void whenGeneratedIT() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        Employee workerTwo = new Employee("Vasya", now, now, 151.2);
        store.add(workerOne);
        store.add(workerTwo);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
        .append("<!doctype html>\n")
        .append("<html lang='en'>\n")
        .append("<head>\n")
        .append("<meta charset='utf-8'>\n")
        .append("<title>Report of Reports</title>\n")
        .append("</head>\n\n")
        .append("<body>\n")
        .append("<h1>List of Reports</h1>\n")
                .append("<ul>\n")
        .append("<li>Name; Hired; Fired; Salary</li>\n")
                .append("<li>" + workerOne.getName()
                        + ";" + workerOne.getHired()
                        + ";" + workerOne.getFired()
                        + ";" + workerOne.getSalary()
                        + ";</li>\n")
                .append("<li>" + workerTwo.getName()
                        + ";" + workerOne.getHired()
                        + ";" + workerOne.getFired()
                        + ";" + workerTwo.getSalary()
                        + ";</li>\n")
        .append("</ul>\n")
        .append("</body>\n\n")
                .append("</html>");
            assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedAcc() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        store.add(workerOne);
        Report engine = new ReportAcc(store);
        SalaryRubToDollar changeSalary = new SalaryRubToDollar(75.6);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(workerOne.getName()).append(";")
                .append(workerOne.getHired()).append(";")
                .append(workerOne.getFired()).append(";")
                .append(changeSalary.changer(workerOne.getSalary())).append(";");
            assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        store.add(workerOne);
        Report engine = new ReportJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"" + workerOne.getName()).append("\",")
                .append("\"hired\":{\"year\":"
                        + workerOne.getHired().get(Calendar.YEAR)).append(",")
                .append("\"month\":"
                        + workerOne.getHired().getTime().getMonth()).append(",")
                .append("\"dayOfMonth\":"
                        + workerOne.getHired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":"
                        + workerOne.getHired().getTime().getHours()).append(",")
                .append("\"minute\":"
                        + workerOne.getHired().getTime().getMinutes()).append(",")
                .append("\"second\":"
                        + workerOne.getHired().getTime().getSeconds()).append("},")
                .append("\"fired\":{\"year\":"
                        + workerOne.getFired().get(Calendar.YEAR)).append(",")
                .append("\"month\":"
                        + workerOne.getFired().getTime().getMonth()).append(",")
                .append("\"dayOfMonth\":"
                        + workerOne.getFired().get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":"
                        + workerOne.getFired().getTime().getHours()).append(",")
                .append("\"minute\":"
                        + workerOne.getFired().getTime().getMinutes()).append(",")
                .append("\"second\":"
                        + workerOne.getFired().getTime().getSeconds()).append("},")
                .append("\"salary\":"
                        + workerOne.getSalary()).append("}]");
            assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        store.add(workerOne);
        Report engine = new ReportXML(store);
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employes>\n")
                .append("    <employes>\n")
                .append("        <fired>" + formater.format(workerOne.getFired().getTime()) + "</fired>").append("\n")
                .append("        <hired>" + formater.format(workerOne.getHired().getTime()) + "</hired>").append("\n")
                .append("        <name>" + workerOne.getName() + "</name>").append("\n")
                .append("        <salary>" + workerOne.getSalary() + "</salary>").append("\n")
                .append("    </employes>\n")
                .append("</employes>\n");
            assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        store.add(workerOne);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(workerOne.getName()).append(";")
                .append(workerOne.getSalary()).append(";");
            assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenChangeSalary() {
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        SalaryRubToDollar changeSalary = new SalaryRubToDollar(75.6);
        assertThat(changeSalary.changer(workerOne.getSalary()), is(1.0));
    }

    @Test
    public void whenAddToStore() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 75.6);
        Employee workerTwo = new Employee("Vasya", now, now, 151.2);
        store.add(workerOne);
        store.add(workerTwo);
        List<Employee> list = store.findBy(em -> true);
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        assertThat(list.get(0).getName(), is("Vasya"));
    }
}