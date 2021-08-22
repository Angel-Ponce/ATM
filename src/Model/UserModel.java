package Model;

import Controller.LoginController;
import Entity.Person;
import Entity.Transaction;
import Others.Helper;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class UserModel {

    public boolean changePin(int newPin, Person person) {
        person.setPin(newPin);
        return Helper.saveObjectToFile(LoginController.persons,"/Files/Persons.txt");
        
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
