package cn.mldn.service;

import java.util.Date;
import java.util.List;

import cn.mldn.vo.income;

/**
 * ����income���ҵ����ִ�б�׼������һ��Ҫ�������ݿ�Ĵ򿪺͹رղ���
 * �������ͨ��DAOFactory��ȡ��IincmoeDao�ӿڶ���
 * @author YH
 */
public interface IIncomeService {
	/**
	 * ʵ����������Ӳ��������β���Ҫ����IincomeDao�ӿڵ����·���
	 * ��Ҫ����IincomeDao.dofindid()�������ж�Ҫ�������ݵ�id�Ƿ��Ѿ�����
	 * ���Ҫ���ӵ����ݱ�Ų����������IincomeDao.doCreate()���������ز������
	 * @param vo ������Ҫ�������ݵ�vo����
	 * @return ����������ݵ�id�ظ����߱���ʧ�ܷ���false�����򷵻�true
	 * @throws Exception SQLִ���쳣
	 */
	public boolean insert(income vo)throws Exception; 
	/**
	 * ʵ���������ݵ��޸Ĳ��������ε���IincomeDao.doupdate()�����������޸�����ȫ�����ݵ��޸�
	 * @param vo ������Ҫ�޸����ݵ�vo����
	 * @return	�޸ĳɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean update(income vo)throws Exception;
	/**
	 * ִ���������ݵ�ɾ������������ɾ��������Ϣ������IincomeDao.doRemove()����
	 * @param username ������Ҫɾ�����ݵ��û���
	 * @Parma id Ҫɾ�����ݵı��
	 * @return	ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean delete(String username,int id) throws Exception;
	/**
	  * ����ʱ���ѯָ����������Ϣ������IincomeDao.dofindTime()����
	 * @param username Ҫ��ѯ���û���
	 * @param SdateҪ��ѯ�Ŀ�ʼʱ��
	 * @param EdateҪ��ѯ�Ľ���ʱ��
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<income> FindTime(String username, Date Sdate, Date Edate) throws Exception;
	/**
	  * ����ʱ���ѯָ����������Ϣ������IincomeDao.dofindTime()����
	 * @param username Ҫ��ѯ���û���
	 * @param itemname ��Ŀ����
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<income> FindIncome(String username, String itemname) throws Exception;
	/**
	  * ��ѯ����������Ϣ
	 * @param username �û���
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<income> findAll(String username)throws Exception;
}
