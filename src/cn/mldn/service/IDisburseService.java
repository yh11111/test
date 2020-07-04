package cn.mldn.service;

import java.util.Date;
import java.util.List;

import cn.mldn.vo.disburse;
import cn.mldn.vo.income;

/**
 * ����disburse���ҵ����ִ�б�׼������һ��Ҫ�������ݿ�Ĵ򿪺͹رղ���
 * �������ͨ��DAOFactory��ȡ��IdisburseDao�ӿڶ���
 * @author YH
 */
public interface IDisburseService {
	/**
	 * ʵ��֧�������Ӳ��������β���Ҫ����IdisburseDao�ӿڵ����·���
	 * ��Ҫ����IdisburseDao.dofindid()�������ж�Ҫ�������ݵ�id�Ƿ��Ѿ�����
	 * ���Ҫ���ӵ����ݱ�Ų����������IdisburseDao.doGreate()���������ز������
	 * @param vo ������Ҫ�������ݵ�vo����
	 * @return ����������ݵ�id�ظ����߱���ʧ�ܷ���false�����򷵻�true
	 * @throws Exception SQLִ���쳣
	 */
	public boolean insert(disburse vo)throws Exception; 
	/**
	 * ʵ���������ݵ��޸Ĳ��������ε���IdisburseDao.doupdate()�����������޸�����ȫ�����ݵ��޸�
	 * @param vo ������Ҫ�޸����ݵ�vo����
	 * @return	�޸ĳɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean update(disburse vo)throws Exception;
	/**
	 * ִ���������ݵ�ɾ������������ɾ��������Ϣ������IdisburseDao.doRemove()����
	 * @param ������Ҫɾ�����ݵ�vo����
	 * @Parma id Ҫɾ�����ݵı��
	 * @return	ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean delete(String username,int id) throws Exception;
	/**
	  * ����ʱ���ѯָ����������Ϣ������IdisburseDao.dofindTime()����
	 * @param username Ҫ��ѯ���û���
	 * @param SdateҪ��ѯ�Ŀ�ʼʱ��
	 * @param EdateҪ��ѯ�Ľ���ʱ��
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<disburse> FindTime(String username, Date Sdate, Date Edate) throws Exception;
	/**
	  * ����ʱ���ѯָ����������Ϣ������IdisburseDao.dofindTime()����
	 * @param username Ҫ��ѯ���û���
	 * @param SdateҪ��ѯ�Ŀ�ʼʱ��
	 * @param EdateҪ��ѯ�Ľ���ʱ��
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<disburse> FindIncome(String username, String itemname) throws Exception;
	/**
	  * ��ѯ����������Ϣ
	 * @param username �û���
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<disburse> findAll(String username)throws Exception;
}
