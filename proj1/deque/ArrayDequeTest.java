package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addTest() {
        //suppose to be 1 2 3 4 5 6 7 8 9 10 11 12
        //size == 12
        ArrayDeque<Integer> Da = new ArrayDeque<>();
        assertTrue(Da.isEmpty());//数组为空
        Da.addFirst(7);
        Da.addFirst(6);
        Da.addFirst(5);
        Da.addLast(8);
        Da.addLast(9);
        Da.addLast(10);
        Da.addLast(11);
        Da.addLast(12);
        Da.addFirst(4);
        Da.addFirst(3);
        Da.addFirst(2);
        Da.addFirst(1);
        Da.printDeque();
        System.out.print("size == " + Da.size());
        assertFalse(Da.isEmpty());//数组非空
    }

    @Test
    public void removeFirstTest() {
        /*suppose to be
        1 2 3 4 5 6 7 8 9 10 11 12
        length == 16
        11 12
        length == 4
         */
        ArrayDeque<Integer> Da = new ArrayDeque<>();
        Da.addFirst(7);
        Da.addFirst(6);
        Da.addFirst(5);
        Da.addLast(8);
        Da.addLast(9);
        Da.addLast(10);
        Da.addLast(11);
        Da.addLast(12);
        Da.addFirst(4);
        Da.addFirst(3);
        Da.addFirst(2);
        Da.addFirst(1);
        Da.printDeque();
        System.out.print("Length == " + Da.length);
        System.out.println();

        for (int i = 0; i < 9; i++) {
            Da.removeFirst();
        }
        assertEquals(Da.removeFirst(), Integer.valueOf(10));//测试返回值
        Da.printDeque();
        System.out.print("Length == " + Da.length);//对比数组长度
    }


    @Test
    public void removeLastTest(){
        /*suppose to be
        1 2 3 4 5 6 7 8 9 10 11 12
        length == 16
        1 2
        DA[0]== 1
        DA[1]== 2
        DA[2]== null
        length == 4
         */
        ArrayDeque<Integer> Da = new ArrayDeque<>();
        Da.addFirst(7);
        Da.addFirst(6);
        Da.addFirst(5);
        Da.addLast(8);
        Da.addLast(9);
        Da.addLast(10);
        Da.addLast(11);
        Da.addLast(12);
        Da.addFirst(4);
        Da.addFirst(3);
        Da.addFirst(2);
        Da.addFirst(1);
        Da.printDeque();
        System.out.print("Length == " + Da.length);
        System.out.println();

        for (int i = 0; i < 9; i++) {
            Da.removeLast();
        }
        assertEquals(Da.removeLast(), Integer.valueOf(3));//测试返回值
        Da.printDeque();
        System.out.println("DA[0]== " + Da.get(0));
        System.out.println("DA[1]== " + Da.get(1));
        System.out.println("DA[2]== " + Da.get(2));
        System.out.println("DA[-1]== " + Da.get(-1));
        System.out.println("Length == " + Da.length);//对比数组长度
    }
}
