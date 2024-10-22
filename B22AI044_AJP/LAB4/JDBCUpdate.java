import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.*;
class DBConnection{
	Connection con;
	Statement stmt;
	ResultSet rs;
	DBConnection(){
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
		}
		catch(SQLException e){ 
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	Connection getConnection(){
		return con;
	}
	Object getResults(String sql, boolean flag){
		int n=0; 
		try{
			if(flag == true){
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(sql); 
				return rs;
			}
			else{
				stmt = con.createStatement(); 
				n = stmt.executeUpdate(sql); 
				return n;
			}
		}
		catch(SQLException e){ 
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
		return n;
	}
}
public class JDBCUpdate{
	JFrame jfrm; 
	JTextField jtf1, jtf2;
	JButton jbtnFirst, jbtnLast, jbtnNext, jbtnPrev, jbtnQuery, jbtnDelete, jbtnUpdate, jbtnInsert;
	JLabel jlbl1, jlbl2; 
	boolean flag; 
	ResultSetrs; 
	String c1 = ""; 
	String c2 = "";
	JDBCUpdate(){
		flag = false;
		jfrm = new JFrame("JFrame for DB Updates"); 
		jfrm.setSize(350, 200);
		jfrm.setLayout(null);
		jlbl1 = new JLabel("C1: "); 
		jlbl1.setBounds(60, 10, 40, 30); 
		jfrm.add(jlbl1);
		jtf1 = new JTextField(); 
		jtf1.setBounds(90, 10, 50, 30); 
		jfrm.add(jtf1);
		jlbl1 = new JLabel("C2: "); 
		jlbl1.setBounds(170, 10, 40, 30); 
		jfrm.add(jlbl1);
		jtf2 = new JTextField();
		jtf2.setBounds(200, 10, 50, 30);
		jfrm.add(jtf2);
		jbtnQuery = new JButton("Query"); 
		jbtnQuery.setBounds(20, 50, 80, 30); 
		jfrm.add(jbtnQuery);
		jbtnQuery.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				try {
					flag = true;
					rs = (ResultSet)new DBConnection().getResults("select * from test1", flag); 
					if(rs != null){
						if(rs.next()){
							jtf1.setText(rs.getString("C1")); 
							jtf2.setText(rs.getString("C2")); 
							c1 = jtf1.getText();
							c2 = jtf2.getText();
						}
					}
				} 
				catch (SQLException e){ 
					Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		});
		jbtnDelete = new JButton("Delete"); 
		jbtnDelete.setBounds(90, 50, 80, 30); 
		jfrm.add(jbtnDelete);
		jbtnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty()){
					flag = false;
					int n = (int)new DBConnection().getResults("delete from test1 where C1 = '" + jtf1.getText()+"' and C2 = '" + jtf2.getText()+"'", flag); 
					JOptionPane.showMessageDialog(jfrm, "Deleted " + n + " Records in DB", "Alert", JOptionPane.INFORMATION_MESSAGE);
					if(n != 0){
						try{
							flag = true;
							rs = (ResultSet)new DBConnection().getResults("select * from test1", flag); 
							if(rs != null){
								if(rs.first()){
									jtf1.setText(rs.getString("C1")); 
									jtf2.setText(rs.getString("C2")); 
									c1 = jtf1.getText();
									c2 = jtf2.getText();
								}
							}
							else{
								jtf1.setText("");
								jtf2.setText("");
								c1 = jtf1.getText(); 
								c2 = jtf2.getText();
							}
						} 
						catch(SQLException e){ 
							Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, e);
						}
					}
				}
			}
		});
		jbtnUpdate = new JButton("Update"); jbtnUpdate.setBounds(160, 50, 80, 30); 
		jfrm.add(jbtnUpdate);
		jbtnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(jfrm, c1 + ", " + c2, "Alert", JOptionPane.INFORMATION_MESSAGE);
				if(!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty()){
					flag = false;
					int n = (int)new DBConnection().getResults("update test1 set C1 = '" +jtf1.getText()+"', C2 = '" + jtf2.getText()+"' where C1 = '" + c1 + "' and C2 = '" + c2 + "'", flag); 
					JOptionPane.showMessageDialog(jfrm, "Updated " + n + " Records in DB", "Alert", JOptionPane.INFORMATION_MESSAGE); 
					if(n != 0){
						try {
							flag = true;
							rs = (ResultSet)new DBConnection().getResults("select * from test1", flag); 
							if(rs != null){
								if(rs.first()){
									jtf1.setText(rs.getString("C1")); 
									jtf2.setText(rs.getString("C2"));
								}
							}
							else{
								jtf1.setText("");
								jtf2.setText("");
							}
						} 
						catch (SQLException ex) { 
							Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
			}
		});
		jbtnInsert = new JButton("Insert"); 
		jbtnInsert.setBounds(230, 50, 80, 30); 
		jfrm.add(jbtnInsert);
		jbtnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty()){
					flag = false;
					int n = (int)new DBConnection().getResults("insert into test1 values('" + jtf1.getText()+"', '" + jtf2.getText()+"')", flag); 
					JOptionPane.showMessageDialog(jfrm, "Inserted " + n + " Records in DB", "Alert", JOptionPane.INFORMATION_MESSAGE);
					if(n != 0){
						try {
							flag = true;
							rs = (ResultSet)new DBConnection().getResults("select * from test1", flag); 
							if(rs != null){
								if(rs.first()){
									jtf1.setText(rs.getString("C1")); 
									jtf2.setText(rs.getString("C2")); 
									c1 = jtf1.getText();
									c2 = jtf2.getText();
								}
							}
							else{
								jtf1.setText("");
								jtf2.setText("");
								c1 = jtf1.getText(); 
								c2 = jtf2.getText();
							}
						} 
						catch (SQLException e){ 
							Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, e);
						}
					}
				}
			}
		});
		jbtnFirst = new JButton("First"); 
		jbtnFirst.setBounds(20, 100, 80, 30); 
		jfrm.add(jbtnFirst);
		jbtnFirst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				if(rs == null){
					flag = true;
					rs = (ResultSet)new DBConnection().getResults("select * from test1", flag);
				}
				if(rs != null){
					try {
						if(!rs.isFirst()){
							rs.first(); 
							jtf1.setText(rs.getString("C1")); 
							jtf2.setText(rs.getString("C2")); 
							c1 = jtf1.getText();
							c2 = jtf2.getText();
						}
					} 
					catch(SQLException e){ 
						Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});
		jbtnNext = new JButton("Next"); 
		jbtnNext.setBounds(90, 100, 80, 30); 
		jfrm.add(jbtnNext);
		jbtnNext.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
				if(rs == null){
					flag = true;
					rs = (ResultSet)new DBConnection().getResults("select * from test1", flag);
				}
				if(rs != null){
					try{ 
						if(!rs.isLast()){
							rs.next(); 
							jtf1.setText(rs.getString("C1")); 
							jtf2.setText(rs.getString("C2")); 
							c1 = jtf1.getText();
							c2 = jtf2.getText();
						}
					} 
					catch(SQLException e){ 
						Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			} 
		});
		jbtnPrev = new JButton("Prev");
		jbtnPrev.setBounds(160, 100, 80, 30); 
		jfrm.add(jbtnPrev);
		jbtnPrev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				if(rs == null){
					flag = true;
					rs = (ResultSet)new DBConnection().getResults("select * from test1", flag);
				}
				if(rs != null){
					try{ 
						if(!rs.isFirst()){
							rs.previous();
							jtf1.setText(rs.getString("C1")); 
							jtf2.setText(rs.getString("C2")); 
							c1 = jtf1.getText();
							c2 = jtf2.getText();
						} 
					}
					catch(SQLException e){ 
						Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			}
		});
		jbtnLast = new JButton("Last"); 
		jbtnLast.setBounds(230, 100, 80, 30); 
		jfrm.add(jbtnLast); 
		jbtnLast.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(rs == null){
					flag = true;
					rs = (ResultSet)new DBConnection().getResults("select * from test1", flag);
				}
				if(rs != null){
					try { 
						rs.last();
						jtf1.setText(rs.getString("C1")); 
						jtf2.setText(rs.getString("C2")); 
						c1 = jtf1.getText();
						c2 = jtf2.getText();
					} 
					catch(SQLException e){ 
						Logger.getLogger(JDBCUpdate.class.getName()).log(Level.SEVERE, null, e);
					}
				}
			}
		});
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jfrm.setVisible(true);
		jfrm.setResizable(false);
	}
	public static void main(String[] args){ 
		new JDBCUpdate();
	}
}