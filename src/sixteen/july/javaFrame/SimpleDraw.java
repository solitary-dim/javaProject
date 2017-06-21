package sixteen.july.javaframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/20
 * Time: 14:48
 */
public class SimpleDraw {

    class MyCanvas extends Canvas {
        public void paint(Graphics g) {
            Random rand = new Random();
            if (shape.equals(RECT_SHAPE)) {
                g.setColor(new Color(220, 100, 80));
                g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
            }
            if (shape.equals(OVAL_SHAPE)) {
                g.setColor(new Color(80, 100, 200));
                g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
            }
        }
    }

    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";
    private Frame f = new Frame("draw");
    private Button rect = new Button("矩形");
    private Button oval = new Button("椭圆");
    private MyCanvas drawArea = new MyCanvas();
    private String shape = "";
    public void init() {
        Panel p = new Panel();
        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = RECT_SHAPE;
                drawArea.repaint();
            }
        });
        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = OVAL_SHAPE;
                drawArea.repaint();
            }
        });
        p.add(rect);
        p.add(oval);
        drawArea.setPreferredSize(new Dimension(250, 180));
        f.add(drawArea);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }
}
