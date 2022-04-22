package ShopText;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

public class Bianji extends JFrame {

	Good good;
	Good good3;
	boolean judge1=true;
	boolean judge2=true;
	boolean judge3=true;
	JScrollPane scrollPane;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	//窗口初始化
	public Bianji() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 514);
		setTitle("编辑信息");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5546\u54C1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(14, 27, 742, 427);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(165, 72, 490, 18);
		panel.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(166, 132, 489, 18);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(165, 190, 490, 18);
		panel.add(label_2);


		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel.setBounds(67, 43, 72, 18);
		panel.add(lblNewLabel);

		textField = new JTextField();

		textField.setBounds(175, 43, 480, 24);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();

		textField_1.setColumns(10);
		textField_1.setBounds(175, 103, 480, 24);
		panel.add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		lblNewLabel_1.setBounds(67, 106, 72, 18);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\u5546\u54C1\u5206\u7C7B");
		lblNewLabel_1_1.setBounds(67, 166, 72, 18);
		panel.add(lblNewLabel_1_1);

		textField_2 = new JTextField();

		textField_2.setColumns(10);
		textField_2.setBounds(175, 163, 480, 24);
		panel.add(textField_2);

		JLabel lblNewLabel_1_2 = new JLabel("\u5546\u54C1\u8BE6\u60C5");
		lblNewLabel_1_2.setBounds(67, 215, 72, 18);
		panel.add(lblNewLabel_1_2);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(175, 221, 534, 141);
		panel.add(textArea);

		JButton btnNewButton = new JButton("\u4FDD\u5B58");


		good=guanli.good;
		textField.setText(good.name);
		textField_1.setText(good.price);
		textField_2.setText(good.type);
		textArea.setText(good.introduce);




		btnNewButton.addActionListener(new ActionListener() {   //保存按钮 监听
			public void actionPerformed(ActionEvent arg0) {

				String name = textField.getText();
				String price = textField_1.getText();
				String group = textField_2.getText();
				String detail = textArea.getText();
				good3=new Good(name, price, group, detail);

				if(judge1&&judge2&&judge3) {
					Good good= new Good(name, price, group, detail);
					List<Good> list = ObjectStream.fanxuliehua();
					for (int i = 0; i < list.size(); i++) {
						Good good2=list.get(i);
						if (good.name.equals(good2.name)) {
							list.set(i, good3);
						}
						ObjectStream.xuliehua(list);
						dispose();

					}
					list.add(good);
					ObjectStream.xuliehua(list);

					dispose();

					//添加商品后重新生成新的树
					guanli.tree = CreatTree.getTree();
					guanli.tree.addTreeSelectionListener(new Show());

					//更新管理员窗口的文本区
					scrollPane.setViewportView(guanli.tree);
					guanli.textArea.setText("");

					//操作完成后重置树节点对象的选中
					guanli.good = null;
				}
				else {
					if (!judge1) {
						label.setText("商品名称不能为空！");
					}
					if (!judge2) {
						if (price.equals("")) {
							label_1.setText("商品价格不能为空！");
						}
						else  if(judgeprice(price)){
							label_2.setText("输入价格格式错误，请更正！");
						}
					}

					if (!judge3) {
						lblNewLabel_1_2.setText("商品分类不能为空！");
					}
					JOptionPane.showMessageDialog(null, "请检查输入是否正确","输入错误",JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		textField.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				String str = textField.getText();
				if (str.equals("")) {
					label.setText("商品名称不能为空！");
					judge1 = false;
				}
				else {
					lblNewLabel.setText("");
					judge1 = true;
				}
				panel.repaint();
			}
		});
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String str = textField_1.getText();
				label_1.setText("");
				if (str.equals("")) {
					label_1.setText("商品价格不能为空！");
					judge2 = false;
				}
				else if(!judgeprice(str)){
					label_1.setText("输入价格格式错误！");
					judge2 = false;
				}
				else{
					lblNewLabel.setText("");
					judge2 = true;
				}
				panel.repaint();
			}


		});
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String str = textField_2.getText();
				if (str.equals("")) {
					label_2.setText("商品分类不能为空！");
					judge3 = false;
				}
				else {
					label_2.setText("");
					judge3 = true;
				}


			}
		});
		btnNewButton.setBounds(219, 387, 113, 27);
		panel.add(btnNewButton);

		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		button.setBounds(442, 387, 113, 27);
		panel.add(button);
		setLocationRelativeTo(null);


	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	private boolean judgeprice(String num) {
		boolean result;
		String regex="[0-9.]+元";  //价格格式
		result=num.matches(regex);
		return result;
	}
	
	public void setGood(Good good) {
		// TODO Auto-generated method stub
		this.good=good;
	}
	
	
}
