package sixteen.july.javaframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/20
 * Time: 15:15
 */
public class RollBall {
    private static Integer score = 0;

    private final int TABLE_WIDTH = 300;
    private final int TABLE_HEIGHT = 400;
    private final int RACKET_Y = 340;
    private final int RACKET_HEIGHT = 20;
    private final int RACKET_WIDTH = 60;
    private final int BALL_SIZE = 16;

    private final Frame f = new Frame("弹球游戏");
    private final JPanel p = new JPanel();
    private final JLabel l = new JLabel();
    Random rand = new Random();
    private int ySpeed = 10;
    private double xyRate = rand.nextDouble() - 0.5;
    private int xSpeed = (int) (ySpeed * xyRate * 2);
    private int ballX = rand.nextInt(200) + 20;
    private int ballY = rand.nextInt(10) + 20;
    private int racketX = rand.nextInt(200);
    private MyCanvas tableArea = new MyCanvas();
    Timer timer;
    private boolean isLose = false;

    public void init () {

        l.setText("分数：0");
        p.add(l);
        p.add(tableArea);
        p.setLayout(null);
        l.setBounds(0, 0, 60, 25);
        l.setOpaque(false);
        p.setOpaque(false);
        tableArea.setBounds(0, 0, TABLE_WIDTH, TABLE_HEIGHT);

        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        KeyAdapter keyProcessor = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (racketX > 0) {
                        racketX -= 20;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (racketX < TABLE_WIDTH - RACKET_WIDTH) {
                        racketX += 20;
                    }
                }
            }
        };
        f.addKeyListener(keyProcessor);
        tableArea.addKeyListener(keyProcessor);
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                    xSpeed = -(xSpeed + (int)rand.nextDouble()*2);
                }
                if (ballY <= 0 || ballY >= RACKET_Y - RACKET_HEIGHT) {
                    if (ballY >= RACKET_Y - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                        timer.stop();
                        isLose = true;
                        tableArea.repaint();
                    } else {
                        ySpeed = -(ySpeed + (int)rand.nextDouble()*2);
                        if (ballY >= RACKET_Y - BALL_SIZE) {
                            score++ ;
                        }
                    }
                }
                l.setText("分数："+score);
                ballX += xSpeed;
                ballY += ySpeed;
                tableArea.repaint();
            }
        };
        timer = new Timer(50, taskPerformer);
        timer.start();

        f.add(p);
        f.pack();
        f.setSize(TABLE_WIDTH, TABLE_HEIGHT);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main (String[] args) {
        new RollBall().init();
    }

    class MyCanvas extends Canvas
    {
        public void paint (Graphics gr) {
            Graphics2D g = (Graphics2D) gr;
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, TABLE_WIDTH, TABLE_HEIGHT);
            if (isLose) {
                g.setColor(new Color(255, 0, 0));
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("Game Over!", 50, 200);
            } else {
                g.setColor(new Color(240, 240, 80));
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                g.setColor(new Color(80, 80, 200));
                g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }
}
