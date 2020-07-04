package cn.mldn.dao;

import java.util.List;

import cn.mldn.vo.income;
import cn.mldn.vo.item;

public interface IItemDAO {
	/**
	 * ʵ�����ݵ����Ӳ���
	 * @param vo ������Ҫ�������ݵ�VO����
	 * @return ���ݱ���ɹ�����true�����򷵻�false
	 * @throws Exception IOִ���쳣
	 */
	public boolean doCreate(item vo)throws Exception;
	/**
	  * ʵ������ɾ��
	 * @param vo ������Ҫɾ�����ݵ�VO����
	 * @return ����ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception IOִ���쳣
	 */
	public boolean doRemovr(item vo)throws Exception;
	/**
	  * ��ѯ����Ƿ��Ѿ�����
	 * @param idҪ��ѯ���
	 * @return ���id�����򷵻�true�����򷵻�false
	 * @throws Exception IOִ���쳣
	 */
	public boolean dofindId(item vo)throws Exception;
	/**
	  * ������Ŀ���Ʋ�ѯָ���������Ϣ
	 * @param idҪ��ѯ���
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public List<item> dofindItem(String username,String itemname)throws Exception;
	/**
	  * ��ѯ������Ϣ
	 * @param username Ҫ��ѯȫ����Ϣ���û���
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public List<item> dofindAll(String username)throws Exception;
	/**
	  * ʵ�����ݵ��޸Ĳ����������޸��Ǹ�������Ž����ֶ����ݵ��޸�
	 * @param vo ������Ҫ�޸����ݵ�VO����
	 * @return �����޸ĳɹ�����true�����򷵻�false
	 * @throws Exception IOִ���쳣
	 */
	public boolean doUpdate(item vo)throws Exception;
	/**
	  * ʵ�ְ��������
	 * @param ali ������Ҫ�������ݵ�VO����
	 * @param ss ������Ĺؼ���
	 * @return ����ļ��������ݣ��򷵻ص����ݻ��װΪVO�����������List���Ϸ���
	 * @throws Exception IOִ���쳣
	 */
	public List<item> doSort(List<item> ali,String s)throws Exception;
}
