package cn.mldn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.mldn.vo.disburse;
import cn.mldn.vo.income;

public class disburseT {
	List<disburse> Aali=new ArrayList<disburse>();
	List<disburse> Sali=new ArrayList<disburse>();
	private static int curentPageIndex=1;//PageController��������ǵ�ǰҳ���
	private int pageCount;//��ҳ��
	private int countPerage=10;//ÿҳ��ʾ����
	private int recordCount;//�ܼ�¼����
	
	public disburseT(int curentPageIndex,List <disburse>ali)
	{ 
		this.curentPageIndex=curentPageIndex; 
		this.Aali=ali;
		{
			if(Aali.size()%countPerage==0)
				this.pageCount=Aali.size()/countPerage;
			else
				this.pageCount=Aali.size()/countPerage+1;
		}
	} 
	public disburseT(List <disburse>ali)
	{ 
		this.Aali=ali;
		{
			if(Aali.size()%countPerage==0)
				this.pageCount=Aali.size()/countPerage;
			else
				this.pageCount=Aali.size()/countPerage+1;
		}
	} 
	//ȷ�еĻ�ȡ��ǰҳ�ļ�¼������һ��list�б� 
	public List<disburse> setCurentPageIndex() 
	{ 
		return select(); 
	} 

	//��һҳ 
	public List<disburse> nextPage() 
	{ 
		if (curentPageIndex < pageCount ) 
		{ 
			curentPageIndex++; 
		} 
		return select(); 
	} 
	//��һҳ 
	public List<disburse> previousPage() 
	{ 
		if (curentPageIndex > 1) 
		{ 
			curentPageIndex--;  
		} 
		return select(); 
	} 
	//�˷��������Ϸ������ã����ݵ�ǰҳ��ɸѡ��¼ 
	public List<disburse> select()
	{ 
		System.out.println("���"+curentPageIndex);
		recordCount=Aali.size(); 
		Sali.clear();
		for(int i=(curentPageIndex-1)*countPerage; i<curentPageIndex*countPerage&&i<recordCount; i++)
		{ 
			Sali.add(Aali.get(i));
			System.out.println(i);
		}
		return Sali;
	} 
}
