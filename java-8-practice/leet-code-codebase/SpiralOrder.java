import java.util.ArrayList;
import java.util.List;
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(s.spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ll = new ArrayList<>();
        int top=0;
        int right=matrix[0].length-1;
        int bottom = matrix.length-1;
        int left=0;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ll.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ll.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){

            for(int i=right;i>=left;i--){
                ll.add(matrix[bottom][i]);
            }
            bottom--;
            }
            if(left<=right){

            for(int i=bottom;i>=top;i--){
                ll.add(matrix[i][left]);
            }
            left++;
            }
            
        }
        return ll;
    }
}

