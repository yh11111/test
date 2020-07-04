package cn.mldn.dao;

import java.sql.Date;
import java.util.List;

import cn.mldn.vo.disburse;
import cn.mldn.vo.income;

public interface Idisburse extends IDAO<disburse,String>{
	/**
	  * ִ�����ݵ�ɾ������
	 * @param username ������Ҫɾ�����ݵ�username����
	 * @Parma id Ҫɾ�����ݵı��
	 * @return ����ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doRemove(String username,int id)throws Exception;
	/**
	 * ���������Ų�ѯָ��֧����Ϣ
	 *@param id Ҫ��ѯ��������
	 *@return �����Ϣ���ڣ���������vo��������ʽ���أ���������ڣ��򷵻�null
	 *@throws Exception SQLִ���쳣
	 */
	public boolean dofindId(String username,int id)throws Exception;
	/**
	  * �����û�����ѯָ����֧����Ϣ
	 * @param username Ҫ��ѯ���û���
	 * @param SdateҪ��ѯ�Ŀ�ʼʱ��
	 * @param EdateҪ��ѯ�Ľ���ʱ��
	 * @return ������������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception SQLִ���쳣
	 */
	public List<disburse> dofindTime(String username,Date sdate,Date edate)throws Exception;
}