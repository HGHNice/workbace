package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.bean.User;
import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//ע�����

public class StudentSystemRegisterFrame extends JFrame {

	private JLabel username_Label;	//�û�����ǩ��
	private JLabel password_Label;	//�����ǩ��
	private JLabel repassword_Label;	//ȷ�������ǩ��
	private JTextField username_Text;	//�û����ı���
	private JPasswordField password_Text;	//�����ı���
	private JPasswordField repassword_Text;	//ȷ�������ı���
	private JButton register_Button;	//ע�ᰴť��
	private JButton cancel_Button;	//ȡ����ť��
	private JFrame jf;	//��ǰ���� ��
	
	public StudentSystemRegisterFrame(){
		super("ѧ���ɼ�����ϵͳע�����");
		this.jf = this;
		this.setLayout(null);//����Ϊ�ղ��֡�
		this.setSize(400,300);//���ô�С��
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);//���ñ�����ɫ��
		username_Label = new JLabel("�û���:");	//����"�û���"��ǩ��
		username_Label.setBounds(100, 60, 50, 20);	//����"�û���"��ǩλ�á�
		c.add(username_Label);	//���"�û���"��ǩ��
		
		username_Text = new JTextField();	//����"�û���"�ı���
		username_Text.setBounds(160, 60, 120, 20);	//����"�û���"�ı���λ�á�
		username_Text.grabFocus();//��ù�ꡣ
		c.add(username_Text);	//���"�û���"�ı���
		
		password_Label = new JLabel("����:");	//����"����"��ǩ��
		password_Label.setBounds(100, 110, 50, 20);
		c.add(password_Label);	//���"����"��ǩ��
		
		password_Text = new JPasswordField();	//����"����"�ı���
		password_Text.setBounds(160, 110, 120, 20);	//����"����"�ı���λ�á�
		c.add(password_Text);	//���"����"�ı���
		
		repassword_Label = new JLabel("ȷ������");	//����"ȷ������"��ǩ��
		repassword_Label.setBounds(100, 162, 70, 20);	//����"ȷ������"��ǩλ�á�
		c.add(repassword_Label);	//���"ȷ������"��ǩ��
		
		repassword_Text = new JPasswordField();	//����"ȷ������"�ı���
		repassword_Text.setBounds(160, 162, 120, 20);	//����"ȷ������"�ı���λ�á�
		c.add(repassword_Text); //���"ȷ������"�ı���
		
		register_Button = new JButton("ע��");	//����"ע��"��ť��
		register_Button.setBounds(90, 210, 60, 20);	//����"ע��"��ťλ�á�
		//ע��"ע��"��ť�¼�������
		register_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = username_Text.getText().trim();//����û�����
				String password = new String(password_Text.getPassword());	//������롣
				String repassword = new String(repassword_Text.getPassword());	//���ȷ�����롣
				if(username.equals("")){
					JOptionPane.showMessageDialog(jf, "�û�������Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "���벻��Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(repassword.equals("")){
					JOptionPane.showMessageDialog(jf, "ȷ�����벻��Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(!password.equals(repassword)){
					JOptionPane.showMessageDialog(jf, "�������벻һ�£�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				//ע��ҵ����
				User user = new User();//�����û�����
				user.setUsername(username);
				user.setPassword(password);
				ManageHelper helper = new ManageHelper();//�������ݿ�ҵ�������
				if(helper.Register(user)){//ע�ᴦ��
					JOptionPane.showMessageDialog(jf, "ע��ɹ���");
					jf.dispose();//�رյ�ǰ����
					StudentSystemLoginFrame frame = new StudentSystemLoginFrame();//���ص�½ҳ�档
					return ;
				}else{
					JOptionPane.showMessageDialog(jf, "ע��ʧ�ܣ�");
					Reset();	//����
					return ; 
				}
				
			}
		});
		c.add(register_Button);	//���"ע��"��ť��
		
		
		cancel_Button = new JButton("ȡ��");	//����"ȡ��"��ť��
		cancel_Button.setBounds(250, 210, 60, 20);	//����"ȡ��"��ťλ�á�
		//ע��"ȡ��"��ť�¼�������
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();//�رյ�ǰҳ�档
				StudentSystemLoginFrame studentSystemLoginFrame = new StudentSystemLoginFrame();//�򿪵�½ҳ�档
			}
		});
		c.add(cancel_Button);	//���"ȡ��"��ť��
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	//���ô�С���ɸı䡣
		WindowUtil.setFrameCenter(this);//���ô��ھ��С�
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setVisible(true);	//���ô���ɼ���
	}
	
	//����
	public void Reset(){
		username_Text.setText("");
		password_Text.setText("");
		repassword_Text.setText("");
	}
}
