package Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class Teacher extends JFrame implements ActionListener,ItemListener {
    JTextField textField,textField1;
    JComboBox admin;
    JButton button;
    String as;
    public Teacher(){
        init();

    }
    void init(){
        JFrame jf = new JFrame("用户登录");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        textField=new JTextField(10);
        admin=new JComboBox();
        admin.addItem("请选择用户");
        String []a={"学生用户","教师用户"};
        for (String s : a) {
            admin.addItem(s);
        }
        admin.addItemListener(this);
        panel.add(new JLabel("用户类型"));
        panel.add(admin);
        JPanel panel01 = new JPanel();
        panel01.add(new JLabel("用户名"));
        panel01.add(textField);
        JPanel panel02 = new JPanel();
        panel02.add(new JLabel("密 码"));
        textField1=new JTextField(10);
        panel02.add(textField1);
        JPanel panel03 = new JPanel(new FlowLayout(FlowLayout.CENTER));//**
        button=new JButton("确定");
        button.addActionListener(this);
        panel03.add(button);
        panel03.add(new JButton("取消"));
        panel03.add(new JButton("退出"));
        Box vBox = Box.createVerticalBox();
        vBox.add(panel);
        vBox.add(panel01);
        vBox.add(panel02);
        vBox.add(panel03);
        jf.setContentPane(vBox);
        jf.setBounds(100,100,400,200);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
       Teacher teacher=new Teacher();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if (textField.getText().equals("")){
        JOptionPane.showMessageDialog(this,"用户名不能为空","对话框",JOptionPane.WARNING_MESSAGE);
    }
    else if (textField1.getText().equals("")){
        JOptionPane.showMessageDialog(this,"密码不能为空","对话框",JOptionPane.WARNING_MESSAGE);
    }
    else if (as.equals("学生用户")){
        if (textField.getText().equals("s")&&textField1.getText().equals("s")){
            JOptionPane.showMessageDialog(this,"学生用户登录成功","对话框",JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this,"用户名不存在或者密码不正确！","对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
    else if (as.equals("教师用户")){
            if (textField.getText().equals("t")&&textField1.getText().equals("t")){
                JOptionPane.showMessageDialog(this,"教师用户登录成功","对话框",JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this,"用户名不存在或者密码不正确！","对话框",JOptionPane.WARNING_MESSAGE);
            }
      }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        as= Objects.requireNonNull(admin.getSelectedItem()).toString();
    }
}
