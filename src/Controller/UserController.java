package Controller;

import Entity.Ticket;
import Model.UserModel;
import Others.Helper;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author samyc
 */
public class UserController implements Controller {

    private int totalRetreated = 0;
    private final NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
    private ArrayList<Ticket> temporalyTickets = new ArrayList();

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
                            if (oldPin.equals(String.valueOf(ATMController.currentPerson.getPin()))) {
                                if (Model.UserModel.changePin(Integer.parseInt(newPin), ATMController.currentPerson)) {
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
                    Helper.error("The new pin must be a numeric value");
                }
            } else {
                Helper.error("The old pin must be a numeric value");
            }
        });

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Retreat Event">
        ActionListener retreatEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == View.retreatView.$1) {
                    if (temporalyTickets.get(0).getSize() > 0) {
                        totalRetreated++;
                        temporalyTickets.get(0).setSize(temporalyTickets.get(0).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $1 are over");
                    }
                } else if (ae.getSource() == View.retreatView.$5) {
                    if (temporalyTickets.get(1).getSize() > 0) {
                        totalRetreated += 5;
                        temporalyTickets.get(1).setSize(temporalyTickets.get(1).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $5 are over");
                    }
                } else if (ae.getSource() == View.retreatView.$10) {
                    if (temporalyTickets.get(2).getSize() > 0) {
                        totalRetreated += 10;
                        temporalyTickets.get(2).setSize(temporalyTickets.get(2).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $10 are over");
                    }
                } else if (ae.getSource() == View.retreatView.$20) {
                    if (temporalyTickets.get(3).getSize() > 0) {
                        totalRetreated += 20;
                        temporalyTickets.get(3).setSize(temporalyTickets.get(3).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $20 are over");
                    }
                } else if (ae.getSource() == View.retreatView.$50) {
                    if (temporalyTickets.get(4).getSize() > 0) {
                        totalRetreated += 50;
                        temporalyTickets.get(4).setSize(temporalyTickets.get(4).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $50 are over");
                    }
                } else if (ae.getSource() == View.retreatView.$100) {
                    if (temporalyTickets.get(5).getSize() > 0) {
                        totalRetreated += 100;
                        temporalyTickets.get(5).setSize(temporalyTickets.get(5).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $100 are over");
                    }
                } else if (ae.getSource() == View.retreatView.$200) {
                    if (temporalyTickets.get(6).getSize() > 0) {
                        totalRetreated += 200;
                        temporalyTickets.get(6).setSize(temporalyTickets.get(6).getSize() - 1);
                    } else {
                        Helper.error("Tickets of $200 are over");
                    }
                }
                View.retreatView.total.setText(format.format(totalRetreated));
            }
        };

        View.retreatView.$1.addActionListener(retreatEvent);
        View.retreatView.$5.addActionListener(retreatEvent);
        View.retreatView.$10.addActionListener(retreatEvent);
        View.retreatView.$20.addActionListener(retreatEvent);
        View.retreatView.$50.addActionListener(retreatEvent);
        View.retreatView.$100.addActionListener(retreatEvent);
        View.retreatView.$200.addActionListener(retreatEvent);

        View.retreatView.save.addActionListener((ae) -> {
            String pin = String.valueOf(View.retreatView.pin.getPassword());
            if (pin.matches("\\d+")) {
                if (ATMController.currentPerson.getPin() == Integer.parseInt(pin)) {
                    if (Helper.personToUser(ATMController.currentPerson).getMaximumAmount() >= totalRetreated) {
                        if (Helper.personToUser(ATMController.currentPerson).getCurrentBalance() >= totalRetreated) {
                            if (UserModel.retreat(totalRetreated, ATMController.currentPerson)) {
                                Helper.success("Operation success");
                                Model.AdminModel.addCash(
                                        temporalyTickets.get(0).getSize(),
                                        temporalyTickets.get(1).getSize(),
                                        temporalyTickets.get(2).getSize(),
                                        temporalyTickets.get(3).getSize(),
                                        temporalyTickets.get(4).getSize(),
                                        temporalyTickets.get(5).getSize(),
                                        temporalyTickets.get(6).getSize()
                                );
                                totalRetreated = 0;
                                View.retreatView.total.setText("");
                                View.retreatView.pin.setText("");
                            } else {
                                Helper.error("Something went wrong");
                            }
                        } else {
                            Helper.error("The money is insufficient");
                        }
                    } else {
                        Helper.error("Limit of retreat is over");
                    }
                } else {
                    Helper.error("The pin is incorrectly");
                }
            } else {
                Helper.error("The pin must be a numeric value");
            }
        });

        View.retreatView.reset.addActionListener((ae) -> {
            View.retreatView.total.setText("");
            View.retreatView.pin.setText("");
            totalRetreated = 0;
            temporalyTickets.clear();
            for (Ticket t : ATMController.tickets) {
                this.temporalyTickets.add(new Ticket(t.getType(), t.getSize()));
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

    //<editor-fold defaultstate="collapsed" desc="Init Retreat Module">
    public void retreat() {
        View.atmView.content.removeAll();
        this.temporalyTickets.clear();
        this.totalRetreated = 0;
        View.retreatView.total.setText("");
        View.retreatView.pin.setText("");
        for (Ticket t : ATMController.tickets) {
            this.temporalyTickets.add(new Ticket(t.getType(), t.getSize()));
        }
        View.atmView.content.add(View.retreatView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>
}
