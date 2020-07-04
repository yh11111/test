package cn.mldn.test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.disburse;
import cn.mldn.vo.income;
import junit.framework.TestCase;

class IIncomeServiceTest {

	@Test
	void testInsert() {
		income vo=new income();
		vo.setUsername("姚虹");
		vo.setId(100585);
		vo.setMoney(9595.5);
		vo.setItemname("生活用品");
		vo.setDate(new Date());
		vo.setRemark("无");
		try {
			TestCase.assertTrue(ServiceFactory.getIIncomeServiceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUpdate() {
		income vo=new income();
		vo.setUsername("姚虹");
		vo.setId(100585);
		vo.setMoney(9595.5);
		vo.setItemname("化妆");
		vo.setDate(new Date());
		vo.setRemark("无");
		try {
			TestCase.assertTrue(ServiceFactory.getIIncomeServiceInstance().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testDelete() {
		String username="姚虹";
		int id=100585;
		try {
			TestCase.assertTrue(ServiceFactory.getIIncomeServiceInstance().delete(username, id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindTime() {
		String username="张三";
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
			TestCase.assertNotNull(ServiceFactory.getIIncomeServiceInstance().FindTime(username, Sdate,Edate));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindIncome() {
		String username="张三";
		String itemname="工资";
		try {
			TestCase.assertNotNull(ServiceFactory.getIIncomeServiceInstance().FindIncome(username, itemname));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindAll() {
		String username="张三";
		try {
			TestCase.assertNotNull(ServiceFactory.getIIncomeServiceInstance().findAll(username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
