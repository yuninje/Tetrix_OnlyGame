import panel.BasePanel;

import javax.swing.*;

public class Client extends JFrame {
  static int WIDTH = 420;
  static int HEIGHT = 590;
  BasePanel basePanel;
  public Client() {
    setTitle("Tetrix");
    setSize(WIDTH, HEIGHT);
    setResizable(false);

    add(basePanel=new BasePanel());
    setVisible(true);
    basePanel.setVisible(true);
    this.setLocationRelativeTo(null);   // 모니터 가운데 띄우
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // 폼 종료시 프로그램 종료
  }
}
