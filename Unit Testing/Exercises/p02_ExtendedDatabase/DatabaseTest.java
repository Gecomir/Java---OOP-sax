package p02_ExtendedDatabase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        Person person1 = new Person(123, "Gosho");
        Person person2 = new Person(456, "Vaqna");
        database = new Database(person1, person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullShouldThrow() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsernameSuccess() throws OperationNotSupportedException {
        Person person = database.findByUsername("Gosho");
        Assert.assertEquals("Gosho", person.getUsername());
        Assert.assertEquals(123, person.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameMissing() throws OperationNotSupportedException {
        database.findByUsername("Simona");
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        Person person = database.findById(456);
        Assert.assertEquals(456, person.getId());
        Assert.assertEquals("Vaqna", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByMissingId() throws OperationNotSupportedException {
        database.findById(222);
    }

}