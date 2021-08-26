package Others;

import Controller.LoginController;
import Entity.Admin;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Entity.Transaction;
import Entity.User;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Angel Ponce
 */
public class Main {

    public static void main(String[] args) {
        //register();
        LoginController loginController = new LoginController();
        loginController.start();
    }

    private static void register() {
        ArrayList<Person> persons = new ArrayList();
        persons.add(new Admin("Angel", "Ponce", 20, "angel@gmail.com", 2304, null, "/Resources/angel.jpg"));
        persons.add(new Admin("Samantha", "Chub", 19, "sami@gmail.com", 12345, null, "/Resources/sami.jpg"));
        persons.add(new User(2304, 1000, 2000, "Josselin", "Tot", 20, "2304", 2304, new GregorianCalendar(2021, 7, 1, 12, 30, 0).getTime(), "/Resources/jossi.jpg"));
        //addUsers(persons);
        boolean saved = Helper.saveObjectToFile(persons, "/Files/Persons.txt");
        System.out.println(saved);

        ArrayList<Ticket> tickets = new ArrayList();
        tickets.add(new Ticket(1, 10));
        tickets.add(new Ticket(5, 10));
        tickets.add(new Ticket(10, 10));
        tickets.add(new Ticket(20, 10));
        tickets.add(new Ticket(50, 10));
        tickets.add(new Ticket(100, 10));
        tickets.add(new Ticket(200, 10));
        saved = Helper.saveObjectToFile(tickets, "/Files/Tickets.txt");
        System.out.println(saved);

        Properties properties = new Properties("", 0, persons.get(2));
        saved = Helper.saveObjectToFile(properties, "/Files/Properties.txt");
        System.out.println(saved);
    }

    private static void addUsers(ArrayList<Person> persons) {
        User jorgePerez = new User(1, 500, 1500, "Jorge", "Peréz", 25, "1", 123, new GregorianCalendar(2021, 1, 17, 18, 33, 2).getTime(), "/Resources/default.png");
        jorgePerez.viewLatestTransactions().add(new Transaction(100, Transaction.DEPOSIT, new GregorianCalendar(2021, 0, 16, 16, 9, 48).getTime()));
        jorgePerez.viewLatestTransactions().add(new Transaction(200, Transaction.DEPOSIT, new GregorianCalendar(2021, 0, 17, 13, 7, 4).getTime()));
        persons.add(jorgePerez);
    }
}
