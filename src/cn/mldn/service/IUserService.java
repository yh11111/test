package cn.mldn.service;

import cn.mldn.vo.income;
import cn.mldn.vo.user;

/**
 * 定义user表的业务层的执行标准，此类一定要负责数据库的打开和关闭操作
 * 此类可以通过DAOFactory类取得IuserDao接口对象
 * @author YH
 */
public interface IUserService {
	/**
	 * 实现用户的增加操作，本次操作要调用IuseDAO接口的如下方法
	 * 需要调用IuseDAO.findusername()方法，判断要增加用户名是否已经存在
	 * 如果要增加的用户名不存在则调用IuseDAO.doGreat()方法，返回操作结果
	 * @param vo 包含了要增加数据的vo对象
	 * @return 如果增加数据的ID重复或者保存失败返回false，否则返回true
	 * @throws Exception SQL执行异常
	 */
	public boolean insert(user vo)throws Exception; 
	/**
	 * 查找数据库中是否存在该用户名
	 * @param username 查找的用户名
	 * @return 存在返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean find(String username)throws Exception;
	/**
	 * 查找数据库中是否存在该用户
	 * @param vo 要查找的用户
	 * @return 存在返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean findU(user vo)throws Exception;
}
