package N;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class personnal extends JFrame{
   static personnal frame = new personnal();
    JRadioButton man,woman;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table;
    private DefaultTableModel model;//表格数据模型

    /**
     * Launch the application.
     */

            public void run() {
                try {
                    frame.init();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


     void init(){
        UsersData.usermoth();                 //引入数据库的数据
        String[]information=UsersData.userInformation(DianShang.id);
        setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 654, 424);
        setLocationRelativeTo(null );
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);

        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane_1.setToolTipText("\u4E2A\u4EBA\u8D44\u6599");
        tabbedPane_1.setBounds(29, 28, 487, 307);
        getContentPane().add(tabbedPane_1);

        JPanel panel = new JPanel();
        panel.setToolTipText("");
        tabbedPane_1.addTab("个人资料", null, panel, null);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
        lblNewLabel.setBounds(38, 10, 67, 20);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(136, 10, 97, 21);
        panel.add(textField);
        textField.setText(information[0]);


        JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
        lblNewLabel_1.setBounds(38, 53, 54, 15);
        panel.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(136, 50, 97, 21);
        panel.add(textField_1);
        textField_1.setText(information[1]);


        JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
        lblNewLabel_2.setBounds(38, 95, 54, 15);
        panel.add(lblNewLabel_2);

         man = new JRadioButton("\u7537");
        man.setBounds(136, 91, 54, 23);
        panel.add(man);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(man);
        buttonGroup.add(woman);

         woman = new JRadioButton("\u5973");
        woman.setBounds(190, 91, 121, 23);
        panel.add(woman);
         String sex=information[2];
         if (sex.equals("男")) {
             woman.setSelected(true);
         } else {
             man.setSelected(true);
         }
         man.setEnabled(false);
         woman.setEnabled(false);


        JLabel lblNewLabel_3 = new JLabel("\u9ED8\u8BA4\u5730\u5740");
        lblNewLabel_3.setBounds(38, 136, 54, 15);
        panel.add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(136, 133, 239, 21);
        panel.add(textField_2);
         textField_2.setText(information[3]);
         textField.setEditable(false);
         textField_1.setEditable(false);
         textField_2.setEditable(false);


        JButton btnNewButton = new JButton("修改");
        btnNewButton.setBounds(40, 209, 93, 23);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //点击修改信息后，将不可编辑状态修改为可编辑状态
                textField.setEditable(true);
                textField_1.setEditable(true);
                textField_2.setEditable(true);
                man.setEnabled(true);
                woman.setEnabled(true);
            }
        });
         JButton btnNewButton1 = new JButton("保存");
         btnNewButton1.setBounds(150, 209, 93, 23);
         panel.add(btnNewButton1);
         btnNewButton1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String getName = String.valueOf(textField.getText());
                 String getCall = String.valueOf(textField_1.getText());
                 String getAddress = String.valueOf(textField_2.getText());
                 String sex = "男";
                 if (!man.isSelected()) {
                     sex = "女";
                 }
                 UsersData.usermoth();
                 UsersData.saveEditor(DianShang.id, getName, getCall, sex, getAddress);
                 JOptionPane.showMessageDialog(frame, "修改成功！", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
                 //保存数据成功后回到原来的不可编辑状态
                 man.setEnabled(false);
                 woman.setEnabled(false);
                 textField.setEditable(false);
                 textField_1.setEditable(false);
                 textField_2.setEditable(false);
             }
         });


        JPanel panel_1 = new JPanel();
        tabbedPane_1.addTab("我的订单", null, panel_1, null);
        panel_1.setLayout(null);
         model=new DefaultTableModel();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 110, 446, -98);
        panel_1.add(scrollPane);

        table = new JTable();
         String[] c = {"序号", "编号", "下单时间", "商品名称", "收货信息"};
         UsersData.usermoth();
         int num=UsersData.numDate(DianShang.id);
         if (num!=0){
             String[][]row=UsersData.showData(num,DianShang.id);
             table=new JTable(row,c);
         }else{
             model=new DefaultTableModel(c,4);
             table=new JTable(model);
         }
         scrollPane.setViewportView(table);
        table.setBounds(20, 122, 409, -90);
        panel_1.add(table);

    }
}

