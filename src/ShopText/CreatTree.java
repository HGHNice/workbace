package ShopText;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreatTree {

	//给树添加节点
	public static void updateTree(JTree tree,DefaultMutableTreeNode node) {
	    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		model.insertNodeInto(node, root, root.getChildCount());
		tree.scrollPathToVisible(new javax.swing.tree.TreePath(node.getPath()));
    }
	
	
	public static JTree getTree() {
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("商品分类");
		JTree tree=new JTree(root);
		
		List<Good> list=new ArrayList<Good>();
		
		list=ObjectStream.fanxuliehua();
		
		//记录所有分类，不重复
		Set<String> typelist=new HashSet<String>();
		if (list !=null) {
			
		
		for (int i = 0; i < list.size(); i++) {
			typelist.add(list.get(i).type);
		}
		
			
		}
		for (String item : typelist) {
			DefaultMutableTreeNode node=new DefaultMutableTreeNode(item);
			for (int i = 0; i < list.size(); i++) {
				Good good=list.get(i);
				if (good.type.equals(item)) {
					//添加子节点
					DefaultMutableTreeNode node1=new DefaultMutableTreeNode(good);
					node.add(node1);
					list.remove(i);
					i=i-1;
				}
			}
			
			
			updateTree(tree, node);
			
		}
		
		return tree;
	}
}
