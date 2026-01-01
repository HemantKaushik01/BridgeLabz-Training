public class CompareStringConcatPerformance {
    public static void main(String[] args) {
        int N = 100;
        String word = "GLA";

 
        String str = "";
        long startString = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            str += word;
        }
        long endString = System.currentTimeMillis();
        System.out.println("String Time: " + (endString - startString) + " ms");

        StringBuilder builder = new StringBuilder();
        long startBuilder = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            builder.append(word);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ms");

        StringBuffer buffer = new StringBuffer();
        long startBuffer = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            buffer.append(word);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ms");
    }
}
