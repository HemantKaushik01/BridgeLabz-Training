import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
  
        String filePath = "E:\\BRAJLAB\\Java Programs\\StringBufferAndBuilder\\file.txt"; 
        String targetWord = "is";

        int count = 0;

        try {  
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;

          
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println("The word " + targetWord + " appears " + count + " times in the file.");

        } catch (IOException e) {
            System.out.println("Error reading the file:");
            e.printStackTrace();
        }
    }
}