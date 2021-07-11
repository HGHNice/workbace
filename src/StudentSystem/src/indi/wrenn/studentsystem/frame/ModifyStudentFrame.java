package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.model.StudentModel;
import StudentSystem.src.indi.wrenn.studentsystem.util.CreateSql;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//�޸�ѧ����Ϣ����
public class ModifyStudentFrame extends JDialog{
	private JPanel jp1,jp2,jp3;	//��塣
	private JLabel query_Label;	//��ǩ��
	private JButton query_Button;	//"��ѯ"��ť��
	private JComboBox query_List;	//"��ѯ"ѡ�
	private JButton preciseQuery_Button;	//"��ȷ��ѯ"��ť��
	private JButton modify_Button;	//"��ϸ��Ϣ"��ť��
	private JTextField query_Text;	//"��ѯ"�ı���
	private JTable jt;	//���
	private JScrollPane jsp;	//��������
	private JDialog jd;	//��ǰ���ڡ�
	private StudentModel studentModel;	//ѧ������ģ��
	private static Vector<String> query_Option;
	
	static {
		query_Option = new Vector<String>();
		query_Option.add("ȫ��");
		query_Option.add("ѧ��");
		query_Option.add("����");
		query_Option.add("�Ա�");
		query_Option.add("�༶");
		query_Option.add("�꼶");
		query_Option.add("רҵ");
		query_Option.add("Ժϵ");
	}
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public ModifyStudentFrame(JFrame owner, String title, boolean modal){
		super(owner, title, modal);
		this.jd = this;
		Container c = this.getContentPane();
		
		jp1 = new JPanel();
		query_Label = new JLabel("�������ѯ��Ϣ:");
		jp1.add(query_Label);
		
		query_Text = new JTextField(10);
		jp1.add(query_Text);
		
		query_List = new JComboBox<String>(query_Option);
		jp1.add(query_List);
		
		query_Button = new JButton("��ѯ");
		//ע��"��ѯ"��ť�¼�����
		query_Button.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String str = query_Text.getText().trim();	//��ѯ����
				String option = query_List.getSelectedItem().toString();	//��ѯѡ��
				String sql = CreateSql.getStudent_Sql(str, option);	//���sql���
				studentModel = new StudentModel(sql,jd);//�����µ�����ģ���࣬������
				jt.setModel(studentModel);//����Jtable
			}
		});
		jp1.add(query_Button);
		
		preciseQuery_Button = new JButton("��������ѯ");
		//ע��"��������ѯ"��ť�¼�����
				preciseQuery_Button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ConditionsQueryFrame frame = new ConditionsQueryFrame(jd, "��������ѯ", true, jt);
						
					}
				});
				
		jp1.add(preciseQuery_Button);
		c.add(jp1,BorderLayout.NORTH);	//������
	
		jp2 = new JPanel();
		jt = new JTable();
		String sql = CreateSql.getStudent_Sql(null, "ȫ��");//��ѯȫ������
		studentModel = new StudentModel(sql,jd);//�����µ�����ģ���࣬������
		jt.setModel(studentModel);
		
		
		jsp = new JScrollPane(jt);
		jp2.add(jsp);
		c.add(jp2,BorderLayout.CENTER);	//������
		
		jp3 = new JPanel();
		modify_Button = new JButton("�޸���Ϣ");
		//ע��"�޸���Ϣ"��ť�¼�����
		modify_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowNum = jt.getSelectedRow();
				if(rowNum==-1){
					JOptionPane.showMessageDialog(jd, "��ѡ��һ�У�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				ModifyFrame frame = new ModifyFrame(jd, "�޸�ѧ����Ϣ", true, rowNum, studentModel);
				//����
				//�����µ�����ģ���࣬������
				String sql = CreateSql.getStudent_Sql(null, "ȫ��");//��ѯȫ������
				studentModel = new StudentModel(sql,jd);//�����µ�����ģ���࣬������
				jt.setModel(studentModel);
			}
		});
		jp3.add(modify_Button);
		c.add(jp3,BorderLayout.SOUTH);
	
		this.setSize(600,540);
		this.setResizable(false);
		WindowUtil.setFrameCenter(this);//���ô�����С�
		this.setVisible(true);
	}
}
