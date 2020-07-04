package cn.mldn.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.dao.IincomeDao;
import cn.mldn.vo.income;

public class incomDaoImpl implements IincomeDao {
	private Connection conn;//需要利用Connection对象操作
	private PreparedStatement pstmt;
	
	public incomDaoImpl(Connection conn)
	{
		this.conn=conn;
	}
	@Override
	public boolean doCreate(income vo) throws Exception {
		String sql="INSERT INTO income(username,id,money,date,itemname,remark) VaLUES(?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,vo.getUsername());
		this.pstmt.setInt(2,vo.getId());
		this.pstmt.setDouble(3, vo.getMoney());
		this.pstmt.setDate(4, new java.sql.Date(vo.getDate().getTime()));
		this.pstmt.setString(5, vo.getItemname());
		this.pstmt.setString(6, vo.getRemark());
		
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(income vo) throws Exception {
		String sql="upDATE income set username=?,id=?,money=?,date=?,itemname=?,remark=? where username=? and id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,vo.getUsername());
		this.pstmt.setInt(2,vo.getId());
		this.pstmt.setDouble(3, vo.getMoney());
		this.pstmt.setDate(4, new java.sql.Date(vo.getDate().getTime()));
		this.pstmt.setString(5, vo.getItemname());
		this.pstmt.setString(6, vo.getRemark());
		this.pstmt.setString(7, vo.getUsername());
		this.pstmt.setInt(8, vo.getId());
		
		return this.pstmt.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(String username,int id) throws Exception {
		if(username==null)
			return false;
		String sql="DELETE FROM income WHERE username=? and id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,username);
		this.pstmt.setInt(2, id);
		return this.pstmt.executeUpdate()==1;
	}

	@Override
	public List<income> dofindTime(String username, Date Sdate, Date Edate) throws Exception {
		List<income> list=new ArrayList<income>();
		String sql="SELECT id,money,date,itemname,remark FROM income WHERE username=? and date>? and date<?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		this.pstmt.setDate(2, new java.sql.Date(Sdate.getTime()));
		this.pstmt.setDate(3, new java.sql.Date(Edate.getTime()));
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next())
		{
			income vo=new income();
			vo.setId(rs.getInt(1));
			vo.setMoney(rs.getDouble(2));
			vo.setDate(rs.getDate(3));
			vo.setItemname(rs.getString(4));
			vo.setRemark(rs.getString(5));
			list.add(vo);
		}
		return list;
	}
	@Override
	public boolean dofindId(String username,int id) throws Exception {
		income vo=null;
		String sql="SELECT id,money,date,itemname,remark FROM income where username=? and id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		this.pstmt.setInt(2, id);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next())
		{
//			vo=new income();
//			vo.setNumber(rs.getString(1));
//			vo.setMoney(rs.getDouble(2));
//			vo.setDate(rs.getDate(3));
//			vo.setId(rs.getInt(4));
//			vo.setRemark(rs.getString(5));
			return true;
		}
//		return vo;
		return false;
	}
	@Override
	public List<income> dofindIncome(String username,String itemname) throws Exception {
		List<income> list=new ArrayList<income>();
		String sql="SELECT id,money,date,itemname,remark FROM income WHERE username=? and itemname=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		this.pstmt.setString(2, itemname);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next())
		{
			income vo=new income();
			vo.setId(rs.getInt(1));
			vo.setMoney(rs.getDouble(2));
			vo.setDate(rs.getDate(3));
			vo.setItemname(rs.getString(4));
			vo.setRemark(rs.getString(5));
			list.add(vo);
		}
		return list;
	}
	@Override
	public List<income> dofindAll(String username) throws Exception {
		List<income> list=new ArrayList<income>();
		String sql="SELECT id,money,date,itemname,remark FROM income WHERE username=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next())
		{
			income vo=new income();
			vo.setId(rs.getInt(1));
			vo.setMoney(rs.getDouble(2));
			vo.setDate(rs.getDate(3));
			vo.setItemname(rs.getString(4));
			vo.setRemark(rs.getString(5));
			list.add(vo);
		}
		return list;
	}

}
