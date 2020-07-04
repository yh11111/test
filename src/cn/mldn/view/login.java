package cn.mldn.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;


import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.user;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {
	
	private JPanel contentPane;
	private JTextField username;
	static String uname;
	private JPasswordField password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("������֧����ϵͳ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("��ӭʹ�ø�����֧����ϵͳ��");
		label.setFont(new Font("������κ", Font.BOLD, 18));
		label.setBounds(88, 10, 263, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("�û�����");
		label_1.setFont(new Font("����", Font.BOLD, 12));
		label_1.setBounds(120, 67, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("���룺");
		label_2.setFont(new Font("����", Font.BOLD, 12));
		label_2.setBounds(120, 108, 54, 15);
		contentPane.add(label_2);
		
		username = new JTextField();
		username.setBounds(186, 64, 106, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton register = new JButton("ע��");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register zc=new register();
				zc.setVisible(true);
				//dispose();
			}
		});
		register.setBounds(50, 168, 64, 23);
		contentPane.add(register);
		
		JButton btnNewButton_1 = new JButton("��¼");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û���������
				user vo=new user();
				vo.setUsername(username.getText());
				vo.setPassword(password.getText());
				
				//�����ݿ��в�ѯ�Ƿ��ж�Ӧ������ 
				boolean flag=false;
				try {
					flag = ServiceFactory.getIUserServiceInstance().findU(vo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//����д��û������ѧ������ϵͳ
				if(flag) {
					//�����û���
					uname=username.getText();
					//�����Ի������
					MainFunction mf=new MainFunction();
					mf.frame.setVisible(true);
					dispose();
					
				}
				else {
					//û�д��û�   ��ʾ�Ի��� ��д�û���������
					JOptionPane.showMessageDialog(null,"�û���������������������룡");
					username.setText("");
					password.setText("");
					username.requestFocus();
				}
			}
		});
		btnNewButton_1.setBounds(179, 168, 64, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
				//������ݺ���Ҫ���������û�����
				username.requestFocus();
			}
		});
		btnNewButton_2.setBounds(316, 168, 64, 23);
		contentPane.add(btnNewButton_2);
		
		password = new JPasswordField();
		password.setBounds(186, 105, 106, 21);
		contentPane.add(password);
	}
}
