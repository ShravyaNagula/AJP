import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NewFrame{
	JFrame jfrm;
	JButton jbtn;
	JLabel jlbl;
	NewFrame(){
		jfrm = new JFrame("JFrame 1");
		jfrm.setSize(400, 300);
		jfrm.setLayout(new FlowLayout());
		jlbl = new JLabel("Label");
		jfrm.add(jlbl);
		jbtn = new JButton("Click Me");
		jfrm.add(jbtn);
		jbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFrame nf = new JFrame("New Frame");
				nf.setSize(600,300);
				nf.setLayout(new FlowLayout());
				nf.setLocationRelativeTo(null);
				nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nf.setVisible(true);
			}
		});
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
	}
	public static void main(String[] args){
		new NewFrame();
	}
}