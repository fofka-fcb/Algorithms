package org.example.MyLinkedList;

public class MyLinkedList {

    private Node head;

    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Object o) {
        Node curNode = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (curNode.getValue().equals(o)) {
                    return true;
                }
                curNode = curNode.getNext();
            }
        }
        return false;
    }

    public boolean add(Object o) {
        Node resNode = new Node(o, null);
        if (head == null) {
            head = resNode;
            size++;
        } else {
            Node curNode = head;
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(resNode);
            size++;
        }
        return true;
    }

    public boolean remove(Object o) {
        if (head.getValue().equals(o)) {
            if (head.getNext() == null) {
                head = null; // "Stroka1" = null
            } else {
                head = head.getNext(); // "Stroka1" = "Stroka2" -> "Stroka2", "Stroka3", "Stroka4", null.
            }
            size--;
            return true;
        } else {
            Node nowNode = head; // nowNode = "Stroka1"
            Node andNode = head; // andNode = "Stroka1"
            while ((nowNode = nowNode.getNext()) != null) { // 1 - 2 - 3 - 4
                //nowNode = "Stroka4"
                if (nowNode.getValue().equals(o)) {
                    break;
                }
                andNode = andNode.getNext(); // 1 - 2 - 3
                //andNode = "Stroka3"
            }
            if (nowNode.getNext() == null) {
                andNode.setNext(null); // nowNode = null
            } else {
                andNode.setNext(nowNode.getNext()); // ("Stroka2" -> "Stroka4", "Stroka3" = null
            }
            size--;
            return true;
        }
    }

    public void clear() {
        Node nowNode = head;
        Node lastNode = head;
        for (int i = 0; i < size; i++) {
            nowNode = nowNode.getNext();
            lastNode.setValue(null);
            lastNode.setNext(null);
            lastNode = nowNode;
        }
        head = null;
        size = 0;
    }

    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.getValue();
        } else {
            int count = 0;
            Node nowNode = head; // nowNode = "Stroka1"
            while ((nowNode = nowNode.getNext()) != null) {
                count++;
                if (count == index) {
                    break;
                }
            }
            Object resValue = nowNode.getValue();
            return resValue;
        }
    }

    public Object set(int index, Object element) {
        checkIndex(index);
        Node nowNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                nowNode.setValue(element);
                return nowNode;
            }
            nowNode = nowNode.getNext();
        }
        return nowNode;
    }

    public void add(int index, Object element) {
        checkIndex(index);
        Node resNode = new Node(element, null);
        Node nowNode = head;
        Node andNode = head;
        if (head == null) {
            head = resNode;
            size++;
        } else if (index == 0) {
            head = resNode;
            resNode.setNext(nowNode);
            size++;
        } else {
            int count = 0;
            while ((nowNode = nowNode.getNext()) != null) {
                count++;
                if (count == index) {
                    break;
                }
                andNode = andNode.getNext();
            }
            andNode.setNext(resNode);
            resNode.setNext(nowNode);
            size++;
        }
    }

    public Object remove(int index) {
        checkIndex(index);
        if (size == 0) {
            return null;
        } else if (index == 0) {
            Object resValue = head.getValue(); // resValue = "Stroka1"
            if (head.getNext() == null) {
                head = null; // "Stroka1" = null
            } else {
                head = head.getNext(); // "Stroka1" = "Stroka2" -> "Stroka2", "Stroka3", "Stroka4", null.
            }
            size--;
            return resValue;
        } else {
            // index = 3
            int count = 0;
            Node nowNode = head; // nowNode = "Stroka1"
            Node andNode = head; // andNode = "Stroka1"
            while ((nowNode = nowNode.getNext()) != null) { // 1 - 2 - 3 - 4
                //nowNode = "Stroka4"
                count++; // 0 - 1 - 2 - 3
                if (count == index) {
                    break;
                }
                andNode = andNode.getNext(); // 1 - 2 - 3
                //andNode = "Stroka3"
            }
            Object resValue = nowNode.getValue(); // resValue = "Stroka4"
            if (nowNode.getNext() == null) {
                andNode.setNext(null); // nowNode = null
            } else {
                andNode.setNext(nowNode.getNext()); // (index = 2): "Stroka2" -> "Stroka4", "Stroka3" = null
            }
            size--;
            return resValue;
        }
    }

    private void checkIndex(int index) {
        if (!isCorrectIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс");
        }
    }

    private boolean isCorrectIndex(int index) {
        if ((index > -1) && (index <= size())) {
            return true;
        }
        return false;
    }

    public int indexOf(Object o) {
        Node nowNode = head;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (nowNode.getValue().equals(o)) {
                return count;
            }
            count++;
            nowNode = nowNode.getNext();
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node nowNode = head;
        int indexOfLastNode = 0;
        for (int i = 0; i < size; i++) {
            if (nowNode.getValue().equals(o)) {
                indexOfLastNode = i;
            }
            nowNode = nowNode.getNext();
        }
        return indexOfLastNode;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}
