package Model;

import Controller.ATMController;
import Controller.LoginController;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Others.Helper;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Angel Ponce
 */
public class ATMModel {

    public static void logout(Person lastPerson) {
        ATMController.properties.setLastPerson(lastPerson);
        Helper.saveObjectToFile(ATMController.tickets, "/Files/Tickets.txt");
        Helper.saveObjectToFile(ATMController.properties, "/Files/Properties.txt");
        Helper.saveObjectToFile(LoginController.persons, "/Files/Persons.txt");
    }

    public static ArrayList<Ticket> getTickets() {
        return (ArrayList<Ticket>) Helper.getObjectFromFile("/Files/Tickets.txt");
    }

    public static Properties getProperties() {
        return (Properties) Helper.getObjectFromFile("/Files/Properties.txt");
    }

    public static void updateLastAccess(Person person, Date date) {
        person.setLastAccess(date);
        Helper.saveObjectToFile(LoginController.persons, "/Files/Persons.txt");
    }
}
