package ru.lanit.service;

import ru.lanit.entity.Person;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class PersonActions {

    public static void insert(Person person) throws Exception {

        try {
            PersonActions app = new PersonActions();
            Properties prop = app.loadPropertiesFile("db.properties");

            Class.forName(prop.getProperty("db.driverClassName"));

            try (Connection conn = DriverManager.getConnection(
                    prop.getProperty("db.url"),
                    prop.getProperty("db.username"),
                    prop.getProperty("db.password"))) {

                String sql = "INSERT INTO people (name, surname, patronymic, date_of_birth) Values (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setString(3, person.getPatronymic());
                    preparedStatement.setString(4, person.getDate());

                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    throw new SQLException(ex);
                }
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    private Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}
