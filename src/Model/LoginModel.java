package Model;

import Entity.Person;
import Others.Helper;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Angel Ponce
 */
public class LoginModel {

    public static Optional<Person> authenticate(String email, int pin, ArrayList<Person> persons) {
        return persons.stream().filter(person -> person.getEmail().equals(email) && person.getPin() == pin).findAny();
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
