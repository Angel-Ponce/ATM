package Controller;

import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Model.Model;
import View.View;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class ATMController implements Controller {

    Model models;
    View views;
    LoginController loginController;
    UserController userController;
    AdminController adminController;
    ArrayList<Person>persons;
    ArrayList<Ticket>tickets;
    Properties properties;
    Person currentPerson;

    public ATMController(Model models, View views, LoginController loginController, ArrayList<Person> persons, ArrayList<Ticket> tickets, Properties propertie, Person currentPerson) {
        this.models = models;
        this.views = views;
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
