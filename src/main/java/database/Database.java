
package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Database extends AbstractPersistable<Long> implements Serializable {

    private Connection connection;

    public Database() {
        super();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:testi.db");

            connection.prepareStatement("CREATE TABLE IF NOT EXISTS User (name TEXT, address TEXT )").execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void add(String n, String a) throws SQLException {
        // connection.prepareStatement("INSERT INTO User (name, address) VALUES ('nimi', 'osoite')").execute();
        //if (validate(n) && validate(a)) {
        connection.createStatement().execute("INSERT INTO User (name, address) VALUES ('" + n + "','" + a + "');");
        //}

    }

    public void delete(String n) throws Exception {
        //if(validate(n)){
        connection.prepareStatement("DELETE FROM User" + " WHERE name='" + n + "'"
        ).execute();
        //}
    }

    public void list() throws Exception {
        Statement statement = connection.createStatement();
//      
//
        ResultSet rs = statement.executeQuery("SELECT * FROM User");
        while (rs.next()) {
            System.out.println(rs.getString("name") + "_" + rs.getString("address"));
        }

    }

    public List<String> findAll() throws Exception {
        List<String> all = new ArrayList<>();
        Statement statement = connection.createStatement();
//      
//
        ResultSet rs = statement.executeQuery("SELECT * FROM User");
        while (rs.next()) {
            all.add("name: " + rs.getString("name") + " address: " + rs.getString("address"));
        }
        return all;
    }

    public boolean validate(String s) {
        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) == ' ')) {
                valid = false;
                break;
            }
        }

        return valid;
    }

    @Override
    public String toString() {
        String tuloste = "_";
        try {
            tuloste += findAll().toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return tuloste;
    }
}
