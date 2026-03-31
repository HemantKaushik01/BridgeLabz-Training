public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber obj=new MissingNumber();
        int[] nums={3,0,1};
        System.out.println(obj.missingNumber(nums));
    }
    public int missingNumber(int[] nums) {
        int xor1=0;
        int xor2=0;
        for(int i=0;i<nums.length;i++){
            xor1^=nums[i];
            xor2^=(i+1);
        }
      
        return xor2^xor1;
    }
}