package Controller;

import Model.Model;
import View.View;

/**
 *
 * @author samyc
 */
public class AdminController implements Controller {

    Model models;
    View views;

    public AdminController(Model models, View views) {
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
