package panel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ChatPanel extends JPanel {
    JPanel chatBottom;
    JTextField fieldTxt;
    JTextField sendTxt;
    JButton sendBtn;
    public ChatPanel(){
        chatBottom = new JPanel();
        fieldTxt = new JTextField();
        sendTxt = new JTextField();
        sendBtn = new JButton("SEND");

        this.setPreferredSize(new Dimension(280, 300));
        this.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Chat"));
        this.setLayout(new BorderLayout());

        chatBottom.setLayout(new BorderLayout());
        fieldTxt.setFocusable(false);
        sendBtn.setFocusable(false);
        this.add(BorderLayout.CENTER, fieldTxt);
        this.add(BorderLayout.SOUTH,chatBottom);
        chatBottom.add(BorderLayout.CENTER, sendTxt);
        chatBottom.add(BorderLayout.EAST, sendBtn);
    }
}
