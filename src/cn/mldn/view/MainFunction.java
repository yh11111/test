package cn.mldn.view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuKeyListener;

import cn.mldn.vo.disburse;

import javax.swing.event.MenuKeyEvent;

public class MainFunction {

	JFrame frame;
	private JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFunction window = new MainFunction();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFunction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("������֧����ϵͳ");
		frame.setBounds(100, 100, 826, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		ImageIcon icon = new ImageIcon(MainFunction.class.getResource("/cn/itcast/rescourse/101.jpg")); // ��������ͼƬ����
		desktopPane.setLayout(null);
		JLabel backLabel = new JLabel(); // ����һ����ǩ�������
		backLabel.setBounds(0, -60, 810, 583);
		backLabel.setIcon(icon);
		desktopPane.add(backLabel); // �����������ӵ�JDesktopPane���������
		desktopPane.setLayer(backLabel, -1); // ���ñ���ͼƬ����Ĳ�Σ����·���
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6536\u5165\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("�����֧");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((JMenuItem)e.getSource()==menuItem)
		    	{
					AddIncome addIncome=new AddIncome();
					displayJInternalFrame(addIncome);
					addIncome.setLocation(220, 100);
		    	}
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("ɾ����֧");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeMgr icm=new IncomeMgr();
				displayJInternalFrame(icm);
				icm.setLocation(130, 15);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("�޸�����");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeMgr icm=new IncomeMgr();
				displayJInternalFrame(icm);
				icm.setLocation(130, 15);
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("��ѯ����");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeMgr icm=new IncomeMgr();
				displayJInternalFrame(icm);
				icm.setLocation(130, 15);
			}
		});
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u652F\u51FA\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_8 = new JMenuItem("���֧��");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDisburse addd=new AddDisburse();
				displayJInternalFrame(addd);
				addd.setLocation(220, 100);
			}
		});
		menu_1.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("ɾ��֧��");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisburseMgr icm=new DisburseMgr();
				displayJInternalFrame(icm);
				icm.setLocation(130, 15);
			}
		});
		menu_1.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("����֧��");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisburseMgr icm=new DisburseMgr();
				displayJInternalFrame(icm);
				icm.setLocation(130, 15);
			}
		});
		menu_1.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("�޸�֧��");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisburseMgr icm=new DisburseMgr();
				displayJInternalFrame(icm);
				icm.setLocation(130, 15);
			}
		});
		menu_1.add(menuItem_11);
		
		JMenu menu_2 = new JMenu("��Ŀ����");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("�����Ŀ");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItem addItem=new AddItem();
				displayJInternalFrame(addItem);
				addItem.setLocation(225, 150);
			}
		});
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("ɾ����Ŀ");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMgr im=new ItemMgr();
				displayJInternalFrame(im);
				im.setLocation(225, 50);
			}
		});
		menu_2.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("�޸���Ŀ");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMgr im=new ItemMgr();
				displayJInternalFrame(im);
				im.setLocation(225, 50);
			}
		});
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("������Ŀ");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemMgr im=new ItemMgr();
				displayJInternalFrame(im);
				im.setLocation(225, 50);
			}
		});
		menu_2.add(menuItem_7);
		
	}
	//������������ֻ�ܵ�����ʾһ���Ӵ���
	public void displayJInternalFrame(JInternalFrame jif) {
		JInternalFrame jifl[]=desktopPane.getAllFrames();
		//�ж϶���������Ƿ��Ѿ�������Ҫ���õ��Ӵ���
		if(jifl.length>0) 	return;
		desktopPane.add(jif);
		jif.setVisible(true);
		try {
			jif.setSelected(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
	}
}
