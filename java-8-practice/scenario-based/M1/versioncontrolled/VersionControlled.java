package versioncontrolled;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class File{
	String fileName;
	String version;
	int size;
	public File(String fileName, String version, int size) {
		this.fileName=fileName;
		this.version=version;
		this.size = size;
	}
	public String getFileName() {
		return fileName;
	}
	public String getVersion() {
		return version;
	}
	public int getSize() {
		return size;
	}
	public void setFileName(String newFileName) {
		this.fileName=newFileName;
	}
	public void display() {
		System.out.println(fileName +" "+ version+" "+size);
	}
	
}

class Controller{
	List<File> filesList = new ArrayList<>();
	public void upload(File file) {
		List<File> ll = filesList.stream()
						.filter(e ->e.getFileName().equals(file.getFileName()))
						.filter(e ->e.getVersion().equals(file.getVersion()))
						.collect(Collectors.toList());
		if(ll.isEmpty()) {
			filesList.add(file);
		}
	}
	public void fetch (String fileName) {
		List<File> ll = filesList.stream()
						.filter(e->e.getFileName().equals(fileName))
						.sorted(Comparator.comparing(File::getSize)
							.thenComparing(File:: getVersion))
						.collect(Collectors.toList());
		if(ll.isEmpty()) {
		    System.out.println("File Not Found");
		    return;
		}
		for(File file:ll) {
			file.display();
		}
		
	}
	public void latest(String fileName) {
		for(int i=filesList.size()-1;i>=0;i--) {
			if(filesList.get(i).getFileName().equals(fileName)) {
				filesList.get(i).display();
				return;
			}
		}
	    System.out.println("File Not Found");

		
	}
	public void totalStorage(String fileName ) {
		int storage = 0;
		boolean found = false;
		for(File file: filesList) {
			if(file.getFileName().equals(fileName)) {
				storage+=file.getSize();
	            found = true;

			}
		}
	    if(!found) {
	        System.out.println("File Not Found");
	    } else {
	        System.out.println(fileName + " " + storage);
	    }
		
	}
}
public class VersionControlled {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Controller controller = new Controller();
		while(n-->0) {
			String str[] = sc.nextLine().split(" ");
			switch(str[0]) {
			
			case "UPLOAD":
				controller.upload(new File(str[1],str[2],Integer.parseInt(str[3])));
				break;
			case "FETCH":
				controller.fetch(str[1]);
				break;
			case "LATEST":
				controller.latest(str[1]);
				break;
			case "TOTAL_STORAGE":
				controller.totalStorage(str[1]);
				break;
			}
			 
				
			
		}
	}
}
