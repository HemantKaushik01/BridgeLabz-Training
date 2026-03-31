
import java.util.*;

class TaskRunner extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
            for (int i = 0; i < 1000000; i++) {}
        } catch (InterruptedException e) {}
    }
}

class StateMonitor extends Thread {
    private Thread[] tasks;

    StateMonitor(Thread[] tasks) {
        this.tasks = tasks;
    }

    public void run() {
        boolean running = true;
        while (running) {
            running = false;
            for (Thread t : tasks) {
                System.out.println("[Monitor] " + t.getName() + " is in " + t.getState() + " at " + new Date());
                if (t.getState() != Thread.State.TERMINATED) running = true;
            }
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

public class ThreadStateMonitor {
    public static void main(String[] args) {
        TaskRunner t1 = new TaskRunner();
        TaskRunner t2 = new TaskRunner();
        t1.setName("Task-1");
        t2.setName("Task-2");

        StateMonitor monitor = new StateMonitor(new Thread[]{t1, t2});

        t1.start();
        t2.start();
        monitor.start();
    }
}
