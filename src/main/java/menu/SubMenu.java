package menu;

import javax.swing.*;

public abstract class SubMenu {

    public void modifyButton(JButton jButton) {
        jButton.setOpaque(false);
        jButton.setFocusable(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorder(BorderFactory.createEmptyBorder());
    }

    public abstract void createOption(JPanel jPanel);

}
