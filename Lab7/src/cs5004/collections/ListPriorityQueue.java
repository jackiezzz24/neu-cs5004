package cs5004.collections;

public class ListPriorityQueue implements PriorityQueue{

    private PriorityNode head;

    private static class PriorityNode {
        private int priority;
        private String value;
        private PriorityNode next;

        private PriorityNode(Integer priority, String value, PriorityNode next) {
            this.priority = priority;
            this.value = value;
            this.next = next;
        }
    }

    public static PriorityQueue createEmpty() {
        return new ListPriorityQueue();
    }

    /**
     * Checks if the priority queue is empty
     *
     * @return true if the PQ is empty, false otherwise.
     */
    @Override
    public Boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds an element to the PQ.
     *
     * @param priority The element's (non-negative) priority.
     * @param value    The element's value.
     * @return A copy of the priority queue containing the new element.
     */
    @Override
    public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException();
        }
        PriorityNode newNode = new PriorityNode(priority, value, null);

        if (head == null || head.priority < newNode.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            PriorityNode current = head;
            while (current.next != null && current.next.priority >= newNode.priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return this;
    }

    /**
     * Gets the value of the highest priority element. If there are multiple elements that have the same priority, gets
     * the value  of the earliest added element.
     *
     * @return The value  of the highest priority element.
     * @throws EmptyPriorityQueueException if the PQ is empty.
     */
    @Override
    public String peek() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return head.value;
    }

    /**
     * Removes the highest priority element.
     *
     * @return A copy of the priority queue without the highest priority element.
     * @throws EmptyPriorityQueueException if the PQ is empty.
     */
    @Override
    public PriorityQueue pop() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        PriorityQueue copy = new ListPriorityQueue();
        PriorityNode current = head.next;
        while (current != null) {
            copy.add(current.priority, current.value);
            current = current.next;
        }
        return copy;
    }
}
