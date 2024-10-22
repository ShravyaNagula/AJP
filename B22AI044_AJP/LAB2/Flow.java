import javax.swing.*;
import java.awt.*;
public class Flow{
	Flow(){
		JFrame jfrm = new JFrame("Flow Layout");
		jfrm.setSize(400, 300);
		jfrm.setLayout(new FlowLayout());
		JButton jbtn1 = new JButton("1");
		JButton jbtn2 = new JButton("2");
		JButton jbtn3 = new JButton("3");
		JButton jbtn4 = new JButton("4");
		JButton jbtn5 = new JButton("5");
		jfrm.add(jbtn1);
		jfrm.add(jbtn2);
		jfrm.add(jbtn3);
		jfrm.add(jbtn4);
		jfrm.add(jbtn5);
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new Flow();
	}
}