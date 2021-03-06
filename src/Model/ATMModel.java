package Model;

import Controller.ATMController;
import Entity.Admin;
//import Controller.LoginController;
//import Entity.Admin;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Entity.User;
import Others.Connecter;
import Others.Helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Angel Ponce
 */
public class ATMModel {

    public static void logout(Person lastPerson) {
        ATMController.properties.setLastPerson(lastPerson);
        try {
            Connecter c = new Connecter();
            Properties p = ATMController.properties;
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("UPDATE properties SET theme=? ,last_card_number=?, \"date\"=?");
            c.ps.setString(1, p.getTheme());
            c.ps.setLong(2, Helper.personToUser(p.getLastPerson()).getCardNumber());
            c.ps.setString(3, p.getDate());
            c.ps.executeUpdate();
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static ArrayList<Ticket> getTickets() {
        ArrayList<Ticket> tickets = new ArrayList();
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("SELECT * FROM ticket");
            c.rs = c.ps.executeQuery();
            while (c.rs.next()) {
                tickets.add(new Ticket(
                        c.rs.getInt("type"),
                        c.rs.getInt("size")
                ));
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return tickets;
    }

    public static Properties getProperties() {
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("SELECT TOP 1 * FROM properties ORDER BY id DESC");
            c.rs = c.ps.executeQuery();
            if (c.rs.next()) {
                c.ps = c.con.prepareStatement("SELECT * FROM \"user\" WHERE card_number = ?");
                c.ps.setLong(1, c.rs.getLong("last_card_number"));
                ResultSet rs = c.ps.executeQuery();
                if (rs.next()) {
                    User user = new User(
                            rs.getLong("card_number"),
                            rs.getInt("current_balance"),
                            rs.getInt("maximum_amount"),
                            rs.getString("name"),
                            rs.getString("last_name"),
                            rs.getInt("age"),
                            rs.getString("email"),
                            rs.getInt("pin"),
                            rs.getTimestamp("last_access"),
                            rs.getString("pick")
                    );
                    Properties properties = new Properties(c.rs.getString("theme"), c.rs.getInt("current_balance"), user, c.rs.getString("date"));
                    c.con.close();
                    return properties;
                }
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return new Properties("", 0, new User(), ATMController.DATE_FORMAT.format(new Date()));
    }

    public static void updateLastAccess(Person person, Date date) {
        person.setLastAccess(date);
        Timestamp time = Timestamp.valueOf(Model.TIMESTAMP.format(date));
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            if (person instanceof User) {
                c.ps = c.con.prepareStatement("UPDATE \"user\" SET last_access=? WHERE card_number = ?");
                c.ps.setTimestamp(1, time);
                c.ps.setLong(2, ((User) person).getCardNumber());
                c.ps.executeUpdate();
            } else if (person instanceof Admin) {
                c.ps = c.con.prepareStatement("UPDATE \"admin\" SET last_access=? WHERE email = ?");
                c.ps.setTimestamp(1, time);
                c.ps.setString(2, person.getEmail());
                c.ps.executeUpdate();
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
