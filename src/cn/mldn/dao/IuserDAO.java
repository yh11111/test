package cn.mldn.dao;

import cn.mldn.vo.income;
import cn.mldn.vo.user;

public interface IuserDAO {
	/**
	 * 实现数据的增加操作
	 * @param vo 包含了要增加数据的VO对象
	 * @return 数据保存成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doCreate(user vo)throws Exception;
	/**
	 * 查找数据库中是否存在改用户名
	 * @param username 查找的用户名
	 * @return 存在返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean findUsername(String username) throws Exception;
	/**
	 * 查找数据库中是否存在该用户
	 * @param vo 包含了要查找数据的VO对象
	 * @return 存在返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean findUser(user vo) throws Exception;
}
