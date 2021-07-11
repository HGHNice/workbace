package StudentSystem.src.indi.wrenn.studentsystem.bean;
//���������
public class AnalyzeResult {
	private String studentId;	//ѧ��ѧ��
	private String studentName;	//ѧ������
	private String sumScore;	//ѧ���ܳɼ�
	private String avgScore;	//ѧ��ƽ���ɼ�
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSumScore() {
		return sumScore;
	}
	public void setSumScore(String sumScore) {
		this.sumScore = sumScore;
	}
	public String getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}
}
