package Controller;

import Entity.Person;
import Others.Helper;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Angel Ponce
 */
public class LoginController implements Controller {

    ATMController atmController;
    public static ArrayList<Person> persons;

    public LoginController() {
        atmController = new ATMController(this);
        this.events();
    }

    @Override
    public void start() {
        View.loginView.email.setText("");
        View.loginView.password.setText("");
        View.loginView.setVisible(true);
        persons = Model.LoginModel.getPersons();
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
                            ATMController.currentPerson = authenticated.get();
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

        View.loginView.password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    String email = View.loginView.email.getText();
                    String password = String.valueOf(View.loginView.password.getPassword());
                    if (!email.trim().isEmpty() && !password.isEmpty()) {
                        if (password.matches("\\d+")) {
                            int pin = Integer.parseInt(password);
                            Optional<Person> authenticated = Model.LoginModel.authenticate(email, pin, persons);
                            if (authenticated.isPresent()) {
                                //Enter to the system
                                ATMController.currentPerson = authenticated.get();
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
            }
        });
    }

}
