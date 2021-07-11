package Text;

import java.util.*;

public class IDcard {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String regex=" ";
        if(str.matches(regex)) {
            System.out.print("Wrong Format");
            str=null;
        }
        if(str.length()%8!=0) {
            System.out.print("Wrong Format");
            str=null;
        }
        if(str!=null){
            char []a=str.toCharArray();
            int sum=0,i1=0;
            for(int i=0;i<a.length;i=i+8) {
                for(int i0=i;i0<i+6;i0++) {
                    if(i0<i+5) {
                        sum=(sum+a[i0]-'0')*10;
                    }
                    else {
                        sum=(sum+a[i0]-'0');
                    }
                }
                if(sum==202017||sum==202061) {
                    if(i1==1) {
                        System.out.print(' ');

                    }
                    for(int j=i+4;j<i+8;j++) {
                        System.out.print(a[j]);
                    }
                    i1=1;
                }

                sum=0;
            }
        }
    }
}