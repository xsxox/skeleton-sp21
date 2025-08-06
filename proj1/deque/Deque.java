package deque;

//
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    default boolean isEmpty(){//isEmpty的默认实现
        return size()==0;
    }
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
