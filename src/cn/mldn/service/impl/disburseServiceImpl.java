package cn.mldn.service.impl;

import java.util.Date;
import java.util.List;

import cn.mldn.dbc.DatabaseConn;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IDisburseService;
import cn.mldn.vo.disburse;

public class disburseServiceImpl implements IDisburseService {
	//�������Ķ����ڲ����ṩһ�����ݿ����ӵ�ʵ��������
	private DatabaseConn dbc=new DatabaseConn();
	
	@Override
	public boolean insert(disburse vo) throws Exception {
		try {
			//���Ҫ���ӵ����ݱ�Ų�����,��findrId()���صĽ������null��null��ʾ���Խ��������������
			if(!(DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).dofindId(vo.getUsername(),vo.getId())))
				return DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).doCreate(vo);
			return false;
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(disburse vo) throws Exception {
		try {
			return DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	
	}

	@Override
	public boolean delete(String username, int id) throws Exception {
		try {
			return DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).doRemove(username, id);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<disburse> FindTime(String username, Date Sdate, Date Edate) throws Exception {
		try {
			return DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).
			dofindTime(username, new java.sql.Date(Sdate.getTime()), new java.sql.Date(Edate.getTime()));
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<disburse> FindIncome(String username, String itemname) throws Exception {
		try {
			return DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).dofindIncome(username, itemname);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<disburse> findAll(String username) throws Exception {
		try {
			return DAOFactory.getIIdisburseInstance(this.dbc.getConnection()).dofindAll(username);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
