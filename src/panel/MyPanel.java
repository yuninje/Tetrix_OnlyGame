package panel;

import game.Game;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MyPanel extends JPanel {

    static public Game game = null;

    private static final int SIZE = 20;
    private static final int X = 13;
    private static final int Y = 22;

    JPanel top;
    JPanel bottom;
    JPanel panelGame;
    JLabel labelID;
    JLabel labelRecord;
    JButton btnStart;
    JButton btnExit;
    public MyPanel(String name, int win, int lose, boolean owner){
        System.out.println("panel.MyPanel 생성자");
        top = new JPanel();
        bottom = new JPanel();
        panelGame = new JPanel();
        labelID = new JLabel("ID");
        labelRecord = new JLabel((win+lose)+"전 "+ win + "승 " + lose + "패");
        btnStart = new JButton("Start");
        btnExit = new JButton("Exit");

        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder(new LineBorder(Color.black, 4), name));
        this.setPreferredSize(new Dimension(400, 900));
        this.setVisible(true);

        game = new Game();
        this.add(BorderLayout.CENTER, game);
        game.init();
        game.setFocusable(true);

        this.add(BorderLayout.NORTH, top);
        this.add(BorderLayout.CENTER, game);
        this.add(BorderLayout.SOUTH, bottom);

        btnStart.setFocusable(false);
        btnExit.setFocusable(false);

        top.add(BorderLayout.CENTER,labelID);
        top.add(BorderLayout.SOUTH,labelRecord);
        if(owner) {
            bottom.add(btnStart);

            btnStart.addActionListener(startActionListener);
        }
        bottom.add(btnExit);

    }

    ActionListener startActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //startPacket send  (client -> server)
            //ClientHandler.getInstance().start(,);  (id, gameId)
            game.gameFlag = true;
            game.start();
        }
    };
}
