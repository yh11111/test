package cn.mldn.service;

import java.util.List;

import cn.mldn.vo.item;

/**
 * 定义item表的业务层的执行标准，此类一定要负责数据库的打开和关闭操作
 * 此类可以通过DAOFactory类取得IItemDao接口对象
 * @author YH
 */
public interface IItemService {
	/**
	 * 实现收入的增加操作，本次操作要调用IItemDao接口的如下方法
	 * 需要调用IItemDao.dofindId()方法，判断要增加数据的id是否已经存在
	 * 如果要增加的数据编号不存在则调用IItemDao.doCreate()方法，返回操作结果
	 * @param vo 包含了要增加数据的vo对象
	 * @return 如果增加数据的id重复或者保存失败返回false，否则返回true
	 * @throws Exception IO执行异常
	 */
	public boolean insert(item vo)throws Exception; 
	/**
	 * 实现收入数据的修改操作，本次调用IItemDao.doupdate()方法，本次修改属于全部内容的修改
	 * @param vo 包含了要修改数据的vo对象
	 * @return	修改成功返回true，否则返回false
	 * @throws Exception IO执行异常
	 */
	public boolean update(item vo)throws Exception;
	/**
	 * 执行收入数据的删除操作，可以删除收入信息，调用IItemDao.doRemove()方法
	 * @param vo 要删除的用户信息
	 * @return	删除成功返回true，否则返回false
	 * @throws Exception IO执行异常
	 */
	public boolean delete(item vo) throws Exception;
	/**
	  * 根据ID查询指定的类别信息，调用IItemDao.dofindId()方法
	 * @param id要查询编号
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public boolean findID(item vo) throws Exception;
	/**
	  * 根据项目编号名查询指定的类别信息，调用IItemDao.dofindItem()方法
	 * @param username 要查找信息的用户名
	 * @param item 要查找的类别
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public List<item> findItem(String username,String itemname)throws Exception;
	/**
	  * 查询所有信息，调用IItemDao.dofindAll()方法
	  * @param username 要查找信息的用户名
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public List<item> findAll(String username)throws Exception;
	/**
	  * 实现按类别排序,调用IItemDao.doSort()方法
	 * @param vo 包含了要排序数据的VO对象
	 * @param ss 按排序的关键字
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public List<item> Sort(List<item> ali,String s)throws Exception;
}
