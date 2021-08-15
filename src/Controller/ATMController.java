package Controller;

import Entity.Admin;
import Entity.Person;
import Entity.Properties;
import Entity.Ticket;
import Entity.User;
import Others.Helper;
import java.util.ArrayList;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        events();
    }

    @Override
    public void start() {
        //Sent propetys to system
        View.atmView.userName.setText(currentPerson.toString());
        View.atmView.user.setText(this.currentPerson.getName());
        View.atmView.pick.setIcon(Helper.roundImage(this.currentPerson.getPick(), 192, 192));
        //Check if the person is a User or Admin
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
        Helper.saveObjectToFile(persons, "/Files/Persons.txt");
        viewButtons();
        View.atmView.dispose();
    }

    @Override
    public void events() {
        View.atmView.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                end();
                loginController.start();
            }
        });
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

    private void viewButtons() {
        View.atmView.deposit.setVisible(true);
        View.atmView.retreat.setVisible(true);
        View.atmView.updatePin.setVisible(true);
        View.atmView.amount.setVisible(true);
        View.atmView.transactions.setVisible(true);
        View.atmView.addUser.setVisible(true);
        View.atmView.initATM.setVisible(true);
        View.atmView.addCash.setVisible(true);
        View.atmView.updateCard.setVisible(true);
        View.atmView.updateLimit.setVisible(true);
        View.atmView.userConsult.setVisible(true);
        View.atmView.userControl.setVisible(true);

    }

}
