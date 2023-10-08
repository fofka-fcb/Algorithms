package org.example.MyArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс MyArrayList должен: ")
public class MyArrayListTest {

    @DisplayName("Корректно вызывать длину массива")
    @Test
    public void shouldHaveCorrectSize() {

        MyArrayList list = new MyArrayList();
        assertEquals(0, list.size());

    }

    @DisplayName("Корректно проверять пустой ли массив")
    @Test
    public void shouldHaveCorrectIsEmpty() {

        MyArrayList list = new MyArrayList();
        Assertions.assertTrue(list.isEmpty());
        list.add("1");
        Assertions.assertFalse(list.isEmpty());

    }

    @DisplayName("Корректно проверять наличие объекта в массиве")
    @Test
    public void shouldHaveCorrectContains() {

        MyArrayList list = new MyArrayList();
        Assertions.assertFalse(list.contains("1"));
        list.add("1");
        Assertions.assertTrue(list.contains("1"));

    }

    @DisplayName("Корректно добавлять элемент в массив")
    @Test
    public void shouldHaveCorrectAdd() {

        MyArrayList list = new MyArrayList();
        list.add("1");
        assertEquals("1", list.get(0));
        assertAll(() -> assertEquals("1", list.get(0)),
                () -> assertEquals(1, list.size()));

    }

    @DisplayName("Корректно удалять объект из массива")
    @Test
    public void shouldHaveCorrectRemove() {

        MyArrayList list = new MyArrayList();
        list.add("1");
        list.remove("1");
        assertEquals(0, list.size());
    }

    @DisplayName("Корректно полностью удалять содержимое массива")
    @Test
    public void shouldHaveCorrectClear() {

        MyArrayList list = new MyArrayList();
        list.add("1");
        list.add("1");
        list.add("1");
        list.clear();
        assertAll(() -> assertFalse(list.contains("1")),
                () -> assertEquals(0, list.size()));

    }

    @DisplayName("Корректно выводить нужный элемент из массива")
    @Test
    public void shouldHaveCorrectGet() {
        MyArrayList list = new MyArrayList();
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
        MyArrayList list = new MyArrayList();
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
        MyArrayList list = new MyArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        int size = list.size();
        list.add(0, "167");
        assertAll(() -> assertEquals(size + 1, list.size()),
                () -> assertEquals("167", list.get(0)));
    }

    @DisplayName("Корректно удалять объект из массива по индексу")
    @Test
    public void shouldHaveCorrectRemoveByIndex() {
        MyArrayList list = new MyArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        int size = list.size();
        list.remove(0);
        assertAll(() -> assertEquals(size - 1, list.size()),
                () -> assertFalse(list.contains("1")));
    }

    @DisplayName("Корректно возвращаеть индекс в данном массиве первого вхождения указанного символа")
    @Test
    public void shouldHaveCorrectIndexOf() {
        MyArrayList list = new MyArrayList();
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

    @DisplayName("Корректно возвращаеть индекс в данном массиве последнего вхождения указанного символа")
    @Test
    public void shouldHaveCorrectLastIndexOf() {
        MyArrayList list = new MyArrayList();
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

