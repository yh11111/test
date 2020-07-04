package cn.mldn.service.impl;

import java.util.Date;
import java.util.List;

import cn.mldn.dbc.DatabaseConn;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IIncomeService;
import cn.mldn.vo.income;

public class incomeServiceImpl implements IIncomeService {
	//在这个类的对象内部就提供一个数据库连接的实例化对象
	private DatabaseConn dbc=new DatabaseConn();
	
	@Override
	public boolean insert(income vo) throws Exception {
		try {
			//如果要增加的数据编号不存在,则findId()返回的结果就是null，null表示可以进行添加收入数据
			if(!(DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).dofindId(vo.getUsername(),vo.getId())))
				return DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).doCreate(vo);
			return false;
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(income vo) throws Exception {
		try {
			return DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).doUpdate(vo);
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
			return DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).doRemove(username, id);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<income> FindTime(String username, Date Sdate, Date Edate) throws Exception {
		try {
			return DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).
			dofindTime(username, new java.sql.Date(Sdate.getTime()), new java.sql.Date(Edate.getTime()));
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<income> FindIncome(String username, String itemname) throws Exception {
		try {
			return DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).dofindIncome(username, itemname);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<income> findAll(String username) throws Exception {
		try {
			return DAOFactory.getIncomeDAOInstance(this.dbc.getConnection()).dofindAll(username);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
