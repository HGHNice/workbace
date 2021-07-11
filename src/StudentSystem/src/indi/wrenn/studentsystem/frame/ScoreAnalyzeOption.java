package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.bean.Student;
import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.util.Tools;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//ѡ���꼶��Ժϵ��רҵ���༶���гɼ�����
public class ScoreAnalyzeOption extends JDialog{
 	private JButton confirm_Button;	//"ȷ��"��ť��
    private JButton cancel_Button;	//"ȡ��"��ť��
    private JComboBox major_Box;	//"רҵ"ѡ�
    private JComboBox department_Box;	//"����Ժϵ"ѡ�
    private JLabel classe_Label;	//"�༶"��ǩ��
    private JLabel grade_Label;	//"�꼶��ǩ"��
    private JLabel major_Label;	//"רҵ"��ǩ��
    private JLabel department_Label;	//"����Ժϵ"��ǩ��
    private JTextField student_IDText;	//"ѧ��"�ı���
    private JTextField student_NameText;	//"����"�ı���
    private JComboBox classe_Box;	//"�༶"�ı���
    private JComboBox grade_Box;	//"�꼶"�ı���
    private JDialog jd;	//��ǰ���ڡ�
    private HashMap<String, String> departments;	//����Ժϵ����
    private HashMap<String, String> all_Major;	//����רҵ����
    private Vector<String> majors;	//רҵ���Ƽ���
    private ManageHelper helper;	//���ݿ�ҵ�������
    private Vector<String> classes;	//�༶����
/**
 * 
 * @param owner ���ĸ�����
 * @param title ������
 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
 */
public ScoreAnalyzeOption(JFrame owner, String title, boolean modal){
	super(owner, title, modal);
	helper = new ManageHelper();	//�������ݿ�ҵ�������
	departments = this.helper.getAllDepartment();	//�������Ժϵ
	all_Major = this.helper.getAllMajor();	//������е�רҵ
	this.jd = this;
	this.setSize(350,300);	//���ô����С��
	this.setLayout(null);	//���ÿղ��֡�
	
	grade_Label = new JLabel("�꼶:");	
	grade_Label.setBounds(78, 48, 30, 20);
	this.add(grade_Label);
	
	grade_Box = new JComboBox<String>(Tools.CreateGrade());	//��Ҫ��û���꼶ѡ��
	grade_Box.setBounds(116, 48, 150, 20);
	//ע��"�꼶ѡ��"�¼�����
	grade_Box.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			classe_Box.removeAllItems();//�Ƴ�"�༶ѡ��"������
			String option = major_Box.getSelectedItem().toString();
			String major_id = all_Major.get(option);	//רҵ���
			String grade = grade_Box.getSelectedItem().toString();
			if(!grade.equals("")){
				 classes = helper.getAllClasse(grade,major_id);	//��ð༶
				for(String s : classes){
					classe_Box.addItem(s);
				}
			}
		}
	});
	this.add(grade_Box);
	
		
	department_Label = new JLabel("Ժϵ:");
	department_Label.setBounds(78, 88, 30, 20);
	
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
	department_Box.setBounds(116, 88, 150, 20);
	this.add(department_Box);

	major_Label = new JLabel("רҵ:");
	major_Label.setBounds(78, 136, 30, 20);	
	this.add(major_Label);
	
	major_Box = new JComboBox(new String[]{""});//��ֹ��ָ���쳣
	//ע��"רҵ"ѡ���¼�����
	major_Box.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(major_Box.getSelectedItem()!=null){	//��ֹ��ָ�� 
				if(!major_Box.getSelectedItem().toString().equals("")){
					if(major_Box.getSelectedItem().toString().equals("") || grade_Box.getSelectedItem()==null || grade_Box.getSelectedItem().toString().equals("")){
						JOptionPane.showMessageDialog(jd, "�꼶����Ϊ��", "", JOptionPane.WARNING_MESSAGE);
						major_Box.setSelectedIndex(0);	//����Ϊ��ѡ��
						return ;
					}
					classe_Box.removeAllItems();//�Ƴ�"�༶ѡ��"������
					String option = major_Box.getSelectedItem().toString();
					String major_id = all_Major.get(option);	//רҵ���
					String grade = grade_Box.getSelectedItem().toString();
					if(!grade.equals("")){
						 classes = helper.getAllClasse(grade,major_id);	//��ð༶
						for(String s : classes){
							classe_Box.addItem(s);
						}
					}
				}
			}
		}
	});
	major_Box.setBounds(116, 136, 150, 20);
	this.add(major_Box);
	
	
	
	classe_Label = new JLabel("�༶:");	//��Ҫ��ð༶ѡ��
	classe_Label.setBounds(78, 184, 30, 20);	
	this.add(classe_Label);
	
	classe_Box = new JComboBox(new String[]{""});//��ֹ��ָ���쳣
	classe_Box.setBounds(116, 184, 150, 20);
	
	this.add(classe_Box);
	
	confirm_Button = new JButton("ȷ��");
	//ע��"ȷ��"��ť�¼�����
	confirm_Button.addActionListener(new ActionListener() {
				
		@Override 
		public void actionPerformed(ActionEvent e) {
			String classe = classe_Box.getSelectedItem().toString();
			String grade = grade_Box.getSelectedItem().toString();
			String major_ID = null;
			String major_Name = null;
			//����У�鲿��
			if(grade.equals("")){
				JOptionPane.showMessageDialog(jd, "�꼶����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			if(department_Box.getSelectedItem()==null){	//�ȼ������
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
				major_Name = major_Box.getSelectedItem().toString();//���רҵ����
				major_ID = all_Major.get(major_Name);	//���רҵ���
			}
			if(major_ID.equals("")){
				JOptionPane.showMessageDialog(jd, "רҵ����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			if(classe.equals("")){
				JOptionPane.showMessageDialog(jd, "�༶����Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
				return ;
			}
				jd.dispose();//�رյ�ǰ����
				ScoreAnalyzeFrame analyzeFrame = new ScoreAnalyzeFrame(jd, major_Name+"����"+classe+"��ĳɼ�����", false, major_ID,major_Name, grade,classe);
			
			}
		});
	confirm_Button.setBounds(70, 232, 60, 25);
	
	
	this.add(confirm_Button);
	
	cancel_Button = new JButton("ȡ��");
	cancel_Button.setBounds(230, 232, 60, 25);
	//ע��"ȡ��"��ť�¼�����
	cancel_Button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			jd.dispose();
			
		}
	});
	this.add(cancel_Button);
	
	WindowUtil.setFrameCenter(this);
	this.setResizable(false);
	this.setVisible(true);
}
}
