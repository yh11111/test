package cn.itcast.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnMgr {
	static Connection con;
	//if(con!=null) 
	//�����������ݿ⣩
	static PreparedStatement prestm;
	
	//�����ݽ�������
	public void ConDatabase(){
		try {
			try {
				new Conn("jdbc:sqlserver://localhost;database=Java","sa","123456");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=Conn.getConnection();
			//�������� �Ƿ�����      (�ѳɹ�)
			//System.out.println(con.getMetaData().getUserName()+"---------���ӳɹ���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con==null)
				System.out.println("����ʧ��");
		}
	}
	// ��ѯ�Ƿ��д��û�
		//����д��û��򷵻�1�����򷵻�-1
		public int queryUser(String u,String p) {
			//ʹ��Ԥ��������ѯ ��ѯ�Ƿ��д���� ����з���true û�з���false
			String sql="select * from user where username=? and password=?";
			try {
				prestm=con.prepareStatement(sql);
				prestm.setString(1,u);
				prestm.setString(2,p);
			
				ResultSet rs=prestm.executeQuery();
				while(rs.next()) {
					 //System.out.println(rs.getString(1)+rs.getString(2));
						return 1;
				}//���������
				}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return -1;
		}

}
