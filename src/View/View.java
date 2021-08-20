package View;

/**
 *
 * @author Angel Ponce
 */
public class View {

    public static ATMView atmView = new ATMView();
    public static AddCashView addCashView = new AddCashView();
    public static BalanceView balanceView = new BalanceView();
    public static ChangeCardNumberView changeCardNumberView = new ChangeCardNumberView(atmView, true);
    public static ChangeMaximumAmountView changeMaximumAmountView = new ChangeMaximumAmountView();
    public static ChangePinView changePinView = new ChangePinView();
    public static CreateUserView createUserView = new CreateUserView();
    public static DepositView depositView = new DepositView();
    public static InitATMView initATMView = new InitATMView();
    public static LastTransactionsView lastTransactionsView = new LastTransactionsView();
    public static LoginView loginView = new LoginView();
    public static RetreatView retreatView = new RetreatView();
    public static UserConsultView userConsultView = new UserConsultView();
    public static UserControlView userControlView = new UserControlView();
}
