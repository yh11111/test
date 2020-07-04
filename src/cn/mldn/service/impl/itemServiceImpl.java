package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IItemService;
import cn.mldn.vo.item;

public class itemServiceImpl implements IItemService {

	@Override
	public boolean insert(item vo) throws Exception {
		//���Ҫ���ӵ����ݱ�Ų�����,��findId()���صĽ������false��false��ʾ���Խ��������������
		if(!(DAOFactory.getItemDAOInstance().dofindId(vo)))
			return DAOFactory.getItemDAOInstance().doCreate(vo);
		return false;
	}

	@Override
	public boolean update(item vo) throws Exception {
		return DAOFactory.getItemDAOInstance().doUpdate(vo);
	}

	@Override
	public boolean delete(item vo) throws Exception {
		return DAOFactory.getItemDAOInstance().doRemovr(vo);
	}

	@Override
	public boolean findID(item vo) throws Exception {
		return DAOFactory.getItemDAOInstance().dofindId(vo);
	}

	@Override
	public List<item> findItem(String username,String itemname) throws Exception {
		return DAOFactory.getItemDAOInstance().dofindItem(username,itemname);
	}

	@Override
	public List<item> findAll(String username) throws Exception {
		return DAOFactory.getItemDAOInstance().dofindAll(username);
	}

	@Override
	public List<item> Sort(List<item> ali, String s) throws Exception {
		return DAOFactory.getItemDAOInstance().doSort(ali, s);
	}

}
