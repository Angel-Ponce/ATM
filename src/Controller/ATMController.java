package Controller;

import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import java.util.ArrayList;
import View.View;

/**
 *
 * @author Angel Ponce
 */
public class ATMController implements Controller {

    LoginController loginController;
    UserController userController;
    AdminController adminController;
    private ArrayList<Person> persons;
    private ArrayList<Ticket> tickets;
    private Properties properties;
    private Person currentPerson;

    public ATMController(LoginController loginController, ArrayList<Person> persons, ArrayList<Ticket> tickets, Properties propertie, Person currentPerson) {
        this.loginController = loginController;
        this.persons = persons;
        this.tickets = tickets;
        this.properties = propertie;
        this.currentPerson = currentPerson;
    }

    @Override
    public void start() {
        View.atmView.userName.setText(currentPerson.toString());
        View.atmView.setVisible(true);
    }

    @Override
    public void end() {
    }

    @Override
    public void events() {
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

}
