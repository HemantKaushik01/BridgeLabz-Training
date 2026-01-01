public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        LongestSubarrayWithSumK obj=new LongestSubarrayWithSumK();
        int[] nums={1,-1,5,-2,3};
        int k=3;
        int result=obj.longestSubarray(nums,k);
        System.out.println(result);
    }
    public int longestSubarray(int[] nums, int k) {
       int sum=nums[0];
       int left=0;
       int right=0;
       int max =0;
       while(right<nums.length){
        while(left<=right && sum>k){
            sum-=nums[left];
            left++;
        }
        if(sum==k){
            max = Math.max(max,right-left+1);
        }
        right++;
        if(right<nums.length){
            sum+=nums[right];
        }

       }
       return max;
    }
}