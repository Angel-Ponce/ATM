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
        int $1 = ATMController.tickets.get(0).getSize();
        int $5 = ATMController.tickets.get(1).getSize();
        int $10 = ATMController.tickets.get(2).getSize();
        int $20 = ATMController.tickets.get(3).getSize();
        int $50 = ATMController.tickets.get(4).getSize();
        int $100 = ATMController.tickets.get(5).getSize();
        int $200 = ATMController.tickets.get(6).getSize();

        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $1 + "WHERE id=1");
            int r=c.ps.executeUpdate();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $5 + "WHERE id=2");
           int r1=c.ps.executeUpdate();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $10 + "'WHERE id=3");
            int r2=c.ps.executeUpdate();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $20 + "'WHERE id=4");
            int r3=c.ps.executeUpdate();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $50 + "'WHERE id=5");
            int r4=c.ps.executeUpdate();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $100 + "'WHERE id=6");
            int r5=c.ps.executeUpdate();
            c.ps = c.con.prepareStatement("UPDATE ticket SET size='" + $200+ "'WHERE id=7");
            int r6=c.ps.executeUpdate();
            
        } catch (Exception e) {
        }
        Helper.saveObjectToFile(ATMController.properties, "database/Properties.txt");
//         try {
//            Connecter c = new Connecter();
//            c.con = c.getConnection();
//            c.ps = c.con.prepareStatement("UPDATE ticket SET current_balance='"+ATMController.properties+"'");
//          } catch(Exception e){
//              
//          }

        Helper.saveObjectToFile(LoginController.persons, "database/Persons.txt");
//            Connecter c=new Connecter();
//            c.con=c.getConnection();
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=1" );
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=2" );
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=3" );
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=4" );
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=5" );
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=6" );
//            c.ps=c.con.prepareStatement("UPDATE ticket SET size='"+h+"'WHERE id=7" );
//            c.rs=c.ps.executeQuery();
//        } catch(Exception e){
//        }

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
