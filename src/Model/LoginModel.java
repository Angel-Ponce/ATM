package Model;

import Entity.Admin;
import Entity.Person;
import Entity.Transaction;
import Entity.User;
import Others.Connecter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Angel Ponce
 */
public class LoginModel {

    public static Optional<Person> authenticate(String email, int pin, ArrayList<Person> persons) {
        return persons.stream().filter(person -> person.getEmail().equals(email) && person.getPin() == pin).findAny();
    }

    public static boolean alreadyExist(String email, ArrayList<Person> persons) {
        return persons.stream().anyMatch(person -> person.getEmail().equals(email));
    }

    public static ArrayList<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList();
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("SELECT * FROM \"user\"");
            c.rs = c.ps.executeQuery();
            while (c.rs.next()) {
                User user = new User(
                        c.rs.getLong("card_number"),
                        c.rs.getInt("current_balance"),
                        c.rs.getInt("maximum_amount"),
                        c.rs.getString("name"),
                        c.rs.getString("last_name"),
                        c.rs.getInt("age"),
                        c.rs.getString("email"),
                        c.rs.getInt("pin"),
                        c.rs.getTimestamp("last_access"),
                        c.rs.getString("pick")
                );
                persons.add(user);
            }
            c.ps = c.con.prepareStatement("SELECT * FROM \"admin\"");
            c.rs = c.ps.executeQuery();
            while (c.rs.next()) {
                Admin admin = new Admin(
                        c.rs.getString("name"),
                        c.rs.getString("last_name"),
                        c.rs.getInt("age"),
                        c.rs.getString("email"),
                        c.rs.getInt("pin"),
                        c.rs.getTimestamp("last_access"),
                        c.rs.getString("pick"));
                persons.add(admin);
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        persons.forEach(p -> {
            if (p instanceof User) {
                ArrayList<Transaction> transactions = UserModel.getTransactionPerUser((User) p);
                transactions.forEach(t -> ((User) p).addTransaction(t));
            }
        });
        return persons;
    }
}
