package panel;

import game.Game;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {

    static public Game game = null;

    JPanel top;
    JPanel bottom;
    JPanel panelGame;
    JButton btnStart;
    public MyPanel(){
        System.out.println("MyPanel 생성자");
        top = new JPanel();
        bottom = new JPanel();
        panelGame = new JPanel();
        btnStart = new JButton("Start");

        this.setLayout(new BorderLayout());
        this.setBorder(new TitledBorder(new LineBorder(Color.black, 4)));
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
        bottom.add(btnStart);
        btnStart.addActionListener(startActionListener);

    }

    ActionListener startActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!game.startFlag) {                      // 게임이 처음 시작
                game.start();
            }else if(game.startFlag && game.gameover_flag){  // 게임이 끝나고 시작버튼 >> 다시시작
                game.game();
            }
        }
    };
}
