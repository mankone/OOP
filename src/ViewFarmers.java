import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ViewFarmers {
	 
	
	public void viewfarmers(){
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Found");
			
		   } catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver not found");
			
		   }
		String url="jdbc:mysql://localhost:3306/Persons";
		String user="root";
		String password="";
		Connection con=null;
		
		
		try {
			 
			 con=DriverManager.getConnection(url,user,password);
			 System.out.println("connected to sql");
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			System.out.println("not connected to sql");
		}
		PreparedStatement stmt=null;
		
		try {
			 stmt = con.prepareStatement("select *  from records");
			System.out.println("selecting record....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed selecting records");
			e.printStackTrace();
		}

		ResultSet out1=null;
		
		try {
			out1=stmt.executeQuery();
			
			System.out.println("executing query");
			
		} catch (SQLException e) {
			System.out.println("Failed executing query");
			e.printStackTrace();
		}
		
		try {
			while(out1.next()){
				System.out.println(out1.getString(1)+" "+out1.getString(2)+" "+out1.getString(3)+" "+out1.getString(4));
				
			}
		} catch (SQLException e) {
			System.out.println("No records found");
			e.printStackTrace();
		}
		}

		
		
	}


