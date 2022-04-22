package ShopText;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream {

	public static List<Good> tree;  //静态全局变量  方便调用


	public static void xuliehua(List<Good> list) {
		// TODO Auto-generated method stub

		File file=new File("shangping/xinxi3");
		try {
			OutputStream out=new FileOutputStream(file);
			ObjectOutputStream pb=new ObjectOutputStream(out);
			pb.writeObject(list);
			pb.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<Good> fanxuliehua() {
		List<Good> list=null;
		File file=new File("shangping/xinxi3");
		if (file.length()!=0) {
			try {
				InputStream in=new FileInputStream(file);
				ObjectInputStream ob=new ObjectInputStream(in);
				
				list=new ArrayList<Good>();
				list=(List<Good>)ob.readObject();
				
				in.close();
				ob.close();
			} catch (Exception e) {
				System.out.println("读取失败");
				
			}
			
		}
		
		return list;
	}
}
