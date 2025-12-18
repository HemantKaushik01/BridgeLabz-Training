public class SearchInsertPosition {
    public static void main(String[] args) {
        
        SearchInsertPosition obj=new SearchInsertPosition();
        int[] nums={1,3,5,6};
        int target=5;
        System.out.println(obj.searchInsert(nums, target));
    }
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        
        int ans=j+1;;
        while(i<=j){
            int mid=(i+j)/2;
           if(nums[mid]>=target){
            ans=mid;
            j=mid-1;
           }
           else{
                i=mid+1;
           }
        }
       
        return ans;
    }
}
