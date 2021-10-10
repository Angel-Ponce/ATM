package Entity;

import Others.Connecter;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Angel Ponce
 */
public class Captcha {

    private String token;
    private ImageIcon captcha;
    private static final Random R = new Random();

    public Captcha() {
        int cantidad = 1;
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("SELECT COUNT(id) as cantidad FROM token");
            c.rs = c.ps.executeQuery();
            if (c.rs.next()) {
                cantidad = c.rs.getInt("cantidad");
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        int random = R.nextInt(cantidad + 1);
        String captchatoken = "2b827.png";
        try {
            Connecter c = new Connecter();
            c.con = c.getConnection();
            c.ps = c.con.prepareStatement("SELECT token FROM token WHERE id = ?");
            c.ps.setInt(1, random);
            c.rs = c.ps.executeQuery();
            if (c.rs.next()) {
                captchatoken = c.rs.getString("token");
            }
            c.con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        this.token = captchatoken.replaceAll("\\..*", "");
        this.captcha = new ImageIcon(getClass().getResource("/Resources/captcha/" + captchatoken));
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean validate(String token) {
        return this.token.equals(token);
    }

    public ImageIcon getCaptcha() {
        return captcha;
    }

    public void setCaptcha(ImageIcon captcha) {
        this.captcha = captcha;
    }

}
