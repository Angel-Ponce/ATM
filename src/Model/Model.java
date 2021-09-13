package Model;

import java.text.SimpleDateFormat;

/**
 *
 * @author Angel Ponce
 */
public class Model {

    public static LoginModel loginModel = new LoginModel();
    public static ATMModel atmModel = new ATMModel();
    public static UserModel userModel = new UserModel();
    public static AdminModel adminModel = new AdminModel();
    public static SimpleDateFormat TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

}
