package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        private Node last;
        private T item;
        private Node next;

        Node() {
            item = null;
            last = next = null;
        }

        Node(Node p, T i, Node n) {
            this.last = p;
            this.item = i;
            this.next = n;
        }
    }

    private int size;
    private Node head;
    private Node tail;


    public LinkedListDeque() {
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.last = head;
    }

//前  值  后
    @Override
    public void addFirst(T item) {
        Node tmp = new Node(head, item, head.next);
        head.next.last = tmp;
        head.next = tmp;
        size ++;
    }

    @Override
    public void addLast(T item) {
        Node tmp = new Node(tail.last, item, tail);
        tail.last.next = tmp;
        tail.last = tmp;
        size ++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = head.next;
        while (p != tail) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if(size==0) return null;
        else {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.last = head;
            size = size - 1;
            return (T) tmp.item;
        }
    }


    @Override
    public T removeLast() {
        if(size==0) return null;
        else {
            Node tmp = tail.last;
            tail.last = tail.last.last;
            tail.last.next = tail;
            size = size - 1;
            return (T) tmp.item;
        }
    }

    @Override
    public T get(int index) {
        Node p = head.next;
        while (p != tail && index > 0) {
            p = p.next;
            index--;
        }
        return (index == 0) ? (T) p.item : null;
    }


    public T getRecursive(int index) {
        return getRecursiveHelper(head.next, index);
    }

    private T getRecursiveHelper(Node p, int index) {
        if (p == tail) {
            return null;
        }
        if (index == 0) {
            return (T) p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }


    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node ptr;
        LinkedListDequeIterator() {
            ptr = head.next;
        }
        public boolean hasNext() {
            return (ptr != tail);
        }
        public T next() {
            T item = (T) ptr.item;
            ptr = ptr.next;
            return item;
        }
    }


    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque other = (Deque) o;
        if (size != other.size()) {
            return false;
        }

        Node p = head.next;
        for (int i = 0; i < size; i++) {
            if (!p.item.equals(other.get(i))) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
