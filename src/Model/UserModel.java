package Model;

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
                    c.ps = c.con.prepareStatement("UPDATE \"user\" SET count_pin_changed = ?  WHERE card_number = ?");
                    c.ps.setInt(1, ((User) person).getCountPinChanged());
                    c.ps.setLong(2, ((User) person).getCardNumber());
                    c.ps.executeUpdate();
                    c.ps = c.con.prepareStatement("INSERT INTO user_update_pin(card_number,old_pin,new_pin,\"date\") VALUES (?,?,?,?)");
                    c.ps.setLong(1, Helper.personToUser(person).getCardNumber());
                    c.ps.setInt(2, Helper.personToUser(person).getPin());
                    c.ps.setInt(3, newPin);
                    c.ps.setTimestamp(4, Timestamp.valueOf(Model.TIMESTAMP.format(new Date())));
                    c.ps.executeUpdate();
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
                int r = c.ps.executeUpdate();
                if (r > 0) {
                    c.con.close();
                    insertTransaction(Transaction.RETREAT, amount, new Date(), ((User) person).getCardNumber());
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
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            if (person instanceof User) {
                ((User) person).deposit(amount);
                c.ps = c.con.prepareStatement("UPDATE \"user\" SET current_balance = ? WHERE card_number = ?");
                c.ps.setInt(1, ((User) person).getCurrentBalance());
                c.ps.setLong(2, ((User) person).getCardNumber());
                int r = c.ps.executeUpdate();
                if (r > 0) {
                    c.con.close();
                    insertTransaction(Transaction.DEPOSIT, amount, new Date(), ((User) person).getCardNumber());
                    return true;
                }
                c.con.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public static ArrayList<Transaction> getTransactionPerUser(User user) {
        ArrayList<Transaction> transactions = new ArrayList();
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("SELECT * FROM \"transaction\" WHERE card_number = ?");
            c.ps.setLong(1, user.getCardNumber());
            c.rs = c.ps.executeQuery();
            while (c.rs.next()) {
                transactions.add(new Transaction(c.rs.getInt("amount"), c.rs.getString("type"), c.rs.getTimestamp("date")));
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return transactions;
    }

    public static void insertTransaction(String type, int amount, Date date, long cardNumber) {
        Timestamp time = Timestamp.valueOf(Model.TIMESTAMP.format(date));
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("INSERT INTO \"transaction\" (type,amount,date,card_number) VALUES(?,?,?,?)");
            c.ps.setString(1, type);
            c.ps.setInt(2, amount);
            c.ps.setTimestamp(3, time);
            c.ps.setLong(4, cardNumber);
            c.ps.executeUpdate();
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
