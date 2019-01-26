package panel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UserPanel extends JPanel {
    private final static int WIDTH = 280;
    private final static int HEIGHT = 300;
    private static final int ROWS = 20;
    private static final int COLUMNS = 10;
    private static final int BORDER_SIZE = 7;
    private static final int BOX_SIZE = 14;
    private static final int MARGIN_X = 25;                 // othter player field's margin X
    private static final int MARGIN_Y = 49;                 // othter player field's margin Y

    TitledBorder titledBorder;

    JLabel userRecord;

    int[][] fieldNum = null;
    int[][] fieldColor = null;

    public boolean getFieldFlag = false;

    public UserPanel(){
        this.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"no player"));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        resetField();
    }

    public UserPanel(String name, int win, int lose){
        this.setBorder(new TitledBorder(new LineBorder(Color.BLACK), name));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        resetField();
        this.add(BorderLayout.NORTH, userRecord);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // server로부터 field 전달받음
        settingField(BasePanel.myPanel.game.sendNum, BasePanel.myPanel.game.sendColor); // server 연동하면 삭제
        drawFieldBorder(g);
        drawField(g);

        repaint();
        invalidate();
    }

    public void settingPanel(String name, int win, int lose){
        this.setBorder(new TitledBorder(new LineBorder(Color.BLACK), name));
        userRecord = new JLabel((win+lose)+"전 "+ win + "승 " + lose + "패");
        this.add(BorderLayout.NORTH, userRecord);
    }



    public void resetField(){
        fieldNum = new int[ROWS][COLUMNS];
        fieldColor = new int[ROWS][COLUMNS];
        for(int x = 0; x<COLUMNS; x++){
            for(int y = 0; y<ROWS; y++){
                fieldNum[y][x] = 0;
                fieldColor[y][x] = 0;
            }
        }
    }

    public void settingField(int[][] fieldNum, int[][] fieldColor){
        for(int x = 0; x<COLUMNS; x++){
            for(int y = 0; y<ROWS; y++){
                this.fieldNum[y][x] = fieldNum[y][x];
                this.fieldColor[y][x] = fieldColor[y][x];
            }
        }
    }

    public void drawFieldBorder(Graphics g){
        g.setColor(Color.BLACK);

        // top border
        g.drawRect(MARGIN_X - BORDER_SIZE, MARGIN_Y - BORDER_SIZE, COLUMNS * BOX_SIZE +  2 * BORDER_SIZE,BORDER_SIZE);
        g.fillRect(MARGIN_X - BORDER_SIZE, MARGIN_Y - BORDER_SIZE, COLUMNS * BOX_SIZE +  2 * BORDER_SIZE,BORDER_SIZE);
        // bottom border
        g.drawRect(MARGIN_X - BORDER_SIZE, MARGIN_Y + ROWS * BOX_SIZE, COLUMNS * BOX_SIZE +  2 * BORDER_SIZE,BORDER_SIZE);
        g.fillRect(MARGIN_X - BORDER_SIZE, MARGIN_Y + ROWS * BOX_SIZE, COLUMNS * BOX_SIZE +  2 * BORDER_SIZE,BORDER_SIZE);

        // left border
        g.drawRect(MARGIN_X-BORDER_SIZE, MARGIN_Y-BORDER_SIZE, BORDER_SIZE, ROWS * BOX_SIZE + 2 * BORDER_SIZE);
        g.fillRect(MARGIN_X-BORDER_SIZE, MARGIN_Y-BORDER_SIZE, BORDER_SIZE, ROWS * BOX_SIZE + 2 * BORDER_SIZE);
        // right border
        g.drawRect(MARGIN_X+COLUMNS*BOX_SIZE, MARGIN_Y-BORDER_SIZE, BORDER_SIZE, ROWS * BOX_SIZE + 2 * BORDER_SIZE);
        g.fillRect(MARGIN_X+COLUMNS*BOX_SIZE, MARGIN_Y-BORDER_SIZE, BORDER_SIZE, ROWS * BOX_SIZE + 2 * BORDER_SIZE);
    }

    // draw ohter Field
    public void drawField(Graphics g){
        for(int x = 0; x < COLUMNS ; x++){     // 0~9
            for (int y = 0; y < ROWS; y++){   // 0~19
                if(fieldNum[y][x] == 1){
                    switch (fieldColor[y][x]) {
                        case -2:    // Gray
                            g.setColor(Color.gray);
                            break;
                        case -1:    // Black
                            g.setColor(Color.BLACK);
                            break;
                        case 0:     //  White
                            g.setColor(Color.WHITE);
                            break;
                        case 1:     //  Red (255,0,0)
                            g.setColor(Color.RED);
                            break;
                        case 2:     //  Yellow (255, 212, 0)
                            g.setColor(Color.YELLOW);
                            break;
                        case 3:     //  Blue    (0, 153, 255)
                            g.setColor(Color.BLUE);
                            break;
                        case 4:     // Green    (0, 153, 0)
                            g.setColor(Color.GREEN);
                            break;
                        case 5:     //  Pink    (255, 144, 190)
                            g.setColor(Color.PINK);
                            break;
                        case 6:     //  Purple  (128, 0, 255)
                            g.setColor(new Color(128, 0, 255));
                            break;
                        case 7:     //  Orange  (255, 127, 0)
                            g.setColor(Color.ORANGE);
                            break;
                    }
                    g.fillRect(BOX_SIZE * x+ MARGIN_X, BOX_SIZE * y+ MARGIN_Y, BOX_SIZE,BOX_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(BOX_SIZE * x+ MARGIN_X, BOX_SIZE * y+ MARGIN_Y, BOX_SIZE,BOX_SIZE);
                }
            }
        }
    }

}
