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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 *
 * @author Angel Ponce
 */
public class ATMController implements Controller {

    LoginController loginController;
    UserController userController;
    AdminController adminController;
    public static ArrayList<Ticket> tickets;
    public static Properties properties;
    public static Person currentPerson;

    public ATMController(LoginController loginController) {
        this.loginController = loginController;
        userController = new UserController();
        adminController = new AdminController();
        events();
    }

    @Override
    public void start() {
        //Read data
        tickets = Model.ATMModel.getTickets();
        properties = Model.ATMModel.getProperties();
        //Sent propetys to system
        View.atmView.userName.setText(currentPerson.toString());
        View.atmView.user.setText(ATMController.currentPerson.getName());
        View.atmView.pick.setIcon(Helper.roundImage(ATMController.currentPerson.getPick(), 192, 192));
        Model.ATMModel.updateLastAccess(currentPerson, new Date());
        //Check if the person is a User or Admin
        if (ATMController.currentPerson instanceof Admin) {
            View.atmView.deposit.setVisible(false);
            View.atmView.retreat.setVisible(false);
            View.atmView.updatePin.setVisible(false);
            View.atmView.amount.setVisible(false);
            View.atmView.transactions.setVisible(false);
        } else if (ATMController.currentPerson instanceof User) {
            View.atmView.addUser.setVisible(false);
            View.atmView.initATM.setVisible(false);
            View.atmView.addCash.setVisible(false);
            View.atmView.updateCard.setVisible(false);
            View.atmView.updateLimit.setVisible(false);
            View.atmView.userConsult.setVisible(false);
            View.atmView.userControl.setVisible(false);
        }
        View.atmView.content.removeAll();
        View.atmView.setVisible(true);
        View.atmView.repaint();
        View.atmView.pack();
    }

    @Override
    public void end() {
        Model.ATMModel.logout(currentPerson instanceof User ? currentPerson : properties.getLastPerson());
        viewButtons();
        View.atmView.dispose();
    }

    @Override
    public void events() {
        View.atmView.logout.addActionListener((ActionEvent ae) -> {
            end();
            loginController.start();
        });

        View.atmView.addUser.addActionListener((ActionEvent ae) -> {
            adminController.addUser();
        });

        View.atmView.initATM.addActionListener((ae) -> {
            adminController.initATM();
        });

        View.atmView.addCash.addActionListener((ae) -> {
            adminController.addCash();
        });

        View.atmView.updateCard.addActionListener((ae) -> {
            adminController.updateCard();
        });

        View.atmView.updateLimit.addActionListener((ae) -> {
            adminController.updateLimit();
        });

        View.atmView.userConsult.addActionListener((ae) -> {
            adminController.userConsult();
        });

        View.atmView.userControl.addActionListener((ae) -> {
            adminController.userControl();
        });

        View.atmView.updatePin.addActionListener((ae) -> {
            userController.updatePin();
        });

        View.atmView.retreat.addActionListener((ae) -> {
            userController.retreat();
        });

        View.atmView.deposit.addActionListener((ae) -> {
            userController.deposit();
        });

        View.atmView.transactions.addActionListener((ae) -> {
            userController.transactions();
        });

        View.atmView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                end();
                loginController.start();
            }
        });
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
