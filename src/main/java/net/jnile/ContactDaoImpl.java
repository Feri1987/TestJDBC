package net.jnile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDaoImpl implements ContactDao {

    private Provider provide = Provider.INSTANCE;


    private final static  String SQL_INSERT = "INSERT INTO contact_table(first_name, last_name) VALUES (?, ?)";



    public void save(Contact contact) {

        Connection connection = provide.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)){

            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact getContactById(long id) {
        return null;
    }
}
