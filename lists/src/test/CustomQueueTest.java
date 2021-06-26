package test;

import datastructure.list.CustomArrayList;
import datatype.CustomQueue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {


    CustomQueue queue;

    @BeforeEach
    void init() {
        queue = new CustomQueue(new CustomArrayList());
    }

    @Test
    void shouldReturnZeroWhenEmptyQueue() {
        assertEquals(0, queue.size());
    }


    @Test
    void shouldReturnSizeWhenAddElement() {

        //given
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);


        //then
        assertEquals(4, queue.size());
    }

    @Test
    void shouldReturnTrueWhenQueueEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldReturnFalseWhenAddElement() {

        //given
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        //then
        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldCheckIfElementIsProperlyAdded() {

        //given
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        //then
        assertEquals(3, queue.peek());
        assertFalse(queue.isEmpty());
        assertEquals(4, queue.size());
    }

    @Test
    void shouldCheckIfElementIsProperlyDeleted() {

        //given
        queue.add(4);
        queue.add(6);
        queue.add(7);


        //then
        assertEquals(4, queue.peek());
        assertEquals(4, queue.poll());
        assertEquals(6, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void shouldReturnFourAsFirtstAddedElement() {

        //given
        queue.add(4);
        queue.add(6);
        queue.add(7);


        //then
        assertEquals(4, queue.peek());
    }
}