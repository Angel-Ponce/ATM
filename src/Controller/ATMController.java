package Controller;

import Entity.Admin;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Entity.User;
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
        if (this.currentPerson instanceof Admin) {
            View.atmView.deposit.setVisible(false);
            View.atmView.retreat.setVisible(false);
            View.atmView.updatePin.setVisible(false);
            View.atmView.amount.setVisible(false);
            View.atmView.transactions.setVisible(false);
        } else if (this.currentPerson instanceof User) {
            View.atmView.addUser.setVisible(false);
            View.atmView.initATM.setVisible(false);
            View.atmView.addCash.setVisible(false);
            View.atmView.updateCard.setVisible(false);
            View.atmView.updateLimit.setVisible(false);
            View.atmView.userConsult.setVisible(false);
            View.atmView.userControl.setVisible(false);
        }
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
