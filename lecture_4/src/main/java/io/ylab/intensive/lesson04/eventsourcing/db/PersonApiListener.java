package io.ylab.intensive.lesson04.eventsourcing.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import io.ylab.intensive.lesson04.eventsourcing.Person;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

public class PersonApiListener {
    private DataSource dataSource;
    private ConnectionFactory connectionFactory;
    private final String queueName;

    public PersonApiListener(DataSource dataSource, ConnectionFactory connectionFactory, String queueName) {
        this.dataSource = dataSource;
        this.connectionFactory = connectionFactory;
        this.queueName = queueName;
    }

    public void startListening() throws Exception {
        var dbConnection = dataSource.getConnection();
        var mqConnection = connectionFactory.newConnection();
        var channel = mqConnection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);

        System.out.println("Waiting for messages...");
        ObjectMapper mapper = new ObjectMapper();

        DeliverCallback callback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.printf("Received message: %s%n", message);

            try {
                String command = delivery.getProperties().getHeaders().get("cmd").toString();

                if (command.equals("delete")) {
                    long personId = Long.parseLong(message);
                    deletePerson(dbConnection, personId);
                } else if (command.equals("save")) {
                    Person person = mapper.readValue(message, Person.class);
                    savePerson(dbConnection, person.getId(), person.getName(), person.getLastName(), person.getMiddleName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        channel.basicConsume(queueName, true, callback, consumerTag -> {
        });
    }

    public void deletePerson(Connection connection, Long personId) throws SQLException {
        try (var statement = connection.prepareStatement("DELETE FROM person WHERE person_id = ?")
        ) {
            statement.setLong(1, personId);
            if (statement.executeUpdate() == 0) {
                System.err.println("Person ID not found: " + personId);
            } else {
                System.err.printf("Deleted person with id=%d%n", personId);
            }
        }
    }

    public void savePerson(Connection connection, Long personId, String firstName, String lastName, String middleName) throws SQLException {
        try (var statementUpdate = connection.prepareStatement(
                "UPDATE person SET first_name = ?, last_name = ?, middle_name = ? WHERE person_id = ?")
        ) {
            int i = 1;
            statementUpdate.setString(i++, firstName);
            statementUpdate.setString(i++, lastName);
            statementUpdate.setString(i++, middleName);
            statementUpdate.setLong(i, personId);
            if (statementUpdate.executeUpdate() > 0) {
                System.out.printf("Updated person with id=%d%n", personId);
            } else {
                try (var statementInsert = connection.prepareStatement(
                        "INSERT INTO person (person_id, first_name, last_name, middle_name) VALUES (?, ?, ?, ?)")) {
                    i = 1;
                    statementInsert.setLong(i++, personId);
                    statementInsert.setString(i++, firstName);
                    statementInsert.setString(i++, lastName);
                    statementInsert.setString(i, middleName);
                    if (statementInsert.executeUpdate() > 0) {
                        System.err.printf("Inserted person with id=%d%n", personId);
                    }
                }
            }
        }
    }
}
