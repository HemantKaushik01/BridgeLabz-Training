public class RotateArray {
    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        obj.rotate(nums, k);
        for(int num: nums){
            System.out.print(num+" ");
        }
    }
    public void rotate(int[] nums, int k) {
        int temp[] = new int[nums.length];
        int n= nums.length;
        k=k%n;
        for(int i=0;i<k;i++){
            temp[i]=nums[n-k+i];
        }
        for(int i=0;i<nums.length-k;i++){
            temp[i+k]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=temp[i];
        }
    }
} 
    

