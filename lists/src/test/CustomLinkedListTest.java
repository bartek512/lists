package test;


import datastructure.list.CustomLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

    List<Integer> list;

    @BeforeEach
    void init() {
        list = new CustomLinkedList<>();
    }

    @Test
    void shouldReturnThreeAfterAdd3Elements() {

        //given
        assertTrue(list.add(5));
        assertTrue(list.add(7));
        assertTrue(list.add(9));

        //then
        assertEquals(3, list.size());
    }

    @Test
    void shouldReturnZeroWhenListIsEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    void shouldReturnTrueWhenListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldReturnFalseWhenListIsNotEmpty() {

        //given
        list.add(5);

        //when
        assertFalse(list.isEmpty());
    }

    @Test
    void shouldReturnTrueIfListConatinsAddedElement() {

        //given
        assertTrue(list.add(5));

        //then
        assertTrue(list.contains(5));
    }

    @Test
    void shouldReturnTrueIfListContansSpecifiedElement() {

        //given
        list.add(5);

        //then
        assertTrue(list.contains(5));
    }

    @Test
    void shouldReturnFalseIfListDoesntContansSpecifiedElement() {
        assertFalse(list.contains(5));
    }

    @Test
    void shouldReturnAddedElement() {

        //given
        list.add(5);
        list.add(6);
        list.add(7);

        //then
        assertEquals(5, list.get(0));
        assertEquals(6, list.get(1));
        assertEquals(7, list.get(2));
    }

    @Test
    void shouldRemoveSpecifiedElement() {

        //given
        Integer x = 5;
        Integer y = 20;
        list.add(x);
        list.add(55);
        list.add(8);

        //when
        int expectedValue = 5;
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;


        //then
        assertEquals(expectedValue, list.get(0));
        assertEquals(expectedSizeBefore, list.size());
        assertTrue(list.remove(x));
        assertFalse(list.remove(y));
        assertEquals(expectedSizeAfter, list.size());
    }

    @Test
    void shouldReturnTrueIfListIsEmpty() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //then
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldReturn5WhenAdd5() {

        //given
        assertTrue(list.add(5));

        //then
        assertEquals(5, list.get(0));
    }

    @Test
    void shouldReturnException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-5));
    }

    @Test
    void shouldReturn6WhenReplaceAnElementBy6() {

        //given
        list.add(5);
        list.add(4);
        list.add(7);
        list.set(1, 6);

        //then
        assertEquals(6, list.get(1));
    }

    @Test
    void shouldReturnAnException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-5, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, 5));
    }

    @Test
    void shouldReturn11WhenAdd11On1Index() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);


        //when
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 4;


        //then
        assertEquals(expectedSizeBefore, list.size());
        list.add(1, 11);
        assertEquals(11, list.get(1));
        assertEquals(expectedSizeAfter, list.size());
    }

    @Test
    void shouldReturn11WhenAdd11OnZeroIndex() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 4;


        //then
        assertEquals(expectedSizeBefore, list.size());
        list.add(0, 11);
        assertEquals(11, list.get(0));
        assertEquals(expectedSizeAfter, list.size());
    }

    @Test
    void shouldReturn11WhenAdd11On2Index() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);


        //when
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 4;


        //then
        assertEquals(expectedSizeBefore, list.size());
        list.add(2, 11);
        assertEquals(11, list.get(2));
        assertEquals(expectedSizeAfter, list.size());

    }

    @Test
    void shouldReturnExceptionWhenAddElementOnWrongIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(15, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-5, 5));
    }

    @Test
    void shouldRemoveElementFromIndex1() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;

        //then
        assertEquals(expectedSizeBefore, list.size());
        assertEquals(6, list.remove(1));
        assertEquals(99, list.get(1));
        assertEquals(expectedSizeAfter, list.size());

    }

    @Test
    void shouldRemoveElementFromIndex2() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;

        //then
        assertEquals(expectedSizeBefore, list.size());
        assertEquals(99, list.remove(2));
        assertEquals(expectedSizeAfter, list.size());

    }

    @Test
    void shouldRemoveElementFromIndex0() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;

        //then
        assertEquals(expectedSizeBefore, list.size());
        assertEquals(5, list.remove(0));
        assertEquals(6, list.get(0));
        assertEquals(expectedSizeAfter, list.size());

    }

    @Test
    void shouldReturnExceptionWhenTryToRemoveFromEpmtyList() {
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> list.remove(0));
        assertThrows(NoSuchElementException.class, () -> list.remove(3));
    }

    @Test
    void shouldReturnExceptionWhenTryToRemoveFromWrongIndex() {

        //given
        list.add(5);

        //then
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void shouldReturnIndexZeroOfElement5() {

        //given
        list.add(5);
        list.add(6);
        list.add(7);

        //when
        assertEquals(0, list.indexOf(5));

    }

    @Test
    void shouldReturnIndex1OfElement6() {

        //given
        list.add(5);
        list.add(6);
        list.add(7);

        //when
        assertEquals(1, list.indexOf(6));

    }

    @Test
    void shouldReturnIndex2OfElement7() {

        //given
        list.add(5);
        list.add(6);
        list.add(7);

        //when
        assertEquals(2, list.indexOf(7));

    }

    @Test
    void shouldReturnZeroWhenTryToGetElementFromEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(-1, list.indexOf(5));
    }

    @Test
    void shouldReturnZeroWhenTryToGetElementFromWrongIndex() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //then
        assertEquals(-1, list.indexOf(7));
    }

    @Test
    void shouldReturnSpecifiedElement() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        Iterator<Integer> itr = list.iterator();

        //then
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), itr.next());
        }

    }

    @Test
    void shouldReturnTrue() {

        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        Iterator<Integer> itr = list.iterator();

        //then
        assertTrue(itr.hasNext());
    }

    @Test
    void shouldCheckIfFirstElementIsRemoved() {
        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        Iterator<Integer> itr = list.iterator();

        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                itr.remove();
        }

        //then
        assertEquals(6, list.get(0));
    }

    @Test
    void shouldCheckIfSecondElementIsRemoved() {
        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        Iterator<Integer> itr = list.iterator();

        for (int i = 0; i < list.size(); i++) {
            if (i == 1)
                itr.remove();
        }

        //then
        assertEquals(99, list.get(1));
    }

    @Test
    void shouldCheckIfThirdElementIsRemoved() {
        //given
        list.add(5);
        list.add(6);
        list.add(99);

        //when
        Iterator<Integer> itr = list.iterator();

        for (int i = 0; i < list.size(); i++) {
            if (i == 2)
                itr.remove();
        }

        //then
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

}