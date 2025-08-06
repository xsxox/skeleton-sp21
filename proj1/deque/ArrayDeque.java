package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{

    private T[] DA;
    int size=0;//值的个数
    int length=8; //初始数组长度为8
    int head=5; //初始head;

    public ArrayDeque(){

        DA = (T[]) new Object[length];
        size = 0;
    }

    private void capacitor(){
        /*数组扩容方法，名字来源于故障机器人的扩容卡牌
       用for循环实现等效于 DA = Arrays.copyOf(DA,length*2) 的数组扩容，并且控制数组元素的索引
       例如6 7 8 1(h) 2 3 4 5 -> nul nul nul 1(h) 2 3 4 5 6 7 8 nul nul nul nul*/

        int moreLength = length*2;
        T[] newDA = (T[]) new Object[moreLength];
        for(int i = 0;i<size;i++){
            newDA[head+i]=DA[(head+i)%length];
        }
        DA=newDA;
        length= moreLength;
    }

    private void consume(){
        /*来源于卡牌耗尽
          实现数组缩容
         */
        int lessLength = length/4;
        T[] newDA = (T[]) new Object[lessLength];
        for(int i = 0;i<size;i++){
            newDA[i]=DA[(head+i)%length];
        }
        DA=newDA;
        length=lessLength;
        head=0;
    }

    //需注意head变化
    @Override
    public void addFirst(T item) {

        if(size>=length){
            capacitor();
        }
            head = (head - 1 + length) % length;
            DA[head]=item;
            size++;
    }

    //addLast无head变化
    @Override
    public void addLast(T item) {

        if(size>=length){
            capacitor();//扩容
        }
            DA[(head+size)%length]=item;
            size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for(int i=head;i<size+head;i++){
            System.out.print(DA[i%length]);
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) return null;
        else{
            if (size < length / 4) {
                consume();
            }
            T tmp = DA[head];
            DA[head] = null;
            head = (head + 1) % length;
            size--;
            return tmp;
        }
    }

    @Override
    public T removeLast() {
        if(isEmpty()) return null;
        else{
            if(size < length/4){
                consume();
            }
            T tmp = DA[(head+size-1)%length];
            DA[(head+size-1)%length] = null;
            size--;
            return tmp;
        }
    }

    @Override
    public T get(int index) {
        //illegal index returns to null;
        if (index>size-1 || index < 0) return null;
        else return DA[(head+index)%length];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    protected class ArrayDequeIterator implements Iterator<T> {
        int ptr=0;

        public boolean hasNext() {
            return ptr<size;
        }

        public T next() {
            // 如果没有下一个元素，抛出异常
            if (!hasNext()) {
                throw new NoSuchElementException("没有更多元素");
            }

            // 计算实际索引
            int Index = (head + ptr) % length;
            T item = DA[Index];
            ptr++;
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

        for (int i = 0; i < size; i++) {
            T thisElem = DA[(head + i) % length];
            Object otherElem = other.get(i);
            if (!Objects.equals(thisElem, otherElem)) {
                return false;
            }
        }
        return true;
    }
}
