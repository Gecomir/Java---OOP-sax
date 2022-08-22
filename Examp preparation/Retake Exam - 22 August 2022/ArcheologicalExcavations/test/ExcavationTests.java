package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Archaeologist archaeologist;
    private Excavation excavation;

    @Test
    public void testNoCapacity() {
        int expected = 0;
        excavation = new Excavation("Name", 1);

        int result = excavation.getCount();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetName() {
        String expected = "Name";
        excavation = new Excavation("Name", 1);

        String result = excavation.getName();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetCapacity() {
        int expected = 1;
        excavation = new Excavation("Name", 1);

        int result = excavation.getCapacity();

        Assert.assertEquals(expected,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityError() {
        excavation = new Excavation("Name", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameEmptyError() {
        excavation = new Excavation("", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNullError() {
        excavation = new Excavation(null, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistNoCapacity() {
        archaeologist = new Archaeologist("ArchName", 20);
        excavation = new Excavation("Name", 0);

        excavation.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistExists() {
        archaeologist = new Archaeologist("ArchName", 20);
        excavation = new Excavation("Name", 5);

        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testAddArchaelogist() {
        int expected = 1;
        excavation = new Excavation("Name", 1);
        archaeologist = new Archaeologist("ArchName", 20);
        excavation.addArchaeologist(archaeologist);

        int result = excavation.getCapacity();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testRemoveArchaelogist() {
        boolean expected = true;
        excavation = new Excavation("Name", 5);
        archaeologist = new Archaeologist("ArchName", 20);
        excavation.addArchaeologist(archaeologist);

        boolean result = excavation.removeArchaeologist("ArchName");

        Assert.assertEquals(expected,result);
    }
}
