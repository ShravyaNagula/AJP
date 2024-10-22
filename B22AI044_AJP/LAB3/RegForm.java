import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
public class RegForm{
	JFrame jfrm;
	JLabel jln, jlr, jlm;
	JTextField jtn, jtr, jtm;
	JScrollPane jsp;
	JTable jtbl;
	JButton jbsave, jbdisp;
	RegForm(){
		jfrm = new JFrame("File Chooser");
		jfrm.setSize(500, 500);
		jfrm.setLayout(null);
		jln = new JLabel("Name: ");
		jln.setBounds(100, 10, 50, 30);
		jfrm.add(jln);
		jtn = new JTextField("");
		jtn.setBounds(160, 10, 100, 30);
		jfrm.add(jtn);
		jlr = new JLabel("Roll No: ");
		jlr.setBounds(100, 10, 50, 30);