package panel;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    UserPanel userPanel1;
    UserPanel userPanel2;
    UserPanel userPanel3;
    UserPanel userPanel4;
    UserPanel userPanel5;
    ChatPanel chatPanel;
    PlayerPanel() {

        setLayout(new GridLayout(2,3));
        setPreferredSize(new Dimension(850,1000));

        userPanel1 = new UserPanel();
        userPanel2 = new UserPanel();
        userPanel3 = new UserPanel();
        userPanel4 = new UserPanel();
        userPanel5 = new UserPanel();
        chatPanel = new ChatPanel();


        this.add(userPanel1);
        this.add(userPanel2);
        this.add(userPanel3);
        this.add(chatPanel);
        this.add(userPanel4);
        this.add(userPanel5);
    }
}
