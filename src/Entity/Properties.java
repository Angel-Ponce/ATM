package Entity;

import java.io.Serializable;

/**
 *
 * @author samyc
 */
public class Properties implements Serializable{

    private String theme;
    private int currentBalance;

    public Properties(String theme, int currentBalance) {
        this.theme = theme;
        this.currentBalance = currentBalance;
    }

    public Properties() {
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

}
