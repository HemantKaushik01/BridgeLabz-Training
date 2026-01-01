public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber obj=new SingleNumber();
        int[] nums={4,1,2,1,2};
        int result=obj.singleNumber(nums);
        System.out.println(result);
    }
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        return xor;
    }
}