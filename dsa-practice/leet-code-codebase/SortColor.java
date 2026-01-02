public class SortColor {
    public static void main(String[] args) {
        SortColor sortColor = new SortColor();
        int[] nums = {2,0,2,1,1,0};
        sortColor.sortColors(nums);
        System.out.print("Sorted Colors: ");
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
        private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        }
}