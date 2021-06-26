package test;

import datastructure.list.CustomArrayList;
import datatype.CustomStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    CustomStack stack;

    @BeforeEach
    void init() {
        stack = new CustomStack(new CustomArrayList());
    }

    @Test
    void shouldReturnSizeTwo() {

        //given
        stack.push(5);
        stack.push(8);

        //then
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
    }

    @Test
    void pop() {

        //given
        stack.push(5);
        stack.push(8);

        //when
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        stack.pop();

        //then
        assertEquals(1, stack.size());

    }

    @Test
    void shouldReturnZero() {
        assertEquals(0, stack.size());
    }

    @Test
    void shouldReturnTwo() {

        //given
        stack.push(5);
        stack.push(8);

        //then
        assertEquals(2, stack.size());
    }

    @Test
    void shouldReturnFalse() {

        //given
        stack.push(5);
        stack.push(8);

        //then
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldReturnTrue() {
        assertTrue(stack.isEmpty());
    }

}