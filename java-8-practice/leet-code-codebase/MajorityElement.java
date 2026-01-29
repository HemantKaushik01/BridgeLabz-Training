import java.util.*;
public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        int n = nums.length / 3;

        if (nums.length == 0) return ll;

        Arrays.sort(nums);

        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            } else {
                if (cnt > n) {
                    ll.add(nums[i - 1]);
                }
                cnt = 1;
            }
        }

        if (cnt > n) {
            ll.add(nums[nums.length - 1]);
        }

        return ll;
    }
}
