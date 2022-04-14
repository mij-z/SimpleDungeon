package menu;

import gui.Game;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartOption extends SubMenu {

    private final JFrame frame;

    private ImageIcon img;
    private ImageIcon imgActive;

    private int width;
    private int height;

    public StartOption(JFrame frame) {
        this.frame = frame;

        try {
            URL imgURL = getClass().getResource("/menu/start_button.png");
            assert imgURL != null;

            URL imgActiveURL = getClass().getResource("/menu/start_button_active.png");
            assert imgActiveURL != null;

            img = new ImageIcon(imgURL);
            imgActive = new ImageIcon(imgActiveURL);

            width = img.getIconWidth();
            height=  img.getIconHeight();
        } catch (Exception e) {
            img = null;
            imgActive = null;
        }
    }

    public void createOption(JPanel jPanel) {
        JButton jButton;

        if (img == null) {
            jButton = new JButton("START");
        } else {
            jButton = new JButton(img);
            jButton.setRolloverEnabled(true);
            jButton.setRolloverIcon(imgActive);
            jButton.setPreferredSize(new Dimension(width, height));
        }

        super.modifyButton(jButton);

        jButton.addActionListener(e -> {
            if(e.getSource() == jButton) {
                frame.getContentPane().removeAll();
                frame.repaint();
                Game game = new Game();
                frame.add(game);
                frame.setVisible(true);
                game.start();
            }
        });

        jPanel.add(jButton);
    }
}
