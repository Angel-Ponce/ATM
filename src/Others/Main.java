package Others;

import Controller.LoginController;
import Entity.Admin;
import Entity.Person;
import Entity.User;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class Main {

    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.start();
    }

    private static void register() {
        ArrayList<Person> persons = new ArrayList();
        Admin angel = new Admin("Angel", "Ponce", 20, "angel@gmail.com", 2304, null, "");
        Admin sami = new Admin("Samantha", "Chub", 19, "sami@gmail.com", 12345, null, "");
        User jossi = new User(3415170, 1000, 2000, "Josselin", "Tot", 20, "jossi@gmail.com", 2304, null, "");
        persons.add(angel);
        persons.add(sami);
        persons.add(jossi);
        boolean saved = Helper.saveObjectToFile(persons, "/Files/Persons.txt");
        System.out.println(saved);
    }
}
