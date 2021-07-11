package K;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Show implements TreeSelectionListener {

	public Show() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub

		DefaultMutableTreeNode node=(DefaultMutableTreeNode)guanli.tree.getLastSelectedPathComponent();
		if (node.isLeaf()) {
			try {
				Good good=(Good) node.getUserObject();
				guanli.good=good;
				guanli.textArea.setText("");
				guanli.textArea.append("名称:"+good.name+"\n");
				guanli.textArea.append("价格:"+good.price+"\n");
				guanli.textArea.append("分类:"+good.type+"\n");
				if (!good.introduce.equals("")) {
					guanli.textArea.append("商品详情:"+good.introduce);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
