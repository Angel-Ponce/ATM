package Model;

import Controller.ATMController;
import Controller.LoginController;
import Entity.Properties;
import Entity.Ticket;
import Others.Helper;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class ATMModel {

    public static void logout() {
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
}
