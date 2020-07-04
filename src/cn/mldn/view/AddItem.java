package cn.mldn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.item;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddItem extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
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
	public AddItem() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u6DFB\u52A0\u9879\u76EE");
		setBounds(100, 100, 382, 197);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		label.setBounds(183, 53, 71, 15);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(251, 50, 102, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item vo=new item();
				vo.setUsername(new login().uname);
				vo.setId(Integer.valueOf(textField_1.getText()));
				vo.setItem(textField.getText());
				try {
					boolean flag=new ServiceFactory().getItemServiceInstance().insert(vo);
					if(flag)
						JOptionPane.showMessageDialog(null,"添加成功！");
					else
						JOptionPane.showMessageDialog(null,"添加失败，改编号已经存在！");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(35, 132, 65, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
				textField.requestFocus();
			}
		});
		button_1.setBounds(258, 132, 71, 23);
		getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		label_1.setBounds(10, 53, 78, 15);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 50, 89, 21);
		getContentPane().add(textField_1);

	}
}
