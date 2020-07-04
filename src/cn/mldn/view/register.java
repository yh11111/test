package cn.mldn.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JButton button;
	private JButton button_1;
	private JPasswordField password;
	private JPasswordField password2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户名：");
		label.setBounds(90, 36, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(99, 81, 41, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("确认密码：");
		label_2.setBounds(74, 120, 83, 15);
		contentPane.add(label_2);
		
		username = new JTextField();
		username.setBounds(154, 33, 131, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//取出文本框中的数据
				user vo=new user();
				vo.setUsername(username.getText());
				vo.setPassword(password.getText());
				String password_2=password2.getText();
				
				boolean flag=true;
				try {
					flag=ServiceFactory.getIUserServiceInstance().find(vo.getUsername());
					if(flag)
					{
						JOptionPane.showMessageDialog(null,"用户名以被使用，换一个吧！");
						label.requestFocus();
					}
					else if(!(vo.getPassword().equals(password_2))) {
							JOptionPane.showMessageDialog(null,"您输入的密码不一致，请重新输入");
							password.setText("");
							password2.setText("");
							password.requestFocus();
					}
					else if(ServiceFactory.getIUserServiceInstance().insert(vo))
					{	//没有错误之后
						//将数据保存到数据库中
						JOptionPane.showMessageDialog(null,"注册成功!");
					}
						
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(88, 190, 67, 23);
		contentPane.add(button);
		
		button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
				password2.setText("");
				username.requestFocus();
			}
		});
		button_1.setBounds(233, 190, 67, 23);
		contentPane.add(button_1);
		
		password = new JPasswordField();
		password.setBounds(154, 78, 131, 21);
		contentPane.add(password);
		
		password2 = new JPasswordField();
		password2.setBounds(154, 117, 131, 21);
		contentPane.add(password2);
	}

}
