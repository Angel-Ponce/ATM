package Others;

import Controller.LoginController;
import Entity.Admin;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
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
        Admin angel = new Admin("Angel", "Ponce", 20, "angel@gmail.com", 2304, null, "/Resources/angel.jpg");
        Admin sami = new Admin("Samantha", "Chub", 19, "sami@gmail.com", 12345, null, "/Resources/sami.jpg");
        User jossi = new User(3415170, 1000, 2000, "Josselin", "Tot", 20, "3415170", 2304, null, "/Resources/jossi.jpg");
        persons.add(angel);
        persons.add(sami);
        persons.add(jossi);
        boolean saved = Helper.saveObjectToFile(persons, "/Files/Persons.txt");
        System.out.println(saved);

        ArrayList<Ticket> tickets = new ArrayList();
        Ticket Q1 = new Ticket(1, 100);
        Ticket Q5 = new Ticket(5, 52);
        Ticket Q10 = new Ticket(10, 30);
        Ticket Q20 = new Ticket(20, 22);
        Ticket Q50 = new Ticket(50, 10);
        Ticket Q100 = new Ticket(100, 52);
        Ticket Q200 = new Ticket(200, 16);
        tickets.add(Q1);
        tickets.add(Q5);
        tickets.add(Q10);
        tickets.add(Q20);
        tickets.add(Q50);
        tickets.add(Q100);
        tickets.add(Q200);
        saved = Helper.saveObjectToFile(tickets, "/Files/Tickets.txt");
        System.out.println(saved);

        Properties properties = new Properties("", 10000, null);
        saved = Helper.saveObjectToFile(properties, "/Files/Properties.txt");
        System.out.println(saved);
    }
}
