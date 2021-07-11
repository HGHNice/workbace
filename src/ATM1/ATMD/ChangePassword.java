package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField oldpassword;
	private JTextField newpassword;
	private JTextField checkpassword;
	JButton yecheck;
	Account account=new Account();
	static ChangePassword frame3=new ChangePassword();
	public void run() {
		try {
			frame3.init();
			frame3.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 66, 93, 33);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(681, 66, 93, 33);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(10, 133, 93, 33);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setBounds(681, 133, 93, 33);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("1");
		btnNewButton_4.setBounds(10, 301, 93, 33);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("2");
		btnNewButton_5.setBounds(681, 301, 93, 33);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("3");
		btnNewButton_6.setBounds(10, 377, 93, 33);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainInterface1 mainInterface1=new MainInterface1();
				mainInterface1.run();
				frame3.dispose();
			}
		});

		yecheck = new JButton("");  //确认
		yecheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		yecheck.setBounds(681, 377, 93, 33);
		contentPane.add(yecheck);

		JPanel 修改密码 = new JPanel();
		修改密码.setBorder(new TitledBorder(null, "\u4FEE\u6539\u5BC6\u7801\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		修改密码.setBounds(113, 66, 558, 344);
		contentPane.add(修改密码);
		修改密码.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u300A\u8FD4\u56DE");
		lblNewLabel.setBounds(0, 319, 54, 15);
		修改密码.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u786E\u8BA4\u300B");
		lblNewLabel_1.setBounds(504, 319, 54, 15);
		修改密码.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u539F\u5BC6\u7801");
		lblNewLabel_2.setBounds(137, 100, 54, 15);
		修改密码.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_3.setBounds(137, 146, 54, 15);
		修改密码.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_4.setBounds(127, 190, 54, 15);
		修改密码.add(lblNewLabel_4);

		oldpassword = new JTextField();
		oldpassword.setBounds(181, 97, 147, 21);
		修改密码.add(oldpassword);
		oldpassword.setColumns(10);

		newpassword = new JTextField();
		newpassword.setBounds(181, 143, 147, 21);
		修改密码.add(newpassword);
		newpassword.setColumns(10);

		checkpassword = new JTextField();
		checkpassword.setBounds(181, 187, 147, 21);
		修改密码.add(checkpassword);
		checkpassword.setColumns(10);
		frame3.setLocationRelativeTo(null);

		//为组件添加监听
		oldpassword.addActionListener(this);
		newpassword.addActionListener(this);
		checkpassword.addActionListener(this);
		yecheck.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==yecheck){
		String tip = account.changePassword(account.cardID, oldpassword.getText(), newpassword.getText(), checkpassword.getText());
		JOptionPane.showMessageDialog(this,tip,"消息提示框",JOptionPane.WARNING_MESSAGE);
	}

	}
}
