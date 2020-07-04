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
		setTitle("个人收支管理系统");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("欢迎使用个人收支管理系统！");
		label.setFont(new Font("华文新魏", Font.BOLD, 18));
		label.setBounds(88, 10, 263, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("宋体", Font.BOLD, 12));
		label_1.setBounds(120, 67, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("宋体", Font.BOLD, 12));
		label_2.setBounds(120, 108, 54, 15);
		contentPane.add(label_2);
		
		username = new JTextField();
		username.setBounds(186, 64, 106, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton register = new JButton("注册");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register zc=new register();
				zc.setVisible(true);
				//dispose();
			}
		});
		register.setBounds(50, 168, 64, 23);
		contentPane.add(register);
		
		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取用户名和密码
				user vo=new user();
				vo.setUsername(username.getText());
				vo.setPassword(password.getText());
				
				//在数据库中查询是否有对应的数据 
				boolean flag=false;
				try {
					flag = ServiceFactory.getIUserServiceInstance().findU(vo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//如果有此用户则进入学生管理系统
				if(flag) {
					//保存用户名
					uname=username.getText();
					//创建对话框对象
					MainFunction mf=new MainFunction();
					mf.frame.setVisible(true);
					dispose();
					
				}
				else {
					//没有此用户   提示对话框 重写用户名及密码
					JOptionPane.showMessageDialog(null,"用户名或密码错误请重新输入！");
					username.setText("");
					password.setText("");
					username.requestFocus();
				}
			}
		});
		btnNewButton_1.setBounds(179, 168, 64, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
				//清除数据后需要将光标放入用户名中
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
