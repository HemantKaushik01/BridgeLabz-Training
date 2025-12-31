
public class WordInsentence {

	public static void main(String[] args) {
		String[] sentences = {"Hello world","Hello Gla","XYZ abc"};
		String word = "Hello"; 
		boolean found = false;
		for(int i = 0;i<sentences.length;i++) {
			if(sentences[i].contains(word)) {
				System.out.println(sentences[i]);
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Not Found");
		}
	}
}