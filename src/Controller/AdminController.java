package Controller;

import View.View;

/**
 *
 * @author samyc
 */
public class AdminController implements Controller {

    public AdminController() {

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

    public void addUser() {
        View.atmView.content.removeAll();
        View.createUserView.name.setText("");
        View.createUserView.numberCard.setText("");
        View.createUserView.initialAmount.setText("");
        View.createUserView.maximumAmount.setText("");
        View.createUserView.pin.setText("");
        View.createUserView.pick.removeAll();
        View.atmView.content.add(View.createUserView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }

}
