package Connection;

import java.sql.*;

public class myConnect {

	//static final String JDBC_DRIVER = "com.mysql.jdbc.GoogleDriver";  
	//static final String DB_URL = "jdbc:google:mysql://dtdm-st3:us-central1:instance";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/xemtintuc";
	
	static final String USER = "root";
	static final String PASS = "123a"; 
	private Connection conn = null;
	

	public myConnect ()
	{
		 try{
		    
		      Class.forName(JDBC_DRIVER);

		      setConn(DriverManager.getConnection(DB_URL, USER, PASS));
		
		     
		   }catch(SQLException se){
		      System.out.println("KET NOI DATABASE THAT BAI........");
		      se.printStackTrace();
		   }catch(Exception e){
			   System.out.println("XIN LOI........");
		      e.printStackTrace();
		   }
	}


	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	public void CloseConn() {
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
