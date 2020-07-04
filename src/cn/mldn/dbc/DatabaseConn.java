package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ����ר�Ÿ������ݿ��������رղ���
 * */
public class DatabaseConn {
	private static final String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String uri="jdbc:sqlserver://localhost;database=������֧����ϵͳ";
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
	 * �������ݿ�Ĺر�
	 */
	public void close() {
		if(this.con!=null)//�������ڴ������Ӷ���
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
       	*  ��ȡ����������
       * @return connectionʵ��������
       */
      public static Connection getConnection() {
    	  return con;
      }
}
