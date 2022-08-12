package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Animal chicken;
    private Animal lion;
    private Farm testFarm;

    @Before
    public void setup() {
        chicken = new Animal("chicken", 1);
        lion = new Animal("lion", 10);
        testFarm = new Farm("SoftUni", 15);
    }

    @Test
    public void testShouldCreateFarmSuccess() {
        Farm farm = new Farm("SoftUni", 15);
        Assert.assertEquals("SoftUni", farm.getName());
        Assert.assertEquals(15, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionBecauseNameIsNull() {
        new Farm(null, 15);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionBecauseNameIsWhiteSpace() {
        new Farm("  ", 15);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionBecauseNameIsEmpty() {
        new Farm("", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowExceptionBecauseCapacityIsNegative() {
        new Farm("SoftUni", -15);
    }

    //1. Add success
    //2. Add exception -> capacity too low (2, 2)
    //3. Add exception -> animal exists
    @Test
    public void testAddShouldAddSuccess() {
        testFarm.add(lion);
        Assert.assertEquals(1, testFarm.getCount());
        testFarm.add(chicken);
        Assert.assertEquals(2, testFarm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowBecauseOfNoCapacity() {
        Farm farm = new Farm("SoftUni", 1);
        farm.add(lion);
        farm.add(chicken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowBecauseOfDuplicateAnimal() {
        testFarm.add(lion);
        testFarm.add(lion);
    }

    //remove -> don't remove and return false
    @Test
    public void testRemoveShouldRemove() {
        testFarm.add(lion);
        Assert.assertTrue(testFarm.remove(lion.getType()));
        Assert.assertEquals(0, testFarm.getCount());
    }

    //remove -> remove and return true
    @Test
    public void testRemoveShouldNotRemove() {
        testFarm.add(lion);
        Assert.assertFalse(testFarm.remove(chicken.getType()));
        Assert.assertEquals(1, testFarm.getCount());
    }


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
}
