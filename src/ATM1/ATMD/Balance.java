package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Balance extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField id;
	private JTextField Jbanlance;
	static Balance frame2=new Balance();
	public void run() {
		try {
			frame2.init();
			frame2.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

void init() {
		setBackground(new Color(240, 240, 240));
		setTitle("\u6B22\u8FCE\u6765\u5230ATM\u673A");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1100, 100, 800, 511);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(153, 153, 153, 70));
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u4F59\u989D\u67E5\u8BE2\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(196, 98, 400, 206);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel.setBounds(66, 66, 96, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\u4F59\u989D\uFF1A");
		lblNewLabel_2.setBounds(66, 112, 96, 25);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("\u8FD4\u56DE\u300B");
		lblNewLabel_4.setBounds(332, 181, 58, 15);
		panel.add(lblNewLabel_4);

		id = new JTextField();
		id.setBounds(138, 68, 123, 21);
		panel.add(id);
		id.setColumns(10);


		Jbanlance = new JTextField();
		Jbanlance.setBounds(138, 114, 123, 21);
		panel.add(Jbanlance);
		Jbanlance.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(38, 98, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(38, 159, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(38, 216, 97, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(38, 278, 97, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(636, 98, 97, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setBounds(636, 159, 97, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.setBounds(636, 216, 97, 23);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_8 = new JButton("8");//返回
		btnNewButton_8.setBounds(636, 278, 97, 23);
		contentPane.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainInterface1 mainInterface1=new MainInterface1();
				mainInterface1.run();
				frame2.dispose();
			}
		});

		frame2.setLocationRelativeTo(null); //居中显示
		/*
		***************************
		*
		 */
	id.addActionListener(this);
	Jbanlance.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Account account=new Account();
		try {
			account.select(id.getText());
			Jbanlance.setText(account.s);

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}
}


