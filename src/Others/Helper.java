package Others;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import javax.swing.Icon;
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
            return object;
        } catch (IOException | URISyntaxException | ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return null;
    }
}
