import model.DBConn;

import java.sql.ResultSet;

public class dbtest {
    public static void main(String[] args) {
        try {
            DBConn db = new DBConn();
            String query = "SELECT id FROM `table` where available = True";
            ResultSet resultSet = db.query(query);
            while(resultSet.next()) {
                System.err.println(resultSet.getInt("id"));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}