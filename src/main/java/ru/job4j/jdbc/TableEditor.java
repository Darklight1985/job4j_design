package ru.job4j.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            this.connection = connection;
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable(String tableName) {
            String sql = String.format(
                    "create table if not exists " + tableName + " (%s);",
                    "id serial primary key"
            );
            stateExec(sql);
        try {
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
            String sql = String.format(
                    "drop table %s;",
                    tableName
            );
            stateExec(sql);
            try {
                System.out.println("Таблица " + tableName + " удалена");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void addColumn(String tableName, String columnName, String type) {
            String sql = String.format(
                    "alter table %s add %s  %s;",
                    tableName,
                    columnName,
                    type
            );
            stateExec(sql);
            try {
                System.out.println(getTableScheme(connection, tableName));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void dropColumn(String tableName, String columnName) {
            String sql = String.format(
                    "alter table %s drop column %s;",
                    tableName,
                    columnName
            );
            stateExec(sql);
            try {
                System.out.println(getTableScheme(connection, tableName));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
            String sql = String.format(
                    "alter table %s rename column %s to %s;",
                    tableName,
                    columnName,
                    newColumnName
            );
            stateExec(sql);
            try {
                System.out.println(getTableScheme(connection, tableName));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public void stateExec(String str) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("app.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("demo");
        tableEditor.addColumn("demo", "name", "varchar(255)");
        tableEditor.renameColumn("demo", "name", "surname");
        tableEditor.dropColumn("demo", "surname");
        tableEditor.dropTable("demo");
        try {
            tableEditor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
