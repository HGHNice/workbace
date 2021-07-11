package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.dao.ManageHelper;
import StudentSystem.src.indi.wrenn.studentsystem.model.ScoreAnalyzeModel;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class ScoreAnalyzeFrame extends JDialog{
	private ManageHelper helper;
	private Vector<String> courses;
	private JLabel average_Scores;	//ƽ���ɼ���ǩ
	private JTextField average_ScoresText;	//ƽ���ɼ��ı���
	private JLabel total_Score;	//�ܳɼ���ǩ
	private JTextField total_ScoreText;	//�ܳɼ��ı���
	private JButton scores_Ranking;	//�ɼ�������ť
	private JDialog jd;

	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public ScoreAnalyzeFrame(JDialog owner, String title, boolean modal,String major_Id,String major_Name,String grade,String classe){
		super(owner, title, modal);
		this.jd = this;
		this.setLayout(null);
		helper = new ManageHelper();
		
		courses = helper.getCourse(major_Id,grade);//������пγ�
		
		average_Scores = new JLabel("�༶ƽ���ɼ�:");
		average_Scores.setBounds(200, 15, 90, 20);//�༶ƽ���ɼ��ı���
		this.add(average_Scores);
		
		average_ScoresText = new JTextField();
		average_ScoresText.setEditable(false);
		//���ð༶��ƽ���ɼ�
		average_ScoresText.setText(helper.getClasseAvg(classe, grade, major_Name));
		average_ScoresText.setBounds(295, 15, 60, 20);
		this.add(average_ScoresText);
		
		total_Score = new JLabel("�༶�ܳɼ�:");
		total_Score.setBounds(435, 15, 80, 20);
		this.add(total_Score);
		
		total_ScoreText = new JTextField();	//�༶�ܳɼ��ı���
		total_ScoreText.setEditable(false);
		//���ð༶�ܳɼ�
		total_ScoreText.setText(helper.getClasse_SumScore(classe, grade, major_Name));
		total_ScoreText.setBounds(520, 15, 60, 20);
		this.add(total_ScoreText);
		
	
		int vgap = 0;	//��ֱ���
		for(int i=0;i<courses.size();i++){
			JTextField course = new JTextField(courses.get(i)+":");	//��Ŀ��ǩ
			course.setEditable(false);
			course.setBounds(26, 48+vgap, 120, 20);	
			this.add(course);
			JLabel highestScore = new JLabel("��߳ɼ�:");	//��߳ɼ���ǩ
			highestScore.setBounds(156, 48+vgap, 60, 20);
			this.add(highestScore);
			
			JTextField highestScoreText = new JTextField();//��߳ɼ��ı���
			highestScoreText.setBounds(221, 48+vgap, 30, 20);
			//������߳ɼ�
			highestScoreText.setText(helper.getCourseHighestScore(courses.get(i), major_Name, classe, grade));
			highestScoreText.setEditable(false);
			this.add(highestScoreText);
			
			JLabel lowest_Score = new JLabel("��ͳɼ�:");	//��ͳɼ���ǩ
			lowest_Score.setBounds(261, 48+vgap, 60, 20);
			this.add(lowest_Score);
			
			JTextField lowest_ScoreText = new JTextField();//��ͳɼ��ı���
			lowest_ScoreText.setBounds(326, 48+vgap, 30, 20);
			//������ͳɼ�
			lowest_ScoreText.setText(helper.getCourseLowestScore(courses.get(i), major_Name, classe, grade));
			lowest_ScoreText.setEditable(false);
			this.add(lowest_ScoreText);
			
			
			JLabel avg_Score = new JLabel("ƽ���ɼ�:");	//ƽ���ɼ���ǩ
			avg_Score.setBounds(366, 48+vgap, 60, 20);
			this.add(avg_Score);
			
			JTextField avg_ScoreText = new JTextField();	//ƽ���ɼ��ı���
			avg_ScoreText.setBounds(431, 48+vgap, 30, 20);
			avg_ScoreText.setEditable(false);
			//����ƽ���ɼ�
			String score = helper.getCourseAvg(courses.get(i), major_Name, classe, grade);
			if(score!=null && !score.equals("")){
				avg_ScoreText.setText(score.charAt(0)+""+score.charAt(1)+""+score.charAt(2)+""+score.charAt(3));
			}
			this.add(avg_ScoreText);
			
			
			JLabel j1 = new JLabel("��:");	//��������ǩ
			j1.setBounds(476, 48+vgap, 20, 20);
			this.add(j1);
			
			JTextField t1 = new JTextField();//���ı���
			t1.setEditable(false);
			t1.setBounds(498, 48+vgap, 40, 20);
			//������������
			t1.setText(helper.getCount_ScoreType(grade, classe, major_Name, "��", courses.get(i)));
			this.add(t1);
			
			JLabel j2 = new JLabel("��:");	//��������ǩ
			j2.setBounds(548, 48+vgap, 20, 20);
			this.add(j2);
			
			JTextField t2 = new JTextField();//���ı���
			t2.setEditable(false);
			t2.setBounds(570, 48+vgap, 40, 20);
			//������������
			t2.setText(helper.getCount_ScoreType(grade, classe, major_Name, "��", courses.get(i)));
			this.add(t2);

			JLabel j3 = new JLabel("��:");	//��������ǩ
			j3.setBounds(620, 48+vgap, 20, 20);
			this.add(j3);
			
			JTextField t3 = new JTextField();//���ı���
			t3.setEditable(false);
			//����������
			t3.setText(helper.getCount_ScoreType(grade, classe, major_Name, "��", courses.get(i)));
			t3.setBounds(642, 48+vgap, 40, 20);
			this.add(t3);
			
			
			JLabel j4 = new JLabel("����:");	//����������ǩ
			j4.setBounds(692, 48+vgap, 30, 20);
			this.add(j4);
			
			JTextField t4 = new JTextField();//�����ı���
			t4.setEditable(false);
			//���㼰������
			t4.setText(helper.getCount_ScoreType(grade, classe, major_Name, "����", courses.get(i)));
			t4.setBounds(724, 48+vgap, 40, 20);
			this.add(t4);
			
			
			JLabel j5 = new JLabel("������:");	//������������ǩ
			j5.setBounds(774, 48+vgap, 50, 20);
			this.add(j5);
			
			JTextField t5 = new JTextField();//�������ı���
			t5.setEditable(false);
			t5.setBounds(825, 48+vgap, 40, 20);
			//���㲻��������
			t5.setText(helper.getCount_ScoreType(grade, classe, major_Name, "������", courses.get(i)));
			this.add(t5);
			
			vgap += 30;
		}
		scores_Ranking = new JButton("�ɼ�����");
		scores_Ranking.setBounds(420, 48+vgap+10, 100, 25);
		//ע��"�ɼ�����"��ť�¼�����
		scores_Ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ScoreAnalyzeModel model = new ScoreAnalyzeModel(major_Name, grade, classe);
				ScoresRankingFrame frame = new ScoresRankingFrame(jd, "�ɼ�����", true, model);
			}
		});
		this.add(scores_Ranking);
		
		
		this.setSize(900, 48+vgap+78);
		this.setResizable(false);
		WindowUtil.setFrameCenter(this);
		this.setVisible(true);
		
	}
}
