public class FibonacciComparison {
    public static void main(String[] args) {
       int n=40;

       
       System.out.println("Fibonacci of " + n + ":");        
       long startIter = System.nanoTime();
       int iterResult = fibonacciIterative(n);
       long endIter = System.nanoTime();
       System.out.println("Iterative Result: " + iterResult);
       System.out.println("Iterative Time: " + (endIter - startIter) );

       long startRec = System.nanoTime();
       int recResult = fibonacciRecursive(n);
       long endRec = System.nanoTime();
       System.out.println("Recursive Result: " + recResult);
       System.out.println("Recursive Time: " + (endRec - startRec) );
           

       
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
