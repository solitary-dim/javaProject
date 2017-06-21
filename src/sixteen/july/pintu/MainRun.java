package sixteen.july.pintu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/21
 * Time: 9:21
 */
public class MainRun {

    public static final int NUM = 9;
    public static Integer clickNum = 0;
    public static String change = null;
    public static boolean result = false;
    static ImageIcon img = new ImageIcon(MainRun.class.getResource("person.gif"));
    public static JFrame jf = new JFrame("PinTu");
    public static JPanel jp = new JPanel();
    public static Map<String, JLabel> map = new HashMap<String, JLabel>();
    public static Map<String, JLabel> nap = new HashMap<String, JLabel>();

    private void randPictures () {
        int height = img.getIconHeight()*3;
        int width = img.getIconWidth()*3;

        jp.setBackground(Color.WHITE);
        jp.setLayout(new GridLayout(3, 3, 1, 1));
        for (int i = 0 ; i < NUM ; i ++ ) {
            JLabel jl = new JLabel();
            jl.setIcon(new ImageIcon(img.getImage()));
            jl.setBorder(BorderFactory.createLineBorder(Color.red));
            map.put(String.valueOf(i), jl);
            final int order = i;
            jl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickNum++;
                    if (clickNum == 1) {
                        change = String.valueOf(order);
                    } else if (clickNum == 2) {
                        System.out.println("change: " + change + "||| order: " + order);
                        String temp = String.valueOf(order);

                        nap.put(change, map.get(change));
                        nap.put(temp, map.get(temp));
                        map.remove(change);
                        map.put(change, nap.get(temp));
                        map.remove(temp);
                        map.put(temp, nap.get(change));

                        jp.removeAll();
                        for (int j = 0 ; j < NUM ; j ++ ) {
                            jp.add(map.get(String.valueOf(j)));
                        }
                        jp.repaint();

                        nap.remove(change);
                        nap.remove(temp);
                        change = null;
                        nap = null;
                        clickNum = 0;
                    }
                }
            });
        }
        for (int i = 0 ; i < NUM ; i ++ ) {
            jp.add(map.get(String.valueOf(i)));
        }
        jf.add(jp);
        jf.pack();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    private boolean movePicture () {
        result = true;
        return result;
    }

    public static void main (String[] args) {
        MainRun mr = new MainRun();
        mr.randPictures();
        mr.movePicture();
        System.out.println(result);
    }
}
