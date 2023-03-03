import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ListPriorityQueueTest {
    private PriorityQueue queue;

    @BeforeEach
    void setUp() {
        queue = ListPriorityQueue.createEmpty();
    }

    @Test
    void createEmpty() {
        assertTrue(queue.isEmpty());

    }

    @Test
    void isEmpty() throws EmptyPriorityQueueException {
        queue.add(1, "A");
        queue.pop();
        assertTrue(queue.isEmpty());

    }

    @Test
    void add() throws EmptyPriorityQueueException {
        queue.add(1, "A");
        queue.add(2, "B");
        queue.add(2, "C");
        assertEquals("B", queue.peek());
        queue.pop();
        assertEquals("C", queue.peek());

        assertThrows(IllegalArgumentException.class, () -> {queue.add(0, "B");});
        assertThrows(IllegalArgumentException.class, () -> {queue.add(11, "B");});
    }

    @Test
    void peek() throws EmptyPriorityQueueException {
        assertThrows(EmptyPriorityQueueException.class, ()->{queue.peek();});

        queue.add(1, "A");
        queue.add(2, "B");
        queue.add(1, "C");
        assertEquals("B", queue.peek());

    }

    @Test
    void pop() throws EmptyPriorityQueueException {
        assertThrows(EmptyPriorityQueueException.class, ()->{queue.pop();});

        queue.add(1, "A");
        queue.add(2, "B");
        queue.add(2, "C");
        assertEquals("C", queue.pop().peek());
    }
}