//package N;
//
//import javax.swing.*;
//import javax.swing.tree.DefaultMutableTreeNode;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//
//
//
//
//public class GreateTree {
//
//    public static JTree getTree() {
//        DefaultMutableTreeNode root=new DefaultMutableTreeNode("商品分类");
//        JTree tree =new JTree(root);
//
//        List<Good> list2=new ArrayList<Good>();
//        list2=ObjectDataStream.fanxuliehua();
//
//        java.util.Set<String> typeList=new HashSet<String>();
//        for(int i=0;i<list2.size();i++) {
//            typeList.add(list2.get(i).getClassGood());
//
//        }
//        for(String item:typeList) {
//            DefaultMutableTreeNode node=new DefaultMutableTreeNode(item);
//            for(int i=0;i<list2.size();i++) {
//                Good good=list2.get(i);
//                if(good.getClassGood().equals(item) ){
//                    DefaultMutableTreeNode node1=new DefaultMutableTreeNode(good.getName());
//                    node.add(node1);
//                    list2.remove(i);
//                    i=i-1;
//                }
//            }
//            root.add(node);
//        }
//        return tree;
//    }
//}
//
