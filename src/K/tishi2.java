//package K;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class tishi2 extends JFrame {
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
//					tishi2 frame = new tishi2();
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
//	public tishi2() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		setLocationRelativeTo(null); //æ”÷–œ‘ æ
//
//		JLabel label = new JLabel("\u4FEE\u6539\u4FE1\u606F\u6210\u529F\uFF01");
//		label.setBounds(144, 106, 113, 18);
//		contentPane.add(label);
//
//		JButton button = new JButton("\u786E\u5B9A");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//			}
//		});
//		button.setBounds(144, 166, 113, 27);
//		contentPane.add(button);
//	}
//}
