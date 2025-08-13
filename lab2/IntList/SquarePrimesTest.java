package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void SquarePrimeTest(){
        IntList lst = IntList.of(1,2,3,4,5,6,7);
        boolean channged = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 4 -> 9 -> 4 -> 25 -> 6 -> 49",lst.toString());
        assertTrue(channged);
    }

}
