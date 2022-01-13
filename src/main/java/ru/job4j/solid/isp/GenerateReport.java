package ru.job4j.solid.isp;

public interface GenerateReport {

    public String generatePDF(String[] data);

    public String generateXLS(String[] data);
}
