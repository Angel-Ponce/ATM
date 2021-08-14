package Model;

import Entity.Person;
import Others.Helper;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class LoginModel {

    public static boolean authenticate(String email, int pin, ArrayList<Person> persons) {
        return persons.stream().anyMatch(person -> person.getEmail().equals(email) && person.getPin() == pin);
    }

    public static ArrayList<Person> getPersons() {
        ArrayList<Person> persons = (ArrayList<Person>) Helper.getObjectFromFile("/Files/Persons.txt");
        if (persons != null) {
            return persons;
        }
        {
            return new ArrayList<>();
        }
    }
}
