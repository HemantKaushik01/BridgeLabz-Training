package jUnit;
import java.io.*;

public class FileProcessor {
	public void writeToFile(String filename, String content) throws IOException {
		try (FileWriter writer = new FileWriter(filename)) {
			writer.write(content);
		}
	}

	public String readFromFile(String filename) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			return br.readLine();
		}
	}
}
