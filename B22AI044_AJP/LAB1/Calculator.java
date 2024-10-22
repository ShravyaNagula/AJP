import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Calculator{
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(500,400);
		f.setLayout(null);
		JLabel jlbl1 = new JLabel("Enter Number1: ");
		JLabel jlbl2 = new JLabel("Enter Number2: ");
		JLabel jlbl3 = new JLabel("Result: ");
		final JTextField txt1 = new JTextField(20);
		final JTextField txt2 = new JTextField(20);
		final JTextField txt3 = new JTextField(20);
		JButton jbtn1 = new JButton("ADD");
		JButton jbtn2 = new JButton("SUBTRACT");
		JButton jbtn3 = new JButton("MULTIPLY");
		JButton jbtn4 = new JButton("DIVIDE");
		jlbl1.setBounds(20, 20, 100, 20);
		txt1.setBounds(140, 20, 100, 20);
		jlbl2.setBounds(20, 50, 100, 20);
		txt2.setBounds(140, 50, 100, 20);
		jlbl3.setBounds(20, 80, 100, 20);
		txt3.setBounds(140, 80, 100, 20);
		jbtn1.setBounds(80, 120, 80, 20);
		jbtn2.setBounds(180, 120, 80, 20);
		jbtn3.setBounds(280, 120, 80, 20);
		jbtn4.setBounds(380, 120, 80, 20);
		jbtn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int n1 = Integer.parseInt(txt1.getText());
				int n2 = Integer.parseInt(txt2.getText());
				int res = n1+n2;
				txt3.setText(Integer.toString(res));
			}
		});
		jbtn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int n1 = Integer.parseInt(txt1.getText());
				int n2 = Integer.parseInt(txt2.getText());
				int res = n1-n2;
				txt3.setText(Integer.toString(res));
			}
		});
		jbtn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int n1 = Integer.parseInt(txt1.getText());
				int n2 = Integer.parseInt(txt2.getText());
				int res = n1*n2;
				txt3.setText(Integer.toString(res));
			}
		});
		jbtn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int n1 = Integer.parseInt(txt1.getText());
				int n2 = Integer.parseInt(txt2.getText());
				int res = n1/n2;
				txt3.setText(Integer.toString(res));
			}
		});
		f.add(jlbl1);
        f.add(txt1);
        f.add(jlbl2);
        f.add(txt2);
        f.add(jlbl3);
        f.add(txt3);
        f.add(jbtn1);
        f.add(jbtn2);
        f.add(jbtn3);
        f.add(jbtn4);
		f.setVisible(true);
	}
}	