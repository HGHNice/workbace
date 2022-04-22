//package K;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class tishi3 extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					tishi3 frame = new tishi3();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public tishi3() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel label = new JLabel("\u786E\u5B9A\u8981\u9000\u51FA\u5417\uFF1F");
//		label.setBounds(146, 106, 144, 18);
//		contentPane.add(label);
//
//		JButton button = new JButton("\u786E\u5B9A");
//
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//			//	setDefaultCloseOperation(EXIT_ON_CLOSE);
//				System.exit(0);
//			}
//		});
//		button.setBounds(47, 162, 113, 27);
//		contentPane.add(button);
//
//		JButton button_1 = new JButton("\u53D6\u6D88");
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//			}
//		});
//		button_1.setBounds(222, 162, 113, 27);
//		contentPane.add(button_1);
//		setLocationRelativeTo(null); //æ”÷–œ‘ æ
//	}
//}
