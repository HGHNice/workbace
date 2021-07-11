package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterface1 extends JFrame {
	JButton btnNewButton;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_4;
	JButton btnNewButton_5;
	JButton btnNewButton_6;
	JButton btnNewButton_7;
	static MainInterface1 frame1=new MainInterface1();
	private JPanel contentPane;
	public void run() {
		try {
			frame1.init();
			frame1.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void init(){
		setVisible(true);
		setTitle("\u6B22\u8FCE\u4F7F\u7528\u94F6\u884CATM\u673A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("");   //取款按钮
		btnNewButton.setBounds(60, 53, 108, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Qu qu=new Qu();
			qu.run();
			frame1.dispose();
			}
		});

		btnNewButton_1 = new JButton("");//存款
		btnNewButton_1.setBounds(60, 138, 108, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cun cun=new Cun();
				cun.run();
				frame1.dispose();
			}
		});


		btnNewButton_2 = new JButton("");          //转账
		btnNewButton_2.setBounds(60, 219, 108, 35);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TransferAccounts transferAccounts=new TransferAccounts();
				transferAccounts.run();
				frame1.dispose();
			}
		});

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(60, 310, 108, 35);
		contentPane.add(btnNewButton_3);

		btnNewButton_4 = new JButton("");  //查询余额
		btnNewButton_4.setBounds(635, 53, 108, 35);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Balance balance=new Balance();
				balance.run();
				frame1.dispose();
			}
		});

		btnNewButton_5 = new JButton("");   //修改密码
		btnNewButton_5.setBounds(635, 138, 108, 35);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			ChangePassword changePassword=new ChangePassword();
			changePassword.run();
			frame1.dispose();
			}
		});

		btnNewButton_6 = new JButton("");   //历史数据
		btnNewButton_6.setBounds(635, 219, 108, 35);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Historicaldata historicaldata=new Historicaldata();
				historicaldata.run();
				frame1.dispose();
			}
		});

		btnNewButton_7 = new JButton("");
		btnNewButton_7.setBounds(635, 310, 108, 35);
		contentPane.add(btnNewButton_7);//退出系统
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4E3B\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(221, 53, 369, 293);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u300A\u53D6\u6B3E");
		lblNewLabel.setBounds(0, 20, 58, 26);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u300A\u5B58\u6B3E");
		lblNewLabel_1.setBounds(0, 89, 58, 26);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u300A\u8F6C\u5E10");
		lblNewLabel_2.setBounds(0, 168, 58, 26);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u67E5\u8BE2\u4F59\u989D\u300B");
		lblNewLabel_3.setBounds(297, 20, 72, 26);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u4FEE\u6539\u5BC6\u7801\u300B");
		lblNewLabel_4.setBounds(297, 89, 72, 26);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u5386\u53F2\u6570\u636E\u67E5\u8BE2\u300B");
		lblNewLabel_5.setBounds(285, 168, 84, 26);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u9000\u51FA\u7CFB\u7EDF\u300B");
		lblNewLabel_6.setBounds(297, 246, 72, 26);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u8BF7\u9009\u62E9\u76F8\u5E94\u529F\u80FD\uFF01");
		lblNewLabel_7.setBounds(133, 26, 96, 15);
		panel.add(lblNewLabel_7);

		frame1.setLocationRelativeTo(null);

	}



	}


