package gui;

import movable.Movable;

import java.awt.*;
import java.util.ArrayList;

public class Handler {

    private final ArrayList<Movable> movables;

    public Handler() {
        movables = new ArrayList<>();
    }

    public void tick() {
        for (Movable movable : movables) {
            movable.tick();
        }
    }

    public void render(Graphics graphics) {
        for (Movable movable : movables) {
            movable.render(graphics);
        }
    }

    public void addMovables(Movable movable) {
        movables.add(movable);
    }

    public void removeMovables(Movable movable) {
        movables.remove(movable);
    }

}
