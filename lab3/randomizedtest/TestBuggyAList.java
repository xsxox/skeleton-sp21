package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Created by hug.
 */
public class TestBuggyAList {
@Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);

        broken.addLast(4);
        broken.addLast(5);
        broken.addLast(6);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest(){
    AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bug = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0,4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bug.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int L_size = L.size();
                int bug_size = bug.size();
                assertEquals(L.size(), bug.size());
            } else if (operationNumber == 2) {
                //getLast
                if(L.size()==0){continue;}
                else {
                    int L_last = L.getLast();
                    int bug_last = bug.getLast();
                    assertEquals(L_last, bug_last);
                }
            } else if (operationNumber == 3) {
                //removeLast
                if(L.size()==0){continue;}
                else {
                   int L_remove = L.removeLast();
                   int bug_remove = bug.removeLast();
                    assertEquals(L_remove, bug_remove);
                }
            }
        }
    }
}
