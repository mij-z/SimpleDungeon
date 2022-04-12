package menu;

import misc.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainMenu {

    private final JFrame frame;

    private final ArrayList<SubMenu> subMenus;
    private final int numOfSubMenus;

    protected MainMenu(JFrame frame) {
        this.frame = frame;

        subMenus = new ArrayList<>();
        subMenus.add(new StartOption(frame));
        subMenus.add(new QuitOption(frame));

        numOfSubMenus = subMenus.size();
    }

    private ArrayList<JPanel> createJPanels() {
        ArrayList<JPanel> jPanels = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            jPanels.add(new JPanel());
        }
        return jPanels;
    }

    private void createTitle(JPanel jPanel) {
        JLabel jLabel = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/menu/title.png"))));
        jPanel.add(jLabel);
    }

    private void createMenuOptions(JPanel jPanel) {
        for (int i = 0; i < numOfSubMenus; i++) {
            subMenus.get(i).createOption(jPanel);
            if (i != numOfSubMenus - 1) {
                jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            }
        }
    }

    private void createHighScore(JPanel jPanel) {
        ResourceLoader resourceLoader = ResourceLoader.getResourceLoader();

        int highScore = 0;
        try {
            highScore = resourceLoader.getHighScore();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel jLabel = new JLabel("High Score: " + highScore);
        jPanel.add(jLabel);
    }

    protected void createMainMenu() {
        ImagePanel imagePanel = new ImagePanel("/menu/background.jpg");
        imagePanel.setLayout(new GridLayout(3, 1));
        frame.add(imagePanel);

        ArrayList<JPanel> jPanels = createJPanels();

        jPanels.get(0).setLayout(new GridBagLayout());
        createTitle(jPanels.get(0));

        BoxLayout boxLayout = new BoxLayout(jPanels.get(1), BoxLayout.Y_AXIS);
        jPanels.get(1).setLayout(boxLayout);
        createMenuOptions(jPanels.get(1));

        jPanels.get(2).setLayout(new GridBagLayout());
        createHighScore(jPanels.get(2));

        for (JPanel jPanel : jPanels) {
            jPanel.setOpaque(false);
            imagePanel.add(jPanel);
        }
    }

}
