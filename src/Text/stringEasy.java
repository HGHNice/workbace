package Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ˼·��
 * 1. �ȶԵ�ǰ�ַ�������ĸ��������
 * 2. ÿ�ζ�����С�Ĳ�ͬ�ַ��滻��ǰ�ַ�
 * 3. ������ʣ�µ��ַ��͵�ǰ�ַ���ͬ����Ӻ���ǰѰ�ҵ�һ����ͬ���ַ������滻
 */
public class stringEasy
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        char[] chars = a.toCharArray(); //תΪ�ַ�����
        List<String> originList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (char c : chars) {
            originList.add(String.valueOf(c));  //��ȡ�����ַ�׷���б�β��
        }
        list.addAll(originList);
        // ����
        list.sort(String::compareTo);
        List<String> resultList = new ArrayList<>();
        for (int j = 0; j < originList.size(); j++) {
            String s = originList.get(j);
            for (int i = 0; i < list.size(); i++) {
                String s1 = list.get(i);
                if(!s1.equals(s)){  //�����������ַ���һ�� �����׷��
                    resultList.add(s1);
                    list.remove(i);  //ͬʱɾ�����Ԫ��
                    break;
                } else if(i == list.size() -1){
                    for (int k = originList.size() - 2; k >= 0; k--) {
                        String s2 = originList.get(k);
                        if(!s1.equals(s2) && !resultList.get(resultList.size() - 1).equals(s2)){
                            String temp = resultList.remove(resultList.size() - 1);
                            resultList.add(s1);
                            resultList.add(temp);
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        resultList.forEach(result::append);
        System.out.println(result);
    }
}
