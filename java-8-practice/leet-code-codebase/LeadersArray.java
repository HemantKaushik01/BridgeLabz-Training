import java.util.*;
public class LeadersArray {
    public static void main(String[] args) {
        LeadersArray la = new LeadersArray();
        int[] arr = {16,17,4,3,5,2};
        List<Integer> res = la.leaders(arr);
        System.out.print(res);
    }
    public List<Integer> leaders(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        ll.add(nums[nums.length-1]);
        int max = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(max<nums[i]){
                max= nums[i];
                ll.add(nums[i]);
            }
        }
        Collections.reverse(ll);
        return ll;
    }
}