package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 本类专门负责数据库的连接与关闭操作
 * */
public class DatabaseConn {
	private static final String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String uri="jdbc:sqlserver://localhost;database=个人收支管理系统";
	private static final String name="sa";
	private static final String password="123456";
	private static Connection con=null;
	
	public DatabaseConn()
	{
			try {
				Class.forName(Driver);
				this.con=DriverManager.getConnection(uri,name,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
     
	/**
	 * 负责数据库的关闭
	 */
	public void close() {
		if(this.con!=null)//表现现在存在连接对象
		{
			try {
				this.con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
      /**
       	*  获取连接器对象
       * @return connection实例化对象
       */
      public static Connection getConnection() {
    	  return con;
      }
}
