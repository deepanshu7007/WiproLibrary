package ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionProvider {
private Connection con;
public Connection establishConnection()
{
try {
	con = DriverManager.getConnection("jdbc:sqlite:/home/deepanshu/practical/Database/matrixDatabase");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
return con;
}

public void closeConnection()
{
try {
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}
}