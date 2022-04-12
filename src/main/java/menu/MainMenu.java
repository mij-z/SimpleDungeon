package menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class MainMenu {

    private final JFrame frame;

    protected MainMenu(JFrame frame) {
        this.frame = frame;
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

    private void createHighScore(JPanel jPanel) {
        // TODO implement file reader
    }

    protected void createMainMenu() {
        ImagePanel imagePanel = new ImagePanel("/menu/background.jpg");
        imagePanel.setLayout(new GridLayout(3, 1));
        frame.add(imagePanel);

        ArrayList<JPanel> jPanels = createJPanels();

        jPanels.get(0).setLayout(new GridBagLayout());
        createTitle(jPanels.get(0));

        jPanels.get(2).setLayout(new GridBagLayout());
        createHighScore(jPanels.get(2));

        for (JPanel jPanel : jPanels) {
            jPanel.setOpaque(false);
            imagePanel.add(jPanel);
        }
    }

}
