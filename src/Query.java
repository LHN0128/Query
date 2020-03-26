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
public class Query {

    private static Connection conn;
    private static Statement stmt;

    public static Statement initStatement(String url, String username, String password)throws Exception {
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
        String sql = "select s_acctbal,s_name,n_name,p_partkey,p_mfgr,s_address,s_phone,s_comment from part,supplier,partsupp,nation,region where p_partkey = ps_partkey and s_suppkey = ps_suppkey and p_size = 1 and p_type like '%BRASS' and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name = 'EUROPE' and ps_supplycost = (select min(ps_supplycost) from partsupp,supplier,nation,region where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name ='EUROPE') order by s_acctbal desc,n_name,s_name,p_partkey;";

        stmt = conn.createStatement();
        return stmt;
    }
    public void CloseConnection()throws Exception{
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        stmt = initStatement("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
        String sql = "select * from pg_stat_statements";
        Object o = stmt.executeQuery(sql);

    }

}
