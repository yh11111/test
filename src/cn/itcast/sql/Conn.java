package cn.itcast.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	private String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String uri;
	private String name;
	private String password;
	private static Connection con;
	
	
      public Conn(String uri,String name,String password) throws SQLException, ClassNotFoundException {
		  this.uri=uri;
		  this.name=name;
		  this.password=password;
		  con=DriverManager.getConnection(uri,name,password);
      }

      //获取连接器对象
      public static Connection getConnection() {
	  return con;
      }
}
