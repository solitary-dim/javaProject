package sixteen.july.javaframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/19
 * Time: 17:31
 */
public class myWindow extends JFrame {

    JFrame jFrame = new JFrame("file path test");
    FileDialog d1 = new FileDialog(jFrame, "toOpen", FileDialog.LOAD);
    FileDialog d2 = new FileDialog(jFrame, "toSave", FileDialog.SAVE);
    JButton jb1 = new JButton("open");
    JButton jb2 = new JButton("save");
    public void getFilePath () {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
                System.out.println("File to read: " + d1.getDirectory() + d1.getFile());
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
                System.out.println("File to save: " + d2.getDirectory() + d2.getFile());
            }
        });
        jFrame.add(jb1);
        jFrame.add(jb2, BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setVisible(true);
    }


    private JFrame jf = new JFrame();
    private JPanel jp = new JPanel();
    private CheckboxGroup cg = new CheckboxGroup();
    private Choice cc = new Choice();

    private void myFrame() {
        Checkbox cb1 = new Checkbox("male", cg, true);
        Checkbox cb2 = new Checkbox("female", cg, false);
        Checkbox mc = new Checkbox("married?", false);

        cc.add("red");
        cc.add("blue");
        cc.add("gray");

        jp.add(cb1);
        jp.add(cb2);
        jp.add(mc);
        jp.add(cc);
        jp.add(new TextField(20));
        jp.add(new JTextArea("text"));
        jp.add(new JButton("click"));

        jf.setTitle("Java Swing");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(jp);
        jf.setSize(300, 300);
        jf.setVisible(true);
    }


    private void myMenu () {
        final JFrame jf = new JFrame("menu test");
        final JPopupMenu pop = new JPopupMenu();
        final JMenuBar jm = new JMenuBar();
        final JMenu file = new JMenu("file");
        final JMenu edit = new JMenu("edit");
        final JMenuItem newItem = new JMenuItem("new");
        final JMenuItem saveItem = new JMenuItem("save");
        final JMenuItem exitItem = new JMenuItem("exit", KeyEvent.VK_X/*, new MenuShortcut(KeyEvent.VK_X)*/);
        final JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("atuo wrap");
        final JMenuItem copyItem = new JMenuItem("copy");
        final JMenuItem pasteItem = new JMenuItem("paste");
        final JMenu format = new JMenu("format");
        final JMenuItem commentItem = new JMenuItem("note"/*, new MenuShortcut(KeyEvent.VK_SLASH, true)*/);
        final JMenuItem cancelItem = new JMenuItem("note off");
        final JTextArea ta = new JTextArea(6, 40);   //构造具有指定行数和列数的新的空 TextArea。

        ActionListener menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                ta.append("\nclick \""+cmd+"\"menu");
                if (cmd.equals("exit")) {
                    System.exit(0);
                }
            }
        };
        commentItem.addActionListener(menuListener);
        exitItem.addActionListener(menuListener);

        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

        /*edit.add(autoWrap);
        edit.addSeparator();//split line
        edit.add(copyItem);
        edit.add(pasteItem);

        format.add(commentItem);
        format.add(cancelItem);

        edit.addSeparator();//split line
        edit.add(format);

        jm.add(edit);*/
        jm.add(file);

        //右键菜单

        pop.add(autoWrap);
        pop.addSeparator();//split line
        pop.add(copyItem);
        pop.add(pasteItem);
        format.add(commentItem);
        format.add(cancelItem);
        pop.addSeparator();//split line
        pop.add(format);
        final JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(500, 400));
        jp.add(pop);
        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //super.mouseReleased(e);
                if (e.isPopupTrigger()) {
                    pop.show(jp, e.getX(), e.getY());
                    System.out.println("work?");
                }
            }
            public void mouseClicked(MouseEvent e) {
                System.out.println("it work?");
            }
        });
        jf.add(jp);

        jf.setJMenuBar(jm);
        /*jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                ta.append("user is trying to close the window!\n");
                System.exit(0);
            }
        });*/

        jf.add(new JScrollPane(ta), BorderLayout.NORTH);
        jf.pack();
        jf.setSize(500, 400);
        jf.setVisible(true);
    }

    public static void main(String[] args){
        /*JFrame frame = new JFrame("test for test");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea();

        panel.setLayout(new GridLayout());
        textArea.setText("test");
        //当TextArea里的内容过长时生成滚动条
        panel.add(new JScrollPane(textArea));
        frame.add(panel);

//        frame.setSize(200,200);
        frame.setBounds(200, 300, 200, 200);
        frame.setVisible(true);*/

//        myWindow m = new myWindow();
//        m.myFrame();

//        new myWindow().myFrame();

//        new myWindow().getFilePath();

        new myWindow().myMenu();
    }


}
