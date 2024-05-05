package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static  Connection con  = null;
	private static ConnectionDB instance = new ConnectionDB();
	private ConnectionDB() {
		//private constructor to prevent instantiation;
	}
	public static ConnectionDB getInstance() {
		return instance;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLBanNuoc";
		String user = "sa";
		String password = "sapassword";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnectionDB() {
		return con;
	}
		public static void main(String[] args)  {
		Connection con = null;
		try {
			String url = "jdbc:sqlserver://localhost:1433;databasename=QLBanNuoc";
			String user = "sa";
			String password = "sapassword";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
