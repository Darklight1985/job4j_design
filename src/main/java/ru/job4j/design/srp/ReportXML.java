package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {

          JAXBContext context = JAXBContext.newInstance(Employes.class);
           Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        List<Employee> list = store.findBy(filter);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employes(list), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        text
                .append(System.lineSeparator())
                .append(xml);
        return text.toString();
    }

    @XmlRootElement(name = "employes")
    public static class Employes {

        private List<Employee> employes;

        public Employes() {
        }

        public Employes(List<Employee> employes) {
            this.employes = employes;
        }

        public List<Employee> getEmployes() {
            return employes;
        }

        public void setEmployes(List<Employee> employes) {
            this.employes = employes;
        }

    }
}
