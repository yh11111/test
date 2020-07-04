package cn.mldn.dao;

import java.util.List;

import cn.mldn.vo.income;

public interface IDAO<T,S> {
	/**
	 * ʵ�����ݵ����Ӳ���
	 * @param vo ������Ҫ�������ݵ�VO����
	 * @return ���ݱ���ɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doCreate(T vo)throws Exception;
	/**
	  * ʵ�����ݵ��޸Ĳ����������޸��Ǹ����û��������ֶ����ݵ��޸�
	 * @param vo ������Ҫ�޸����ݵ�VO����
	 * @return �����޸ĳɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doUpdate(T vo)throws Exception;
	/**
	  * ��������ѯָ����������Ϣ
	 * @param username
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<T> dofindIncome(S username,S itemname)throws Exception;
	/**
	  * ��ѯ������Ϣ
	 * @param username �û���
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<T> dofindAll(S username)throws Exception;
}
