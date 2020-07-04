package cn.mldn.test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.disburse;
import junit.framework.TestCase;

class IDisburseServiceTest {
	@Test
	public void testInsert() {
		disburse vo=new disburse();
		vo.setUsername("Ҧ��");
		vo.setId(100585);
		vo.setMoney(9595.5);
		vo.setItemname("������Ʒ");
		vo.setDate(new Date());
		vo.setRemark("��");
		try {
			TestCase.assertTrue(ServiceFactory.getdisburseServiceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		disburse vo=new disburse();
		vo.setUsername("Ҧ��");
		vo.setId(100585);
		vo.setMoney(9595.5);
		vo.setItemname("��ױ");
		vo.setDate(new Date());
		vo.setRemark("��");
		try {
			TestCase.assertTrue(ServiceFactory.getdisburseServiceInstance().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		String username="Ҧ��";
		int id=100585;
		try {
			TestCase.assertTrue(ServiceFactory.getdisburseServiceInstance().delete(username, id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindTime() {
		String username="����";
		String sd="2020/7/1 00:00:00";
		String Ed="2020/7/7 00:00:00";
		Date Sdate=null;
		Date Edate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Sdate=sdf.parse(sd);
			Edate=sdf.parse(Ed);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TestCase.assertNotNull(ServiceFactory.getdisburseServiceInstance().FindTime(username, Sdate,Edate));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindIncome() {
		String username="����";
		String itemname="����";
		try {
			TestCase.assertNotNull(ServiceFactory.getdisburseServiceInstance().FindIncome(username, itemname));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAll() {
		String username="����";
		try {
			TestCase.assertNotNull(ServiceFactory.getdisburseServiceInstance().findAll(username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
