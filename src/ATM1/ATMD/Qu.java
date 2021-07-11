package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Qu extends JFrame implements ActionListener  {
	Account account=new Account();
	private JPanel contentPane;
	JButton btnNewButton,btnNewButton_1 ,btnNewButton_2,btnNewButton_3,btnNewButton_4,btnNewButton_5,btnNewButton_6,btnNewButton_7;
	JPanel panel;
	JTextField yutext;
	static Qu frame5=new Qu();
	/*
	建立账户类的对象
	 */

	public void run() {
		try {
			frame5.init();
			frame5.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void init() {
		setTitle("\u6B22\u8FCE\u4F7F\u7528ATM\u673A");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("");//1000
		btnNewButton.setBounds(34, 107, 93, 23);//1000//
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("");//1200//
		btnNewButton_1.setBounds(34, 165, 93, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("");   //1500//
		btnNewButton_2.setBounds(34, 252, 93, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("确定");//确定//
		btnNewButton_3.setBounds(34, 351, 93, 23);
		contentPane.add(btnNewButton_3);

		btnNewButton_4 = new JButton("");//100//
		btnNewButton_4.setBounds(669, 107, 93, 23);
		contentPane.add(btnNewButton_4);

		btnNewButton_5 = new JButton("");//200//
		btnNewButton_5.setBounds(669, 165, 93, 23);
		contentPane.add(btnNewButton_5);

		btnNewButton_6 = new JButton("");//300//
		btnNewButton_6.setBounds(669, 252, 93, 23);
		contentPane.add(btnNewButton_6);

		btnNewButton_7 = new JButton("");//返回//
		btnNewButton_7.setBounds(669, 351, 93, 23);
		contentPane.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainInterface1 mainInterface1=new MainInterface1();
				mainInterface1.run();
				frame5.dispose();
			}
		});

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u73B0\u91D1\u63D0\u53D6\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(137, 92, 522, 293);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u300A1000");
		lblNewLabel.setBounds(10, 20, 54, 21);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u300A1200");
		lblNewLabel_1.setBounds(10, 81, 54, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u300A1500");
		lblNewLabel_2.setBounds(10, 165, 54, 15);
		panel.add(lblNewLabel_2);

//		JLabel lblNewLabel_3 = new JLabel("\u300A\u5176\u4ED6");
//		lblNewLabel_3.setBounds(10, 268, 54, 15);
//		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("100\u300B");
		lblNewLabel_4.setBounds(458, 23, 54, 15);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("200\u300B");
		lblNewLabel_5.setBounds(458, 81, 42, 15);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("300\u300B");
		lblNewLabel_6.setBounds(458, 165, 42, 15);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u8FD4\u56DE\u300B");
		lblNewLabel_7.setBounds(470, 268, 42, 15);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("   \u8BF7\u9009\u62E9\u91D1\u989D\uFF01");
		lblNewLabel_8.setBounds(208, 44, 122, 50);
		panel.add(lblNewLabel_8);

		yutext=new JTextField(10);
		yutext.setBounds(220, 90, 100, 50);
		panel.add(yutext);

		frame5.setLocationRelativeTo(null);

	//加入各个按钮的监听
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);
		btnNewButton_4.addActionListener(this);
		btnNewButton_5.addActionListener(this);
		btnNewButton_6.addActionListener(this);
		btnNewButton_3.addActionListener(this);




	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String balance1=yutext.getText();
		if (e.getSource()==btnNewButton_1){
			yutext.setText("1200");
		}
		if (e.getSource()==btnNewButton_2){
			yutext.setText("1500");
		}
		if (e.getSource()==btnNewButton_4){
			yutext.setText("100");
		}
		if (e.getSource()==btnNewButton_5){
			yutext.setText("200");
		}
		if (e.getSource()==btnNewButton_6){
			yutext.setText("300");
		}
		if (e.getSource()==btnNewButton){
			yutext.setText("1000");
		}
		if (e.getSource()==btnNewButton_3){
			String s=account.Withdrawal(account.cardID,balance1);
			JOptionPane.showMessageDialog(this,s,"消息提示框",JOptionPane.WARNING_MESSAGE);
		}
	}
}
