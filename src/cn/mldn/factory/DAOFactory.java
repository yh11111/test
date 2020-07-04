package cn.mldn.factory;

import java.sql.Connection;

import cn.mldn.dao.IItemDAO;
import cn.mldn.dao.Idisburse;
import cn.mldn.dao.IincomeDao;
import cn.mldn.dao.IuserDAO;
import cn.mldn.dao.impl.disburseDaoimpl;
import cn.mldn.dao.impl.incomDaoImpl;
import cn.mldn.dao.impl.itemDaoImp;
import cn.mldn.dao.impl.userDaoImpl;

public class DAOFactory {
	public static IincomeDao getIncomeDAOInstance(Connection conn)
	{
		return new incomDaoImpl(conn);
	}
	public static IuserDAO getUserDAOInstance(Connection conn)
	{
		return new userDaoImpl(conn);
	}
	public static IItemDAO getItemDAOInstance()
	{
		return new itemDaoImp();
	}
	public static Idisburse getIIdisburseInstance(Connection conn)
	{
		return new disburseDaoimpl(conn);
	}
}
