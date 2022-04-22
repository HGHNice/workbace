package ShopText;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class guanli extends JFrame {

	static JTree tree;
	static JTextArea textArea;
	static Good good;
	private JPanel contentPane;
	static guanli h=new guanli();

	public guanli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 519);
		setTitle("商品管理");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_2 = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		flowLayout.setVgap(40);
		contentPane.add(panel, BorderLayout.SOUTH);
		setLocationRelativeTo(null); //居中显示
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u7F16\u8F91");   //编辑
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (good==null) {
					JOptionPane.showMessageDialog(null, "未选中节点","对象未选中",JOptionPane.WARNING_MESSAGE);
				}
				else {
					Bianji b=new Bianji();
					b.setScrollPane(scrollPane);
					b.setGood(good);
					b.setVisible(true);
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Good> list=new ArrayList<Good>();
				list=ObjectStream.fanxuliehua();
				if (good==null) {
					JOptionPane.showMessageDialog(null, "未选中节点","对象未选中",JOptionPane.WARNING_MESSAGE);
				}
				else {
					for (int i = 0; i < list.size(); i++) {
						Good good1=list.get(i);
						if (good.name.equals(good1.name)) {   //比较选择的节点和要删除的是否符合 符合则按顺序删除下去
							list.remove(i);
							
							break;
						}
					}
				}
				ObjectStream.xuliehua(list);
				tree=CreatTree.getTree();
				tree.addTreeSelectionListener(new Show());
				scrollPane.setViewportView(guanli.tree);
				textArea.setText("");
				guanli.good=null;
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		
		panel.add(btnNewButton_3);
		
		
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		panel_1.add(panel_2);
		
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(scrollPane);
		
	    tree =CreatTree.getTree();
		tree.addTreeSelectionListener(new Show());
		scrollPane.setViewportView(tree);
		
		
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		 textArea = new JTextArea();
		
		scrollPane_1.setViewportView(textArea);
		
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(h,"退出成功");
				System.exit(3);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tianjia tian=new tianjia();
			    tian.setScrollPane(scrollPane);
				tian.setVisible(true);
				
			}
		});
		

	}

}

