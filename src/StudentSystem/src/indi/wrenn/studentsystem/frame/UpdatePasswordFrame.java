package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.bean.User;
import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//�޸��������
public class UpdatePasswordFrame extends JDialog{

	private JLabel password_Label;	//ԭ�����ǩ��
	private JLabel newpassword_Label;	//�������ǩ��
	private JLabel repassword_Label;	//ȷ�������ǩ��
	private JPasswordField password_Text;	//ԭ�����ı���
	private JPasswordField newpassword_Text;	//�������ı���
	private JPasswordField repassword_Text;	//ȷ�������ı���
	private JButton confirm_Button;	//ȷ�ϰ�ť��
	private JButton cancel_Button;	//ȡ����ť��
	private JDialog jd;	//��ǰ���� ��
	private User user;
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public UpdatePasswordFrame(JFrame owner, String title, boolean modal,User user){
		super(owner, title, modal);
		this.user = user;
		this.jd = this;
		this.setLayout(null);//����Ϊ�ղ��֡�
		this.setSize(400,300);//���ô�С��
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);//���ñ�����ɫ��
		password_Label = new JLabel("ԭ����:");	//����"ԭ����"��ǩ��
		password_Label.setBounds(100, 60, 50, 20);	//����"ԭ����"��ǩλ�á�
		c.add(password_Label);	//���"����"��ǩ��
		
		password_Text = new JPasswordField();	//����"ԭ����"�ı���
		password_Text.setBounds(160, 60, 120, 20);	//����"ԭ����"�ı���λ�á�
		password_Text.grabFocus();//��ù�ꡣ
		c.add(password_Text);	//���"����"�ı���
		
		newpassword_Label = new JLabel("������:");	//����"������"��ǩ��
		newpassword_Label.setBounds(100, 110, 50, 20);
		c.add(newpassword_Label);	//���"������"��ǩ��
		
		newpassword_Text = new JPasswordField();	//����"������"�ı���
		newpassword_Text.setBounds(160, 110, 120, 20);	//����"������"�ı���λ�á�
		c.add(newpassword_Text);	//���"������"�ı���
		
		repassword_Label = new JLabel("ȷ������");	//����"ȷ������"��ǩ��
		repassword_Label.setBounds(100, 162, 70, 20);	//����"ȷ������"��ǩλ�á�
		c.add(repassword_Label);	//���"ȷ������"��ǩ��
		
		repassword_Text = new JPasswordField();	//����"ȷ������"�ı���
		repassword_Text.setBounds(160, 162, 120, 20);	//����"ȷ������"�ı���λ�á�
		c.add(repassword_Text); //���"ȷ������"�ı���
		
		confirm_Button = new JButton("ȷ��");	//����"ȷ��"��ť��
		confirm_Button.setBounds(90, 210, 60, 20);	//����"ȷ��"��ťλ�á�
		//ע��"ȷ��"��ť�¼�������
		confirm_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = new String(password_Text.getPassword());
				String repassword = new String(repassword_Text.getPassword());
				String newpassword = new String(newpassword_Text.getPassword());
				if(password.equals("")){
					JOptionPane.showMessageDialog(jd, "ԭ���벻��Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(newpassword.equals("")){
					JOptionPane.showMessageDialog(jd, "�����벻��Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(repassword.equals("")){
					JOptionPane.showMessageDialog(jd, "ȷ�����벻��Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(repassword.equals(newpassword)){
					//���ԭ�����Ƿ���ȷ
					ManageHelper helper = new ManageHelper();
					user.setPassword(password);
					if(helper.Login(user)){//���ԭ�����Ƿ���ȷ
						helper.update_Password(user, newpassword);	//�޸�����
						JOptionPane.showMessageDialog(jd, "�޸�����ɹ���");
						jd.dispose();//�رյ�ǰ����
						return ;
					}else{
						JOptionPane.showMessageDialog(jd,"ԭ���벻��ȷ��","",JOptionPane.WARNING_MESSAGE);
						Reset();	//����
						return ;
					}
				}else{
					JOptionPane.showMessageDialog(jd,"�������벻һ��","",JOptionPane.WARNING_MESSAGE);
					Reset();	//����
					return ;
				}
				
			}
		});
		c.add(confirm_Button);	//���"ȷ��"��ť��
		
		
		cancel_Button = new JButton("ȡ��");	//����"ȡ��"��ť��
		cancel_Button.setBounds(250, 210, 60, 20);	//����"ȡ��"��ťλ�á�
		//ע��"ȡ��"��ť�¼�������
		cancel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose();//�رյ�ǰҳ�档
			
			}
		});
		c.add(cancel_Button);	//���"ȡ��"��ť��
		

		this.setResizable(false);	//���ô�С���ɸı䡣
		WindowUtil.setFrameCenter(this);//���ô��ھ��С�
		this.setVisible(true);	//���ô���ɼ���
	}
	
	//����
	public void Reset(){
		password_Text.setText("");
		repassword_Text.setText("");
		newpassword_Text.setText("");
	}
}
