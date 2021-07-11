package N;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class ObjectDataStream {
    public static void xuliehua(List<Good> list2) {
        File file=new File("D:\\goods.txt");

        try {
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list2);

            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }




    public static List<Good> fanxuliehua() {
        List<Good> list2=null;
        File file=new File("D:\\goods.txt");
        if(file.length()!=0) {
            try {
                InputStream in=new FileInputStream(file);
                ObjectInputStream objIn=new ObjectInputStream(in);

                list2=new ArrayList<Good>();
                list2=(List<Good>)objIn.readObject();


            } catch (IOException | ClassNotFoundException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }

        }
        return list2;
    }

}


