package ATM2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChangePassword implements ActionListener {
    public JPasswordField oldPassword, newPassword, checkPassword;
    public JFrame iframe;
    public JPanel ip0, ip1, ip2, ip3, ip4;
    public JButton confirm, cancel, exit;

    public ChangePassword() {
        iframe = new JFrame("更改密码");
        iframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ip2 = new JPanel();
        ip2.add(new JLabel("原密码:"));
        oldPassword = new JPasswordField(20);
        ip2.add(new JLabel("<html><br/><html>"));//换行
        ip2.add(oldPassword);

        ip0 = new JPanel();
        ip0.add(new JLabel("新密码:"));
        newPassword = new JPasswordField(20);
        ip0.add(new JLabel("<html><br/><html>"));//换行
        ip0.add(newPassword);

        ip4 = new JPanel();
        ip4.add(new JLabel("再次输入新密码:"));
        checkPassword = new JPasswordField(20);
        ip4.add(new JLabel("<html><br/><html>"));//换行
        ip4.add(checkPassword);

        ip3 = new JPanel();
        confirm = new JButton("确定");
        ip3.add(confirm);
        cancel = new JButton("返回");
        ip3.add(cancel);

        iframe.add(ip2);
        iframe.add(ip0);
        iframe.add(ip4);
        iframe.add(ip3);
        iframe.add(confirm);
        iframe.add(cancel);
        iframe.setLayout(new FlowLayout());
        iframe.setVisible(true);
        iframe.setTitle("密码更改");//窗体标签
        iframe.setSize(400, 200);//窗体大小
        iframe.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        confirm.addActionListener(this);

        cancel.addActionListener(this);

    }

    public void pw_clean() {
        newPassword.setText("");
        oldPassword.setText("");
        checkPassword.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
