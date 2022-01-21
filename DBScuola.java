package esercizioDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBScuola {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuola","root","P4$$word");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from studenti");
			ResultSetMetaData rsmd=rs.getMetaData();
			int col=rsmd.getColumnCount();
			while(rs.next()) {
				for(int i=1;i<=col;i++) {
					System.out.print(rs.getString(i)+" ");
				}
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
