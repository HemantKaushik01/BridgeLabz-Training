import java.util.Arrays;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        longestConsecutiveSequence obj = new longestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(obj.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length ==1){
            return 1;
        }
        int cnt=0;
        int max=-1;
        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i]+1==nums[i+1]){
                cnt++;
            }
            else if(nums[i]!=nums[i+1]){
                cnt=0;
            }
            max= Math.max(max,cnt);
        }
        
        return max+1;
    }
}
