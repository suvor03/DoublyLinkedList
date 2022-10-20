package test;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.suvorov_d_a.DoublyLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<Integer>();
    }

    @Test
    public void testIsEmptyReturnsTrue() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptySizeIsZero() {
        assertEquals(0, list.size());
    }

    @Test
    public void testInsertAtFirst() {
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        assertEquals("[4,3,2,1,0]", list.toString());
    }

    @Test
    public void testInsertAtLast() {
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }
        assertEquals("[0,1,2,3,4]", list.toString());
    }

    @Test
    public void testAddBefore() {
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }

        list.addBefore(4, 10);
        list.addBefore(0, 20);
        list.addBefore(2, 30);

        assertEquals("[10,4,3,30,2,1,20,0]", list.toString());
    }

    @Test
    public void testAddAfter() {
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }

        list.addAfter(4, 10);
        list.addAfter(0, 20);
        list.addAfter(2, 30);

        assertEquals("[0,20,1,2,30,3,4,10]", list.toString());
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 15; i++) {
            list.addLast(i);
        }

        for (int i = 0; i < 10; i++) {
            list.remove(i);
        }

        assertEquals("[10,11,12,13,14]", list.toString());
    }
}