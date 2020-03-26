import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection c = null;
        Statement stmt = null;

        go();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            c.setAutoCommit(false);// 把自动提交  
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void go() {
        String user = "root";//SSH连接用户名
        String password = "8839962";//SSH连接密码
        String host = "192.168.233.129";//SSH服务器
        int port = 22;//SSH访问端口
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息

            int assinged_port = session.setPortForwardingL(5432, "192.168.233.129", 5432);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}