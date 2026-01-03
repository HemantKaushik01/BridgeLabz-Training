package secnario_Based;

import java.util.Scanner;

public class SentenceFormatter{
    public String Format(String str){
        str.trim();
        if(str== null || str.length()==0){
            return "";
        }
        boolean isCapitalized = true;
        boolean spaceAllowed = false;

        StringBuilder newString = new StringBuilder("");
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isLetter(ch)){
                if(isCapitalized){
                    newString.append(Character.toUpperCase(ch));
                    isCapitalized = false;
                }else{
                    newString.append(Character.toLowerCase(ch));
                }
                spaceAllowed = true;
            }
            else if(ch == ' ' && spaceAllowed){
                newString.append(' ');
                spaceAllowed = false;
            }
            else if(ch == '!'||ch=='?'||ch=='.'){
                newString.append(ch);
                newString.append(' ');
                isCapitalized = true;
                spaceAllowed = false;
            }
        }
        return newString.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Paragraph that is expected to be formatted: ");
        String paragraph = sc.nextLine();
        SentenceFormatter tf = new SentenceFormatter();
        System.out.println("formatted Paragraph: "+ tf.Format(paragraph));
    }
}