package N;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Good extends JFrame {
   private JTable table;
    private DefaultTableModel model;//表格数据模型
    static Good frame=new Good();
    public static void main(String[] args) {
        Good good=new Good();
        good.init();
    }

    void init(){
        UsersData.usermoth();
        setBounds(300,300,500,500);

        JPanel panel_1 = new JPanel();
        frame.add(panel_1);
        panel_1.add(new JButton("5"));
        model=new DefaultTableModel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 110, 46, 50);
        panel_1.add(scrollPane);

        table = new JTable();
        String[] c = {"序号", "编号", "下单时间", "商品名称", "收货信息"};
        UsersData.usermoth();
        int num=UsersData.numDate(DianShang.id);

            String[][]row=UsersData.showData(num,DianShang.id);
            table=new JTable(row,c);

        scrollPane.setViewportView(table);
        table.setBounds(20, 122, 40, 90);
        panel_1.add(table);
        setVisible(true);

    }

}
