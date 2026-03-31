
import java.util.*;

class FileDownloader extends Thread {
    private String fileName;

    FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        Random r = new Random();
        for (int i = 0; i <= 100; i += 25) {
            System.out.println("[" + getName() + "] Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep(500 + r.nextInt(500));
            } catch (InterruptedException e) {}
        }
    }
}

public class DownloadManager {
    public static void main(String[] args) throws Exception {
        Thread t1 = new FileDownloader("Document.pdf");
        Thread t2 = new FileDownloader("Image.jpg");
        Thread t3 = new FileDownloader("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}
