package ru.job4j.design.srp;

public class HTMLCreater {

    public static String stringToHTMLString(String string) {
        StringBuilder html = new StringBuilder();
        html.append("<!doctype html>\n");
        html.append("<html lang='en'>\n");

        html.append("<head>\n");
        html.append("<meta charset='utf-8'>\n");
        html.append("<title>Report of Reports</title>\n");
        html.append("</head>\n\n");

        html.append("<body>\n");
        html.append("<h1>List of Reports</h1>\n");

        html.append("<ul>\n");
          String[] reports = string.split(System.lineSeparator());
        for (String report : reports) {
            html.append("<li>" + report + "</li>\n");
        }
        html.append("</ul>\n");
        html.append("</body>\n\n");

        html.append("</html>");

        return html.toString();
    }

    }
