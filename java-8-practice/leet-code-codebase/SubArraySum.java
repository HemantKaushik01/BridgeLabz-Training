public class SubArraySum {
    public static void main(String[] args) {
        SubArraySum s = new SubArraySum();
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(s.subArraySum(nums, k));
    }
    public int subArraySum(int[] nums, int k) {
        int i=0;
        int sum=0;
        int cnt=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);   
        while(i<nums.length){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            i++;

        }
        return cnt;
    }
}