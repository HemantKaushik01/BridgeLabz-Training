package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class PerformanceTesting {
	public void longRunningTask() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

	@Test
	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	void testTimeout() {
		longRunningTask();
	}
}
