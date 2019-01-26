package panel;

import javax.swing.*;
import java.awt.*;


public class BasePanel extends JPanel {

    static public MyPanel myPanel;
    static public PlayerPanel playerPanel;

    public BasePanel() {
        System.out.println("basePanel 생성자");
        setLayout(new BorderLayout());

        add(myPanel = new MyPanel("윤인제", 0, 0, true), BorderLayout.WEST);
        add(playerPanel = new PlayerPanel());
        // startPacket receive ( client <- server )
        // 게임 시작

        // 게임 시작 listenr

    }

    //start button listener

}