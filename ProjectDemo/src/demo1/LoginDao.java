package demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public boolean validate(String name,String pass){  
		boolean status=false; 
		System.out.println("hello");
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");  
		      
		PreparedStatement ps=con.prepareStatement("select username from usereg where username=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();
		System.out.println("hii");
		if(rs.next()){
			System.out.println("true");
			status=true;
		}
		
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
}
