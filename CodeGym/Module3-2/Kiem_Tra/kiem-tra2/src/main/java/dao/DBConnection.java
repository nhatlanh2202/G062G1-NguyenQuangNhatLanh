package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//    private static final String USER_NAME = "root";
//    private static final String PASSWORD = "lanh1997";
//    private static final String HOST = "localhost";
//    private static final String DATABASE = "exam";
//    private static final String PORT = "3306";
//
//    private static Connection connection;
//
//
//    public static Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE, USER_NAME, PASSWORD);
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }


    private String jdbcURL = "jdbc:mysql://localhost:3306/exam?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "lanh1997";

    Connection connection;


    public  Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return connection;
    }


    /**
     * Close connection
     */
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
