package Controller;

import Entity.Ticket;
import Entity.User;
import Others.Helper;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFormattedTextField;

/**
 *
 * @author samyc
 */
public class AdminController implements Controller {

    public AdminController() {
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
        /*
            Events Area
         */

        //<editor-fold defaultstate="collapsed" desc="Choose a Pick Event">
        View.createUserView.choosePick.addActionListener(((ae) -> {
            int opened = View.createUserView.fileChooser.showOpenDialog(View.createUserView);
            if (opened == 0) {
                File file = View.createUserView.fileChooser.getSelectedFile();
                if (file != null) {
                    if (file.getName().matches(".*\\.(png|PNG|jpe?g|JPE?G|)")) {
                        View.createUserView.pick.setIcon(Helper.roundImage(file, 256, 256));
                    } else {
                        Helper.error("Error, the file would be a Image");
                    }
                }
            }
        }));
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add User Event">
        View.createUserView.save.addActionListener((ae) -> {
            String name = View.createUserView.name.getText();
            String lastName = View.createUserView.lastName.getText();
            String email = View.createUserView.email.getText();
            String numberCard = View.createUserView.numberCard.getText();
            String pin = View.createUserView.pin.getText();
            String initialAmount = View.createUserView.initialAmount.getText();
            String maximumAmount = View.createUserView.maximumAmount.getText();
            File pick = View.createUserView.fileChooser.getSelectedFile();
            String age = View.createUserView.age.getText();
            if (!name.isEmpty() && !lastName.isEmpty()) {
                if (!email.isEmpty()) {
                    if (numberCard.matches("\\d+")) {
                        if (pin.matches("\\d+")) {
                            if (initialAmount.matches("\\d+")) {
                                if (maximumAmount.matches("\\d+")) {
                                    if (pick != null) {
                                        try {
                                            BufferedImage buffer = ImageIO.read(pick);
                                            boolean moved = ImageIO.write(buffer, "png", new File(System.getProperty("user.dir") + "/src/Resources/" + pick.getName()));
                                            if (moved) {
                                                User user = new User(Integer.valueOf(numberCard), Integer.valueOf(initialAmount), Integer.valueOf(maximumAmount), name, lastName, Integer.valueOf(age), email, Integer.valueOf(pin), null, "/Resources/" + pick.getName());
                                                if (Model.AdminModel.addUser(user)) {
                                                    Helper.success("User added successfly");
                                                    View.createUserView.name.setText("");
                                                    View.createUserView.lastName.setText("");
                                                    View.createUserView.email.setText("");
                                                    View.createUserView.age.setText("");
                                                    View.createUserView.numberCard.setText("");
                                                    View.createUserView.pin.setText("");
                                                    View.createUserView.initialAmount.setText("");
                                                    View.createUserView.maximumAmount.setText("");
                                                    View.createUserView.fileChooser.setSelectedFile(null);
                                                    View.createUserView.pick.setIcon(Helper.roundImage("/Resources/default.png", 256, 256));
                                                } else {
                                                    Helper.error("The user cant be added");
                                                }
                                            } else {
                                                Helper.error("An error ocurred while we move the pick");
                                            }
                                        } catch (IOException ex) {
                                            Helper.error("An error ocurred while we load the pick");
                                        }
                                    } else {
                                        Helper.error("The pick is required");
                                    }
                                } else {
                                    Helper.error("The maximum amount is a integer number, and is required");
                                }
                            } else {
                                Helper.error("The initial amount is a integer number, and is required");
                            }
                        } else {
                            Helper.error("The pin is a number, and is required");
                        }
                    } else {
                        Helper.error("The number card is a number, and is required");
                    }
                } else {
                    Helper.error("The email is required");
                }
            } else {
                Helper.error("The name and lastname are required");
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Init ATM Event">
        PropertyChangeListener ticketEvent = (PropertyChangeEvent evt) -> {
            try {
                int $1 = Integer.parseInt(View.initATMView.$1.getText()) * 1;
                int $5 = Integer.parseInt(View.initATMView.$5.getText()) * 5;
                int $10 = Integer.parseInt(View.initATMView.$10.getText()) * 10;
                int $20 = Integer.parseInt(View.initATMView.$20.getText()) * 20;
                int $50 = Integer.parseInt(View.initATMView.$50.getText()) * 50;
                int $100 = Integer.parseInt(View.initATMView.$100.getText()) * 100;
                int $200 = Integer.parseInt(View.initATMView.$200.getText()) * 200;
                if (($1 + $5 + $10 + $20 + $50 + $100 + $200) <= 10000) {
                    View.initATMView.limitBar.setValue($1 + $5 + $10 + $20 + $50 + $100 + $200);
                } else {
                    Helper.error("The maximum limit is $10000");
                    JFormattedTextField field = (JFormattedTextField) evt.getSource();
                    field.setText("0");
                }
            } catch (NumberFormatException e) {
                System.err.println(e);
            }

        };
        View.initATMView.$1.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.$5.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.$10.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.$20.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.$50.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.$100.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.$200.addPropertyChangeListener("value", ticketEvent);
        View.initATMView.save.addActionListener((ActionEvent e) -> {
            try {
                int $1 = Integer.parseInt(View.initATMView.$1.getText());
                int $5 = Integer.parseInt(View.initATMView.$5.getText());
                int $10 = Integer.parseInt(View.initATMView.$10.getText());
                int $20 = Integer.parseInt(View.initATMView.$20.getText());
                int $50 = Integer.parseInt(View.initATMView.$50.getText());
                int $100 = Integer.parseInt(View.initATMView.$100.getText());
                int $200 = Integer.parseInt(View.initATMView.$200.getText());
                if (Model.AdminModel.initATM($1, $5, $10, $20, $50, $100, $200)) {
                    Helper.success("Tickets saved correctly");
                } else {
                    Helper.error("Something went wrong");
                }
            } catch (NumberFormatException er) {
                Helper.error("Tickets must be numeric values");
            }

        });
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add cash Event">
        PropertyChangeListener addCashEvent = (PropertyChangeEvent pce) -> {
            try {
                int $1new = Integer.parseInt(View.addCashView.$1new.getText()) * 1 + Integer.parseInt(View.addCashView.$1actual.getText()) * 1;
                int $5new = Integer.parseInt(View.addCashView.$5new.getText()) * 5 + Integer.parseInt(View.addCashView.$5actual.getText()) * 5;
                int $10new = Integer.parseInt(View.addCashView.$10new.getText()) * 10 + Integer.parseInt(View.addCashView.$10actual.getText()) * 10;
                int $20new = Integer.parseInt(View.addCashView.$20new.getText()) * 20 + Integer.parseInt(View.addCashView.$20actual.getText()) * 20;
                int $50new = Integer.parseInt(View.addCashView.$50new.getText()) * 50 + Integer.parseInt(View.addCashView.$50actual.getText()) * 50;
                int $100new = Integer.parseInt(View.addCashView.$100new.getText()) * 100 + Integer.parseInt(View.addCashView.$100actual.getText()) * 100;
                int $200new = Integer.parseInt(View.addCashView.$200new.getText()) * 200 + Integer.parseInt(View.addCashView.$200actual.getText()) * 200;
                if (($1new + $5new + $10new + $20new + $50new + $100new + $200new) <= 30000) {
                    View.addCashView.limitBar.setValue($1new + $5new + $10new + $20new + $50new + $100new + $200new);
                } else {
                    Helper.error("The maximum limit is $30000");
                    JFormattedTextField field = (JFormattedTextField) pce.getSource();
                    field.setText("0");
                }
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        };
        View.addCashView.$1new.addPropertyChangeListener("value", addCashEvent);
        View.addCashView.$5new.addPropertyChangeListener("value", addCashEvent);
        View.addCashView.$10new.addPropertyChangeListener("value", addCashEvent);
        View.addCashView.$20new.addPropertyChangeListener("value", addCashEvent);
        View.addCashView.$50new.addPropertyChangeListener("value", addCashEvent);
        View.addCashView.$100new.addPropertyChangeListener("value", addCashEvent);
        View.addCashView.$200new.addPropertyChangeListener("value", addCashEvent);

        View.addCashView.save.addActionListener((ae) -> {
            try {
                int $1new = Integer.parseInt(View.addCashView.$1new.getText()) + Integer.parseInt(View.addCashView.$1actual.getText());
                int $5new = Integer.parseInt(View.addCashView.$5new.getText()) + Integer.parseInt(View.addCashView.$5actual.getText());
                int $10new = Integer.parseInt(View.addCashView.$10new.getText()) + Integer.parseInt(View.addCashView.$10actual.getText());
                int $20new = Integer.parseInt(View.addCashView.$20new.getText()) + Integer.parseInt(View.addCashView.$20actual.getText());
                int $50new = Integer.parseInt(View.addCashView.$50new.getText()) + Integer.parseInt(View.addCashView.$50actual.getText());
                int $100new = Integer.parseInt(View.addCashView.$100new.getText()) + Integer.parseInt(View.addCashView.$100actual.getText());
                int $200new = Integer.parseInt(View.addCashView.$200new.getText()) + Integer.parseInt(View.addCashView.$200actual.getText());
                if (Model.AdminModel.addCash($1new, $5new, $10new, $20new, $50new, $100new, $200new)) {
                    Helper.success("Cash added success");
                } else {
                    Helper.error("Something went wrong");
                }
            } catch (Exception e) {
                Helper.error("Tickets must be a numeric values");
            }
        });
        //</editor-fold>
    }

    /**
     * Methods area
     */
    //<editor-fold defaultstate="collapsed" desc="Init add User Module">
    public void addUser() {
        View.atmView.content.removeAll();
        View.createUserView.name.setText("");
        View.createUserView.lastName.setText("");
        View.createUserView.email.setText("");
        View.createUserView.age.setText("");
        View.createUserView.numberCard.setText("");
        View.createUserView.initialAmount.setText("");
        View.createUserView.maximumAmount.setText("");
        View.createUserView.pin.setText("");
        View.createUserView.pick.setIcon(Helper.roundImage("/Resources/default.png", 256, 256));
        View.createUserView.fileChooser.setSelectedFile(null);
        View.atmView.content.add(View.createUserView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init ATM Module">
    public void initATM() {
        View.atmView.content.removeAll();
        ArrayList<Ticket> tickets = Model.ATMModel.getTickets();
        View.initATMView.$1.setText(tickets.get(0).getSize() + "");
        View.initATMView.$5.setText(tickets.get(1).getSize() + "");
        View.initATMView.$10.setText(tickets.get(2).getSize() + "");
        View.initATMView.$20.setText(tickets.get(3).getSize() + "");
        View.initATMView.$50.setText(tickets.get(4).getSize() + "");
        View.initATMView.$100.setText(tickets.get(5).getSize() + "");
        View.initATMView.$200.setText(tickets.get(6).getSize() + "");
        int total = (int) tickets.stream().mapToDouble(ticket -> ticket.getSize() * ticket.getType()).sum();
        View.initATMView.limitBar.setValue(total);
        View.atmView.content.add(View.initATMView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init add cash Module">
    public void addCash() {
        View.atmView.content.removeAll();
        ArrayList<Ticket> tickets = Model.ATMModel.getTickets();
        View.addCashView.$1actual.setText("" + tickets.get(0).getSize());
        View.addCashView.$5actual.setText("" + tickets.get(1).getSize());
        View.addCashView.$10actual.setText("" + tickets.get(2).getSize());
        View.addCashView.$20actual.setText("" + tickets.get(3).getSize());
        View.addCashView.$50actual.setText("" + tickets.get(4).getSize());
        View.addCashView.$100actual.setText("" + tickets.get(5).getSize());
        View.addCashView.$200actual.setText("" + tickets.get(6).getSize());
        View.addCashView.$1new.setText("0");
        View.addCashView.$5new.setText("0");
        View.addCashView.$10new.setText("0");
        View.addCashView.$20new.setText("0");
        View.addCashView.$50new.setText("0");
        View.addCashView.$100new.setText("0");
        View.addCashView.$200new.setText("0");
        int total = (int) tickets.stream().mapToDouble(ticket -> ticket.getType() * ticket.getSize()).sum();
        View.addCashView.limitBar.setValue(total);
        View.atmView.content.add(View.addCashView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init Update card Module">
    public void updateCard() {
        View.changeCardNumberView.setVisible(true);
    }
    //</editor-fold>
}
