package Others;

import Entity.Admin;
import Entity.Person;
import Entity.User;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

    public static void success(String message) {
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static ImageIcon roundImage(Object o, int width, int height) {
        try {
            BufferedImage master = ImageIO.read(Helper.class.getResource("/Resources/default.png"));
            if (o instanceof String) {
                master = ImageIO.read(new File(String.valueOf(o)));
            } else if (o instanceof File) {
                master = ImageIO.read((File) o);
            } else if (o instanceof URL) {
                master = ImageIO.read((URL) o);
            }

            int diameter = Math.min(master.getWidth(), master.getHeight());
            BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = mask.createGraphics();
            applyQualityRenderingHints(g2d);
            g2d.fillOval(0, 0, diameter - 1, diameter - 1);
            g2d.dispose();

            BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
            g2d = masked.createGraphics();
            applyQualityRenderingHints(g2d);
            int x = (diameter - master.getWidth()) / 2;
            int y = (diameter - master.getHeight()) / 2;
            g2d.drawImage(master, x, y, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mask, 0, 0, null);
            g2d.dispose();

            ImageIcon imageIcon = new ImageIcon(masked);
            Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return new ImageIcon(
                new ImageIcon(Helper.class.getResource("/Resources/default.png"))
                        .getImage()
                        .getScaledInstance(width, height, Image.SCALE_SMOOTH)
        );
    }

    private static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    public static User personToUser(Person person) {
        return (User) person;
    }

    public static Admin personToAdmin(Person person) {
        return (Admin) person;
    }
}
