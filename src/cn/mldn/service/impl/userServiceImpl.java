package cn.mldn.service.impl;

import cn.mldn.dbc.DatabaseConn;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IUserService;
import cn.mldn.vo.user;

public class userServiceImpl implements IUserService {
	//在这个类的对象内部就提供一个数据库连接的实例化对象
	private DatabaseConn dbc=new DatabaseConn();
	@Override
	public boolean insert(user vo) throws Exception {
		try {
			//如果要增加的用户不存在,则findusername()返回的结果就是null，null表示可以进行添加收入数据
			if(!(DAOFactory.getUserDAOInstance(this.dbc.getConnection()).findUsername(vo.getUsername())))
				return DAOFactory.getUserDAOInstance(this.dbc.getConnection()).doCreate(vo);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean find(String username) throws Exception {
		try {
			return DAOFactory.getUserDAOInstance(this.dbc.getConnection()).findUsername(username);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean findU(user vo) throws Exception {
		try {
			return DAOFactory.getUserDAOInstance(this.dbc.getConnection()).findUser(vo);
		}catch(Exception e)
		{
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
