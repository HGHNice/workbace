//package Text;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @projName: algorithm
// * @packgeName: indi.pentiumcm.thought
// * @className: DpBack
// * @author�� pentiumCM
// * @email�� 842679178@qq.com
// * @date: 2020/3/25 23:38
// * @describe: ��̬�滮 - 0/1��������
// */
// class text1 extends A implements Shopp {
//
//
//    /**
//     * 0/1�����㷨ʵ��
//     *
//     * @param backCap ����������
//     * @param weights ��Ʒ����������
//     * @param values  ��Ʒ�ļ�ֵ����
//     * @return
//     */
//    public void backPro(int backCap, int[] weights, int[] values) {
//
////      ��Ʒ����
//        int goodNum = weights.length;
//
////      1. ȷ��״̬
////      dp[i][j] ��ʾǰi����Ʒ��������Ϊj�ı���ʱ������ֵ
//        int[][] dp = new int[goodNum + 1][backCap + 1];
//
////      2. ȷ��һЩ��ʼ״̬��dp[0][0~backCap]=0��dp[0~goodNum][0]=0
//        for (int i = 0; i <= backCap; i++) {
//            dp[0][i] = 0;
//        }
//        for (int i = 0; i <= goodNum; i++) {
//            dp[i][0] = 0;
//        }
//
////      3.ȷ��״̬ת�Ʒ��̣�dp[i][j] = max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
//        for (int i = 1; i <= goodNum; i++) {
////          j �� 1 ��������������
//            for (int j = 1; j <= backCap; j++) {
//                if (weights[i - 1] <= j) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//
//
////      ���ݣ����������������Щ��Ʒ
//        int tempCap = backCap;
//        List<Integer> backList = new ArrayList<>();
//        for (int i = goodNum; i > 0; i--) {
//            if (dp[i][tempCap] != dp[i - 1][tempCap]) {
//                backList.add(i);
//                tempCap -= weights[i - 1];
//            }
//
//        }
//
//        System.out.print("�����з�����Ʒ��");
//
//            double x=0;
//            for (int i = backList.size() - 1; i >= 0; i--) {
//                x+=backList.get(i);
//            }
//
//            double sum=dp[goodNum][backCap];
//        System.out.println(sum / x);
//
//    }
//
//    public static void main(String[] args) {
//       Scanner sc=new Scanner(System.in);
//       int backCap = sc.nextInt();
//
//       int[] weights = new int[backCap];
//
////      ��Ʒ������
//        for (int i=0;i<backCap;i++){
//            weights[i]= sc.nextInt();
//        }
//        int b[]=new int[backCap];
//        for (int i=0;i<backCap;i++){
//            b[i]=sc.nextInt();
//        }
//
////      ��Ʒ�ļ�ֵ
//        int[] values = new int[backCap];
//        for (int i=0;i<backCap;i++){
//            values[i]=weights[i]*b[i];
//        }
//
//        new text1().backPro(backCap, weights, values);
//    }
//}
