package test;

import ru.vsu.cs.suvorov_d_a.CircularLinkedList;
import org.junit.Before;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class CircularLinkedListTest {

    private CircularLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new CircularLinkedList<Integer>();
    }

    @Test
    public void testAddingElements_ThenListContainsThoseElements() {
        list.addNode(4);
        assertEquals("[4]", list.toString());
    }

    @Test
    public void testForNonExistingElement_ThenReturnsFalse() {
        assertFalse(list.containsNode(11));
    }
}