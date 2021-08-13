package Model;

import Entity.Person;
import Entity.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class UserModel {

    public boolean changePin(int newPin, Person person) {
        return false;
    }

    public boolean retreat(int amount, Person person) {
        return false;
    }

    public boolean deposit(int amount, Person person) {
        return false;
    }

    public ArrayList<Transaction> getLatestTransactions(Person person) {
        return null;
    }
}
