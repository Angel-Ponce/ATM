package Model;

import Entity.Person;
import Entity.Ticket;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class AdminModel {

    public boolean addUser(User user) {
        return false;
    }

    public boolean initATM(ArrayList<Ticket> tickets) {
        return false;
    }

    public boolean addCash(ArrayList<Ticket> tickets) {
        return false;
    }

    public boolean changeCardNumber(int newCardNumber, Person person) {
        return false;
    }

    public boolean changeLimit(int newLimit, Person person) {
        return false;
    }

    public ArrayList<User> getUsers() {
        return null;
    }
}
