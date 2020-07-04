package cn.mldn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.mldn.vo.income;
import cn.mldn.vo.item;

public class IncomeT {
	List<income> Aali=new ArrayList<income>();
	List<income> Sali=new ArrayList<income>();
	private static int curentPageIndex=1;//PageController��������ǵ�ǰҳ���
	private int pageCount;//��ҳ��
	private int countPerage=10;//ÿҳ��ʾ����
	private int recordCount;//�ܼ�¼����
	
	public IncomeT(int curentPageIndex,List <income>ali)
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
	public IncomeT(List <income>ali)
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
	public List<income> setCurentPageIndex() 
	{ 
		return select(); 
	} 

	//��һҳ 
	public List<income> nextPage() 
	{ 
		if (curentPageIndex < pageCount ) 
		{ 
			curentPageIndex++; 
		} 
		return select(); 
	} 
	//��һҳ 
	public List<income> previousPage() 
	{ 
		if (curentPageIndex > 1) 
		{ 
			curentPageIndex--;  
		} 
		return select(); 
	} 
	//�˷��������Ϸ������ã����ݵ�ǰҳ��ɸѡ��¼ 
	public List<income> select()
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
