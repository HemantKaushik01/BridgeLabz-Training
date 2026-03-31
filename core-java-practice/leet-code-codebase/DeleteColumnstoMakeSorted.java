import java.util.ArrayList;
import java.util.Collections;
public class DeleteColumnstoMakeSorted {
    public static void main(String[] args) {
        DeleteColumnstoMakeSorted obj= new DeleteColumnstoMakeSorted();
        String[] strs= {"cba","daf","ghi"};
        System.out.println(obj.minDeletionSize(strs));
    }
    public int minDeletionSize(String[] strs) {
        int count=0;
        for(int i=0;i<strs[0].length();i++){
            ArrayList<Character> ll1= new ArrayList<>();
            ArrayList<Character> ll2= new ArrayList<>();
            for(int j=0;j<strs.length;j++){
                ll1.add(strs[j].charAt(i));
                ll2.add(strs[j].charAt(i));
            }
            Collections.sort(ll1);
            if(!ll1.equals(ll2)){
                count++;
            }
        }
        return count;
    }
}