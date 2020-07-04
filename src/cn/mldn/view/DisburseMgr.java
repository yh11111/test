package cn.mldn.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;

import cn.mldn.dao.impl.IncomeT;
import cn.mldn.dao.impl.disburseT;
import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.disburse;
import cn.mldn.vo.income;
import cn.mldn.vo.item;

public class DisburseMgr extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JScrollPane scrollPane;
	private List<disburse> ali=new ArrayList<disburse>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisburseMgr frame = new DisburseMgr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisburseMgr() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6536\u5165\u7BA1\u7406");
		setBounds(-20, -20, 561, 489);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("类别名称");
		label.setBounds(10, 31, 66, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(74, 28, 89, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		final DatePicker datepick;
        datepick = getDatePicker();
        datepick.setBounds(70, 65, 177, 24);
        getContentPane().add(datepick);
		
        final DatePicker datepick1;
        datepick1 = getDatePicker();
        datepick1.setBounds(350, 65, 177, 24);
        getContentPane().add(datepick1);
        
        final DatePicker datepick2;
        datepick2 = getDatePicker();
        datepick2.setBounds(50, 380, 177, 24);
        getContentPane().add(datepick2);
        
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//List<income> ali=new ArrayList<income>();
					List<disburse> ali1=new ArrayList<disburse>();
					System.out.println(textField.getText());
					if(textField.getText().equals(""))
						ali=new ServiceFactory().getdisburseServiceInstance().findAll(new login().uname);
					else
						ali=new ServiceFactory().getdisburseServiceInstance().FindIncome(new login().uname,
							textField.getText());
					//System.out.println(ali.get(0).getId()+ali.get(0).getItem());
					ali1=new disburseT(1,ali).setCurentPageIndex();
					showTable(ali1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(185, 27, 66, 23);
		getContentPane().add(button);
		
		JLabel label_1 = new JLabel("开始时间：");
		label_1.setBounds(10, 72, 66, 15);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("结束时间：");
		label_2.setBounds(280, 72, 73, 15);
		getContentPane().add(label_2);
		
		JButton button_1 = new JButton("按日期查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List<income> ali=new ArrayList<income>();
				List<disburse> ali1=new ArrayList<disburse>();
				Date date1 = null;
				Date date2=null;
				Date Sdate = null;
				Date Edate=null;
				try {

			        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
					date1 = (Date) sdf.parse(datepick.getValue().toString());
					date2 = (Date) sdf.parse(datepick1.getValue().toString());
					SimpleDateFormat formatStr2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Sdate = (Date) formatStr2.parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date1));
					Edate = (Date) formatStr2.parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date2));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ali=new ServiceFactory().getdisburseServiceInstance().FindTime(new login().uname, Sdate, Edate);
					ali1=new disburseT(1,ali).setCurentPageIndex();
					showTable(ali1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(348, 27, 101, 23);
		getContentPane().add(button_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 525, 185);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[][] ob = new Object[10][];
		table.setModel(new javax.swing.table.DefaultTableModel(ob, new String[] { "收入编号","金额","日期","项目类型","标记" }));
		
		JButton button_2 = new JButton("第一页");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List <income> ali=new ArrayList<income>();
				try {
					//ali=new ServiceFactory().getIIncomeServiceInstance().findAll(new login().uname);
					List<disburse> list=new disburseT(1,ali).previousPage();
					showTable(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(10, 300, 93, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("上一页");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List <income> ali=new ArrayList<income>();
				try {
					//ali=new ServiceFactory().getIIncomeServiceInstance().findAll(new login().uname);
					List<disburse> list=new disburseT(ali).previousPage();
					showTable(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(231, 300, 93, 23);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("下一页");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List <income> ali=new ArrayList<income>();
				try {
					//ali=new ServiceFactory().getIIncomeServiceInstance().findAll(new login().uname);
					List<disburse> list=new disburseT(ali).nextPage();
					showTable(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(442, 300, 93, 23);
		getContentPane().add(button_4);
		
		JLabel label_3 = new JLabel("收入编号：");
		label_3.setBounds(10, 346, 73, 15);
		getContentPane().add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 343, 91, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("金额：");
		label_4.setBounds(196, 346, 54, 15);
		getContentPane().add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(231, 343, 91, 21);
		getContentPane().add(textField_2);
		
		JLabel label_5 = new JLabel("项目类型：");
		label_5.setBounds(360, 346, 66, 15);
		getContentPane().add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(424, 343, 89, 21);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("日期：");
		lblNewLabel.setBounds(10, 384, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label_6 = new JLabel("备注");
		label_6.setBounds(249, 384, 54, 15);
		getContentPane().add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(293, 381, 220, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_5 = new JButton("删除");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(button_4, "真的要删除吗？", "确认删除",
						JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					boolean flag=false;
					try {
						flag=new ServiceFactory().getdisburseServiceInstance().
							delete(new login().uname,Integer.valueOf(textField_1.getText()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						if(flag)
						{
							List<disburse>  ali1 = new ArrayList<disburse>();
							ali=new ServiceFactory().getdisburseServiceInstance().findAll(new login().uname);
							ali1=new disburseT(ali).setCurentPageIndex();
							showTable(ali1);
							JOptionPane.showMessageDialog(button_4, "删除成功！");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_5.setBounds(70, 422, 93, 23);
		getContentPane().add(button_5);
		
		JButton button_5_1 = new JButton("修改");
		button_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(button_4, "真的要修改吗？", "确认修改",
						JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					disburse vo=new disburse();
					if(!(table.getValueAt(row, 0).equals(textField_1.getText())))
					{
						JOptionPane.showMessageDialog(null,"编号不能修改！！！");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
					}
					else
					{
						vo.setUsername(new login().uname);
						vo.setId(Integer.valueOf(textField_1.getText()));
						vo.setMoney(Double.valueOf(textField_2.getText()));
						Date date1 = null;
						Date date=null;
						try {

					        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
							date1 = (Date) sdf.parse(datepick2.getValue().toString());
							SimpleDateFormat formatStr2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							date = (Date) formatStr2.parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date1));
							vo.setDate(date);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						vo.setItemname(comboBox.getSelectedItem().toString());
						vo.setRemark(textField_3.getText());
						try {
							List <disburse> ali1=new ArrayList<disburse>();
							new ServiceFactory().getdisburseServiceInstance().update(vo);
							ali=new ServiceFactory().getdisburseServiceInstance().findAll(new login().uname);
							ali1=new disburseT(ali).setCurentPageIndex();
							showTable(ali1);
							JOptionPane.showMessageDialog(button_4, "修改成功！");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		button_5_1.setBounds(356, 422, 93, 23);
		getContentPane().add(button_5_1);
		
		table.addMouseListener(new MouseAdapter() {// 添加单击JTable的事件处理
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();// 获得当前被选中的行号
					textField_1.setText(table.getValueAt(row, 0).toString());
					textField_2.setText(table.getValueAt(row, 1).toString());
					textField_3.setText(table.getValueAt(row,4).toString());
					//datepick2
					//comboBox.set(table.getValueAt(row,4).toString());
			        try {
						List<item> ali=new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
						String[] objects = new String[ali.size()]; 
						for (int i = 0; i < ali.size(); i++) {
							objects[i] = ali.get(i).getItem(); 
						}
						DefaultComboBoxModel dtm=new DefaultComboBoxModel(objects);
						comboBox.setModel(dtm);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (Exception e1) {
					// 点击表格空白处，什么也不处理
				}
			}
		});
	}
	private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体a
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = { 1, 3, 5, 7 };
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(137, 83);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
	public void showTable(List<disburse> ali)
	{
		String[][] objects = new String[10][]; 
		if(ali.size()!=0)
		{
			System.out.println("行数："+ali.size()+"，"+ali.get(0).getId().toString()+""+ali.get(0).getMoney()+objects.length);
			for (int i = 0; i < ali.size(); i++) {
				objects[i] = new String[5];
				objects[i][0]=ali.get(i).getId().toString(); 
				objects[i][1]=ali.get(i).getMoney().toString();
				objects[i][2]=ali.get(i).getDate().toString();
				objects[i][3]=ali.get(i).getItemname();
				objects[i][4]=ali.get(i).getRemark();		
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(objects, new String[] {"收入编号","金额","日期","项目类型","标记"});
		table.setModel(dtm);// 设置TableModel
		scrollPane.setViewportView(table);
		scrollPane.repaint();
	}
}
