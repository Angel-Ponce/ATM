package Others;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Use this class to put a image in a some frame object using JPanel object
 *
 * @author Angel
 */
public class Image extends JPanel {

    int width;
    int height;
    String path;

    /**
     * Initialite a image
     *
     * @param height height of image
     * @param width width of image
     * @param path path to localize image (Prefered use the absolute path)
     */
    public Image(int width, int height, String path) {
        this.width = width;
        this.height = height;
        this.path = path;
        this.setSize(width, height);
    }

    /**
     * Paint image (This method is executed when instantiating an image)
     *
     * @param g Graphics object required
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension d = this.getSize();
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
        setOpaque(false);
    }

}
