package ru.job4j.design.srp;

public class SalaryRubToDollar implements ChangeSalary {
    private Double course;

    public SalaryRubToDollar(Double course) {
        this.course = course;
    }

    @Override
    public Double changer(Double salary) {
        double value = salary / course;
        double scale = Math.pow(10, 1);
        return Math.ceil(value * scale) / scale;
    }
}
