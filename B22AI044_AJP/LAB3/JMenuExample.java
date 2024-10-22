import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JMenuExample {
    JMenu jmFile;
    JMenu jmOptions, jmColor;
    JMenuBar jmb;
    JFrame jfrm;
    JLabel jlbl;
    Font f;

    JMenuExample() {
        jfrm = new JFrame("Menu Bar Example");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(500, 400);
        jfrm.setLocationRelativeTo(null);
        jlbl = new JLabel("Actions Displayed here");
        jfrm.add(jlbl);

        jmFile = new JMenu("File");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiSaveAs = new JMenuItem("Save As");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmFile.setMnemonic(KeyEvent.VK_F);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmiSave.setMnemonic(KeyEvent.VK_S);
        jmFile.add(jmiSaveAs);
        jmFile.addSeparator();
        jmFile.add(jmiExit);

        jmb = new JMenuBar();
        jmb.add(jmFile);
        jfrm.setJMenuBar(jmb);

        jmOptions = new JMenu("Options");
        jmColor = new JMenu("Color");
        JMenuItem jmiFontSize = new JMenuItem("Font Size");
        JMenuItem jmiRedColor = new JMenuItem("Red color");
        JMenuItem jmiGreenColor = new JMenuItem("Green Color");
        JMenuItem jmiBlueColor = new JMenuItem("Blue color");

        jmOptions.add(jmiFontSize);
        jmColor.add(jmiRedColor);
        jmColor.add(jmiGreenColor);
        jmColor.add(jmiBlueColor);
        jmb.add(jmOptions);
        jmOptions.add(jmColor);

        jmiOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbl.setText(e.getActionCommand() + " Selected");
            }
        });
        jmiSaveAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbl.setText(e.getActionCommand() + " Selected");
            }
        });
        jmiExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jmiFontSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbl.setFont(new Font("ALGERIAN", Font.BOLD, 30));
            }
        });
        jmiGreenColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbl.setForeground(Color.green);
            }
        });
        jmiRedColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbl.setForeground(Color.red);
            }
        });
        jmiBlueColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbl.setForeground(Color.blue);
            }
        });

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        new JMenuExample();
    }
}