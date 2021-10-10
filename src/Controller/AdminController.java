package Controller;

import Entity.Person;
import Entity.Ticket;
import Entity.Transaction;
import Entity.User;
import Others.Helper;
import View.JUser;
import View.View;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.JFormattedTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import Others.Process;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

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
                    if (numberCard.matches("\\d+") && numberCard.equals(email) && numberCard.length() == 16) {
                        if (pin.matches("\\d+") && pin.length() == 4) {
                            if (initialAmount.matches("\\d+")) {
                                if (maximumAmount.matches("\\d+")) {
                                    if (!Model.LoginModel.alreadyExist(email, LoginController.persons)) {
                                        if (pick != null) {
                                            try {
                                                BufferedImage buffer = ImageIO.read(pick);
                                                boolean moved = ImageIO.write(buffer, "png", new File("database/profiles/" + pick.getName()));
                                                if (moved) {
                                                    User user = new User(Long.valueOf(numberCard), Integer.valueOf(initialAmount), Integer.valueOf(maximumAmount), name, lastName, Integer.valueOf(age), email, Integer.valueOf(pin), null, "database/profiles/" + pick.getName());
                                                    if (Model.AdminModel.addUser(user, Helper.personToAdmin(ATMController.currentPerson))) {
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
                                                        View.createUserView.pick.setIcon(Helper.roundImage(getClass().getResource("/Resources/default.png"), 256, 256));
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
                                        Helper.error("This email already is in use");
                                        View.createUserView.email.setText("");
                                        View.createUserView.numberCard.setText("");
                                    }
                                } else {
                                    Helper.error("The maximum amount is a integer number, and is required");
                                }
                            } else {
                                Helper.error("The initial amount is a integer number, and is required");
                            }
                        } else {
                            Helper.error("The pin is a number, and is required\n The pin don't have 4 characters");
                        }
                    } else {
                        Helper.error("The number card is a number, and is required\nThe number card and email they must be equals\nThe number card don't have 16 characters");
                    }
                } else {
                    Helper.error("The email is required");
                }
            } else {
                Helper.error("The name and lastname are required");
            }
        });
        View.createUserView.email.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                String email = View.createUserView.email.getText();
                if (email.matches("\\d+")) {
                    if (email.matches("0+\\d*")) {
                        email = email.replaceAll("0", "");
                    }
                    if (email.length() >= 16) {
                        String numberCard = email.trim().substring(0, 16);
                        View.createUserView.email.setText(numberCard);
                        View.createUserView.numberCard.setText(numberCard);
                    } else {
                        View.createUserView.numberCard.setText(email);
                        View.createUserView.email.setText(email);
                    }
                } else {
                    View.createUserView.email.setText(email.replaceAll("\\D*", ""));
                    View.createUserView.numberCard.setText(email.replaceAll("\\D*", ""));
                }
            }
        });

        View.createUserView.pin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                String pin = View.createUserView.pin.getText();
                if (pin.matches("\\d+")) {
                    if (pin.matches("0+\\d*")) {
                        pin = pin.replaceAll("0", "");
                    }
                    if (pin.length() >= 4) {
                        View.createUserView.pin.setText(pin.substring(0, 4));
                    } else {
                        View.createUserView.pin.setText(pin);
                    }
                } else {
                    View.createUserView.pin.setText(pin.replaceAll("\\D*", ""));
                }
            }
        });
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Init ATM Event">
        FocusListener ticketEvent = new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {
                JFormattedTextField field = (JFormattedTextField) fe.getSource();
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
                        field.setText("0");
                        $1 = Integer.parseInt(View.initATMView.$1.getText()) * 1;
                        $5 = Integer.parseInt(View.initATMView.$5.getText()) * 5;
                        $10 = Integer.parseInt(View.initATMView.$10.getText()) * 10;
                        $20 = Integer.parseInt(View.initATMView.$20.getText()) * 20;
                        $50 = Integer.parseInt(View.initATMView.$50.getText()) * 50;
                        $100 = Integer.parseInt(View.initATMView.$100.getText()) * 100;
                        $200 = Integer.parseInt(View.initATMView.$200.getText()) * 200;
                        View.initATMView.limitBar.setValue($1 + $5 + $10 + $20 + $50 + $100 + $200);
                        Helper.error("The maximum limit is $10000");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e);
                }
            }
        };
        View.initATMView.$1.addFocusListener(ticketEvent);
        View.initATMView.$5.addFocusListener(ticketEvent);
        View.initATMView.$10.addFocusListener(ticketEvent);
        View.initATMView.$20.addFocusListener(ticketEvent);
        View.initATMView.$50.addFocusListener(ticketEvent);
        View.initATMView.$100.addFocusListener(ticketEvent);
        View.initATMView.$200.addFocusListener(ticketEvent);
        View.initATMView.save.addActionListener(
                (ActionEvent e) -> {
                    try {
                        int $1 = Integer.parseInt(View.initATMView.$1.getText());
                        int $5 = Integer.parseInt(View.initATMView.$5.getText());
                        int $10 = Integer.parseInt(View.initATMView.$10.getText());
                        int $20 = Integer.parseInt(View.initATMView.$20.getText());
                        int $50 = Integer.parseInt(View.initATMView.$50.getText());
                        int $100 = Integer.parseInt(View.initATMView.$100.getText());
                        int $200 = Integer.parseInt(View.initATMView.$200.getText());
                        if (Model.AdminModel.initATM($1, $5, $10, $20, $50, $100, $200, Helper.personToAdmin(ATMController.currentPerson))) {
                            Helper.success("Tickets saved correctly");
                            View.atmView.addCash.setEnabled(true);
                            ATMController.properties.setDate(ATMController.DATE_FORMAT.format(new Date()));
                        } else {
                            Helper.error("Something went wrong");
                        }
                    } catch (NumberFormatException er) {
                        Helper.error("Tickets must be numeric values");
                    }

                }
        );
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Add cash Event">
        FocusListener addCashEvent = new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
            }

            @Override
            public void focusLost(FocusEvent fe) {
                JFormattedTextField field = (JFormattedTextField) fe.getSource();
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
                        field.setText("0");
                        $1new = Integer.parseInt(View.addCashView.$1new.getText()) * 1 + Integer.parseInt(View.addCashView.$1actual.getText()) * 1;
                        $5new = Integer.parseInt(View.addCashView.$5new.getText()) * 5 + Integer.parseInt(View.addCashView.$5actual.getText()) * 5;
                        $10new = Integer.parseInt(View.addCashView.$10new.getText()) * 10 + Integer.parseInt(View.addCashView.$10actual.getText()) * 10;
                        $20new = Integer.parseInt(View.addCashView.$20new.getText()) * 20 + Integer.parseInt(View.addCashView.$20actual.getText()) * 20;
                        $50new = Integer.parseInt(View.addCashView.$50new.getText()) * 50 + Integer.parseInt(View.addCashView.$50actual.getText()) * 50;
                        $100new = Integer.parseInt(View.addCashView.$100new.getText()) * 100 + Integer.parseInt(View.addCashView.$100actual.getText()) * 100;
                        $200new = Integer.parseInt(View.addCashView.$200new.getText()) * 200 + Integer.parseInt(View.addCashView.$200actual.getText()) * 200;
                        View.addCashView.limitBar.setValue($1new + $5new + $10new + $20new + $50new + $100new + $200new);
                        Helper.error("The maximum limit is $30000");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e);
                }
            }
        };

        View.addCashView.$1new.addFocusListener(addCashEvent);
        View.addCashView.$5new.addFocusListener(addCashEvent);
        View.addCashView.$10new.addFocusListener(addCashEvent);
        View.addCashView.$20new.addFocusListener(addCashEvent);
        View.addCashView.$50new.addFocusListener(addCashEvent);
        View.addCashView.$100new.addFocusListener(addCashEvent);
        View.addCashView.$200new.addFocusListener(addCashEvent);
        View.addCashView.save.addActionListener((ae) -> {
            try {
                int $1new = Integer.parseInt(View.addCashView.$1new.getText()) + Integer.parseInt(View.addCashView.$1actual.getText());
                int $5new = Integer.parseInt(View.addCashView.$5new.getText()) + Integer.parseInt(View.addCashView.$5actual.getText());
                int $10new = Integer.parseInt(View.addCashView.$10new.getText()) + Integer.parseInt(View.addCashView.$10actual.getText());
                int $20new = Integer.parseInt(View.addCashView.$20new.getText()) + Integer.parseInt(View.addCashView.$20actual.getText());
                int $50new = Integer.parseInt(View.addCashView.$50new.getText()) + Integer.parseInt(View.addCashView.$50actual.getText());
                int $100new = Integer.parseInt(View.addCashView.$100new.getText()) + Integer.parseInt(View.addCashView.$100actual.getText());
                int $200new = Integer.parseInt(View.addCashView.$200new.getText()) + Integer.parseInt(View.addCashView.$200actual.getText());
                if (Model.AdminModel.addCash($1new, $5new, $10new, $20new, $50new, $100new, $200new, Helper.personToAdmin(ATMController.currentPerson))) {
                    Helper.success("Cash added success");
                    ArrayList<Ticket> tickets = ATMController.tickets;
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
                } else {
                    Helper.error("Something went wrong");
                }
            } catch (Exception e) {
                Helper.error("Tickets must be a numeric values");
            }
        }
        );
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Change card number Event">
        View.changeCardNumberView.save.addActionListener(
                (e) -> {
                    String oldCard = View.changeCardNumberView.oldCardNumber.getText();
                    String newCard = View.changeCardNumberView.newCardNumber.getText();
                    String pin = String.valueOf(View.changeCardNumberView.pin.getPassword());
                    if (!oldCard.isEmpty()) {
                        if (!newCard.isEmpty() && newCard.length() == 16) {
                            if (!Model.LoginModel.alreadyExist(newCard, LoginController.persons)) {
                                if (pin.matches("\\d+")) {
                                    Optional<Person> authenticated = Model.LoginModel.authenticate(oldCard, Integer.parseInt(pin), LoginController.persons);
                                    if (authenticated.isPresent()) {
                                        User user = (User) authenticated.get();
                                        if (Model.AdminModel.changeCardNumber(Long.parseLong(newCard), user, Helper.personToAdmin(ATMController.currentPerson))) {
                                            Helper.success("New card number has been update");
                                            View.changeCardNumberView.newCardNumber.setText("");
                                            View.changeCardNumberView.oldCardNumber.setText("");
                                            View.changeCardNumberView.pin.setText("");
                                        } else {
                                            Helper.error("Something went wrong");
                                        }

                                    } else {
                                        Helper.error("Invalid data");
                                    }
                                } else {
                                    Helper.error("The pin must be a numeric value");
                                }
                            } else {
                                Helper.error("The card already exist");
                            }
                        } else {
                            Helper.error("Please fill in the new card field\n The new card don't have 16 characters");
                        }
                    } else {
                        Helper.error("Please fill in the old card field");
                    }
                }
        );

        View.changeCardNumberView.newCardNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                String newCard = View.changeCardNumberView.newCardNumber.getText();
                if (newCard.matches("\\d+")) {
                    if (newCard.matches("0+\\d*")) {
                        newCard = newCard.replaceAll("0", "");
                    }
                    if (newCard.length() >= 16) {
                        String numberCard = newCard.trim().substring(0, 16);
                        View.changeCardNumberView.newCardNumber.setText(numberCard);
                    } else {
                        View.changeCardNumberView.newCardNumber.setText(newCard);
                    }
                } else {
                    View.changeCardNumberView.newCardNumber.setText(newCard.replaceAll("\\D*", ""));
                }
            }
        });

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Change limit Event">
        View.changeMaximumAmountView.save.addActionListener(
                (ae) -> {
                    String newLimit = View.changeMaximumAmountView.newLimit.getText();
                    String card = View.changeMaximumAmountView.cardNumber.getText();
                    String pin = String.valueOf(View.changeMaximumAmountView.pin.getPassword());
                    if (!newLimit.isEmpty()) {
                        if (!card.isEmpty()) {
                            if (pin.matches("\\d+")) {
                                Optional<Person> authenticated = Model.LoginModel.authenticate(card, Integer.parseInt(pin), LoginController.persons);
                                if (authenticated.isPresent()) {
                                    User user = (User) authenticated.get();
                                    if (Model.AdminModel.changeLimit(Integer.parseInt(newLimit), user, Helper.personToAdmin(ATMController.currentPerson))) {
                                        Helper.success("New limit has been update");
                                        View.changeMaximumAmountView.newLimit.setText("");
                                        View.changeMaximumAmountView.cardNumber.setText("");
                                        View.changeMaximumAmountView.pin.setText("");
                                    } else {
                                        Helper.error("Something went wrong");
                                    }

                                } else {
                                    Helper.error("Invalid data");
                                }
                            } else {
                                Helper.error("The pin must be a numeric value");
                            }
                        } else {
                            Helper.error("Please fill in the card field");
                        }
                    } else {
                        Helper.error("Please fill in the new limit field");
                    }
                }
        );

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
        View.createUserView.pick.setIcon(Helper.roundImage(getClass().getResource("/Resources/default.png"), 256, 256));
        View.createUserView.fileChooser.setSelectedFile(null);
        View.atmView.content.add(View.createUserView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init ATM Module">
    public void initATM() {
        View.atmView.content.removeAll();
        ArrayList<Ticket> tickets = ATMController.tickets;
        View.initATMView.$1.setText(tickets.get(0).getSize() + "");
        View.initATMView.$5.setText(tickets.get(1).getSize() + "");
        View.initATMView.$10.setText(tickets.get(2).getSize() + "");
        View.initATMView.$20.setText(tickets.get(3).getSize() + "");
        View.initATMView.$50.setText(tickets.get(4).getSize() + "");
        View.initATMView.$100.setText(tickets.get(5).getSize() + "");
        View.initATMView.$200.setText(tickets.get(6).getSize() + "");
        int total = (int) tickets.stream().mapToDouble(ticket -> ticket.getSize() * ticket.getType()).sum();
        View.initATMView.limitBar.setValue(total);
        if (ATMController.properties.getCurrentBalance() >= 10000) {
            View.initATMView.$1.setEnabled(false);
            View.initATMView.$5.setEnabled(false);
            View.initATMView.$10.setEnabled(false);
            View.initATMView.$20.setEnabled(false);
            View.initATMView.$50.setEnabled(false);
            View.initATMView.$100.setEnabled(false);
            View.initATMView.$200.setEnabled(false);
        } else {
            View.initATMView.$1.setEnabled(true);
            View.initATMView.$5.setEnabled(true);
            View.initATMView.$10.setEnabled(true);
            View.initATMView.$20.setEnabled(true);
            View.initATMView.$50.setEnabled(true);
            View.initATMView.$100.setEnabled(true);
            View.initATMView.$200.setEnabled(true);
        }
        View.atmView.content.add(View.initATMView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init add cash Module">
    public void addCash() {
        View.atmView.content.removeAll();
        ArrayList<Ticket> tickets = ATMController.tickets;
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

        View.changeCardNumberView.newCardNumber.setText("");
        View.changeCardNumberView.oldCardNumber.setText("");
        View.changeCardNumberView.pin.setText("");
        View.changeCardNumberView.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init Update Limit Module">
    public void updateLimit() {
        View.changeMaximumAmountView.newLimit.setText("");
        View.changeMaximumAmountView.cardNumber.setText("");
        View.changeMaximumAmountView.pin.setText("");
        View.changeMaximumAmountView.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init User Consult Module">
    public void userConsult() {

        View.atmView.content.removeAll();
        View.userConsultView.users.removeAll();
        View.userConsultView.actualAmount.setText("");
        View.userConsultView.retreats.setText("");
        View.userConsultView.maxRetreat.setText("");
        View.userConsultView.lastAccess.setText("");
        Process process = new Process() {
            @Override
            public void callback() {
                View.userConsultView.load.setMaximum(
                        (int) LoginController.persons.stream().filter(person -> person instanceof User).count()
                );
                int counter = 0;
                for (Person person : LoginController.persons) {
                    if (person instanceof User) {
                        View.userConsultView.users.add(new JUser((User) person));
                        counter++;
                        View.userConsultView.load.setValue(counter);
                    }
                }
                View.userConsultView.users.repaint();
                for (Component component : View.userConsultView.users.getComponents()) {
                    try {
                        JUser juser = (JUser) component;
                        ActionListener event = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    View.userConsultView.maxRetreat.setText(
                                            UserController.USD.format(juser.getUser().getMaximumAmount())
                                    );
                                    View.userConsultView.actualAmount.setText(
                                            UserController.USD.format(juser.getUser().getCurrentBalance())
                                    );
                                    View.userConsultView.retreats.setText(
                                            UserController.USD.format(juser.getUser().viewLatestTransactions().stream().mapToDouble(transaction -> {
                                                if (transaction.getType().equals(Transaction.RETREAT)) {
                                                    return transaction.getAmount();
                                                }
                                                return 0;
                                            }).sum())
                                    );
                                    View.userConsultView.lastAccess.setText(Person.dateFormat.format(juser.getUser().getLastAccess()));
                                } catch (Exception e2) {
                                }
                            }
                        };
                        juser.name.addActionListener(event);
                        juser.pick.addActionListener(event);
                    } catch (Exception e) {
                    }
                }
            }
        };
        process.start();

        View.atmView.content.add(View.userConsultView);
        View.atmView.content.repaint();
        View.atmView.pack();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init User Control Module">
    public void userControl() {
        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        BarRenderer.setDefaultBarPainter(new StandardBarPainter());
        View.atmView.content.removeAll();

        View.userControlView.graph1.removeAll();
        DefaultCategoryDataset datasetGraph1 = new DefaultCategoryDataset();
        for (Person person : LoginController.persons) {
            if (person instanceof User) {
                datasetGraph1.addValue(
                        ((User) person).viewLatestTransactions().stream().mapToDouble(transaction -> {
                            if (transaction.getType().equals(Transaction.RETREAT)) {
                                return transaction.getAmount();
                            }
                            return 0;
                        }).sum(),
                        "Retreats", person.getName());
                datasetGraph1.addValue(
                        ((User) person).viewLatestTransactions().stream().mapToDouble(transaction -> {
                            if (transaction.getType().equals(Transaction.DEPOSIT)) {
                                return transaction.getAmount();
                            }
                            return 0;
                        }).sum(),
                        "Deposits", person.getName());
            }
        }
        JFreeChart graph1 = ChartFactory.createLineChart("Retreats vs Deposits", "Users", "Retreats/Deposits", datasetGraph1);
        graph1.setBackgroundPaint(View.userControlView.graph1.getBackground());
        graph1.getCategoryPlot().setBackgroundPaint(View.userControlView.graph1.getBackground());
        graph1.getTitle().setPaint(Color.WHITE);
        graph1.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
        graph1.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);
        graph1.getCategoryPlot().getDomainAxis().setLabelPaint(Color.WHITE);
        graph1.getCategoryPlot().getRangeAxis().setLabelPaint(Color.WHITE);
        graph1.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);
        graph1.getCategoryPlot().getRenderer().setSeriesPaint(1, Color.GREEN);
        graph1.getCategoryPlot().setShadowGenerator(new DefaultShadowGenerator());
        LineAndShapeRenderer figures = (LineAndShapeRenderer) graph1.getCategoryPlot().getRenderer();
        figures.setDefaultShapesVisible(true);
        ChartPanel graph1Panel = new ChartPanel(graph1);
        graph1Panel.setVisible(true);
        View.userControlView.graph1.add(graph1Panel);

        View.userControlView.graph2.removeAll();
        DefaultCategoryDataset datasetGraph2 = new DefaultCategoryDataset();
        datasetGraph2.addValue(
                LoginController.persons.stream().mapToDouble(person -> {
                    if (person instanceof User) {
                        return Helper.personToUser(person).viewLatestTransactions().stream().mapToDouble(transaction -> {
                            if (transaction.getType().equals(Transaction.RETREAT)) {
                                return transaction.getAmount();
                            }
                            return 0;
                        }).sum();
                    }
                    return 0;
                }).sum() / LoginController.persons.stream().filter(person -> person instanceof User).count(),
                "Retreats", "Users");
        datasetGraph2.addValue(
                LoginController.persons.stream().mapToDouble(person -> {
                    if (person instanceof User) {
                        return Helper.personToUser(person).viewLatestTransactions().stream().mapToDouble(transaction -> {
                            if (transaction.getType().equals(Transaction.DEPOSIT)) {
                                return transaction.getAmount();
                            }
                            return 0;
                        }).sum();
                    }
                    return 0;
                }).sum() / LoginController.persons.stream().filter(person -> person instanceof User).count(),
                "Deposits", "Users");
        JFreeChart graph2 = ChartFactory.createBarChart("Media of Deposits and Retreats", "Users", "Medias", datasetGraph2);
        graph2.setBackgroundPaint(View.userControlView.graph2.getBackground());
        graph2.getCategoryPlot().setBackgroundPaint(View.userControlView.graph2.getBackground());
        graph2.getTitle().setPaint(Color.WHITE);
        graph2.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
        graph2.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);
        graph2.getCategoryPlot().getDomainAxis().setLabelPaint(Color.WHITE);
        graph2.getCategoryPlot().getRangeAxis().setLabelPaint(Color.WHITE);
        graph2.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);
        graph2.getCategoryPlot().getRenderer().setSeriesPaint(1, Color.GREEN);
        graph2.getCategoryPlot().setShadowGenerator(new DefaultShadowGenerator());
        ChartPanel graph2Panel = new ChartPanel(graph2);
        graph2Panel.setVisible(true);
        View.userControlView.graph2.add(graph2Panel);

        View.userControlView.graph3.removeAll();
        DefaultPieDataset datasetGraph3 = new DefaultPieDataset();
        for (Person person : LoginController.persons) {
            if (person instanceof User) {
                datasetGraph3.setValue(person.getName(), ((User) person).getCountPinChanged());
            }
        }
        JFreeChart graph3 = ChartFactory.createPieChart("Users who changed the pin", datasetGraph3, true, true, Locale.ENGLISH);
        graph3.setBackgroundPaint(View.userControlView.graph3.getBackground());
        graph3.getTitle().setPaint(Color.WHITE);
        ((PiePlot) graph3.getPlot()).setBackgroundPaint(View.userControlView.graph3.getBackground());
        PieSectionLabelGenerator labels = new StandardPieSectionLabelGenerator(
                "{0} : ({1}, {2})",
                new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) graph3.getPlot()).setLabelGenerator(labels);
        ChartPanel graph3Panel = new ChartPanel(graph3);
        graph3Panel.setVisible(true);
        View.userControlView.graph3.add(graph3Panel);

        View.userControlView.pick.setIcon(Helper.roundImage(ATMController.properties.getLastPerson().getPick(), 192, 192));
        View.userControlView.name.setText(ATMController.properties.getLastPerson().toString());
        View.userControlView.date.setText(Person.dateFormat.format(ATMController.properties.getLastPerson().getLastAccess()));
        View.userControlView.graph1.repaint();
        View.atmView.content.add(View.userControlView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>
}
