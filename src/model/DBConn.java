package model;

import java.sql.*;

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

    //all methods throw RunTimeExceptions if there are any errors.
    //These must be caught at the higher level, and errors displayed appropriately by the controllers/views.
    public DBConn() throws RuntimeException {
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

    /**
     * Executes a query and returns the result set
     * @param query : the query as a PREPARED STATEMENT
     * @param params : the parameters
     * @return : the result set
     */
    public ResultSet query(String query, Object... params) throws RuntimeException{
        try {
            //using prepared statement to prevent sql injection
            PreparedStatement stmt = con.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                //starting at i + 1 because the first parameter is 1
                stmt.setObject(i+1, params[i]);
            }

            ResultSet result =  stmt.executeQuery();

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes a write operation
     * @param nonQuery : the write operation as a PREPARED STATEMENT
     * @param params : the parameters
     */
    public void write(String nonQuery, Object... params)throws RuntimeException {
        try {
            PreparedStatement stmt = con.prepareStatement(nonQuery);

            for (int i = 0; i < params.length; i++) {
                //starting at i + 1 because the first parameter is 1
                stmt.setObject(i+1, params[i]);
            }

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Dispose the connection
     * Call when done with using the object
     */
    public void kill() throws RuntimeException {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
