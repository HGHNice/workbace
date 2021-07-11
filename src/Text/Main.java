package Text;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        String str;
        str = sc.nextLine();
        str.replace(" ", "");
        boolean flag = false;//true:zhange zai chu li
        int linshi = 0;

        for(int i=0;i<str.length();++i){

            if (str.charAt(i)=='：'){
                System.out.print("--");
            }
           else if(str.charAt(i) == '；'){   //检测到分号换行

                System.out.println();
            }
            else{
                System.out.print(str.charAt(i));    //没有检测到分号就一直加
            }
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){   //判断数字集合成价格
                linshi = linshi * 10 + str.charAt(i) - '0';
                flag = true;
            }
            else if(i + 1<str.length()){
                total += linshi;
                linshi = 0;
            }
            else{
                total += linshi;
                linshi = 0;

            }
        }
        total += linshi;
        System.out.println();
        System.out.println("总价格--"+total);

        sc.close();
    }
}

class Book{
    public String name;
    public int p;
}

