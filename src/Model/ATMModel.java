package Model;

import Controller.ATMController;
import Controller.LoginController;
import Entity.Admin;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Entity.User;
import Others.Connecter;
import Others.Helper;
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
            c.con = c.getConnection();
            for (int i = 0; i < ATMController.tickets.size(); i++) {
                c.ps = c.con.prepareStatement("UPDATE ticket SET size = ? WHERE type = ?");
                c.ps.setInt(1, ATMController.tickets.get(i).getSize());
                c.ps.setInt(2, ATMController.tickets.get(i).getType());
                c.ps.executeUpdate();
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        try {
            Connecter c = new Connecter();
            Properties p = ATMController.properties;
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("UPDATE properties SET theme=?, current_balance=?,last_card_number=?,\"date\"=?");
            c.ps.setString(1, p.getTheme());
            c.ps.setInt(2, p.getCurrentBalance());
            c.ps.setLong(3, Helper.personToUser(p.getLastPerson()).getCardNumber());
            c.ps.setString(4, p.getDate());
            c.ps.executeUpdate();
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            for (int i = 0; i < LoginController.persons.size(); i++) {
                Person person = LoginController.persons.get(i);
                Timestamp time = Timestamp.valueOf(Model.TIMESTAMP.format(person.getLastAccess()));
                if (person instanceof Admin) {
                    c.ps = c.con.prepareStatement("UPDATE \"admin\" SET last_access=? WHERE email=?");
                    c.ps.setTimestamp(1, time);
                    c.ps.setString(2, person.getEmail());
                    c.ps.executeUpdate();
                } else if (person instanceof User) {
                    c.ps = c.con.prepareStatement("UPDATE \"user\" SET card_number=?, pin=?, last_access=?, current_balance=?, maximum_amount=?, count_pin_changed=? WHERE card_number=?");
                    c.ps.setLong(1, ((User) person).getCardNumber());
                    c.ps.setInt(2, person.getPin());
                    c.ps.setTimestamp(3, time);
                    c.ps.setInt(4, ((User) person).getCurrentBalance());
                    c.ps.setInt(5, ((User) person).getMaximumAmount());
                    c.ps.setInt(6, ((User) person).getCountPinChanged());
                    c.ps.setLong(7, ((User) person).getCardNumber());
                    c.ps.executeUpdate();
                }
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static ArrayList<Ticket> getTickets() {
        return (ArrayList<Ticket>) Helper.getObjectFromFile("database/Tickets.txt");
    }

    public static Properties getProperties() {
        return (Properties) Helper.getObjectFromFile("database/Properties.txt");
    }

    public static void updateLastAccess(Person person, Date date) {
        person.setLastAccess(date);
        Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
    }
}
