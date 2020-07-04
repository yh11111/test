package cn.itcast.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnMgr {
	static Connection con;
	//if(con!=null) 
	//连接器（数据库）
	static PreparedStatement prestm;
	
	//传数据建立连接
	public void ConDatabase(){
		try {
			try {
				new Conn("jdbc:sqlserver://localhost;database=Java","sa","123456");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=Conn.getConnection();
			//测试数据 是否连接      (已成功)
			//System.out.println(con.getMetaData().getUserName()+"---------连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con==null)
				System.out.println("连接失败");
		}
	}
	// 查询是否有此用户
		//如果有此用户则返回1，否则返回-1
		public int queryUser(String u,String p) {
			//使用预编译器查询 查询是否有此语句 如果有返回true 没有返回false
			String sql="select * from user where username=? and password=?";
			try {
				prestm=con.prepareStatement(sql);
				prestm.setString(1,u);
				prestm.setString(2,p);
			
				ResultSet rs=prestm.executeQuery();
				while(rs.next()) {
					 //System.out.println(rs.getString(1)+rs.getString(2));
						return 1;
				}//这个大括号
				}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return -1;
		}

}
