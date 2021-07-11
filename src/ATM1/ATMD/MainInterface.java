package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame implements ActionListener {
	JComboBox comboBox;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_8;
	private JPanel contentPane;
	static MainInterface frame = new MainInterface();
	private JPasswordField passwordField;

	public void run() {
		try {
			frame.init();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void init() {
		setTitle("\u6B22\u8FCE\u4F7F\u7528\u94F6\u884CATM\u673A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setToolTipText("");
		panel.setBorder(
				new TitledBorder(null, "\u767B\u9646\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(201, 98, 400, 206);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u9884\u7F6E\u8D26\u53F7\uFF01");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(152, 10, 109, 38);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel.setBounds(66, 66, 96, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(66, 112, 96, 25);
		panel.add(lblNewLabel_2);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[]{"\u8BF7\u9009\u62E9\u9884\u7F6E\u8D26\u53F7", "202009601074","202009601308","202009601305","202009601259"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setToolTipText("");
		comboBox.setBounds(138, 66, 123, 25);
		panel.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("\u300A\u53D6\u6D88");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setBounds(10, 181, 66, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u786E\u5B9A\u300B");
		lblNewLabel_4.setBounds(332, 181, 58, 15);
		panel.add(lblNewLabel_4);

		passwordField = new JPasswordField();
		passwordField.setBounds(138, 114, 123, 21);
		panel.add(passwordField);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(38, 98, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(38, 159, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(38, 216, 97, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(38, 278, 97, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(636, 98, 97, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(636, 159, 97, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBounds(636, 216, 97, 23);
		contentPane.add(btnNewButton_6);

		btnNewButton_8 = new JButton("");
		btnNewButton_8.setBounds(636, 278, 97, 23);
		contentPane.add(btnNewButton_8); // 每个按钮的功能以及监视器

		frame.setLocationRelativeTo(null);

		btnNewButton_8.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flag=false;
	Account account=new Account();
	account.jlogin((String) comboBox.getSelectedItem(),passwordField.getText());  //调用账户类进行判断登录
	System.out.println("你输入的密码是"+passwordField.getText());
	if (account.s.equals("登陆成功")){     //如果登录成功打开新页面并且释放此页面
		MainInterface1 mainInterface1=new MainInterface1();
		mainInterface1.run();
		frame.dispose();
	}
	}
}

