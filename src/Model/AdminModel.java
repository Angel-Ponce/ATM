package Model;

import Controller.LoginController;
import Entity.Person;
import Entity.Ticket;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class AdminModel {

    public static boolean addUser(User user) {
        LoginController.persons.add(user);
        return true;
    }

    public static boolean initATM(ArrayList<Ticket> tickets) {
        return false;
    }

    public static boolean addCash(ArrayList<Ticket> tickets) {
        return false;
    }

    public static boolean changeCardNumber(int newCardNumber, Person person) {
        return false;
    }

    public static boolean changeLimit(int newLimit, Person person) {
        return false;
    }

    public static ArrayList<User> getUsers() {
        return null;
    }
}
