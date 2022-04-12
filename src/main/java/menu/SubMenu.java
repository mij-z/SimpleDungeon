package menu;

import javax.swing.*;
import java.awt.*;

public abstract class SubMenu {

    public void modifyButton(JButton jButton) {
        jButton.setOpaque(false);
        jButton.setFocusable(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorder(BorderFactory.createEmptyBorder());
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public abstract void createOption(JPanel jPanel);

}
