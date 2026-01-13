public class rearrangeArrayBySign {
    public static void main(String[] args) {
        rearrangeArrayBySign obj = new rearrangeArrayBySign();
        int[] nums = {3,1,-2,-5,2,-4};
        int[] result = obj.rearrangeArray(nums);
        for(int val: result){
            System.out.print(val+" ");
        }
    }
      public int[] rearrangeArray(int[] nums) {
        int result[] = new int[nums.length];
        int idxN =1;
        int idxP=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                result[idxN]=nums[i];
                idxN+=2;
            }
            else{
                result[idxP]=nums[i];
                idxP+=2;
            }
        }
       
       
        return result;
    }
}