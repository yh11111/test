package cn.mldn.service.impl;

import cn.mldn.dbc.DatabaseConn;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IUserService;
import cn.mldn.vo.user;

public class userServiceImpl implements IUserService {
	//�������Ķ����ڲ����ṩһ�����ݿ����ӵ�ʵ��������
	private DatabaseConn dbc=new DatabaseConn();
	@Override
	public boolean insert(user vo) throws Exception {
		try {
			//���Ҫ���ӵ��û�������,��findusername()���صĽ������null��null��ʾ���Խ��������������
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
