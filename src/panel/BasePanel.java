package panel;

import javax.swing.*;
import java.awt.*;


public class BasePanel extends JPanel {

    static public MyPanel myPanel;

    public BasePanel() {
        System.out.println("basePanel 생성자");
        setLayout(new BorderLayout());
        add(myPanel = new MyPanel(), BorderLayout.WEST);
    }

    //start button listener

}