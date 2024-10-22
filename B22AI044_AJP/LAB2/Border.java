import javax.swing.*;
import java.awt.*;
public class Border{
	Border(){
		JFrame jfrm = new JFrame("Border Layout");
		jfrm.setSize(400, 300);
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		jfrm.setLayout(layout);
		JButton jbtn1 = new JButton("NORTH");
		JButton jbtn2 = new JButton("EAST");
		JButton jbtn3 = new JButton("SOUTH");
		JButton jbtn4 = new JButton("WEST");
		JButton jbtn5 = new JButton("CENTER");
		jfrm.add(jbtn1, BorderLayout.NORTH);
		jfrm.add(jbtn2, BorderLayout.EAST);
		jfrm.add(jbtn3, BorderLayout.SOUTH);
		jfrm.add(jbtn4, BorderLayout.WEST);
		jfrm.add(jbtn5, BorderLayout.CENTER);
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new Border();
	}
}