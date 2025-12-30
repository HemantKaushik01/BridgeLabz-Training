public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes obj = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        obj.moveZeroes(nums);
        for(int num: nums){
            System.out.print(num+" ");
        }
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[idx]=nums[i];
                idx++;
            }

        }        
        for(int i=idx;i<n;i++ ){
            nums[i]=0;
        }
    }
}