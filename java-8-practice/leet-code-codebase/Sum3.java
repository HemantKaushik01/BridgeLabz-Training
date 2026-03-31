import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        Sum3 s3 = new Sum3();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = s3.threeSum(arr);
        System.out.print(res);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for(int i=0;i<n-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int currentSum = nums[i] + nums[j] + nums[k];
                if(currentSum == 0){
                    sum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                } else if(currentSum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}