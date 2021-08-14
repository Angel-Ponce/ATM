package Others;

import java.awt.Color;
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
}
