package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class DBConn
 * <br>
 * interaction logic for the database connector
 * contains methods for interacting with the database
 *
 */
public class DBConn {


    String url = "jdbc:mysql://localhost:3306/savoursync";
    String uname = "root";
    String passwd = "";
    Connection con;
    public DBConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            con = DriverManager.getConnection(url, uname, passwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet query(String query) {
        try {
            return con.createStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String nonQuery) {
        try {
            con.createStatement().execute(nonQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String nonQuery) {
        try {
            con.createStatement().executeUpdate(nonQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
