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

    public static boolean changePin(int newPin, Person person) {
        person.setPin(newPin);
        return Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");

    }

    public static boolean retreat(int amount, Person person) {
        Helper.personToUser(person).retreat(amount);
        return Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
    }

    public static boolean deposit(int amount, Person person) {
        Helper.personToUser(person).deposit(amount);
        return Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
    }

    public static ArrayList<Transaction> getLatestTransactions(Person person) {
        return null;
    }
}
