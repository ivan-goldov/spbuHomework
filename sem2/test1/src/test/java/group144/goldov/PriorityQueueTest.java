package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    @Test
    public void isEmptyTest() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void getLengthTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(37, 1);
        assertEquals(1, priorityQueue.getLength());
    }

    @Test
    public void enqueueAndDequeueSingleElementTest() throws EmptyPriorityException {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue("Single", 1);
        assertEquals("Single", priorityQueue.dequeue());
    }

    @Test
    public void enqueueAndDequeueTwoElementsTest() throws EmptyPriorityException {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue("First", 5);
        priorityQueue.enqueue("Second", 20);
        assertEquals("Second", priorityQueue.dequeue());
    }

    @Test
    public void dequeueFromEmptyQueueTest() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        try {
            priorityQueue.dequeue();
        }
        catch (EmptyPriorityException e) {
            assertEquals("The queue is empty", e.getMessage());
        }
    }

    @Test
    public void dequeueFewElementsTest() throws EmptyPriorityException {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue("First", 29);
        priorityQueue.enqueue("Second", 42);
        priorityQueue.enqueue("Third", 10);
        priorityQueue.enqueue("Fourth", 5);
        priorityQueue.enqueue("Fifth", 90);
        assertEquals("Fifth", priorityQueue.dequeue());
        assertEquals("Second", priorityQueue.dequeue());
        assertEquals("First", priorityQueue.dequeue());
        assertEquals("Third", priorityQueue.dequeue());
        assertEquals("Fourth", priorityQueue.dequeue());
    }

    @Test
    public void getLengthWithFewElementsTest() throws EmptyPriorityException {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue("First", 30);
        priorityQueue.enqueue("Second", 41);
        priorityQueue.enqueue("Third", 9);
        priorityQueue.enqueue("Fourth", 6);
        priorityQueue.enqueue("Fifth", 53);
        assertEquals(5, priorityQueue.getLength());
        priorityQueue.dequeue();
        assertEquals(4, priorityQueue.getLength());
        priorityQueue.dequeue();
        assertEquals(3, priorityQueue.getLength());
        priorityQueue.dequeue();
        assertEquals(2, priorityQueue.getLength());
        priorityQueue.dequeue();
        assertEquals(1, priorityQueue.getLength());
        priorityQueue.dequeue();
        assertEquals(0, priorityQueue.getLength());
    }
}