package ShopText;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;

	String re="[0-9]+";
	static Main main=new Main();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//窗口实现方法
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 480);
		setTitle("小何电商平台");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7\u7C7B\u578B\uFF1A");
		label.setBounds(112, 74, 94, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		label_1.setBounds(142, 125, 72, 18);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(384, 125, 157, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(142, 177, 45, 18);
		contentPane.add(label_2);
		setLocationRelativeTo(null); //居中显示
		
		JLabel lblNewLabel = new JLabel("");    //此方法为窗口下面设置小字
		lblNewLabel.addFocusListener(new FocusAdapter() {   //焦点事件
					public void focusLost(FocusEvent arg0) {
						lblNewLabel.setText("账号输入错误!");
			}
		});
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				String p=textField_1.getText();
				Pattern p1 = Pattern.compile("[\\d]");       //对名字进行判断是否符合规则
				Pattern p2 = Pattern.compile("[\\p{Alpha}]+");
				Pattern p3 = Pattern.compile("[_]+");
				Matcher m1 = p1.matcher(p);
				Matcher m2 = p2.matcher(p);
				Matcher m3 = p3.matcher(p);
				if (!m2.find()&&m1.find()&&m3.find()) {
					lblNewLabel_1.setText("账号错误!");	
					}
				if (p.matches(re)) {
					lblNewLabel_1.setText("");
				}
			}
		});
		textField_1.setBounds(190, 122, 184, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		Putong pu=new Putong();
		guanli g=new guanli();   //管理员窗口
		JComboBox comboBox = new JComboBox();
		JLabel label_3 = new JLabel("");
		
		JButton button = new JButton("\u767B\u5F55");
		
		button.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
			String type= (String)(comboBox.getSelectedItem()); //获取下拉框的内容
			
		String p1=textField_1.getText();
	
		String p2 = new String(passwordField.getPassword());
			if (type.equals("普通用户") ) {
				if (!p1.matches(re)) {
					pu.setVisible(false);   //设置窗口可见性
				}else {
					pu.setVisible(true);
					System.out.println("普通用户打开成功");}
				}
			
	
			if (type.equals("管理员")) {
				if (!p1.matches(re)) {
					g.setVisible(false);
				}else {
					g.setVisible(true);
					System.out.println("管理员打开成功");
				}
			}
					
			}
		});
		button.setBounds(101, 284, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setBounds(317, 284, 113, 27);
		contentPane.add(button_1);
		
		
		lblNewLabel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		lblNewLabel.setBounds(152, 146, 249, 18);
		contentPane.add(lblNewLabel);
		
		
		
		label_3.setBounds(152, 197, 356, 18);
		contentPane.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {//密码失去焦点
			public void focusLost(FocusEvent e) {
				String p3 = new String(passwordField.getPassword());
				if (!p3.matches(re)) {
					label_3.setText("密码输入错误!");
				}
				if (p3.matches(re)) {
					label_3.setText("");
				}
				
			}
		});
		passwordField.setBounds(190, 174, 184, 24);
		contentPane.add(passwordField);
		
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"普通用户", "管理员"}));
		comboBox.setBounds(190, 71, 184, 24);
		contentPane.add(comboBox);
		
		
	}
}
