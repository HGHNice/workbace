package N;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addGoods extends JFrame implements ActionListener {// 添加商品商品//

    private JPanel contentPane;
    private JTextField nameField1;
    private JTextField priceField;
    private JTextField partField;
    JButton btnNewButton, btnNewButton_1;
    JTextArea textArea;

    static addGoods frame = new addGoods();

            public void run() {
                try {
                    frame.init();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }

    /**
     * Create the frame.
     */
    public void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 417);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 564, 378);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
                "\u5546\u54C1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 10, 544, 358);
        panel_1.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0");
        lblNewLabel.setBounds(51, 31, 72, 22);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u4EF7\u683C");
        lblNewLabel_1.setBounds(52, 70, 71, 22);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u5206\u7C7B");
        lblNewLabel_2.setBounds(51, 115, 72, 22);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u8BE6\u60C5");
        lblNewLabel_3.setBounds(51, 160, 72, 22);
        panel.add(lblNewLabel_3);

        nameField1 = new JTextField();
        nameField1.setBounds(133, 32, 273, 21);
        panel.add(nameField1);
        nameField1.setColumns(10);

        priceField = new JTextField();
        priceField.setBounds(133, 71, 273, 21);
        panel.add(priceField);
        priceField.setColumns(10);

        partField = new JTextField();
        partField.setBounds(133, 116, 273, 21);
        panel.add(partField);
        partField.setColumns(10);

        textArea = new JTextArea();
        textArea.setBounds(133, 172, 273, 119);
        panel.add(textArea);

        btnNewButton = new JButton("\u4FDD\u5B58");// 保存//
        btnNewButton.setBounds(264, 325, 93, 23);
        panel.add(btnNewButton);

        btnNewButton_1 = new JButton("\u53D6\u6D88");// 取消//
        btnNewButton_1.setBounds(383, 325, 93, 23);
        panel.add(btnNewButton_1);

        btnNewButton.addActionListener(this);
        btnNewButton_1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自动生成的方法存根
        if (e.getSource() == btnNewButton) {
            String name = String.valueOf(nameField1.getText());
            String price = String.valueOf(priceField.getText());
            String part = String.valueOf(partField.getText());
            String details = String.valueOf(textArea.getText());
            if (name.equals("")){
                JOptionPane.showMessageDialog(this,"名字不能为空");
            }
            else{
                TreeData.usermoth();
                TreeData.addNewNode(name,price,part,details);  //将数据保存到表

                /*
                还没添加树的组件
                 */
            }
        }

        if (e.getSource() == btnNewButton_1) {
            treeandB son3 = new treeandB();
            son3.run();
            this.dispose();

        }

    }
}

