package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.bean.User;
import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//��½����
public class StudentSystemLoginFrame extends JFrame{
	
	private JLabel username_Label;	//�û�����ǩ��
	private JLabel password_Label;	//�����ǩ��
	private JTextField username_Text;	//�û����ı���
	private JPasswordField password_Text;	//�����ı���
	private JButton login_Button;	//��½��ť��
	private JButton register_Button;	//ע�ᰴť��
	private JFrame jf;	//��ǰ���� ��
	public StudentSystemLoginFrame(){
		super("ѧ���ɼ�����ϵͳ��¼����");
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
		password_Label.setBounds(100, 140, 50, 20);
		c.add(password_Label);	//���"����"��ǩ��
		
		password_Text = new JPasswordField();	//����"����"�ı���
		password_Text.setBounds(160, 140, 120, 20);	//����"����"�ı���λ�á�
		c.add(password_Text);	//���"����"�ı���
		 
		login_Button = new JButton("��¼");	//����"��¼"��ť��
		login_Button.setBounds(100, 210, 60, 20);	//����"��¼"��ťλ�á�
		//ע��"��¼"��ť�¼�������
		login_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = username_Text.getText().trim();
				String password = new String(password_Text.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(jf, "�û�������Ϊ��","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "���벻��Ϊ��","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				//��¼ҵ����
				User user = new User();//�����û�����
				user.setUsername(username);
				user.setPassword(password);
				ManageHelper helper = new ManageHelper();//�������ݿ�ҵ�������
				if(helper.Login(user)){	//��½ҵ����
					if(helper.Check_IsLogin(user)){
						JOptionPane.showMessageDialog(jf, "�ظ���½��","",JOptionPane.WARNING_MESSAGE);
						return ;
					}else{
						JOptionPane.showMessageDialog(jf, "��½�ɹ���");
						jf.dispose();//�رյ�ǰ���ڡ�
						//�޸ĵ�½���
						user.setIsLogin(1);//�޸ĳ�Ϊ�Ѿ���½��
						helper.Update_IsLogin(user);
						//��������
						user.setPassword("");//��������
						StudentSystemMainFrame frame = new StudentSystemMainFrame(user);
						return ;
					}
				}else{
					JOptionPane.showMessageDialog(jf, "�û������������");
					 Reset();	//����
					return ;
				}
				
			}
		});
		c.add(login_Button);	//���"��¼"��ť ��
		
		
		register_Button = new JButton("ע��");	//����"ע��"��ť��
		register_Button.setBounds(250, 210, 60, 20);	//����"ע��"��ťλ�á�
		//ע��"ע��"��ť�¼�������
		register_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();	//��ǰ���ڹرա�
				StudentSystemRegisterFrame studentSystemRegisterFrame = new StudentSystemRegisterFrame();	//��ע�����		
				
			}
		});
		c.add(register_Button);	//���"ע��"��ť��
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	//���ô�С���ɸı䡣
		WindowUtil.setFrameCenter(this);//���ô��ھ��С�
//		try {
////			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
////			this.setIconImage(img);
//
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		this.setVisible(true);	//���ô���ɼ���
	}
	
		//����
		public void Reset(){
			username_Text.setText("");
			password_Text.setText("");
		}
}
