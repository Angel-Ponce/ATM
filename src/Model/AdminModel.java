package Model;

import Controller.ATMController;
import Controller.LoginController;
import Entity.Ticket;
import Entity.User;
import Others.Helper;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class AdminModel {

    public static boolean addUser(User user) {
        LoginController.persons.add(user);
        return Helper.saveObjectToFile(LoginController.persons, "/Files/Persons.txt");
    }

    public static boolean initATM(int $1, int $5, int $10, int $20, int $50, int $100, int $200) {
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
            return Helper.saveObjectToFile(ATMController.tickets, "/Files/Tickets.txt")
                    && Helper.saveObjectToFile(ATMController.properties, "/Files/Properties.txt");
        } catch (Exception e) {
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
            return Helper.saveObjectToFile(ATMController.tickets, "/Files/Tickets.txt")
                    && Helper.saveObjectToFile(ATMController.properties, "/Files/Properties.txt");
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean changeCardNumber(int newCardNumber, User user) {
        try {
            user.setCardNumber(newCardNumber);
            user.setEmail(String.valueOf(newCardNumber));
            return Helper.saveObjectToFile(LoginController.persons, "/Files/Persons.txt");
        } catch (Exception e) {
        }

        return false;
    }

    public static boolean changeLimit(int newLimit, User user) {
        try {
            user.setMaximumAmount(newLimit);
            return Helper.saveObjectToFile(LoginController.persons, "/Files/Persons.txt");
        } catch (Exception e) {
        }
        return false;
    }

    public static ArrayList<User> getUsers() {
        return null;
    }
}
