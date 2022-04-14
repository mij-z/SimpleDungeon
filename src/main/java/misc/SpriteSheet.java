package misc;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private final BufferedImage img;

    public SpriteSheet(BufferedImage img) {
        this.img = img;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        return img.getSubimage((col * 96) - 96, (row * 96) - 96, width, height);
    }

}
