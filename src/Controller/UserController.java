package Controller;

import Entity.Person;
import Entity.User;
import Model.Model;
import Others.Helper;
import View.View;
import java.util.Optional;

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
//<editor-fold defaultstate="collapsed" desc="Change pin event">
        View.changePinView.save.addActionListener((e) -> {
            String oldPin = String.valueOf(View.changePinView.oldPassword.getPassword());
            String newPin = String.valueOf(View.changePinView.newPassword.getPassword());
            String confirmPin = String.valueOf(View.changePinView.confirmPassword.getPassword());
            if (oldPin.matches("\\d+")) {
                if (newPin.matches("\\d+")) {
                    if (confirmPin.matches("\\d+")) {
                        if (newPin.equals(confirmPin)) {
                            if (oldPin.equals(ATMController.currentPerson.getPin()+"")) {
                                if (Model.userModel.changePin(Integer.parseInt(newPin), ATMController.currentPerson)) {
                                    Helper.success("The new pin has been saved successfully");
                                    View.changePinView.oldPassword.setText("");
                                    View.changePinView.newPassword.setText("");
                                    View.changePinView.confirmPassword.setText("");
                                } else {
                                    Helper.error("Something went wrong");
                                }
                            } else {
                                Helper.error("The old pin is wrong");
                            }
                            
                        } else {
                            Helper.error("The pins are not the same");
                        }
                    } else {
                        Helper.error("The pin must be a numeric value");
                    }
                } else {
                    Helper.error("Please fill in the new card field");
                }
            } else {
                Helper.error("Please fill in the old card field");
            }
        });

//</editor-fold>
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
