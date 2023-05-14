package model;

import java.sql.ResultSet;

/**
 * Class: Client
 * <br>
 * manipulates information related to the person who booked the table
 *
 */
public class Client {

    private String name;
    private String phone;
    private String email;
    private int id;

    public Client(int id) {
        this.id = id;
    }
    public Client(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean exists() throws RuntimeException{
        try {
            DBConn db = new DBConn();
            String query = "SELECT * FROM client WHERE name = ? AND phone = ? AND email = ?";
            ResultSet reply = db.query(query, name, phone, email);
            if(reply.next()) {
                this.name = reply.getString("name");
                this.phone = reply.getString("phone");
                this.email = reply.getString("email");
                this.id = reply.getInt("id");
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save() throws RuntimeException {
        try{
            DBConn db = new DBConn();
            String query = "INSERT INTO client (name, phone, email) VALUES (?, ?, ?)";
            db.write(query, name, phone, email);

        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void load() throws RuntimeException {
        try {
            DBConn db = new DBConn();
            String query = "SELECT * FROM client WHERE id = ?";
            ResultSet reply = db.query(query, id);
            if(reply.next()) {
                this.name = reply.getString("name");
                this.phone = reply.getString("phone");
                this.email = reply.getString("email");
            }
            else {
                throw new RuntimeException("Client not found");
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
