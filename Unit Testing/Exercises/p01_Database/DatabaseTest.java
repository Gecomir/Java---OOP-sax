package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {1, 5, 2, 34, 56, 73};

    @Before
    public void prepare() throws OperationNotSupportedException {
        Integer[] numbers = {1, 5, 2, 34, 56, 73};
        database = new Database(numbers);
    }

    @Test
    public void testCreateDatabase() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length, dbElements.length);
        Assert.assertArrayEquals(NUMBERS, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Argument() throws OperationNotSupportedException {
        Integer[] arrayEmpty = new Integer[0];
        new Database(arrayEmpty);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan16Arguments() throws OperationNotSupportedException {
        Integer[] bigInteger = new Integer[17];
        new Database(bigInteger);
    }

    @Test
    public void testAddSuccess() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.add(12);
        Integer[] dbElements = database.getElements();
        int lastElementsFromDB = dbElements[dbElements.length - 1];
        Assert.assertEquals(12, lastElementsFromDB);
        Assert.assertEquals(initialSize + 1, dbElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveSuccess() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();

        Integer[] currentElements = database.getElements();
        Assert.assertEquals(initialSize - 1, currentElements.length);

        int secondToLastBeforeRemove = NUMBERS[NUMBERS.length - 2];
        int lastElementAfterRemove = currentElements[currentElements.length - 1];
        Assert.assertEquals(secondToLastBeforeRemove, lastElementAfterRemove);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}
