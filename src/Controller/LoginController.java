package Controller;

import Entity.Person;
import Others.Helper;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Angel Ponce
 */
public class LoginController implements Controller {

    ATMController atmController;
    ArrayList<Person> persons;

    public LoginController() {
        atmController = new ATMController(this, null, null, null, null);
        this.events();
    }

    @Override
    public void start() {
        persons = Model.LoginModel.getPersons();
        View.loginView.setVisible(true);
    }

    @Override
    public void end() {
        View.loginView.dispose();
    }

    @Override
    public void events() {
        View.loginView.signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = View.loginView.email.getText();
                String password = String.valueOf(View.loginView.password.getPassword());
                if (!email.trim().isEmpty() && !password.isEmpty()) {
                    if (password.matches("\\d+")) {
                        int pin = Integer.parseInt(password);
                        Optional<Person> authenticated = Model.LoginModel.authenticate(email, pin, persons);
                        if (authenticated.isPresent()) {
                            //Enter to the system
                            atmController.setPersons(persons);
                            atmController.setCurrentPerson(authenticated.get());
                            atmController.start();
                            end();
                        } else {
                            Helper.error("Email or password are invalid");
                        }
                    } else {
                        Helper.error("The pin would be a number");
                    }
                } else {
                    Helper.error("The email and pin are required");
                }
            }
        });
    }

}
