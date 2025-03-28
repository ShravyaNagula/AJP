package tablesdisplay; 
import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
class DBConnection{
	Connection con;
	Statement stmt;
	ResultSetrs;
	DBConnection(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Soora123");
		} 
		catch(SQLException e){ 
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	Connection getConnection(){
		return con;
	}
	ResultSetgetResults(String sql){
		try{
			stmt = con.createStatement(); rs = stmt.executeQuery(sql);
		} 
		catch(SQLException e){ 
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
		}
		return rs;
	}
}
public class TablesDisplay{ 
	JFramejfrm;
	JTablejtbl; 
	JComboBox<String>jcmbTable; 
	ResultSetrs;
	int nRows, nColumns; 
	String selectedTable;
	//JLabeljlbl; JScrollPanejsp;
	TablesDisplay(){
		jfrm = new JFrame("Display selected table data from ComboBox"); 
		jfrm.setSize(500, 400);
		jfrm.setLayout(new FlowLayout());
		jcmbTable = new <String>JComboBox(); 
		jcmbTable.addItem(""); 
		jcmbTable.addItem("EMP"); 
		jcmbTable.addItem("DEPT");
		jfrm.add(jcmbTable); jtbl = null;
		jsp = null;
		jcmbTable.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){ 
				try {
					if(jcmbTable.getSelectedItem().toString().length() > 0){
						selectedTable = jcmbTable.getSelectedItem().toString();
						rs = new DBConnection().getResults("select count(*) as \"ROWS\" from "+ selectedTable); rs.next();
						nRows = Integer.parseInt(rs.getString("ROWS"));
						rs = new DBConnection().getResults("select count(*) as \"COLUMNS\" from "+ "user_tab_columns where table_name = '" + selectedTable + "'");
						rs.next();
						nColumns = Integer.parseInt(rs.getString("COLUMNS")); String colHeadings[] = new String[nColumns];
						String colDataTypes[] = new String[nColumns];
						rs = new DBConnection().getResults("select column_name, data_type from "+ "user_tab_columns where table_name = '" + selectedTable + "'"); 
						for(int i=0; rs.next(); i++){
							colHeadings[i] = rs.getString("column_name"); 
							colDataTypes[i] = rs.getString("data_type");
						}
						String data[][] = new String[nRows][nColumns];
						rs = new DBConnection().getResults("select * from " + selectedTable); 
						for(int r=0; rs.next(); r++){
							for(int i=0; i<nColumns; i++){
								switch(colDataTypes[i]){
									case "NUMBER":
										data[r][i] = rs.getInt(colHeadings[i])+""; break;
									case "DATE":
										data[r][i] = rs.getDate(colHeadings[i])+""; break;
									case "VARCHAR2":
										data[r][i] = rs.getString(colHeadings[i]) + "";
								}
							}
						}
						if(jsp != null){
							jsp.remove(jtbl); 
							jsp.revalidate(); 
							jsp.repaint(); 
							jfrm.remove(jsp); 
							jfrm.revalidate(); 
							jfrm.repaint();
						}
						jtbl = new JTable(data, colHeadings); 
						jsp = new JScrollPane(jtbl); 
						jfrm.add(jsp);
						jfrm.revalidate(); 
						jfrm.repaint(); 
						jfrm.repaint();
					}
				} 
				catch(SQLException e){ 
					Logger.getLogger(TablesDisplay.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		});
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); jfrm.setVisible(true);
	}
	public static void main(String[] args){ 
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){ 
				new TablesDisplay();
			}
		});
	}
}