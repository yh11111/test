package cn.mldn.dao;

import java.util.List;

import cn.mldn.vo.income;
import cn.mldn.vo.item;

public interface IItemDAO {
	/**
	 * 实现数据的增加操作
	 * @param vo 包含了要增加数据的VO对象
	 * @return 数据保存成功返回true，否则返回false
	 * @throws Exception IO执行异常
	 */
	public boolean doCreate(item vo)throws Exception;
	/**
	  * 实现类别的删除
	 * @param vo 包含了要删除数据的VO对象
	 * @return 数据删除成功返回true，否则返回false
	 * @throws Exception IO执行异常
	 */
	public boolean doRemovr(item vo)throws Exception;
	/**
	  * 查询编号是否已经存在
	 * @param id要查询编号
	 * @return 如果id存在则返回true，否则返回false
	 * @throws Exception IO执行异常
	 */
	public boolean dofindId(item vo)throws Exception;
	/**
	  * 根据项目名称查询指定的类别信息
	 * @param id要查询编号
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public List<item> dofindItem(String username,String itemname)throws Exception;
	/**
	  * 查询所有信息
	 * @param username 要查询全部信息的用户名
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public List<item> dofindAll(String username)throws Exception;
	/**
	  * 实现数据的修改操作，本次修改是根据类别编号进行字段数据的修改
	 * @param vo 包含了要修改数据的VO对象
	 * @return 数据修改成功返回true，否则返回false
	 * @throws Exception IO执行异常
	 */
	public boolean doUpdate(item vo)throws Exception;
	/**
	  * 实现按类别排序
	 * @param ali 包含了要排序数据的VO对象
	 * @param ss 按排序的关键字
	 * @return 如果文件中有数据，则返回的数据会封装为VO对象而后利用List集合返回
	 * @throws Exception IO执行异常
	 */
	public List<item> doSort(List<item> ali,String s)throws Exception;
}
