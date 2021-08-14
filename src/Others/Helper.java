package Others;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import jiconfont.IconCode;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Angel Ponce
 */
public class Helper {

    public static Icon icon(IconCode icon, int size, Color color) {
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        return IconFontSwing.buildIcon(icon, size, color);
    }

    public static Object getObjectFromFile(String path) {
        try {
            ObjectInputStream objectStream = new ObjectInputStream(
                    new FileInputStream(
                            new File(Helper.class.getResource(path).toURI())
                    )
            );
            Object object = objectStream.readObject();
            objectStream.close();
            return object;
        } catch (IOException | URISyntaxException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return null;
    }

    public static boolean saveObjectToFile(Object object, String path) {
        try {
            ObjectOutputStream objectStream = new ObjectOutputStream(
                    new FileOutputStream(
                            new File(Helper.class.getResource(path).toURI())
                    )
            );
            objectStream.writeObject(object);
            objectStream.close();
            return true;
        } catch (IOException | URISyntaxException ex) {
            System.err.println(ex);
        }
        return false;
    }

    public static void error(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
