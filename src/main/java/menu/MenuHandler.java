package menu;

import javax.swing.*;
import java.awt.*;

public class MenuHandler extends Canvas {

    private final MainMenu mainMenu;

    public MenuHandler(JFrame frame) {
        this.mainMenu = new MainMenu(frame);
    }

    public void createMainMenu() {
        mainMenu.createMainMenu();
    }

}
