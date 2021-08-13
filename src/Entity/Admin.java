
package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author samyc
 */
public class Admin extends Person{

    public Admin(String name, String lastName, int age, SimpleDateFormat dateFormat, String email, int pin, Date lastAccess, String pick) {
        super(name, lastName, age, dateFormat, email, pin, lastAccess, pick);
    }

    public Admin() {
    }
    
}
