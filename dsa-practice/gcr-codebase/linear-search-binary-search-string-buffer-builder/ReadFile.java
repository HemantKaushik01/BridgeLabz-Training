import java.io.*;


public class ReadFile{
    public static void main(String[] args) {
        String path="E:\\BridgeLabz-Training\\dsa-practice\\gcr-codebase\\linear-search-binary-search-string-buffer-builder\\file.txt";

        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println("Error");
        }
       
    }
}