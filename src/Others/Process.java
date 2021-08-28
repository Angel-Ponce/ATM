package Others;

/**
 *
 * @author samyc
 */
public abstract class Process extends Thread {

    public abstract void callback();

    @Override
    public void run() {
        callback();
    }

}
