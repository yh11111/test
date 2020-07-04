package cn.mldn.factory;

import cn.mldn.service.IDisburseService;
import cn.mldn.service.IIncomeService;
import cn.mldn.service.IItemService;
import cn.mldn.service.IUserService;
import cn.mldn.service.impl.disburseServiceImpl;
import cn.mldn.service.impl.incomeServiceImpl;
import cn.mldn.service.impl.itemServiceImpl;
import cn.mldn.service.impl.userServiceImpl;


public class ServiceFactory {
	public static IIncomeService getIIncomeServiceInstance() {
		return new incomeServiceImpl();
	}
	public static IUserService getIUserServiceInstance() {
		return  new userServiceImpl();
	}
	public static IItemService getItemServiceInstance() {
		return  new itemServiceImpl();
	}
	public static IDisburseService getdisburseServiceInstance() {
		return  new disburseServiceImpl();
	}
}
