import java.util.*;
public class LongestConsecutive_128 {

    static int longestConsecutive(int[] nums) {
    Set <Integer> set=new HashSet<>();
    for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
    }
    int longest=0;
    for(int num:set){
        if(!set.contains(num-1)){
            int curr=num;
            int length=1;
        
        while(set.contains(curr+1)){
            curr++;
            length++;
        }
        longest=Math.max(longest,length);
    }
}
return longest;
}
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
     
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Longest consecutive sequence length: " + longestConsecutive(nums));
    }
}