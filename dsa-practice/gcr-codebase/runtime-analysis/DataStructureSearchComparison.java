import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
            Random rand = new Random();
            int size =100;

            List<Integer> dataList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                dataList.add(rand.nextInt(size * 10));
            }

            int target = dataList.get(rand.nextInt(size));

            int[] array = dataList.stream().mapToInt(i -> i).toArray();
            long startArray = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            long endArray = System.nanoTime();

            HashSet<Integer> hashSet = new HashSet<>(dataList);
            long startHash = System.nanoTime();
            boolean foundInHash = hashSet.contains(target);
            long endHash = System.nanoTime();

            TreeSet<Integer> treeSet = new TreeSet<>(dataList);
            long startTree = System.nanoTime();
            boolean foundInTree = treeSet.contains(target);
            long endTree = System.nanoTime();

  
            System.out.printf("Array Search Time: %.4f ms\n", (endArray - startArray) / 1e6);
            System.out.printf("HashSet Search Time: %.4f ms\n", (endHash - startHash) / 1e6);
            System.out.printf("TreeSet Search Time: %.4f ms\n", (endTree - startTree) / 1e6);
            
        
    }


    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}
