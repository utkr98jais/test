import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class jdb2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/new_schema1";
		Connection con = DriverManager.getConnection(url,"root","admin");
		Statement st = con.createStatement();
		
		for (int i=0; i<5;i++) {
			PreparedStatement smt = con.prepareStatement("insert into books values(?,?,?,?,?)");
			System.out.println("Enter recs");
			int id = sc.nextInt();
			sc.nextLine();
			String book = sc.nextLine();
			String author = sc.nextLine();
			float price = sc.nextFloat();
			int no = sc.nextInt();
			smt.setInt(1, id);
			smt.setString(2, book);
			smt.setString(3, author);
			smt.setFloat(4, price);
			smt.setInt(5, no);
			int x=smt.executeUpdate();  
			System.out.println(x+" records inserted"); 
			
		}
		String query2 = "select id from books";
		ResultSet rs = st.executeQuery(query2);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		}
		catch(ClassNotFoundException e) {
			Logger.getLogger(jdb2.class.getName()).log(Level.SEVERE, null,e);
		}
		catch(SQLException e) {
			Logger.getLogger(jdb2.class.getName()).log(Level.SEVERE, null,e);
		}
	}
}
