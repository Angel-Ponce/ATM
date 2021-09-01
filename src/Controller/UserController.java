package Controller;

import Entity.Ticket;
import Entity.Transaction;
import Model.UserModel;
import Others.Helper;
import View.JTransaction;
import View.View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author samyc
 */
public class UserController implements Controller {

    private int totalRetreated = 0;
    private int totalDeposited = 0;
    public static final NumberFormat USD = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
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
                View.retreatView.total.setText(USD.format(totalRetreated));
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
                    if (Helper.personToUser(ATMController.currentPerson).getMaximumRetreatPerDay() >= totalRetreated) {
                        if (Helper.personToUser(ATMController.currentPerson).getCurrentBalance() >= totalRetreated) {
                            if (UserModel.retreat(totalRetreated, ATMController.currentPerson)) {
                                Helper.success("Operation success");
                                Helper.personToUser(ATMController.currentPerson).addTransaction(
                                        new Transaction(totalRetreated, Transaction.RETREAT, new Date())
                                );
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
        //<editor-fold defaultstate="collapsed" desc="Deposit Event">
        ActionListener depositEvent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == View.depositView.$1) {
                    totalDeposited++;
                    temporalyTickets.get(0).setSize(temporalyTickets.get(0).getSize() + 1);
                } else if (ae.getSource() == View.depositView.$5) {
                    totalDeposited += 5;
                    temporalyTickets.get(1).setSize(temporalyTickets.get(1).getSize() + 1);
                } else if (ae.getSource() == View.depositView.$10) {
                    totalDeposited += 10;
                    temporalyTickets.get(2).setSize(temporalyTickets.get(2).getSize() + 1);
                } else if (ae.getSource() == View.depositView.$20) {
                    totalDeposited += 20;
                    temporalyTickets.get(3).setSize(temporalyTickets.get(3).getSize() + 1);
                } else if (ae.getSource() == View.depositView.$50) {
                    totalDeposited += 50;
                    temporalyTickets.get(4).setSize(temporalyTickets.get(4).getSize() + 1);
                } else if (ae.getSource() == View.depositView.$100) {
                    totalDeposited += 100;
                    temporalyTickets.get(5).setSize(temporalyTickets.get(5).getSize() + 1);
                } else if (ae.getSource() == View.depositView.$200) {
                    totalDeposited += 200;
                    temporalyTickets.get(6).setSize(temporalyTickets.get(6).getSize() + 1);
                }
                View.depositView.total.setText(USD.format(totalDeposited));
            }
        };

        View.depositView.$1.addActionListener(depositEvent);
        View.depositView.$5.addActionListener(depositEvent);
        View.depositView.$10.addActionListener(depositEvent);
        View.depositView.$20.addActionListener(depositEvent);
        View.depositView.$50.addActionListener(depositEvent);
        View.depositView.$100.addActionListener(depositEvent);
        View.depositView.$200.addActionListener(depositEvent);

        View.depositView.save.addActionListener((ae) -> {
            String pin = String.valueOf(View.depositView.pin.getPassword());
            if (pin.matches("\\d+")) {
                if (ATMController.currentPerson.getPin() == Integer.parseInt(pin)) {
                    if (totalDeposited + ATMController.properties.getCurrentBalance() <= 30000) {
                        if (UserModel.deposit(totalDeposited, ATMController.currentPerson)) {
                            Helper.success("Operation success");
                            Helper.personToUser(ATMController.currentPerson).addTransaction(
                                    new Transaction(totalDeposited, Transaction.DEPOSIT, new Date())
                            );
                            Model.AdminModel.addCash(
                                    temporalyTickets.get(0).getSize(),
                                    temporalyTickets.get(1).getSize(),
                                    temporalyTickets.get(2).getSize(),
                                    temporalyTickets.get(3).getSize(),
                                    temporalyTickets.get(4).getSize(),
                                    temporalyTickets.get(5).getSize(),
                                    temporalyTickets.get(6).getSize()
                            );
                            totalDeposited = 0;
                            View.depositView.total.setText("");
                            View.depositView.pin.setText("");
                        } else {
                            Helper.error("Something went wrong");
                        }
                    } else {
                        Helper.error("Limit of ATM has been exceded");
                    }
                } else {
                    Helper.error("The pin is incorrectly");
                }
            } else {
                Helper.error("The pin must be a numeric value");
            }
        });

