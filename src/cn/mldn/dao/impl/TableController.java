package cn.mldn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.view.login;
import cn.mldn.vo.item;

public class TableController {
	List<item> Aali=new ArrayList<item>();
	List<item> Sali=new ArrayList<item>();
	private static int curentPageIndex=1;//PageController中用来标记当前页面的
	private int pageCount;//总页数
	private int countPerage=10;//每页显示条数
	private int recordCount;//总记录条数
	
	public TableController(int curentPageIndex,List <item>ali)
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
	public TableController(List <item>ali)
	{ 
		this.Aali=ali;
		{
			if(Aali.size()%countPerage==0)
				this.pageCount=Aali.size()/countPerage;
			else
				this.pageCount=Aali.size()/countPerage+1;
		}
	} 
	//确切的获取当前页的记录，返回一个list列表 
	public List<item> setCurentPageIndex() 
	{ 
		return select(); 
	} 

	//下一页 
	public List<item> nextPage() 
	{ 
		if (curentPageIndex < pageCount ) 
		{ 
			curentPageIndex++; 
		} 
		return select(); 
	} 
	//上一页 
	public List<item> previousPage() 
	{ 
		if (curentPageIndex > 1) 
		{ 
			curentPageIndex--;  
		} 
		return select(); 
	} 
	//此方法供以上方法调用，根据当前页，筛选记录 
	public List<item> select()
	{ 
		System.out.println("表格"+curentPageIndex);
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
