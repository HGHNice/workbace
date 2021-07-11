package Text;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
public class Digital extends IOException{
    public static void main(String args[]) throws Exception {
        int n=-1;
        File file=new File("D:","n.txt");
        file.createNewFile();
        int  []a=new int[10];
        Random random = new Random();
        for(int i=0;i< a.length;i++){
            a[i]= random.nextInt(50)+1;
        }
        Arrays.sort(a);
            OutputStream out =new FileOutputStream(file);
            InputStream inputStream=new FileInputStream(file);
          for(int i=0;i<10;i++) {
              out.write((a[i] + "\n").getBytes(StandardCharsets.UTF_8));
          }
              out.close();

    }

}

