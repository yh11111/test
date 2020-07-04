package cn.mldn.test.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cn.mldn.dbc.DatabaseConn;
import cn.mldn.factory.DAOFactory;
import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.user;
import junit.framework.TestCase;

class IUserServiceTest {

	@Test
	
	void testInsert() {
		
		user vo=new user();
		vo.setUsername("Ò¦ºç");
		vo.setPassword("123456");
		DatabaseConn data=new DatabaseConn();
		try {
			TestCase.assertTrue(DAOFactory.getUserDAOInstance(data.getConnection()).doCreate(vo));
			//ServiceFactory.getIUserServiceInstance().insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFind() {
		String username="ÕÅÈý";
		try {
			TestCase.assertTrue(ServiceFactory.getIUserServiceInstance().find(username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindU() {
		user vo=new user();
		vo.setUsername("Ò¦ºç");
		vo.setPassword("123456");
		try {
			TestCase.assertTrue(ServiceFactory.getIUserServiceInstance().findU(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
