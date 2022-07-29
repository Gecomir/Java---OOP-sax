package p04_BubbleSortTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testSort() {
        int[] numbers = {5, 2, 24, 12, 4, 57};
        Bubble.sort(numbers);
        int[] arraySorted = {2, 4, 5, 12, 24, 57};
        Assert.assertArrayEquals(arraySorted, numbers);
    }
}