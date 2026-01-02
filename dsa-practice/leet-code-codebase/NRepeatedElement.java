import java.util.HashSet;
import java.util.Set;
public class NRepeatedElement {
    public static void main(String[] args) {
        NRepeatedElement nRepeatedElement = new NRepeatedElement();
        int[] nums = {1,2,3,3};
        System.out.println(nRepeatedElement.repeatedNTimes(nums));
    }

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(!set.add(i)){
                return i;
            }
        }
        return 0;
    }
}