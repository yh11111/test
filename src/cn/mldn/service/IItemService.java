package cn.mldn.service;

import java.util.List;

import cn.mldn.vo.item;

/**
 * ����item���ҵ����ִ�б�׼������һ��Ҫ�������ݿ�Ĵ򿪺͹رղ���
 * �������ͨ��DAOFactory��ȡ��IItemDao�ӿڶ���
 * @author YH
 */
public interface IItemService {
	/**
	 * ʵ����������Ӳ��������β���Ҫ����IItemDao�ӿڵ����·���
	 * ��Ҫ����IItemDao.dofindId()�������ж�Ҫ�������ݵ�id�Ƿ��Ѿ�����
	 * ���Ҫ���ӵ����ݱ�Ų����������IItemDao.doCreate()���������ز������
	 * @param vo ������Ҫ�������ݵ�vo����
	 * @return ����������ݵ�id�ظ����߱���ʧ�ܷ���false�����򷵻�true
	 * @throws Exception IOִ���쳣
	 */
	public boolean insert(item vo)throws Exception; 
	/**
	 * ʵ���������ݵ��޸Ĳ��������ε���IItemDao.doupdate()�����������޸�����ȫ�����ݵ��޸�
	 * @param vo ������Ҫ�޸����ݵ�vo����
	 * @return	�޸ĳɹ�����true�����򷵻�false
	 * @throws Exception IOִ���쳣
	 */
	public boolean update(item vo)throws Exception;
	/**
	 * ִ���������ݵ�ɾ������������ɾ��������Ϣ������IItemDao.doRemove()����
	 * @param vo Ҫɾ�����û���Ϣ
	 * @return	ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception IOִ���쳣
	 */
	public boolean delete(item vo) throws Exception;
	/**
	  * ����ID��ѯָ���������Ϣ������IItemDao.dofindId()����
	 * @param idҪ��ѯ���
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public boolean findID(item vo) throws Exception;
	/**
	  * ������Ŀ�������ѯָ���������Ϣ������IItemDao.dofindItem()����
	 * @param username Ҫ������Ϣ���û���
	 * @param item Ҫ���ҵ����
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public List<item> findItem(String username,String itemname)throws Exception;
	/**
	  * ��ѯ������Ϣ������IItemDao.dofindAll()����
	  * @param username Ҫ������Ϣ���û���
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public List<item> findAll(String username)throws Exception;
	/**
	  * ʵ�ְ��������,����IItemDao.doSort()����
	 * @param vo ������Ҫ�������ݵ�VO����
	 * @param ss ������Ĺؼ���
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public List<item> Sort(List<item> ali,String s)throws Exception;
}
