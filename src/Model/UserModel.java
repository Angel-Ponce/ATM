package Model;

import Controller.LoginController;
import Entity.Admin;
import Entity.Person;
import Entity.Transaction;
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
public class UserModel {

    public static boolean changePin(int newPin, Person person) {
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            if (person instanceof User) {
                c.ps = c.con.prepareStatement("UPDATE \"user\" SET pin = ? WHERE card_number = ?");
                c.ps.setInt(1, newPin);
                c.ps.setLong(2, ((User) person).getCardNumber());
                int r = c.ps.executeUpdate();
                if (r > 0) {
                    person.setPin(newPin);
                    c.con.close();
                    return true;
                }
                c.con.close();
            } else if (person instanceof Admin) {
                c.ps = c.con.prepareStatement("UPDATE \"admin\" SET pin = ? WHERE email = ?");
                c.ps.setInt(1, newPin);
                c.ps.setString(2, person.getEmail());
                int r = c.ps.executeUpdate();
                if (r > 0) {
                    person.setPin(newPin);
                    c.con.close();
                    return true;
                }
                c.con.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean retreat(int amount, Person person) {

        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            if (person instanceof User) {
                ((User) person).retreat(amount);
                c.ps = c.con.prepareStatement("UPDATE \"user\" SET current_balance = ? WHERE card_number = ?");
                c.ps.setInt(1, ((User) person).getCurrentBalance());
                c.ps.setLong(2, ((User) person).getCardNumber());
                insertTransaction(Transaction.RETREAT, amount, new Date(), ((User) person).getCardNumber());
                int r = c.ps.executeUpdate();
                if (r > 0) {
                    c.con.close();
                    return true;
                }
                c.con.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean deposit(int amount, Person person) {
        Helper.personToUser(person).deposit(amount);
        return Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
    }

    public static ArrayList<Transaction> getLatestTransactions(Person person) {
        return null;
    }

    public static void insertTransaction(String type, int amount, Date date, long cardNumber) {
        Timestamp time = Timestamp.valueOf(Model.TIMESTAMP.format(date));
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("INSERT INTO transaction(type,amount,date,card_number) VALUES(?,?,?,?)");
            c.ps.setString(1, type);
            c.ps.setInt(2, amount);
            c.ps.setTimestamp(3, time);
            c.ps.setLong(4, cardNumber);
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
