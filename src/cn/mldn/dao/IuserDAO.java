package cn.mldn.dao;

import cn.mldn.vo.income;
import cn.mldn.vo.user;

public interface IuserDAO {
	/**
	 * ʵ�����ݵ����Ӳ���
	 * @param vo ������Ҫ�������ݵ�VO����
	 * @return ���ݱ���ɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doCreate(user vo)throws Exception;
	/**
	 * �������ݿ����Ƿ���ڸ��û���
	 * @param username ���ҵ��û���
	 * @return ���ڷ���true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean findUsername(String username) throws Exception;
	/**
	 * �������ݿ����Ƿ���ڸ��û�
	 * @param vo ������Ҫ�������ݵ�VO����
	 * @return ���ڷ���true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean findUser(user vo) throws Exception;
}
