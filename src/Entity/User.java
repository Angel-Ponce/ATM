package Entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author samyc
 */
public class User extends Person implements Serializable {

    private int cardNumber;
    private int currentBalance;
    private int maximumAmount;
    ArrayList<Transaction> latestTransactions = new ArrayList<Transaction>();

    public User(int cardNumber, int currentBalance, int maximumAmount) {
        this.cardNumber = cardNumber;
        this.currentBalance = currentBalance;
        this.maximumAmount = maximumAmount;
    }

    public User() {
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public void retreat(int mount) {
        this.currentBalance -= mount;
    }

    public void deposit(int mount) {
        this.currentBalance += mount;
    }

    public ArrayList<Transaction> viewLatestTransactions() {
        return this.latestTransactions;
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getLastName();
    }
}