        View.depositView.reset.addActionListener((ae) -> {
            View.depositView.total.setText("");
            View.depositView.pin.setText("");
            totalDeposited = 0;
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

    //<editor-fold defaultstate="collapsed" desc="Init Deposit Module">
    public void deposit() {
        View.atmView.content.removeAll();
        this.totalDeposited = 0;
        View.depositView.pin.setText("");
        View.depositView.total.setText("");
        this.temporalyTickets.clear();
        for (Ticket t : ATMController.tickets) {
            this.temporalyTickets.add(new Ticket(t.getType(), t.getSize()));
        }
        View.atmView.content.add(View.depositView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Init Transactions Module">
    public void transactions() {
        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        View.atmView.content.removeAll();
        //Creatte a chart of transactions
        View.lastTransactionsView.graph.removeAll();
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries retreats = new TimeSeries("Retreats");
        TimeSeries deposits = new TimeSeries("Deposits");
        for (Transaction t : Helper.personToUser(ATMController.currentPerson).viewLatestTransactions()) {
            if (t.getType().equals(Transaction.RETREAT)) {
                retreats.add(new Second(t.getDate()), t.getAmount());
            } else if (t.getType().equals(Transaction.DEPOSIT)) {
                deposits.add(new Second(t.getDate()), t.getAmount());
            }
        }
        dataset.addSeries(retreats);
        dataset.addSeries(deposits);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Transactions in the Time", "Date", "Amount", dataset, true, true, true);
        chart.setBackgroundPaint(View.lastTransactionsView.graph.getBackground());
        chart.getPlot().setBackgroundPaint(View.lastTransactionsView.graph.getBackground());
        chart.getTitle().setPaint(Color.WHITE);
        ((XYPlot) chart.getPlot()).getDomainAxis().setTickLabelPaint(Color.WHITE);
        ((XYPlot) chart.getPlot()).getRangeAxis().setTickLabelPaint(Color.WHITE);
        ((XYPlot) chart.getPlot()).getDomainAxis().setLabelPaint(Color.WHITE);
        ((XYPlot) chart.getPlot()).getRangeAxis().setLabelPaint(Color.WHITE);
        ((XYPlot) chart.getPlot()).getRenderer().setSeriesPaint(0, Color.RED);
        ((XYPlot) chart.getPlot()).getRenderer().setSeriesPaint(1, Color.GREEN);
        ((XYPlot) chart.getPlot()).setShadowGenerator(new DefaultShadowGenerator());
        XYLineAndShapeRenderer figures = (XYLineAndShapeRenderer) ((XYPlot) chart.getPlot()).getRenderer();
        figures.setDefaultShapesVisible(true);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setVisible(true);
        View.lastTransactionsView.graph.add(chartPanel);

        //Adding last transactions
        View.lastTransactionsView.transactions.removeAll();
        View.lastTransactionsView.transactions.add(new JTransaction("Amount", "Type", "Date"));
        for (int i = Helper.personToUser(ATMController.currentPerson).viewLatestTransactions().size() - 1;
                i >= Helper.personToUser(ATMController.currentPerson).viewLatestTransactions().size() - 5;
                i--) {
            if (i >= 0) {
                View.lastTransactionsView.transactions.add(
                        new JTransaction(
                                Helper.personToUser(ATMController.currentPerson).viewLatestTransactions().get(i)
                        )
                );
            }
        }
        View.atmView.content.add(View.lastTransactionsView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Iinit Amount Module">
    public void amount() {
        View.atmView.content.removeAll();
        View.balanceView.avAmount.setText(USD.format(
                Helper.personToUser(ATMController.currentPerson).getCurrentBalance()
        ));
        View.balanceView.maxAmount.setText(USD.format(
                Helper.personToUser(ATMController.currentPerson).getMaximumAmount()
        ) + " / " + USD.format(
                Helper.personToUser(ATMController.currentPerson).getMaximumRetreatPerDay()
        ));
        View.atmView.content.add(View.balanceView);
        View.atmView.content.repaint();
        View.atmView.pack();
    }
    //</editor-fold>
}
