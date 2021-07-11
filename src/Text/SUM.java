package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
public class SUM extends JFrame implements ActionListener {
    JTextField textField1,textField2,textField3;
    JLabel label,label1;
    public SUM(){
        init();
    }
    void init(){
        setBounds(100,100,400,100);
        setTitle("计算");
    textField1 =new JTextField(10);
    textField2=new JTextField(10);
    textField3=new JTextField(10);
    label=new JLabel("+");
    label1=new JLabel("=");
    setLayout(new FlowLayout());  //布局
    add(textField1);
    add(label);
    add(textField2);
    add(label1);
    add(textField3);
    textField3.addActionListener(this);


    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if(textField3.getText().equals("")){
            JOptionPane.showMessageDialog(this,"请重新输入", "消息对话框",
                    JOptionPane.WARNING_MESSAGE);
        }
        double a=Double.parseDouble(textField1.getText());
        double b=Double.parseDouble(textField2.getText());
        textField3.setText(String.valueOf(a+b));

    }
    public static void main(String args[]) {
        SUM sum=new SUM();
    }



}
