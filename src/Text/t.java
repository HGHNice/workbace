package Text;


public class t {
    public static void main(String[] args) {
     on s=new on();
     int a[]={1,1,2};
        System.out.println(s.removeDuplicates(a));
    }
}
class on {
    public int removeDuplicates(int[] nums) {
        int fast=1,low=1,n=nums.length;
        if (n==0){
            return 0;
        }
        while (fast<n){
            if (nums[fast]!= nums[fast-1]){
                nums[low]=nums[fast];
                ++low;
            }
            fast++;
        }
        return low ;
    }
}