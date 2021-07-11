package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.model.StudentModel;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//�޸ĳɼ�����
public class UpdateScoreFrame extends JDialog{
	private ManageHelper helper;
	private StudentModel sm;
	private Vector<String> courses;
	private JDialog jd;
	private JButton update_button;	//�޸İ�ť
	private JButton cancel_button;	//ȡ����ť
	private HashMap<String, JTextField> jtextFieldHashMap;//�����ı���ļ���
	private HashMap<String, String> scores;	//ѧ�����гɼ�
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public UpdateScoreFrame(JDialog owner, String title, boolean modal,StudentModel sm,int rowNum){
		super(owner, title, modal);
		this.jd = this;
		this.setLayout(null);
		helper = new ManageHelper();
		this.sm = sm;
		jtextFieldHashMap = new HashMap<String, JTextField>();
		courses = helper.getCourse(helper.getAllMajor().get(sm.getValueAt(rowNum, 6)),sm.getValueAt(rowNum, 3).toString());//������пγ�
		int vgap = 0;	//��ֱ���
		scores = helper.getStudentScore(sm.getValueAt(rowNum, 0).toString());//����ѧ�Ż�ø�ѧ�������п�Ŀ�ɼ�
		if(scores.isEmpty()){
			JOptionPane.showMessageDialog(jd, "��ͬѧ��û�гɼ���", "", JOptionPane.WARNING_MESSAGE);
			jd.dispose();
			return ;
		}
		for(int i=0;i<courses.size();i++){
			JLabel jLabel = new JLabel(courses.get(i)+":");
			jLabel.setBounds(78, 48+vgap, 120, 20);
			JTextField field = new JTextField();
			field.setText(scores.get(courses.get(i)));//���ı�����ӳɼ�
			field.setBounds(206, 48+vgap, 150, 20);
			jtextFieldHashMap.put(courses.get(i),field);	//���������ı���ļ���
			this.add(jLabel);
			this.add(field);
			vgap += 30;
		}
		
		update_button = new JButton("�޸�");
		update_button.setBounds(120, 48+vgap+5, 60, 20);
		//ע��"�޸�"��ť�¼�����
		update_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<courses.size();i++){
					JTextField field = jtextFieldHashMap.get(courses.get(i));
					String score = field.getText().trim();
					if(score.equals("")){
						JOptionPane.showMessageDialog(jd, "�ɼ�����Ϊ�գ�","",JOptionPane.WARNING_MESSAGE);
						return ;
					}
					if(Double.parseDouble(score)<0 || Double.parseDouble(score)>100){
						JOptionPane.showMessageDialog(jd, "������0~100֮��ĳɼ�", "", JOptionPane.WARNING_MESSAGE);
						return ;
					}
				}
				int i;
				for(i=0;i<courses.size();i++){
					JTextField field = jtextFieldHashMap.get(courses.get(i));
					String score = field.getText().trim();
					boolean b = helper.updateStudentScore(sm.getValueAt(rowNum, 0).toString(),courses.get(i),score);
					if(!b){
						break;
					}
				}
				if(i<courses.size()){
					JOptionPane.showMessageDialog(jd, "�޸�ʧ�ܣ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "�޸ĳɹ���","",JOptionPane.WARNING_MESSAGE);
					jd.dispose();
					return ;
				}
				
			}
		});
		this.add(update_button);
		cancel_button = new JButton("ȡ��");
		cancel_button.setBounds(280, 48+vgap+5, 60, 20);
		cancel_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose(); 
			}
		});
		this.add(cancel_button);
		this.setSize(450, 48+vgap+78);
		WindowUtil.setFrameCenter(this);
		this.setVisible(true);
		
	}
}
