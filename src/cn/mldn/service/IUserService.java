package cn.mldn.service;

import cn.mldn.vo.income;
import cn.mldn.vo.user;

/**
 * ����user���ҵ����ִ�б�׼������һ��Ҫ�������ݿ�Ĵ򿪺͹رղ���
 * �������ͨ��DAOFactory��ȡ��IuserDao�ӿڶ���
 * @author YH
 */
public interface IUserService {
	/**
	 * ʵ���û������Ӳ��������β���Ҫ����IuseDAO�ӿڵ����·���
	 * ��Ҫ����IuseDAO.findusername()�������ж�Ҫ�����û����Ƿ��Ѿ�����
	 * ���Ҫ���ӵ��û��������������IuseDAO.doGreat()���������ز������
	 * @param vo ������Ҫ�������ݵ�vo����
	 * @return ����������ݵ�ID�ظ����߱���ʧ�ܷ���false�����򷵻�true
	 * @throws Exception SQLִ���쳣
	 */
	public boolean insert(user vo)throws Exception; 
	/**
	 * �������ݿ����Ƿ���ڸ��û���
	 * @param username ���ҵ��û���
	 * @return ���ڷ���true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean find(String username)throws Exception;
	/**
	 * �������ݿ����Ƿ���ڸ��û�
	 * @param vo Ҫ���ҵ��û�
	 * @return ���ڷ���true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean findU(user vo)throws Exception;
}
