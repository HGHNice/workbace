package StudentSystem.src.indi.wrenn.studentsystem.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.model.ScoreModel;
import StudentSystem.src.indi.wrenn.studentsystem.model.StudentModel;
import StudentSystem.src.indi.wrenn.studentsystem.util.CreateSql;
import StudentSystem.src.indi.wrenn.studentsystem.util.Tools;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class QueryStudentScoreFrame extends JDialog{
    private JComboBox major_Box;	//"רҵ"ѡ�
    private JComboBox department_Box;	//"����Ժϵ"ѡ�
    private JLabel classe_Label;	//"�༶"��ǩ��
    private JLabel grade_Label;	//"�꼶��ǩ"��
    private JLabel major_Label;	//"רҵ"��ǩ��
    private JLabel department_Label;	//"����Ժϵ"��ǩ��
    private JComboBox classe_Box;	//"�༶"�ı���
    private JComboBox grade_Box;	//"�꼶"�ı���
	private JButton query_Button;	//"��ѯ"��ť��
	private JButton conditions_button;	//��������ѯ��ť 
	private JComboBox query_List;	//"��ѯ"ѡ�
	private JLabel query_Label;	//��ǩ��
	private JTextField query_Text;	//"��ѯ"�ı���
	private JButton details_Button;	//"��ϸ��Ϣ"��ť
	private JTable jt;	//���
	private JScrollPane jsp;	//��������
    private JDialog jd;	//��ǰ���ڡ�
    private HashMap<String, String> departments;	//����Ժϵ����
    private HashMap<String, String> all_Major;	//����רҵ����
    private Vector<String> majors;	//רҵ���Ƽ���
    private ManageHelper helper;	//���ݿ�ҵ�������
    private ScoreModel scoreModel;
    private static Vector<String> query_Option;
	
	static {
		query_Option = new Vector<String>();
		query_Option.add("ȫ��");
		query_Option.add("ѧ��");
		query_Option.add("����");
		query_Option.add("�Ա�");
		query_Option.add("�༶");
	}
    
    /**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public QueryStudentScoreFrame(JFrame owner, String title, boolean modal){
		super(owner, title, modal);
		this.setLayout(null);
		
		this.jd = this;
		helper = new ManageHelper();	//�������ݿ�ҵ�������
		departments = this.helper.getAllDepartment();	//�������Ժϵ
		all_Major = this.helper.getAllMajor();	//������е�רҵ
		
		grade_Label = new JLabel("�꼶:");
		grade_Label.setBounds(25, 19, 30, 20);
		this.add(grade_Label);
		
		grade_Box = new JComboBox(Tools.CreateGrade());
		grade_Box.setBounds(60, 19, 60, 20);
		this.add(grade_Box);
		
		department_Label = new JLabel("Ժϵ:");
		department_Label.setBounds(130, 19, 30, 20);
		this.add(department_Label);
		
		
		department_Box = new JComboBox(departments.keySet().toArray());//��ü��ļ���
		//ע��"Ժϵ"ѡ���¼�����
		department_Box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				major_Box.removeAllItems();//�Ƴ�"רҵѡ��"������
				String option = department_Box.getSelectedItem().toString();//���ѡ������
				String department_ID = departments.get(option);	//���Ժϵ���
				if(!department_ID.equals("")){
					majors = helper.getMajor(department_ID);	//���רҵ
					for(String s : majors){
						major_Box.addItem(s);
					}
				}
				
			}
		});
		department_Box.setBounds(165, 19, 150, 20);
		this.add(department_Box);
		
		major_Label = new JLabel("רҵ:");
		major_Label.setBounds(325, 19, 30, 20);
		this.add(major_Label);
		
		major_Box = new JComboBox(new String[]{""});//��ֹ��ָ���쳣
		major_Box.setBounds(360, 19, 150, 20);
		this.add(major_Box);
		
		query_Label = new JLabel("��ѯ��Ϣ:");
		query_Label.setBounds(520, 19, 60, 20);
		this.add(query_Label);
		
		
		query_Text = new JTextField();
		query_Text.setBounds(585, 19, 100, 20);
		this.add(query_Text);
		
		query_List = new JComboBox(query_Option);
		query_List.setBounds(695, 19, 65, 20);
		this.add(query_List);
		
	
		
		
		query_Button = new JButton("��ѯ");
		query_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				String grade = grade_Box.getSelectedItem().toString();
				String major =	null;
				String str = query_Text.getText().trim();
				String option = query_List.getSelectedItem().toString();
				if(grade.equals("")){
					JOptionPane.showMessageDialog(jd, "�꼶����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}if(department_Box.getSelectedItem()==null){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "Ժϵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(department_Box.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(jd, "Ժϵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(major_Box.getSelectedItem()==null){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					major = major_Box.getSelectedItem().toString();//���רҵ����
				}
				if(major.equals("")){
					JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				//������ѯ��sql���
				String sql = CreateSql.getStudent_Sql(grade, major, str, option);
				scoreModel = new ScoreModel(sql, major, grade, jd);
				jt.setModel(scoreModel);
			}
		});
		query_Button.setBounds(770, 19, 65, 20);
		this.add(query_Button);
		
		conditions_button = new JButton("��������ѯ");
		conditions_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String grade = grade_Box.getSelectedItem().toString();
				String major =	null;
				if(grade.equals("")){
					JOptionPane.showMessageDialog(jd, "�꼶����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}if(department_Box.getSelectedItem()==null){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "Ժϵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(department_Box.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(jd, "Ժϵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(major_Box.getSelectedItem()==null){	//�ȼ������
					JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					major = major_Box.getSelectedItem().toString();//���רҵ����
				}
				if(major.equals("")){
					JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				ScoreConditionsQueryFrame frame = new ScoreConditionsQueryFrame(jd, "��������ѯ", true, jt, department_Box.getSelectedItem().toString(), major,grade);
			}
		});
		
		conditions_button.setBounds(845, 19, 100, 20);
		this.add(conditions_button);
		
		jt = new JTable();
		jsp = new JScrollPane(jt);
		jsp.setBounds(26, 45, 925, 480);
		this.add(jsp);
		
		details_Button = new JButton("��ϸ�ɼ�");
		//ע��"��ϸ��Ϣ"��ť�¼�����
		details_Button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rowNum = jt.getSelectedRow();
				if(rowNum==-1){
					JOptionPane.showMessageDialog(jd, "��ѡ��һ�У�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}				
				QueryScoreFrame frame = new QueryScoreFrame(jd, "ѧ���ɼ�", true, scoreModel, rowNum);
			}
		});
		
		details_Button.setBounds(450, 530, 100, 20);
		this.add(details_Button);
		
		this.setSize(1000,600);
		WindowUtil.setFrameCenter(this);
		this.setVisible(true);
	}
}
