package unit.misc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 28.10.2014.
 *
 */
public class TestMemoryUsage {
    @Test
    public void test() {
        int[] ints = new int[100000000];
        /*for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }*/

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException ie) {
            System.err.println("InterruptedException occured: " + ie.getMessage());
        }
    }
}
