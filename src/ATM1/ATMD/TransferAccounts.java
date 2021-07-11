package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferAccounts extends JFrame implements ActionListener {

	static TransferAccounts frame6 = new TransferAccounts();
	Account account=new Account();
	JButton btnNewButton_8;
	private JPanel contentPane;
	private JTextField passID, money;

	public void run() {
		try {
			frame6.init();
			frame6.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void init() {
		setAutoRequestFocus(false);
		setBackground(new Color(240, 240, 240));
		setTitle("\u6B22\u8FCE\u6765\u5230ATM\u673A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8F6C\u8D26\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(196, 98, 400, 206);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u8981\u8F6C\u5165\u8D26\u6237\u7684\u91D1\u989D\uFF01");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(122, 10, 160, 38);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel.setBounds(66, 66, 96, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\u91D1\u989D\uFF1A");
		lblNewLabel_2.setBounds(66, 112, 96, 25);
		panel.add(lblNewLabel_2);


		JLabel lblNewLabel_3 = new JLabel("\u300A\u8FD4\u56DE");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setBounds(10, 181, 66, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u786E\u5B9A\u300B");
		lblNewLabel_4.setBounds(332, 181, 58, 15);
		panel.add(lblNewLabel_4);

		money = new JTextField();
		money.setBounds(138, 114, 123, 21);
		panel.add(money);

		passID = new JTextField();
		passID.setBounds(138, 68, 123, 21);
		panel.add(passID);
		passID.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u66F4\u6B63\u300B");
		lblNewLabel_5.setBounds(332, 127, 58, 15);
		panel.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("5");
		btnNewButton.setBounds(38, 98, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("4");
		btnNewButton_1.setBounds(38, 159, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setBounds(38, 216, 97, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("2");//返回
		btnNewButton_3.setBounds(38, 278, 97, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainInterface1 mainInterface1=new MainInterface1();
				mainInterface1.run();
				frame6.dispose();
			}
		});

		JButton btnNewButton_4 = new JButton("1");
		btnNewButton_4.setBounds(636, 98, 97, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(636, 159, 97, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBounds(636, 216, 97, 23);
		contentPane.add(btnNewButton_6);

		 btnNewButton_8 = new JButton("");//确定
		btnNewButton_8.setBounds(636, 278, 97, 23);
		contentPane.add(btnNewButton_8);

		frame6.setLocationRelativeTo(null);
		passID.addActionListener(this);
		money.addActionListener(this);
		btnNewButton_8.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnNewButton_8){
			String ZID= passID.getText();
			if (ZID.equals(account.cardID)!=true){
				String ZM=money.getText();
				if (ZM.equals("")){
					JOptionPane.showMessageDialog(frame6,"请输入金额");
				}
				else if (!ZM.equals("")){
					account.Withdrawal(account.cardID,ZM);//转出账户
					account.deposit(ZID,ZM);//转入账户
					System.out.println("转账成功");
					JOptionPane.showMessageDialog(this,"转账成功");
				}

			}
			}
			else {
				JOptionPane.showMessageDialog(this, "不能转给自己");
			}

		}


	}
