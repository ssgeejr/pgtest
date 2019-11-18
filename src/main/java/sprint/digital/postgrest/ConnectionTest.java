package sprint.digital.postgrest;

import java.sql.*;

public class ConnectionTest {

	public ConnectionTest() {
		
	}
	public ConnectionTest(boolean isLocalTest) {
		//not used, but available for testing from the CLI
	}
	
	public String fetchResults() throws Exception{
		Connection psqlConn = null;
		StringBuffer result = new StringBuffer();
		try {
			psqlConn = DriverManager.getConnection("jdbc:postgresql://pgres:5432/postgres", "magicbox", "magicbox");
			ResultSet rset = psqlConn.createStatement().executeQuery("select loc_type_nme,lat_long_nbr,enb_id from loc limit 5");
			while(rset.next()) {
				result.append("<tr><td>" + rset.getString("loc_type_nme") + "</td><td>" + rset.getString("lat_long_nbr") + "</td><td>" + rset.getString("enb_id") + "</td></tr>");
			}
			return result.toString();
		}finally {
			try {psqlConn.close();}catch(Exception ex) {}
		}
	}
	
//	String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//	Connection conn = DriverManager.getConnection(url);
//	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")

	public static void main(String[] args) {
		new ConnectionTest(true);
	}

}
