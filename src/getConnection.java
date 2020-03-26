import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 */

/**
 * @author 刘冬燕
 *
 */
public class getConnection {

	private Connection conn;
	private Statement stmt;

	public Statement initStatement(String url, String username, String password)throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);//?把自动提交??
			System.out.println("Opened database successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = conn.createStatement();
		return stmt;
	}
	public void CloseConnection()throws Exception{
		stmt.close();
		conn.close();
	}

}
