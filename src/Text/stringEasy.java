package Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 思路：
 * 1. 先对当前字符串的字母进行排序
 * 2. 每次都用最小的不同字符替换当前字符
 * 3. 如果最后剩下的字符和当前字符相同，则从后往前寻找第一个不同的字符进行替换
 */
public class stringEasy
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        char[] chars = a.toCharArray(); //转为字符数组
        List<String> originList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (char c : chars) {
            originList.add(String.valueOf(c));  //获取单个字符追加列表尾部
        }
        list.addAll(originList);
        // 排序
        list.sort(String::compareTo);
        List<String> resultList = new ArrayList<>();
        for (int j = 0; j < originList.size(); j++) {
            String s = originList.get(j);
            for (int i = 0; i < list.size(); i++) {
                String s1 = list.get(i);
                if(!s1.equals(s)){  //如果这个两个字符不一样 则进行追加
                    resultList.add(s1);
                    list.remove(i);  //同时删除这个元素
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
