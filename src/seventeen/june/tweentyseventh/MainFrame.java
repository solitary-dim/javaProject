package seventeen.june.tweentyseventh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/5/12
 * Time: 11:05
 */
public class MainFrame {

    public static void main(String[] args) {
        JFrame jf = new JFrame();

        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("选择文件（可多选）");
        JTextField jTextField = new JTextField(10);
        jTextField.setEditable(false);
        jTextField.setBackground(Color.WHITE);
        JButton jButton = new JButton("choose");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setMultiSelectionEnabled(true);
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int rtVal = jFileChooser.showOpenDialog(new JDialog());
                if (rtVal == JFileChooser.APPROVE_OPTION) {
                    File[] files = jFileChooser.getSelectedFiles();
                    String path = "";
                    for (File file : files) {
                        if (file.isFile()) {
                            //多文件选择，得到多文件的名称，及路径
                            System.out.println("file name:" + file.getName() + ": " + file.getAbsolutePath());
                        } else {
                            //多文件选择，得到多文件的名称，及路径
                            System.out.println("file path:" + file.getName() + ": " + file.getAbsolutePath());
                        }
                        path += file.getAbsolutePath() + "\n";
                    }
                    System.out.println("=============================================");
                    System.out.println(path);
                    jTextField.setText(path);
                }
            }
        });
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);

        jf.add(jPanel);
        jf.setTitle("test");
        jf.setVisible(true);
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
