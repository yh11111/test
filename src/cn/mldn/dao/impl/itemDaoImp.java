package cn.mldn.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import cn.mldn.dao.IItemDAO;
import cn.mldn.view.login;
import cn.mldn.vo.income;
import cn.mldn.vo.item;


public class itemDaoImp implements IItemDAO {
	@Override
	public boolean doCreate(item vo) throws Exception {
		BufferedWriter bw=new BufferedWriter(new FileWriter(new File("item.txt"),true));
		StringBuilder sb = new StringBuilder();
		sb.append(vo.getUsername()).append(",").append(vo.getId()).append(",").append(vo.getItem());
		bw.write(sb.toString());
		bw.newLine();
		bw.close();
		return true;
	}

	@Override
	public boolean doRemovr(item vo) throws Exception {
		//将文件中的类别信息读取出来
		 BufferedReader br=new BufferedReader(new FileReader(new File("item.txt")));
		ArrayList<item> ali=new ArrayList<item>();
		String line;
		int flag=0;
		item item1=null;
		while((line=br.readLine())!=null)
		{
			//将该项目信息分割
			String[]ss=line.split(",");
			if(ss[0].equals(vo.getUsername())&&Integer.valueOf(ss[1])==vo.getId())
			{
				flag=1;
				continue;
			}
			item1=new item(ss[0], Integer.valueOf(ss[1]), ss[2]);
			ali.add(item1);
		}
		br.close();
		if(flag==0)
		{
			return false;
		}else {
				BufferedWriter bw=new BufferedWriter(new FileWriter(new File("item.txt")));
				StringBuilder sb=new StringBuilder();
				for(item it:ali)
				{
					sb.append(it.getUsername()).append(",").append(it.getId()).append(",").append(it.getItem());
					bw.write(sb.toString());
					bw.newLine();
					bw.flush();
					//清空StringBuilder中的内容
					sb.delete(0, sb.length());
				}
				//释放资源
				bw.close();
				return true;
			}
	}

	@Override
	public boolean dofindId(item vo) throws Exception {
		//将文件中的类别信息读取出来
		 BufferedReader br=new BufferedReader(new FileReader(new File("item.txt")));
		ArrayList<item> ali=new ArrayList<item>();
		String line;
		while((line=br.readLine())!=null)
		{
			//将该项目信息分割
			String[]ss=line.split(",");
			if(ss[0].equals(vo.getUsername())&&ss[1].equals(vo.getId().toString()))
			{
				br.close();
				return true;
			}
		}
		br.close();
		return false;
			
	}

	@Override
	public boolean doUpdate(item vo) throws Exception {
		//将文件中的类别信息读取出来
		 BufferedReader br=new BufferedReader(new FileReader(new File("item.txt")));
		ArrayList<item> ali=new ArrayList<item>();
		String line;
		int flag=0;
		item item1=null;
		while((line=br.readLine())!=null)
		{
			//将该项目信息分割
			String[]ss=line.split(",");
			if(ss[0].equals(vo.getUsername())&&(Integer.valueOf(ss[1])==vo.getId()))
			{
				flag=1;
				item1=new item(ss[0], Integer.valueOf(ss[1]), vo.getItem());
				ali.add(item1);
				continue;
			}
			item1=new item(ss[0], Integer.valueOf(ss[1]), ss[2]);
			ali.add(item1);
		}
		br.close();
		if(flag==0)
		{
			return false;
		}else {
				BufferedWriter bw=new BufferedWriter(new FileWriter(new File("item.txt")));
				StringBuilder sb=new StringBuilder();
				for(item im:ali)
				{
					sb.append(im.getUsername()).append(",").append(im.getId()).append(",").append(im.getItem());
					bw.write(sb.toString());
					bw.newLine();
					bw.flush();
					//清空StringBuilder中的内容
					sb.delete(0, sb.length());
				}
				//释放资源
				bw.close();
				return true;
			}
	}

	@Override
	public List<item> dofindItem(String username,String itemname) throws Exception {
		//将文件中的类别信息读取出来
		System.out.println("进入查找函数");
		BufferedReader br=new BufferedReader(new FileReader(new File("item.txt")));
		List<item> ali=new ArrayList<item>();
		String line;
		int flag=0;
		item item1=null;
		while((line=br.readLine())!=null)
		{
			//将该项目信息分割
			String[]ss=line.split(",");
			System.out.println(""+ss[2]);
			if(ss[0].equals(username)&&ss[2].equals(itemname)) 
			{
				System.out.println("找到了");
				item1=new item(ss[0], Integer.valueOf(ss[1]), ss[2]);
				ali.add(item1);
				break;
			}
			
		}
		br.close();
		System.out.println(ali.get(0).getId()+ali.get(0).getItem());
		return ali;
	}

	@Override
	public List<item> dofindAll(String username) throws Exception {
		//将文件中的类别信息读取出来
		BufferedReader br=new BufferedReader(new FileReader(new File("item.txt")));
		List<item> ali=new ArrayList<item>();
		String line;
		item item1=null;
		while((line=br.readLine())!=null)
		{
			//将该项目信息分割
			String[]ss=line.split(",");
			if(username.equals(ss[0]))
			{
				item1=new item(ss[0], Integer.valueOf(ss[1]), ss[2]);
				ali.add(item1);
			}
		}
		br.close();
		return ali;
	}

	@Override
	public List<item> doSort(List<item> ali, String s) throws Exception {
		if(s.equals("项目名称"))
		{
			TreeSet<item> set=new TreeSet<item>(new Comparator<item>() {
				@Override
				public int compare(item o1, item o2) {
					//按项目名称排序
					return o1.getItem().compareTo(o2.getUsername());
				}
			});
			for(item vo:ali)
			{
				set.add(vo);
			}
			ali.clear();
			for(item vo:set)
			{
				ali.add(vo);
			}
		}
		else {
				TreeSet<item> set=new TreeSet<item>(new Comparator<item>() {
					@Override
					public int compare(item o1, item o2) {
						//按项目名称排序
						return o1.getId()-o2.getId();
					}
					
				});
				for(item vo:ali)
				{
					set.add(vo);
				}
				ali.clear();
				for(item vo:set)
				{
					ali.add(vo);
				}
			}
		return ali;
	}
	
}
