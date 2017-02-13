package net.jnile;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum Provider {

    INSTANCE;

    private Connection connection;


    Provider() {
        try {
            new Driver();
            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
