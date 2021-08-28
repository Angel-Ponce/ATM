package Others;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samyc
 */
public abstract class Process extends Thread {

    public abstract void callback();

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
        callback();
    }

}
