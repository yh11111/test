package cn.mldn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.mldn.dao.IuserDAO;
import cn.mldn.vo.income;
import cn.mldn.vo.user;

public class userDaoImpl implements IuserDAO {
	private Connection conn;//��Ҫ����Connection�������
	private PreparedStatement pstmt;
	
	public userDaoImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(user vo) throws Exception {
		String sql="insert into [user](username,password) values(?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,vo.getUsername());
		this.pstmt.setString(2,vo.getPassword());
		
		return this.pstmt.executeUpdate()>0;
		
			
	}

	@Override
	public boolean findUsername(String username) throws Exception {
		//ʹ��Ԥ��������ѯ ��ѯ�Ƿ��д���� ����з���true û�з���false
		String sql="select * from [user] where username=?";
		pstmt=conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
				return true;
		}
		return false;
	}
	@Override
	public boolean findUser(user vo) throws Exception {
		//ʹ��Ԥ��������ѯ ��ѯ�Ƿ��д���� ����з���true û�з���false
		String sql="select * from [user] where username=? and password=?";
		try {
				this.pstmt=conn.prepareStatement(sql);
				this.pstmt.setString(1,vo.getUsername());
				this.pstmt.setString(2,vo.getPassword());
			
				ResultSet rs=this.pstmt.executeQuery();
				while(rs.next()) {
						return true;
					}
			}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
