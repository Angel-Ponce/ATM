package Model;

import Controller.ATMController;
import Controller.LoginController;
import Entity.Admin;
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
public class AdminModel {

    public static boolean addUser(User user, Admin admin) {
        LoginController.persons.add(user);
        user.setLastAccess(user.getLastAccess() == null ? new Date() : user.getLastAccess());
        Timestamp time = Timestamp.valueOf(Model.TIMESTAMP.format(user.getLastAccess()));
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("INSERT INTO \"user\"(card_number,name,last_name,age,email,pin,last_access,pick,current_balance,maximum_amount,count_pin_changed) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            c.ps.setLong(1, user.getCardNumber());
            c.ps.setString(2, user.getName());
            c.ps.setString(3, user.getLastName());
            c.ps.setInt(4, user.getAge());
            c.ps.setString(5, user.getEmail());
            c.ps.setInt(6, user.getPin());
            c.ps.setTimestamp(7, time);
            c.ps.setString(8, user.getPick());
            c.ps.setInt(9, user.getCurrentBalance());
            c.ps.setInt(10, user.getMaximumAmount());
            c.ps.setInt(11, user.getCountPinChanged());
            int r = c.ps.executeUpdate();
            if (r > 0) {
                c.ps = c.con.prepareStatement("INSERT INTO admin_register_user (email_admin,card_number,\"date\",) VALUES(?,?,?)");
                c.ps.setString(1, admin.getEmail());
                c.ps.setLong(2, user.getCardNumber());
                c.ps.setTimestamp(3, Timestamp.valueOf(Model.TIMESTAMP.format(new Date())));
                int r2 = c.ps.executeUpdate();
                if (r2 > 0) {
                    c.con.close();
                    return true;
                }
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean initATM(int $1, int $5, int $10, int $20, int $50, int $100, int $200, Admin admin) {
        try {
            ATMController.tickets.set(0, new Ticket(1, $1));
            ATMController.tickets.set(1, new Ticket(5, $5));
            ATMController.tickets.set(2, new Ticket(10, $10));
            ATMController.tickets.set(3, new Ticket(20, $20));
            ATMController.tickets.set(4, new Ticket(50, $50));
            ATMController.tickets.set(5, new Ticket(100, $100));
            ATMController.tickets.set(6, new Ticket(200, $200));
            ATMController.properties.setCurrentBalance(
                    (int) ATMController.tickets.stream().mapToDouble(ticket -> ticket.getType() * ticket.getSize()).sum()
            );
            try {
                Connecter c = new Connecter();
                c.con = c.getConnection();
                for (int i = 0; i < ATMController.tickets.size(); i++) {
                    c.ps = c.con.prepareStatement("UPDATE ticket SET size = ? WHERE type = ?");
                    c.ps.setInt(1, ATMController.tickets.get(i).getSize());
                    c.ps.setInt(2, ATMController.tickets.get(i).getType());
                    c.ps.executeUpdate();
                }
                c.ps = c.con.prepareStatement("UPDATE properties SET current_balance=?");
                c.ps.setInt(1, ATMController.properties.getCurrentBalance());
                c.ps.executeUpdate();
                c.ps = c.con.prepareStatement("INSERT INTO admin_init_atm (email_admin,balance,\"date\") VALUES(?,?,?)");
                c.ps.setString(1, admin.getEmail());
                c.ps.setInt(2, ATMController.properties.getCurrentBalance());
                c.ps.setTimestamp(3, Timestamp.valueOf(Model.TIMESTAMP.format(new Date())));
                c.ps.executeUpdate();
                c.con.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean addCash(int $1, int $5, int $10, int $20, int $50, int $100, int $200) {
        try {
            ATMController.tickets.set(0, new Ticket(1, $1));
            ATMController.tickets.set(1, new Ticket(5, $5));
            ATMController.tickets.set(2, new Ticket(10, $10));
            ATMController.tickets.set(3, new Ticket(20, $20));
            ATMController.tickets.set(4, new Ticket(50, $50));
            ATMController.tickets.set(5, new Ticket(100, $100));
            ATMController.tickets.set(6, new Ticket(200, $200));
            ATMController.properties.setCurrentBalance(
                    (int) ATMController.tickets.stream().mapToDouble(ticket -> ticket.getType() * ticket.getSize()).sum()
            );
            try {
                Connecter c = new Connecter();
                c.con = c.getConnection();
                for (int i = 0; i < ATMController.tickets.size(); i++) {
                    c.ps = c.con.prepareStatement("UPDATE ticket SET size = ? WHERE type = ?");
                    c.ps.setInt(1, ATMController.tickets.get(i).getSize());
                    c.ps.setInt(2, ATMController.tickets.get(i).getType());
                    c.ps.executeUpdate();
                }
                c.ps = c.con.prepareStatement("UPDATE properties SET current_balance=?");
                c.ps.setInt(1, ATMController.properties.getCurrentBalance());
                c.ps.executeUpdate();
                c.con.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean changeCardNumber(long newCardNumber, User user) {
        try {
            try {
                Connecter c = new Connecter();
                c.con = c.getConnection();
                c.ps = c.con.prepareStatement("UPDATE \"user\" SET card_number = ?, email = ? WHERE card_number = ?");
                c.ps.setLong(1, newCardNumber);
                c.ps.setString(2, String.valueOf(newCardNumber));
                c.ps.setLong(3, user.getCardNumber());
                c.ps.executeUpdate();
                //Comprobe if the user is the latest user to login into system
                if (user.getCardNumber() == Helper.personToUser(ATMController.properties.getLastPerson()).getCardNumber()) {
                    Helper.personToUser(ATMController.properties.getLastPerson()).setCardNumber(newCardNumber);
                }
                user.setCardNumber(newCardNumber);
                user.setEmail(String.valueOf(newCardNumber));
                c.con.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return false;
    }

    public static boolean changeLimit(int newLimit, User user) {
        try {
            try {
                Connecter c = new Connecter();
                c.con = c.getConnection();
                c.ps = c.con.prepareStatement("UPDATE \"user\" SET maximum_amount = ? WHERE card_number = ?");
                c.ps.setInt(1, newLimit);
                c.ps.setLong(2, user.getCardNumber());
                c.ps.executeUpdate();
                user.setMaximumAmount(newLimit);
                c.con.close();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    @Deprecated
    public static ArrayList<User> getUsers() {
        return null;
    }
}
