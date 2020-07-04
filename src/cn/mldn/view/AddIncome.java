package cn.mldn.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.income;
import cn.mldn.vo.item;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class AddIncome extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddIncome frame = new AddIncome();
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
	public AddIncome() {
		setClosable(true);
		setIconifiable(true);
		setTitle("�������");
		setBounds(100, 100, 387, 274);
		getContentPane().setLayout(null);
		
		JLabel label_6 = new JLabel("���ڣ�");
		label_6.setBounds(10, 73, 54, 15);
		getContentPane().add(label_6);
		
		final DatePicker datepick;
        datepick = getDatePicker();
        getContentPane().add(datepick);
        
		JLabel label = new JLabel("���:");
		label.setBounds(10, 23, 54, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(54, 20, 121, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
//		JLabel label_1 = new JLabel("\u5E74");
//		label_1.setBounds(148, 100, 18, 15);
//		getContentPane().add(label_1);
		
		
		JLabel label_2 = new JLabel("��Ŀ��");
		label_2.setBounds(199, 23, 54, 15);
		getContentPane().add(label_2); 
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(240, 20, 121, 21);
		getContentPane().add(comboBox);
		
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
		
		JLabel label_3 = new JLabel("\u5907\u6CE8\uFF1A");
		label_3.setBounds(10, 119, 54, 15);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(54, 116, 289, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("���");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				income vo=new income();
				vo.setUsername(new login().uname);
				vo.setId(Integer.valueOf(textField_1.getText()));
				vo.setMoney(Double.valueOf(textField.getText()));
				Date date1 = null;
				Date date=null;
				try {

			        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
					date1 = (Date) sdf.parse(datepick.getValue().toString());
					SimpleDateFormat formatStr2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					 date = (Date) formatStr2.parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date1));
					vo.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vo.setItemname(comboBox.getSelectedItem().toString());
				vo.setRemark(textField_2.getText());
				try {
					boolean flag=ServiceFactory.getIIncomeServiceInstance().insert(vo);
					if(flag==true)
						JOptionPane.showMessageDialog(null,"��ӳɹ���");
					else
						JOptionPane.showMessageDialog(null,"��֧����Ѵ��ڣ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(52, 172, 72, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("����");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField.requestFocus();
			}
		});
		button_1.setBounds(224, 172, 72, 23);
		getContentPane().add(button_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("����", Font.BOLD, 14));
		comboBox_1.setBounds(54, 97, 72, 21);
//		getContentPane().add(comboBox_1);
//		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020",
//		"2021", "2022", "2023", "2024", "2025" }));
		
//		JComboBox comboBox_2 = new JComboBox();
//		comboBox_2.setBounds(176, 97, 54, 21);
//		getContentPane().add(comboBox_2);
//		comboBox_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", 
//		"5", "6", "7", "8", "9", "10", "11", "12"}));
		
//		JLabel label_4 = new JLabel("\u6708");
//		label_4.setBounds(240, 100, 25, 15);
//		getContentPane().add(label_4);
		
//		JComboBox comboBox_3 = new JComboBox();
//		comboBox_3.setBounds(265, 97, 54, 21);
//		getContentPane().add(comboBox_3);
//		comboBox_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6",
//		"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", 
//		"25", "26", "27", "28", "29", "30", "31" }));
		
		
//		JLabel label_5 = new JLabel("\u65E5");
//		label_5.setBounds(329, 100, 32, 15);
//		getContentPane().add(label_5);
		
        
		JLabel label_7 = new JLabel("\u6536\u5165\u7F16\u53F7\uFF1A");
		label_7.setBounds(240, 73, 81, 15);
		getContentPane().add(label_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(307, 67, 54, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		

	}
	 private static DatePicker getDatePicker() {
	        final DatePicker datepick;
	        // ��ʽ
	        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
	        // ��ǰʱ��
	        Date date = new Date();
	        // ����a
	        Font font = new Font("Times New Roman", Font.BOLD, 14);
	        Dimension dimension = new Dimension(177, 24);
	        int[] hilightDays = { 1, 3, 5, 7 };
	        datepick = new DatePicker(date, DefaultFormat, font, dimension);
	        datepick.setLocation(137, 83);
	        datepick.setBounds(50, 65, 177, 24);
	        // ����һ���·�����Ҫ������ʾ������
	        datepick.setHightlightdays(hilightDays, Color.red);
	        // ����һ���·��в���Ҫ�����ӣ��ʻ�ɫ��ʾ
	        //datepick.setDisableddays(disabledDays);
	        // ���ù���
	        datepick.setLocale(Locale.CHINA);
	        // ����ʱ�����ɼ�
	        datepick.setTimePanleVisible(true);
	        return datepick;
	    }
}
