
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll = new ArrayList<>();
        for(int row=0;row<numRows;row++){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<=row;i++){
                if(i==row || i==0){
                    l.add(1);
                }
                else{
                    l.add(ll.get(row-1).get(i-1)+ll.get(row-1).get(i));
                }
            }
            ll.add(l);
        }
        return ll;
    }
}