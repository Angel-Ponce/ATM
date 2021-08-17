package Model;

import Entity.Properties;
import Entity.Ticket;
import Others.Helper;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class ATMModel {

    public void logout() {

    }

    public static ArrayList<Ticket> getTickets() {
        return (ArrayList<Ticket>) Helper.getObjectFromFile("/Files/Tickets.txt");
    }

    public static Properties getProperties() {
        return (Properties) Helper.getObjectFromFile("/Files/Properties.txt");
    }
}
