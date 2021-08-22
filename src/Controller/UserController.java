package Controller;

import View.View;

/**
 *
 * @author samyc
 */
public class UserController implements Controller {

    public UserController() {
        events();
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

    //<editor-fold defaultstate="collapsed" desc="Init Update Pin Module">
    public void updatePin() {
        View.changePinView.oldPassword.setText("");
        View.changePinView.newPassword.setText("");
        View.changePinView.confirmPassword.setText("");
        View.changePinView.setVisible(true);
    }
    //</editor-fold>

}
