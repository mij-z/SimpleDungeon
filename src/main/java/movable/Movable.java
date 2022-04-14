package movable;

import misc.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Movable {

    private int x;
    private int y;
    private boolean isEnemy;
    private BufferedImage image = null;
    private SpriteSheet spriteSheet = null;

    public Movable(int x, int y, boolean isEnemy) {
        this.x = x;
        this.y = y;
        this.isEnemy = isEnemy;
    }

    public abstract void tick();

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    protected void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    protected void setImage(BufferedImage image) {
        this.spriteSheet = new SpriteSheet(image);
        this.image = spriteSheet.grabImage(1, 1, 96, 96);
    }

}
