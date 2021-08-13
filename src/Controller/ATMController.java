package Controller;

import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class ATMController implements Controller {

    LoginController loginController;
    UserController userController;
    AdminController adminController;
    ArrayList<Person> persons;
    ArrayList<Ticket> tickets;
    Properties properties;
    Person currentPerson;

    public ATMController(LoginController loginController, ArrayList<Person> persons, ArrayList<Ticket> tickets, Properties propertie, Person currentPerson) {
        this.loginController = loginController;
        this.persons = persons;
        this.tickets = tickets;
        this.properties = propertie;
        this.currentPerson = currentPerson;
    }

    @Override
    public void start() {
    }

    @Override
    public void end() {
    }

    @Override
    public void events() {
    }

}
