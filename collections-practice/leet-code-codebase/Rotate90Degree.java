public class Rotate90Degree {
    public static void main(String[] args) {
        Rotate90Degree obj=new Rotate90Degree();
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        obj.rotate(matrix);
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix.length;c++){
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        int row =matrix.length;
        int top=0;
        int bottom=row-1;
        while(top<bottom){
            for(int col=0;col<row;col++){
                int temp=matrix[top][col];
                matrix[top][col]=matrix[bottom][col];
                matrix[bottom][col]=temp;
            }
            top++;
            bottom--;
        }
        for(int r=0;r<row;r++){
            for(int col=r+1;col<row;col++){
                int temp=matrix[r][col];
                matrix[r][col]=matrix[col][r];
                matrix[col][r]=temp;
            }
        }
    }
}