package menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImagePanel extends JPanel {

    private BufferedImage img;

    protected ImagePanel(String url) {
        try {
            URL imgURL = getClass().getResource(url);
            assert imgURL != null;
            img = ImageIO.read(imgURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(img, 0, 0, null);
    }
}
