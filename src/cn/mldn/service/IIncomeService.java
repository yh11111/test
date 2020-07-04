package cn.mldn.service;

import java.util.Date;
import java.util.List;

import cn.mldn.vo.income;

/**
 * 定义income表的业务层的执行标准，此类一定要负责数据库的打开和关闭操作
 * 此类可以通过DAOFactory类取得IincmoeDao接口对象
 * @author YH
 */
public interface IIncomeService {
	/**
	 * 实现收入的增加操作，本次操作要调用IincomeDao接口的如下方法
	 * 需要调用IincomeDao.dofindid()方法，判断要增加数据的id是否已经存在
	 * 如果要增加的数据编号不存在则调用IincomeDao.doCreate()方法，返回操作结果
	 * @param vo 包含了要增加数据的vo对象
	 * @return 如果增加数据的id重复或者保存失败返回false，否则返回true
	 * @throws Exception SQL执行异常
	 */
	public boolean insert(income vo)throws Exception; 
	/**
	 * 实现收入数据的修改操作，本次调用IincomeDao.doupdate()方法，本次修改属于全部内容的修改
	 * @param vo 包含了要修改数据的vo对象
	 * @return	修改成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean update(income vo)throws Exception;
	/**
	 * 执行收入数据的删除操作，可以删除收入信息，调用IincomeDao.doRemove()方法
	 * @param username 包含了要删除数据的用户名
	 * @Parma id 要删除数据的编号
	 * @return	删除成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean delete(String username,int id) throws Exception;
	/**
	  * 根据时间查询指定的收入信息，调用IincomeDao.dofindTime()方法
	 * @param username 要查询的用户名
	 * @param Sdate要查询的开始时间
	 * @param Edate要查询的结束时间
	 * @return 如果表中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception SQL执行异常
	 */
	public List<income> FindTime(String username, Date Sdate, Date Edate) throws Exception;
	/**
	  * 根据时间查询指定的收入信息，调用IincomeDao.dofindTime()方法
	 * @param username 要查询的用户名
	 * @param itemname 项目名称
	 * @return 如果表中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception SQL执行异常
	 */
	public List<income> FindIncome(String username, String itemname) throws Exception;
	/**
	  * 查询所以收入信息
	 * @param username 用户名
	 * @return 如果表中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception SQL执行异常
	 */
	public List<income> findAll(String username)throws Exception;
}
