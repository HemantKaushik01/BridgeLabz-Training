package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListManagerTest {
	ListOfManagers listOf = new ListOfManagers();

	@Test
	void testAddElement() {
		List<Integer> list = new ArrayList<>();
		listOf.addElement(list, 6);
		assertTrue(list.contains(6));
	}

	@Test
	void testRemoveElement() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		listOf.removeElement(list, 8);
		assertFalse(list.contains(8));
	}

	@Test
	void testGetSize() {
		List<Integer> list = new ArrayList<>();
		listOf.addElement(list, 5);
		assertEquals(1, listOf.getSize(list));
	}
}
