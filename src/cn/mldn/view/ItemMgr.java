package cn.mldn.view;

import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.mldn.dao.impl.TableController;
import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.item;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ItemMgr extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JScrollPane scrollPane;
	private List<item> ali=new ArrayList<item>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemMgr frame = new ItemMgr();
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
	public ItemMgr() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6536\u652F\u9879\u76EE\u7BA1\u7406");
		setBounds(100, 100, 373, 408);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		label.setBounds(10, 20, 67, 15);
		getContentPane().add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 49, 307, 185);
		getContentPane().add(scrollPane); 
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[][] objects = new Object[10][];
		table.setModel(new javax.swing.table.DefaultTableModel(objects, 
				new String[] { "���","��Ŀ����" }));
		
		table.addMouseListener(new MouseAdapter() {// ��ӵ���JTable���¼�����
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();// ��õ�ǰ��ѡ�е��к�
					textField_1.setText(table.getValueAt(row, 0).toString());
					textField_2.setText(table.getValueAt(row, 1).toString());
				} catch (Exception e1) {
					// ������հ״���ʲôҲ������
				}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(68, 17, 68, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("��ѯ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//List<item> ali=new ArrayList<item>();
					List<item> ali1=new ArrayList<item>();
					System.out.println(textField.getText());
					if(textField.getText().equals(""))
						ali=new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
					else
						ali=new ServiceFactory().getItemServiceInstance().findItem(new login().uname,textField.getText());
					System.out.println(ali.get(0).getId()+ali.get(0).getItem());
					ali1=new TableController(ali).setCurentPageIndex();
					showTable(ali1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(146, 16, 66, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("��һҳ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List <item> ali=new ArrayList<item>();
				try {
					ali=new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
					List<item> list=new TableController(1,ali).previousPage();
					showTable(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(25, 254, 93, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("��һҳ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List <item> ali=new ArrayList<item>();
				try {
					//ali=new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
					List<item> list=new TableController(ali).previousPage();
					showTable(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(131, 254, 93, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("��һҳ");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//List <item> ali=new ArrayList<item>();
				try {
					//ali=new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
					List<item> list=new TableController(ali).nextPage();
					showTable(list);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(239, 254, 93, 23);
		getContentPane().add(button_3);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		label_1.setBounds(25, 292, 54, 15);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 289, 66, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		label_2.setBounds(167, 292, 68, 15);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 289, 102, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_4 = new JButton("ɾ��");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(button_4, "���Ҫɾ����", "ȷ��ɾ��",
						JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					boolean flag=false;
					item vo=new item();
					vo.setUsername(new login().uname);
					vo.setId(Integer.valueOf(textField_1.getText()));
					vo.setItem(textField_2.getText());
					try {
						flag=new ServiceFactory().getItemServiceInstance().delete(vo);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						if(flag)
						{
							List<item> ali1=new ArrayList<item>();
							ali = new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
							ali1=new TableController(ali).setCurentPageIndex();
							showTable(ali1);
							JOptionPane.showMessageDialog(button_4, "ɾ���ɹ���");
							textField_1.setText("");
							textField_2.setText("");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_4.setBounds(69, 332, 67, 23);
		getContentPane().add(button_4);
		
		JButton button_4_1 = new JButton("�޸�");
		button_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(button_4, "���Ҫ�޸���", "ȷ���޸�",
						JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					item vo=new item();
					System.out.println(table.getValueAt(row, 0)+",,,"+textField_1.getText());
					if(!(table.getValueAt(row, 0).equals(textField_1.getText())))
					{
						JOptionPane.showMessageDialog(null,"��Ų����޸ģ�����");
						textField_1.setText("");
						textField_2.setText("");
					}
					else
					{
						vo.setUsername(new login().uname);
						vo.setId(Integer.valueOf(textField_1.getText()));
						vo.setItem(textField_2.getText());
						try {
							List<item> ali1=new ArrayList<item>(); 
							new ServiceFactory().getItemServiceInstance().update(vo);
							ali=new ServiceFactory().getItemServiceInstance().findAll(new login().uname);
							ali1=new TableController(ali).setCurentPageIndex();
							showTable(ali1);
							JOptionPane.showMessageDialog(button_4, "�޸ĳɹ���");
							textField_1.setText("");
							textField_2.setText("");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		button_4_1.setBounds(209, 332, 67, 23);
		getContentPane().add(button_4_1);
		
		JLabel label_3 = new JLabel("����:");
		label_3.setBounds(222, 20, 54, 15);
		getContentPane().add(label_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("-��ѡ��-");
		comboBox.addItem("���"); // ����3������ѡ��
		comboBox.addItem("��Ŀ����");
		comboBox.setToolTipText("\u6392\u5E8F");
		comboBox.setBounds(265, 17, 82, 21);
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String field=(String) comboBox.getSelectedItem();
				try {
					if(!(field.equals("-��ѡ��-")))
					{
						ali=new ServiceFactory().getItemServiceInstance().Sort(ali, field);
						List<item> list=new TableController(1,ali).previousPage();
						showTable(list);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public void showTable(List<item> ali)
	{
		String[][] objects = new String[10][]; 
		System.out.println("������"+ali.size()+"��"+ali.get(0).getId().toString()+""+ali.get(0).getItem()+objects.length);
		for (int i = 0; i < ali.size(); i++) {
			objects[i] = new String[2];
			objects[i][0] = String.valueOf(ali.get(i).getId()); 
			objects[i][1] = ali.get(i).getItem();
		}
		DefaultTableModel dtm = new DefaultTableModel(objects, new String[] {"���","��Ŀ����"});
		table.setModel(dtm);// ����TableModel
		scrollPane.setViewportView(table);
		scrollPane.repaint();
	}
}
