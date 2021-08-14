package Controller;

import Entity.Person;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Angel Ponce
 */
public class LoginController implements Controller {

    ATMController atmController;
     ArrayList<Person>persons;

    public LoginController() {
        atmController = new ATMController(this, null, null, null, null);
        
    }

    @Override
    public void start() {
        View.loginView.setVisible(true);
        persons=Model.LoginModel.getPersons();
       
    }

    @Override
    public void end() {
    }

    @Override
    public void events() {
        View.loginView.signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //Model.LoginModel.authenticate(email, 0, persons);
            }
        });
    }

}
