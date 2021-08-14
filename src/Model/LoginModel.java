package Model;

import Entity.Person;
import Others.Helper;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class LoginModel {

    public boolean authenticate(String email, int pin) {
        return false;
    }

    public ArrayList<Person> getPersons() throws IOException {
        ArrayList<Person> persons = (ArrayList<Person>) Helper.getObjectFromFile("/Files/Persons.txt");
        if (persons != null) {
            return persons;
        }
        {
            return new ArrayList<>();
        }
    }
}
