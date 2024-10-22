import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
public class WindowEvents{
	JFrame jfrm;
	WindowEvents(){
		jfrm = new JFrame("Mouse Events");
		jfrm.setSize(400, 300);
		jfrm.setLayout(new FlowLayout());
		jfrm.addWindowListener(new WindowListener(){
			public void windowOpened(WindowEvent e){
				jfrm.setTitle("windowOpened");
				System.out.println("windowOpened");
			}
			public void windowClosing(WindowEvent e){
				jfrm.setTitle("windowClosing");
				System.out.println("windowClosing");
			}
			public void windowClosed(WindowEvent e){
				jfrm.setTitle("windowClosed");
				System.out.println("windowClosed");
			}
			public void windowIconified(WindowEvent e){
				jfrm.setTitle("windowIconified");
				System.out.println("windowIconified");
			}
			public void windowDeiconified(WindowEvent e){
				jfrm.setTitle("windowDeiconified");
				System.out.println("windowDeiconified");
			}
			public void windowActivated(WindowEvent e){
				jfrm.setTitle("windowActivated");
				System.out.println("windowActivated");
			}
			public void windowDeactivated(WindowEvent e){
				jfrm.setTitle("windowDeactivated");
				System.out.println("windowDeactivated");
			}
		});
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
	}
	public static void main(String[] args){
		new WindowEvents();
	}
}