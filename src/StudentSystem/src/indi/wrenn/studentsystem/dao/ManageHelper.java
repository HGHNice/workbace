package StudentSystem.src.indi.wrenn.studentsystem.dao;

import StudentSystem.src.indi.wrenn.studentsystem.bean.AnalyzeResult;
import StudentSystem.src.indi.wrenn.studentsystem.bean.Student;
import StudentSystem.src.indi.wrenn.studentsystem.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;


//���ݿ�ҵ������
public class ManageHelper {
	private JdbcHelper helper;	//�����ݿ�ͨ�ŵĶ���
	
	
	
	/**
	 * ��½ҵ����
	 * @param user	�û�����
	 * @return �����Ƿ�ɹ���½
	 */
	public boolean Login(User user){
		boolean b = true;
		helper = new JdbcHelper();	//���������ݿ�ͨ�ŵĶ���
		User newUser = helper.getUser(user);	//����û�����
		if(!user.getPassword().equals(newUser.getPassword())){	//�ȶ����������ݿ��еĶ�Ӧ�����Ƿ�һ��
			b = false;
		}
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ע��ҵ����
	 * @param user �û�����
	 * @return	�����Ƿ�ע��ɹ�
	 */
	public boolean Register(User user){
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		boolean b = helper.register(user);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ����Ƿ��ظ���½�ķ���
	 * @param user �û�����
	 * @return �Ƿ��ظ���½,��½���ķ���true,���򷵻�false
	 */
	public boolean Check_IsLogin(User user){
		boolean b = true;
		int isLogin;
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		User newUser = helper.getUser(user);
		if(newUser.getIsLogin()==0){
			b = false;
		}
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ���سɹ��޸ĵ�½���
	 * @param user �û�����
	 */
	public boolean  Update_IsLogin(User user){
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		boolean b = helper.update_IsLogin(user);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * �޸�����ҵ����
	 * @param user	�û�����
	 * @param new_Password	������
	 * @return �����Ƿ��޸ĳɹ�
	 */
	public boolean update_Password(User user,String new_Password){
		boolean b;
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		b = helper.update_Password(user, new_Password);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * �������Ժϵ
	 * @return	����ԺϵHashMap����
	 */	
	public HashMap<String, String>getAllDepartment(){
		helper = new JdbcHelper();
		HashMap<String, String> map;
		map = helper.getAllDepartment();
		helper.close();//�ر���Դ
		return map;
	}
	
	
	
	/**
	 * �������רҵ
	 * @return	��������רҵ����
	 */
	public HashMap<String, String>getAllMajor(){
		helper = new JdbcHelper();
		HashMap<String, String> map;
		map = helper.getAllMajor();
		helper.close();//�ر���Դ
		return map;
	}
	
	
	
	/**
	 * ����department_ID���ض�Ӧ��רҵ
	 * @param department_ID	Ժϵ���
	 * @return ���ض�Ӧ��רҵ����
	 */
	public Vector<String> getMajor(String department_ID){
		helper = new JdbcHelper();
		Vector<String> vector;
		vector = helper.getMajor(department_ID);
		helper.close();
		return vector;
	}
	
	
	
	/**
	 * ���ѧ��ҵ��
	 * @param student ѧ������
	 * @return �����Ƿ���ӳɹ�
	 */
	public boolean addStudent(Student student){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.addStudent(student);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	/**
	 * �޸�ѧ��ҵ��
	 * @param newStudent	��ѧ������
	 * @param oldStudentID	��ѧ����Ϣ
	 * @return	�����Ƿ���ӳɹ�
	 */
	public boolean updateStudent(Student newStudent,String oldStudentID){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.updateStudent(newStudent, oldStudentID);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	/**
	 * ɾ��ѧ��ҵ��
	 * @param studentID	ѧ��ѧ��
	 * @return	�����Ƿ�ɾ���ɹ�
	 */
	public boolean deleteStudent(String studentID){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.deleteStudent(studentID);
		helper.close();
		return b;
	}
	
	
	/**
	 * ����sql��䷵���ض���ѧ�����󼯺�
	 * @param sql	sql���
	 * @return	����ѧ������
	 */
	public Vector<Student> getStudent(String sql){
		Vector<Student> students;
		helper = new JdbcHelper();
		students = helper.getStudent(sql);
		helper.close();
		return students;
	}
	
	
	/**
	 * �����꼶��רҵ��ű�ŷ��ض�Ӧ�İ༶
	 * @param 
	 * @return
	 */
	public Vector<String> getAllClasse(String grade,String major_ID){
		Vector<String> vector;
		helper = new JdbcHelper();
		vector = helper.getAllClasse(grade,major_ID);
		helper.close();
		return vector;
		
	}
	
	
	
	
	/**
	 *  ����רҵ��ŷ��ض�Ӧ�����пγ�
	 * @param major_Id
	 * @return ���ؿγ̼���
	 */
	public Vector<String> getCourse(String major_Id,String grade){
		Vector<String> vector;
		helper = new JdbcHelper();
		vector = helper.getCourse(major_Id,grade);
		helper.close();
		return vector;
	}
	
	
	/**
	 * ���ѧ���ɼ�
	 */
	public boolean addStudentScore(Student student,Vector<String> courses){
		boolean b;
		helper = new JdbcHelper();
		b = helper.addStudentScore(student,courses);
		helper.close();
		return b;
	}
	
	
	
	/**
	 * �޸�ѧ���ɼ�
	 * @param student_Id	ѧ��ѧ��
	 * @param course_Name	�γ�����
	 * @param score �ɼ�
	 * @return	�����Ƿ��޸ĳɹ�
	 */
	public boolean updateStudentScore(String student_Id,String course_Name,String score){
		boolean b;
		helper = new JdbcHelper();
		b = helper.updateStudentScore(student_Id, course_Name, score);
		helper.close();
		return b;
	}
	
	/**
	 * ��ѯѧ���ɼ�
	 * @param student_Id	ѧ��ѧ��
	 * @param course_Name	�γ�����
	 * @return	���سɼ�����
	 */
	public HashMap<String, String> getStudentScore(String student_Id){
		HashMap<String, String> map;
		helper = new  JdbcHelper();
		map = helper.getStudentScore(student_Id);
		helper.close();
		return map;
		
	}
	
//	/**
//	 * ����ѧ�źͿγ�����ѯָ���ĳɼ�
//	 * @param student_Id ѧ��
//	 * @param course_Name	�γ���
//	 * @return	���سɼ�
//	 */
//	public String getStudentScore(String student_Id,String course_Name){
//		String score = null;
//		helper = new JdbcHelper();
//		score = helper.getStudentScore(student_Id, course_Name);
//		helper.close();
//		return score;
//	}
//	

	

	
	/**
	 * �����ض���sql��䷵��ѧ������
	 * @param sql
	 * @return
	 */
	public Vector<Student> getScores(String sql){
		Vector<Student> students;
		helper = new JdbcHelper();
		students = helper.getScores(sql);
		helper.close();
		return students;
	}
	
	
	
	/**
	 * ��ð༶�ܳɼ�
	 * @param classe	�༶
	 * @param grade		�꼶
	 * @param major		רҵ
	 * @return �ܳɼ�
	 */
	public String getClasse_SumScore(String classe,String grade,String major){
		String sum = null;
		helper = new JdbcHelper();
		sum = helper.getClasse_SumScore(classe, grade, major);
		helper.close();
		return sum;
	}
	
	
	/**
	 * ����ѧ��id���ظ�ѧ����ƽ���ɼ�
	 * @param student_Id
	 * @return
	 */
	public String getStudentAvgScore(String student_Id){
		String avg = null;
		helper = new JdbcHelper();
		avg = helper.getStudentAvgScore(student_Id);
		helper.close();
		return avg;
	}
	
	/**
	 * ����ѧ��רҵ���꼶���༶����Ŀ�����Գɼ�����(�ţ������У����񣬲�����)���ظ����͵�ѧ������
	 * @param grade
	 * @param classe
	 * @param major
	 * @param type
	 * @param course_Name
	 * @return
	 */
	public String getCount_ScoreType(String grade,String classe,String major,String type,String course_Name){
		String count = null;
		helper = new JdbcHelper();
		count = helper.getCount_ScoreType(grade, classe, major, type, course_Name);
		helper.close();
		return count;
	}
	
	/**
	 * ��ÿγ̵�ƽ����
	 * @param course �γ���
	 * @param major	רҵ
	 * @return	ƽ����
	 */
	public String getCourseAvg(String course,String major,String classe,String grade){
		String avg = null;
		helper = new JdbcHelper();
		avg = helper.getCourseAvg(course, major, classe, grade);
		helper.close();
		return avg;
	}
	
	/**
	 * ��õ��Ƴɼ�����߷�
	 * @param course
	 * @param major
	 * @param classe
	 * @param grade
	 * @return
	 */
	public String getCourseHighestScore(String course,String major,String classe,String grade){
		String highest = null;
		helper = new JdbcHelper();
		highest = helper.getCourseHighestScore(course, major, classe, grade);
		helper.close();
		return highest;
	}
	
	/**
	 * ��õ��Ƴɼ�����ͷ�
	 * @param course
	 * @param major
	 * @param classe
	 * @param grade
	 * @return
	 */
	public String getCourseLowestScore(String course,String major,String classe,String grade){
		String lowest = null;
		helper = new JdbcHelper();
		lowest = helper.getCourseLowestScore(course, major, classe, grade);
		helper.close();
		return lowest;
	}
	
	/**
	 * ��ð༶��ƽ���ɼ�
	 * @param classe
	 * @param grade
	 * @param major
	 * @return
	 */
	public String getClasseAvg(String classe,String grade,String major){
		String sum = getClasse_SumScore(classe,grade,major);
		helper = new JdbcHelper();
		String num = helper.getHaveScoreCount(major, classe, grade);
		if(sum!=null && num!=null){
			return String.valueOf((Double.parseDouble(sum)/Double.parseDouble(num)));
		}else{
			return "";
		}
	}
	

	/**
	 * ��óɼ������Ľ��
	 * @param major	רҵ
	 * @param classe	�༶
	 * @param grade	�꼶
	 * @return	���ط�������
	 */
	public Vector<AnalyzeResult> analyzeScore(String major,String classe,String grade ){
		Vector<AnalyzeResult> vector ;
		helper = new JdbcHelper();
		vector = helper.analyzeScore(major, classe, grade);
		helper.close();
		return vector;
	}
	
}
