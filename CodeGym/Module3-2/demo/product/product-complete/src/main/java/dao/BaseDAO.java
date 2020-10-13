package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/product_complete?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";

    public BaseDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
