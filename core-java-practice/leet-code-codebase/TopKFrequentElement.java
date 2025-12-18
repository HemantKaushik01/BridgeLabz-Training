import java.util.HashMap;
import java.util.PriorityQueue;
class TopKFrequentElement {
    public static void main(String[] args) {
        TopKFrequentElement t = new TopKFrequentElement();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = t.topKFrequent(nums,k);
        for(int i =0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b)
        );
         for(int num : map.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int result[] = new int[k]; 
        int i=0;
        while(!pq.isEmpty()){
            result[i]= pq.poll();
            i++;
        }
        return result;

    }
}