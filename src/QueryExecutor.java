import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 */

/**
 * @author 刘冬燕
 *
 */
public class QueryExecutor {

	private ResultSet SnapResult = null;
	public void ExecQuery(String query, Statement stmt) throws Exception {
		stmt.executeQuery(query);
	}
	public ResultSet SnapQuery(String Query,Statement  stmt) throws Exception{
		SnapResult = stmt.executeQuery(Query);
		return SnapResult;
	}
}
