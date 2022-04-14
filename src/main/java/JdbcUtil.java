import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description:
 * @author: zhengyuhui
 * @date: 2022/4/13 10:01
 */
public class JdbcUtil {

	private static DataSource dataSource;
	public static void initDataSource(){
		Properties properties = new Properties();
		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			properties.load(in);
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getDataSource(){
		try {
			Connection connection =dataSource.getConnection();
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ServerSocket serverSocket = new ServerSocket(6666);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void release(Connection connection, PreparedStatement preparedStatement){
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
