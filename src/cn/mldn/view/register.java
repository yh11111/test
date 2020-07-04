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
		setTitle("�û�ע��");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("�û�����");
		label.setBounds(90, 36, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("���룺");
		label_1.setBounds(99, 81, 41, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("ȷ�����룺");
		label_2.setBounds(74, 120, 83, 15);
		contentPane.add(label_2);
		
		username = new JTextField();
		username.setBounds(154, 33, 131, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		button = new JButton("ע��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ȡ���ı����е�����
				user vo=new user();
				vo.setUsername(username.getText());
				vo.setPassword(password.getText());
				String password_2=password2.getText();
				
				boolean flag=true;
				try {
					flag=ServiceFactory.getIUserServiceInstance().find(vo.getUsername());
					if(flag)
					{
						JOptionPane.showMessageDialog(null,"�û����Ա�ʹ�ã���һ���ɣ�");
						label.requestFocus();
					}
					else if(!(vo.getPassword().equals(password_2))) {
							JOptionPane.showMessageDialog(null,"����������벻һ�£�����������");
							password.setText("");
							password2.setText("");
							password.requestFocus();
					}
					else if(ServiceFactory.getIUserServiceInstance().insert(vo))
					{	//û�д���֮��
						//�����ݱ��浽���ݿ���
						JOptionPane.showMessageDialog(null,"ע��ɹ�!");
					}
						
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(88, 190, 67, 23);
		contentPane.add(button);
		
		button_1 = new JButton("����");
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
