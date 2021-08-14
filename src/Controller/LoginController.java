package Controller;

import View.View;

/**
 *
 * @author Angel Ponce
 */
public class LoginController implements Controller {

    ATMController atmController;

    public LoginController() {
        atmController = new ATMController(this, null, null, null, null);
    }

    @Override
    public void start() {
        View.loginView.setVisible(true);
    }

    @Override
    public void end() {
    }

    @Override
    public void events() {
    }

}
