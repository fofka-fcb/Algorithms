package org.example.MyLinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс MyLinkedList должен: ")
public class MyLinkedListTest {

    @DisplayName("Корректно вызывать длину списка")
    @Test
    public void shouldHaveCorrectSize() {
        MyLinkedList list = new MyLinkedList();
        assertEquals(0, list.size());
    }

    @DisplayName("Корректно проверять пустой ли список")
    @Test
    public void shouldHaveCorrectIsEmpty() {
        MyLinkedList list = new MyLinkedList();
        Assertions.assertTrue(list.isEmpty());
        list.add("1");
        Assertions.assertFalse(list.isEmpty());
    }

    @DisplayName("Корректно проверять наличие объекта в списке")
    @Test
    public void shouldHaveCorrectContains() {
        MyLinkedList list = new MyLinkedList();
        Assertions.assertFalse(list.contains("1"));
        list.add("1");
        Assertions.assertTrue(list.contains("1"));
    }

    @DisplayName("Корректно добавлять элемент в список")
    @Test
    public void shouldHaveCorrectAdd() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        assertEquals("1", list.get(0));
        assertAll(() -> assertEquals("1", list.get(0)),
                () -> assertEquals(1, list.size()));
    }

    @DisplayName("Корректно удалять объект из списка")
    @Test
    public void shouldHaveCorrectRemove() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.remove("1");
        assertAll(() -> assertEquals(0, list.size()),
                () -> assertFalse(list.contains("1")));
    }

    @DisplayName("Корректно полностью удалять содержимое списка")
    @Test
    public void shouldHaveCorrectClear() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("1");
        list.add("1");
        list.clear();
        assertAll(() -> assertFalse(list.contains("1")),
                () -> assertEquals(0, list.size()));
    }

    @DisplayName("Корректно выводить нужный элемент из списка")
    @Test
    public void shouldHaveCorrectGet() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
    }

    @DisplayName("Корректно устанавливать новый элемент взамен старого")
    @Test
    public void shouldHaveCorrectSet() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        int size = list.size();
        list.set(0, "15");
        assertAll(() -> assertEquals(size, list.size()),
                () -> assertEquals("15", list.get(0)));
    }

    @DisplayName("Корректно добавлять новый элемент по индексу")
    @Test
    public void shouldHaveCorrectAddByIndex() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        int size = list.size();
        list.add(0, "167");
        assertAll(() -> assertEquals(size + 1, list.size()),
                () -> assertEquals("167", list.get(0)));
    }

    @DisplayName("Корректно удалять объект из списка по индексу")
    @Test
    public void shouldHaveCorrectRemoveByIndex() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        int size = list.size();
        list.remove(0);
        assertAll(() -> assertEquals(size - 1, list.size()),
                () -> assertFalse(list.contains("1")));
    }

    @DisplayName("Корректно возвращаеть индекс в данном списке первого вхождения указанного символа")
    @Test
    public void shouldHaveCorrectIndexOf() {
        MyLinkedList list = new MyLinkedList();
        list.add("2");
        list.add("1");
        list.add("6");
        list.add("1");
        list.add("3");
        list.add("1");
        list.add("3");
        list.add("14");
        assertEquals(1, list.indexOf("1"));
    }

    @DisplayName("Корректно возвращаеть индекс в данном списке последнего вхождения указанного символа")
    @Test
    public void shouldHaveCorrectLastIndexOf() {
        MyLinkedList list = new MyLinkedList();
        list.add("2");
        list.add("1");
        list.add("6");
        list.add("1");
        list.add("3");
        list.add("1");
        list.add("3");
        list.add("14");
        assertEquals(5, list.lastIndexOf("1"));
    }

}


