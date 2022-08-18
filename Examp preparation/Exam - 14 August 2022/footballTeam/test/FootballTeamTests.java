package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private Footballer first;

    @Before
    public void setUp() {
        footballTeam = new FootballTeam("Test", 2);
        first = new Footballer("George");
        footballTeam.addFootballer(first);
    }

    @Test(expected = NullPointerException.class)
    public void create_Team_With_Empty_Name() {
        FootballTeam footballTeam = new FootballTeam(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_Team_With_Negative_Vacant_Position() {
        FootballTeam footballTeam = new FootballTeam("Test", -3);
    }

    @Test
    public void get_Vacant_Positions() {
        int actual = footballTeam.getVacantPositions();

        Assert.assertEquals(2, actual);
    }

    @Test
    public void getCount() {
        int actual = footballTeam.getCount();
        Assert.assertEquals(1, actual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void add_In_Full_Team(){
        Footballer second = new Footballer("Ivan");
        Footballer third = new Footballer("Stoyan");

        footballTeam.addFootballer(second);
        footballTeam.addFootballer(third);

    }
    @Test
    public void remove_Existing_Footballer(){
        footballTeam.removeFootballer("George");

        int actual = footballTeam.getCount();

        Assert.assertEquals(0, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_Non_Existing_Footballer(){
        footballTeam.removeFootballer("Ivan");
    }

    @Test
    public void sale_Existing_Footballer(){
        Footballer footballer = footballTeam.footballerForSale("George");

        Assert.assertEquals("George", footballer.getName());
        Assert.assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sale_Non_Existing_Footballer(){
        Footballer footballer = footballTeam.footballerForSale("Ivan");
    }

    @Test
    public void getStatistic(){
        String expected = "The footballer George is in the team Test.";
        String actual = footballTeam.getStatistics();

        Assert.assertEquals(expected, actual);
    }
}
