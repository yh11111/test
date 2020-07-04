package cn.mldn.test.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.item;
import junit.framework.TestCase;

class IItemServiceTest {

	@Test
	void testInsert() {
		item vo=new item();
		vo.setUsername("张三");
		vo.setId(20);
		vo.setItem("其他");
		try {
			TestCase.assertTrue(ServiceFactory.getItemServiceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUpdate() {
		item vo=new item();
		vo.setUsername("张三");
		vo.setId(20);
		vo.setItem("其他");
		try {
			TestCase.assertTrue(ServiceFactory.getItemServiceInstance().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testDelete() {
		item vo=new item();
		vo.setUsername("张三");
		vo.setId(20);
		vo.setItem("其他");
		try {
			TestCase.assertTrue(ServiceFactory.getItemServiceInstance().delete(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindID() {
		item vo=new item();
		vo.setUsername("张三");
		vo.setId(20);
		vo.setItem("其他");
		try {
			TestCase.assertTrue(ServiceFactory.getItemServiceInstance().findID(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindItem() {
		String username="张三";
		String itemname="工资";
		try {
			TestCase.assertNotNull(ServiceFactory.getItemServiceInstance().findItem(username, itemname));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testFindAll() {
		String username="张三";
		try {
			TestCase.assertNotNull(ServiceFactory.getItemServiceInstance().findAll(username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
