import java.util.ArrayList;
public class SetZeroes {
    public static void main(String[] args) {
        SetZeroes obj = new SetZeroes();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        obj.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int j = 0; j < row.size(); j++) {
            int rowIdx = row.get(j);
            int colIdx = col.get(j);

            for (int i = 0; i < matrix[0].length; i++) {
                matrix[rowIdx][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][colIdx] = 0;
            }
        }
    }
}