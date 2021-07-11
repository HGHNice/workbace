package N;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DianShang extends JFrame  implements ActionListener{

    JButton btnNewButton, btnNewButton_1 ;
    JComboBox comboBox;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    public static String id;
    static DianShang frame1=new DianShang();

    public void init() {
        setTitle("xxx\u7535\u5546\u5E73\u53F0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 654, 424);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u8D26\u53F7\u7C7B\u578B\uFF1A");
        lblNewLabel.setBounds(172, 97, 66, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
        lblNewLabel_1.setBounds(196, 148, 53, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel_2.setBounds(196, 206, 53, 15);
        contentPane.add(lblNewLabel_2);

        btnNewButton = new JButton("\u767B\u5F55");//登录？//
        btnNewButton.setBounds(159, 267, 93, 23);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("\u53D6\u6D88");
        btnNewButton_1.setBounds(421, 267, 93, 23);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
            }
        });

        textField = new JTextField();
        textField.setBounds(321, 145, 178, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(321, 203, 178, 21);
        contentPane.add(passwordField);

        comboBox= new JComboBox();
        comboBox.setBounds(321, 93, 178, 23);
        contentPane.add(comboBox);
        comboBox.addItem("普通用户");
        comboBox.addItem("管理员");

        btnNewButton.addActionListener(this);
    }


            public void run() {
                try {
                    frame1.init();
                    frame1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


    @Override
    public void actionPerformed(ActionEvent e) {
        id=String.valueOf(textField.getText());
        String password =new String (passwordField.getPassword());
        String user=comboBox.getSelectedItem().toString();
        if(e.getSource()== btnNewButton) {
            Pattern p1 = Pattern.compile("[\\d]");       //对名字进行判断是否符合规则
            Pattern p2 = Pattern.compile("[\\p{Alpha}]+");
            Pattern p3 = Pattern.compile("[_]+");
            Matcher m1 = p1.matcher(textField.getText());
            Matcher m2 = p2.matcher(textField.getText());
            Matcher m3 = p3.matcher(textField.getText());
            if (user.equals("普通用户")){
                UsersData.usermoth();
                boolean ok=UsersData.ordinaryUser(id,password);
                if (ok){
                    personnal son2=new personnal();
                    son2.run();
                    this.dispose();
                }
            }
            if (user.equals("管理员")){
                UsersData.usermoth();
                boolean ok=UsersData.ordinaryUser(id,password);
                if (ok){
                    treeandB t=new treeandB();
                    t.run();
                    this.dispose();
                }
            }
            else if (passwordField.equals("")){
                JOptionPane.showMessageDialog(passwordField, "账号必须由数字字母下划线组成，输入的密码不能为空","提示",JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }


}
