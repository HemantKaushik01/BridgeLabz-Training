class TwoSum {
    public static void main(String[] args) {
        TwoSum ts=new TwoSum();
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=ts.twoSum(nums,target);
        for(int i:result){
            System.out.println(i);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=0;
        for(i=0;i<nums.length-1;i++){
            for(j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                     return new int[]{i,j};
                }
                
            }
            
            
        }
        return new int[]{};
    }
}