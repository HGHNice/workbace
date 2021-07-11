package StudentSystem.src.indi.wrenn.studentsystem.util;

import java.util.Calendar;
import java.util.Vector;

public class Tools {

	//��ȡ�꼶
		public static Vector<String> CreateGrade(){
			Vector<String> vector = new Vector<String>();
			vector.add("");	//���һ����ѡ�� 
			Calendar c = Calendar.getInstance();
			int Year = c.get(Calendar.YEAR);
			for(int i=0;i<4;i++){
				vector.add(String.valueOf(Year--));
			}
			return vector;
			
		}
		
		
		//����ѧ��ѧ�ŵķ���(ѧ�ţ�department+major+grade+classe+num)
		public static String CreateID(String grade,String classe,String major,String department,String num){
			String id = department+major+grade.charAt(2)+""+grade.charAt(3)+classe+num;
			return id;
		}
}
