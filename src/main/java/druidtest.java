import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * @description:
 * @author: zhengyuhui
 * @date: 2022/4/13 10:01
 */
public class druidtest {

	public static void main(String[] args) {
		JdbcUtil.initDataSource();
		System.out.println("================1");
		Connection connection = JdbcUtil.getDataSource();
		System.out.println("================2");
		Connection connection2 = JdbcUtil.getDataSource();
		System.out.println("================3");
	}


	public static void excuteSql(String name){
		// 创建sql
		String sql = "insert into demo_user values(?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			// 获得连接
			System.out.println("startGetConnect name:"+name);
			connection = JdbcUtil.getDataSource();
			System.out.println("GetConnect successFul name:"+name);
			Thread.sleep(1000000L);
			// 开启事务设置非自动提交
			connection.setAutoCommit(false);
			// 获得Statement对象
			statement = connection.prepareStatement(sql);
			// 设置参数
			statement.setString(1, "zzf003");
			statement.setInt(2, 18);
			statement.setString(3, "hangzhou");
			statement.setString(4, "gongshu");
			// 执行
			statement.executeUpdate();
			// 提交事务
			connection.commit();

		}catch (Exception e){

		}finally {
			// 释放资源
			JdbcUtil.release(connection, statement);
		}
	}
}
