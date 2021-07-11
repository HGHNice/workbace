package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cun extends JFrame implements ActionListener {

    JButton btnNewButton_7,btnNewButton_6;
    static Cun frame7=new Cun();
    private JPanel contentPane;
    private JTextField cuntext;
    Account account=new Account();

            public void run() {
                try {
                   frame7.init();
                   frame7.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

   void init() {
        setTitle("\u6B22\u8FCE\u4F7F\u7528ATM\u673A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 803, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("1");
        btnNewButton.setBounds(79, 122, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("2");
        btnNewButton_1.setBounds(79, 172, 93, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("3");
        btnNewButton_2.setBounds(79, 222, 93, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("4");
        btnNewButton_3.setBounds(79, 273, 93, 23);
        contentPane.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainInterface1 mainInterface1=new MainInterface1();
                mainInterface1.run();
                frame7.dispose();
            }
        });

        JButton btnNewButton_4 = new JButton("5");
        btnNewButton_4.setBounds(621, 122, 93, 23);
        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("6");
        btnNewButton_5.setBounds(621, 172, 93, 23);
        contentPane.add(btnNewButton_5);

         btnNewButton_6 = new JButton("7");
        btnNewButton_6.setBounds(621, 222, 93, 23);
        contentPane.add(btnNewButton_6);

        btnNewButton_7 = new JButton("8"); //存钱按钮
        btnNewButton_7.setBounds(621, 273, 93, 23);
        contentPane.add(btnNewButton_7);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u5B58\u6B3E\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panel.setBounds(197, 115, 396, 192);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u300A\u8FD4\u56DE");
        lblNewLabel.setBounds(10, 167, 54, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u786E\u8BA4\u300B");
        lblNewLabel_1.setBounds(332, 167, 54, 15);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u66F4\u6B63\u300B");
        lblNewLabel_2.setBounds(332, 119, 54, 15);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("\u8BF7\u5C06\u6574\u7406\u597D\u7684\u7EB8\u5E01\u653E\u5165\u5B58\u6B3E\u53E3\uFF08\u9762\u989D\u5FC5\u987B100\uFF09\uFF01");
        lblNewLabel_3.setBounds(87, 27, 258, 15);
        panel.add(lblNewLabel_3);

        cuntext = new JTextField();
        cuntext.setBounds(148, 52, 172, 21);
        panel.add(cuntext);
        cuntext.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("\u91D1\u989D\uFF1A");
        lblNewLabel_4.setBounds(97, 55, 54, 15);
        panel.add(lblNewLabel_4);

        frame7.setLocationRelativeTo(null);
        cuntext.addActionListener(this);
        btnNewButton_6.addActionListener(this);//更正
       btnNewButton_7.addActionListener(this);//确认

    }


    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==btnNewButton_6){
        cuntext.setText("");
    }
    if (e.getSource()==btnNewButton_7){
        String money=cuntext.getText();
        String op=account.deposit(account.cardID,money);
        JOptionPane.showMessageDialog(this,op,"消息提示框",JOptionPane.WARNING_MESSAGE);
    }
    }
}
