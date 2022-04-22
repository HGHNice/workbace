package ShopText;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Putong extends JFrame {

	private static final String[][] Object = null;
	private JPanel contentPane;
	private JTable table_1;
	private JTable table_1_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;



	/**
	 * Create the frame.
	 */
	public Putong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 513);
		setTitle("个人中心");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 702, 456);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u4E2A\u4EBA\u8D44\u6599", null, panel, null);
		panel.setLayout(null);
		
		
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setBounds(86, 48, 72, 18);
		panel.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(147, 45, 139, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_1.setBounds(57, 110, 105, 18);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(147, 107, 139, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(86, 175, 51, 18);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u9ED8\u8BA4\u5730\u5740\uFF1A");
		label_3.setBounds(57, 249, 101, 18);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(147, 246, 354, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);
		setLocationRelativeTo(null);
		
		JButton button = new JButton("\u4FEE\u6539\u4FE1\u606F");
		File file=new File("shangping/xinxi-2");
		String []datax = new String[4];
		int f = 0;
		try {
			Reader out=new FileReader(file);
			
			BufferedReader bufferedReader = new BufferedReader(out);
			String data=null ;
			
			while((data =bufferedReader.readLine())!=null) {  //换行读取 为空就换行 一行为分割  分别赋值
				datax[f] = data;
				f++;
				}
			textField.setText(datax[0]);
				textField_1.setText(datax[1]);
			textField_2.setText(datax[2]);
			
			bufferedReader.close();
			
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField_1.setEditable(true);
				textField_2.setEditable(true);

				
			}
		});
		button.setBounds(161, 324, 113, 27);
		panel.add(button);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setBounds(235, 171, 51, 27);
		panel.add(radioButton);
		
		
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setBounds(147, 171, 51, 27);
		panel.add(radioButton_1);

		radioButton.setSelected(true);
		group.add(radioButton);
		group.add(radioButton_1);
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEditable(false);
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				
			}
		});
		button_1.setBounds(330, 324, 113, 27);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(505, 324, 113, 27);
		panel.add(button_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u6211\u7684\u8BA2\u5355", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1_1 = new JTable();
		File file3=new File("shangping/xinxi3");
		String []datay = new String[4];
		int d = 0;
		try {
			Reader ou=new FileReader(file3);
			
			BufferedReader bufferedReader = new BufferedReader(ou);

			bufferedReader.close();
			
			ou.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		table_1_1.setModel(new DefaultTableModel(
				
			new Object[][] {
				
				{"1", "20011054", "2021-5-20", "水果", "广西科技大学"},
				{"2", "20011055", "2021-6-20", "冰箱", "广西科技大学"},
				{"3", "20011056", "2021-7-20", "空调", "广西科技大学"},
				{"4", "20011057", "2021-8-20", "洗衣机", "广西科技大学"},
			},
			
			
			new String[] {
				"序号", "\u7F16\u53F7", "\u4E0B\u5355\u65F6\u95F4", "\u5546\u54C1\u540D\u79F0", "\u6536\u8D27\u4FE1\u606F"
			}
			
		)
		
		
		
		
		{
			
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1_1.getColumnModel().getColumn(4).setPreferredWidth(222);
		scrollPane_1.setViewportView(table_1_1);
		}
}
