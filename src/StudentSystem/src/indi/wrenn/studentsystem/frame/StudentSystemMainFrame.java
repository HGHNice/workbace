package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.bean.User;
import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
//������
public class StudentSystemMainFrame extends JFrame {
	private JMenuBar menuBar;	//Ӧ�ò˵�����
	private JMenu student_Management;	//"ѧ������"�˵���
	private JMenu score_Management;	//"�ɼ�����"�˵���
	private JMenu personal_Management;	//"���˹���"�˵���
	private JMenuItem add_Student;	//"���ѧ��"�˵��
	private JMenuItem query_Student;	//"��ѯѧ����Ϣ"�˵��
	private JMenuItem modify_Student;	//"�޸�ѧ����Ϣ"�˵��
	private JMenuItem delete_Student;	//"ɾ��ѧ��"�˵��
	private JMenuItem add_Score;	//"���ѧ���ɼ�"�˵��
	private JMenuItem modify_Score;	//"�޸�ѧ���ɼ�"�˵��
	private JMenuItem query_Score;	//"�ɼ���ѯ"�˵��
	private JMenuItem score_Statistics;	//"�ɼ�ͳ��"�˵��
	private JMenuItem change_Password;	//"�޸�����"�˵��
	private JMenuItem logout;	//"�˳���¼"�˵��
	private JFrame jf;	//��ǰ���ڡ�
	private User user;//��ǰ�û���
	public StudentSystemMainFrame(User user){
		super("ѧ���ɼ�����ϵͳ,��ӭ��"+user.getUsername());
		this.user = user;
		this.jf = this;
		menuBar = new JMenuBar();	//�����˵�����
		this.setJMenuBar(menuBar);	//��Ӳ˵�����
		
		student_Management = new JMenu("ѧ������");	//����"ѧ������"�˵���
		menuBar.add(student_Management);	//���"ѧ������"�˵���
		
		add_Student = new JMenuItem("���ѧ��");	//����"���ѧ��"�˵��
		//ע��"���ѧ��"�˵����¼�����
		add_Student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStudentFrame addStudentFrame = new AddStudentFrame(jf,"���ѧ��",true);
			}
		});
		student_Management.add(add_Student);	//���"���ѧ��"�˵��
		
		query_Student = new JMenuItem("��ѯѧ����Ϣ");	//����"��ѯѧ��"�˵��
		//ע��"��ѯѧ��"�˵����¼�������
		query_Student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QueryStudentFrame queryStudentFrame = new QueryStudentFrame(jf, "��ѯѧ����Ϣ", true);
				
			}
		});
		student_Management.add(query_Student);	//���"��ѯѧ����Ϣ"�˵��
		
		modify_Student = new JMenuItem("�޸�ѧ����Ϣ");	//����"�޸�ѧ����Ϣ"�˵��
		//ע��"�޸�ѧ����Ϣ"�˵����¼�����
		modify_Student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifyStudentFrame modifyStudentFrame = new ModifyStudentFrame(jf, "�޸�ѧ����Ϣ", true);
				
			}
		});
		student_Management.add(modify_Student);	//���"�޸�ѧ��"�˵��
		
		delete_Student = new JMenuItem("ɾ��ѧ��");	//����"ɾ��ѧ��"�˵��
		//ע��"ɾ��ѧ��"��ť�¼�����
		delete_Student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteStudentFrame deleteStudentFrame = new DeleteStudentFrame(jf, "ɾ��ѧ��", true);
				
			}
		});
		student_Management.add(delete_Student);	//���"ɾ��ѧ��"�˵���.
		
		score_Management = new JMenu("�ɼ�����");	//����"�ɼ�����"�˵���
		menuBar.add(score_Management);	//���"�ɼ�����"�˵���
		
		add_Score = new JMenuItem("���ѧ���ɼ�");	//����"���ѧ���ɼ�"�˵��
		//ע��"���ѧ���ɼ�"�˵����¼�����
		add_Score.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddStudentScoreFrame frame = new AddStudentScoreFrame(jf, "���ѧ���ɼ�", true);
				
			}
		});
		score_Management.add(add_Score);	//���"���ѧ���ɼ�"�˵��
		
		modify_Score = new JMenuItem("�޸�ѧ���ɼ�");	//����"�޸�ѧ���ɼ�"�˵��
		//ע��"�޸�ѧ���ɼ�"�˵����¼�����
		modify_Score.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateStudentScoreFrame frame = new UpdateStudentScoreFrame(jf, "�޸�ѧ���ɼ�", true);
				
			}
		});
		
		score_Management.add(modify_Score);	//���"�޸�ѧ���ɼ�"�˵��
		
		query_Score = new JMenuItem("�ɼ���ѯ");	//����"�ɼ���ѯ"�˵��
		//ע��"�ɼ���ѯ"�˵����¼�����
		query_Score.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				QueryStudentScoreFrame frame = new  QueryStudentScoreFrame(jf, "��ѯѧ���ɼ�", true);
			}
		});
		score_Management.add(query_Score);	//���"�ɼ���ѯ"�˵��
		
		score_Statistics = new JMenuItem("�ɼ�ͳ��");	//����"�ɼ�ͳ��"�˵��
		score_Statistics.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ScoreAnalyzeOption analyzeOption = new ScoreAnalyzeOption(jf, "�ɼ�����ѡ��", true);
			}
		});
		score_Management.add(score_Statistics);	//���"�ɼ�ͳ��"�˵��
		
		personal_Management = new JMenu("���˹���");	//����"���˹���"�˵���
		menuBar.add(personal_Management);	//���"���˹���"�˵���
		
		change_Password = new JMenuItem("�޸�����");	//����"�޸�����"�˵��
		//ע��"�޸�����"�˵����¼�����
		change_Password.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "�޸�����", true,user);
			}
		});
		personal_Management.add(change_Password);	//���"�޸�����"�˵��
		
		logout = new JMenuItem("�˳���¼");	//����"�˳���¼"�˵��
		//ע��"�˳���¼"�˵���ʱ�����
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				jf.dispose();	//�رյ�ǰ����
				//�޸ĵ�½״̬
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//���õ�½״̬Ϊδ��¼��
				helper.Update_IsLogin(user);
				StudentSystemLoginFrame frame = new StudentSystemLoginFrame();	//�򿪵�½����
				
			}
		});
		personal_Management.add(logout);	//���"�˳���¼"�˵��
		
		this.setSize(578, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		WindowUtil.setFrameCenter(this);//���ô�����С�
		ImagePanel imagePanel = new ImagePanel();
		setContentPane(imagePanel);
		
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	     
		this.setVisible(true);//���ô���ɼ���
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//�޸ĵ�½״̬
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//���õ�½״̬Ϊδ��¼��
				helper.Update_IsLogin(user);
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
}
