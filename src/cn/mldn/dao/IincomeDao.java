package cn.mldn.dao;

import java.sql.Date;
import java.util.List;

import cn.mldn.vo.income;


public interface IincomeDao extends IDAO<income,String>{
	/**
	  * 执行数据的删除操作
	 * @param username 包含了要删除数据的username对象
	 * @Parma id 要删除数据的编号
	 * @return 数据删除成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doRemove(String username,int id)throws Exception;
	/**
	 * 根据收入编号查询指定收入信息
	 *@param id 要查询的收入编号
	 *@return 如果信息存在，则返回true，否则返回false
	 *@throws Exception SQL执行异常
	 */
	public boolean dofindId(String username,int id)throws Exception;
	/**
	  * 根据用户名查询指定的收入信息
	 * @param username 要查询的用户名
	 * @param Sdate要查询的开始时间
	 * @param Edate要查询的结束时间
	 * @return 如果表中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception SQL执行异常
	 */
	public List<income> dofindTime(String username,Date sdate,Date edate)throws Exception;
}
