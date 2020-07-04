package cn.mldn.dao;

import java.util.List;

import cn.mldn.vo.income;

public interface IDAO<T,S> {
	/**
	 * 实现数据的增加操作
	 * @param vo 包含了要增加数据的VO对象
	 * @return 数据保存成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doCreate(T vo)throws Exception;
	/**
	  * 实现数据的修改操作，本次修改是根据用户名进行字段数据的修改
	 * @param vo 包含了要修改数据的VO对象
	 * @return 数据修改成功返回true，否则返回false
	 * @throws Exception SQL执行异常
	 */
	public boolean doUpdate(T vo)throws Exception;
	/**
	  * 根据类别查询指定的收入信息
	 * @param username
	 * @return 如果表中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception SQL执行异常
	 */
	public List<T> dofindIncome(S username,S itemname)throws Exception;
	/**
	  * 查询所有信息
	 * @param username 用户名
	 * @return 如果表中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception SQL执行异常
	 */
	public List<T> dofindAll(S username)throws Exception;
}
