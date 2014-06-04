import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.catalina.ha.deploy.FarmWarDeployer;





public class InsertDb {

	
	public static void MyConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver has been found");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver failed");
			e.printStackTrace();
		}
		
	}
	
	public static void  ConnectToDb(String Fname,String Sname, int Farmerno,int Noofbags){
		MyConnection();
		
		try {
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Persons","root","");
			System.out.println("Records inserted Succesful");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO records(Fname,Sname,Farmerno,Noofbags)VALUES(?,?,?,?)");
			stmt.setString(1, Fname);
			stmt.setString(2, Sname);
			stmt.setInt(3, Farmerno);
			stmt.setInt(4, Noofbags);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection to Db failed");
		}
		
		
		
	} 
	public static void main(String[] args) {
		
		//adding records to database as in Fname,sname, and bag collection
		
		ConnectToDb("Michael"," Mwangi",0,2);
		
		//cannot put 1,2..... since field is primary on the database
		
		ViewFarmers obj =new ViewFarmers();
		
		//viewing the database
		
		obj.viewfarmers();
		
		
		
	}

}
