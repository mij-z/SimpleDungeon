package movable;

import misc.BufferedImageLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Knight extends Movable {

    public Knight(int x, int y) {
        super(x, y, false);

        BufferedImageLoader bufferedImageLoader = new BufferedImageLoader();
        try {
            BufferedImage image = bufferedImageLoader.loadImage("/sprites/characters/adventurer/player.png");
            setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void tick() {
    }

}
