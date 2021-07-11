package StudentSystem.src.indi.wrenn.studentsystem.frame;

import StudentSystem.src.indi.wrenn.studentsystem.model.ScoreAnalyzeModel;
import StudentSystem.src.indi.wrenn.studentsystem.util.WindowUtil;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
//�ɼ���������
import javax.swing.JTable;
public class ScoresRankingFrame extends JDialog{

	private JTable jt;
	private JScrollPane jsp;
	
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public ScoresRankingFrame(JDialog owner, String title, boolean modal,ScoreAnalyzeModel model){
		super(owner, title, modal);
		jt = new JTable();
		jsp = new JScrollPane(jt);
		jt.setModel(model);
		jsp.setBounds(20, 20, 860, 460);
		this.add(jsp);
		
		this.setSize(1000,500);
		WindowUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}
}
