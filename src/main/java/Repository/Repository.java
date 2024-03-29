package Repository;

import Model.Person;
import Util.DBConfiguration;

import java.sql.*;
import java.util.ArrayList;

public class Repository {
    Connection connection;

    public Repository() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DBConfiguration.url, DBConfiguration.user, DBConfiguration.password);
            // Set isolation level
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            //
            if (connection != null) {
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to connect to the database");
            }

        } catch (SQLException | ClassNotFoundException exception) {
            System.err.println("An error occurred: " + exception.getMessage());
        }
    }

    public ArrayList<Person> getPeople() {

        String getPeople = "SELECT * FROM people ORDER BY id ASC";
        ArrayList<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getPeople);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("Surname"));
                person.setAge(resultSet.getInt("age"));
                people.add(person);
            }
        } catch (SQLException exception) {
            System.err.println("An error occurred: " + exception.getMessage());
        }
        return people;
    }

    public void addPerson(Person person) {
        String addPerson = "INSERT INTO people (name, surname, age) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addPerson);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getAge());

            preparedStatement.executeUpdate();

        } catch (Exception exception) {
            System.err.println("An error occurred: " + exception.getMessage());
        }
    }


    public void deletePerson(int id) {
        String deleteProcedure = "{call delete_person(?)}";
        try (CallableStatement callableStatement = connection.prepareCall(deleteProcedure)) {
            callableStatement.setInt(1, id);
            callableStatement.execute();
        } catch (SQLException exception) {
            System.err.println("An error occurred: " + exception.getMessage());
        }
    }


    public void updatePerson(Person person) {
        String updateQuery = "UPDATE people SET name = ?, surname = ?, age = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.err.println("An error occurred: " + exception.getMessage());
        }
    }

    public Person getPersonById(String id) {
        String query = "SELECT * FROM people WHERE id = CAST(? AS INTEGER)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int personId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                return new Person(personId, name, surname, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
