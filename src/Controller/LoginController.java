package Controller;

import Model.Model;
import View.View;

/**
 *
 * @author Angel Ponce
 */
public class LoginController implements Controller {

    Model models;
    View views;
    ATMController atmController;

    public LoginController(Model models, View views) {
        this.models = models;
        this.views = views;
       
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
