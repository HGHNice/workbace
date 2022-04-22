package ShopText;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class tianjia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 JScrollPane scrollPane1;
    public void setScrollPane(JScrollPane scrollPane1) {
		this.scrollPane1 = scrollPane1;
	}



	/**
	 * Create the frame.
	 */
	public tianjia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 535);
		setTitle("添加信息");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel.setBounds(83, 49, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(196, 46, 395, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		lblNewLabel_1.setBounds(82, 115, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 115, 395, 24);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u5206\u7C7B");
		lblNewLabel_2.setBounds(83, 175, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(197, 175, 394, 24);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u4FE1\u606F");
		lblNewLabel_3.setBounds(82, 252, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(196, 250, 485, 150);
		contentPane.add(textArea);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5546\u54C1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(14, 13, 694, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.setBounds(171, 422, 113, 27);
		panel.add(button);
		setLocationRelativeTo(null); //居中显示
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 
			
				String name=textField.getText();
				String price=textField_1.getText();
				String type=textField_2.getText();
				String introduce=textArea.getText();
				
				Good good=new Good(name, price, type, introduce);
				List<Good> list=ObjectStream.fanxuliehua();
				if (list==null) {
					list=new ArrayList<Good>();
				}
				
				list.add(good);
				ObjectStream.xuliehua(list);
				dispose();
				
				JTree tree=CreatTree.getTree();//更新树
				scrollPane1.setViewportView(tree);
				
				

			}
		});
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(421, 422, 113, 27);
		panel.add(button_1);
	}

	
	
}
