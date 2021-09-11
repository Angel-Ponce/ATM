package Model;

import Controller.ATMController;
import Controller.LoginController;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Others.Connecter;
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
        Helper.saveObjectToFile(ATMController.tickets, "database/Tickets.txt");
          try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='"+ATMController.tickets+"'");
          } catch(Exception e){
              
          }
        Helper.saveObjectToFile(ATMController.properties, "database/Properties.txt");
         try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("UPDATE ticket SET current_balance='"+ATMController.properties+"'");
          } catch(Exception e){
              
          }
          
        Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
      try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("UPDATE ticket SET card_number,current_balance,maximum_amount,pin,last_access='"+LoginController.persons+"'");
          } catch(Exception e){
              
          }
    }

    public static ArrayList<Ticket> getTickets() {
        return (ArrayList<Ticket>) Helper.getObjectFromFile("database/Tickets.txt");
    }

    public static Properties getProperties() {
        return (Properties) Helper.getObjectFromFile("database/Properties.txt");
    }

    public static void updateLastAccess(Person person, Date date) {
        person.setLastAccess(date);
        Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
    }
}
