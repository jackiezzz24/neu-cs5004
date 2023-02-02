import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import artists.IArtist;
import artists.Actor;
import artists.Musician;
import artists.Poet;

import static org.junit.Assert.*;

public class IArtistTest {
    String [] genre1 = {"Action", "SciFi", "Drama"};
    String [] genre2 = {"Rock", "Rock-Soul"};
    String [] genre3 = {"Comedy", "Romantic Comedy"};
    String [] genre4 = {"R&B", "Pop", "Rap"};
    String [] genre5 = {"Autobiographical Fiction"};

    String [] awards = {"Academy Award", "Golden Globe"};
    String [] awards2 = {"Pulitzer"};
    String [] awards3 = {"Emmy", "People's Choice"};
    String [] awards4 = {"Grammy", "American Music Award"};
    String [] awards5 = {"Grammy", "Billboard"};

    String [] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
    String [] movies3 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

    IArtist denzel;
    IArtist melissa;
    IArtist musician;
    IArtist musician2;
    IArtist poet;

    @Before
    public void setUp() throws Exception {
        denzel = new Actor("Denzel Washington", 67, genre1, awards, movies);
        melissa = new Actor("Melissa McCarthy", 52, genre3, awards3, movies3);

        musician = new Musician("Bruce Springsteen", 73, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");

        musician2 = new Musician("Lizzo", 34, genre4, awards5,
                "Special", "Atlantic Records");
        poet = new Poet("Maya Angelou", 86, genre5, awards2, "Random House");
    }

    @Test
    public void testCreatedInstances() {
        String test = "My name is Denzel Washington\n" +
                "My age is 67\n" +
                "I am an ACTOR\n" +
                "I make these types of movies: [Action, SciFi, Drama]\n" +
                "I have acted in these movies: [Glory, Flight, Training Day, Book of Eli, Fences]";
        assertTrue(denzel.toString().equalsIgnoreCase(test));


        test = "My name is Melissa McCarthy\n" +
                "My age is 52\n" +
                "I am an ACTOR\n" +
                "I make these types of movies: [Comedy, Romantic Comedy]\n" +
                "I have acted in these movies: [Bridesmaids, Tammy, Life of the Party, Ghostbusters]";
        assertTrue(melissa.toString().equalsIgnoreCase(test));

        test = "My name is Bruce Springsteen\n" +
                "My age is 73\n" +
                "I am an MUSICIAN\n" +
                "I make these types of music: [Rock, Rock-Soul]\n" +
                "My current album is: Only the Strong Survive\n" +
                "My recording company is: Columbia Records";
        assertTrue(musician.toString().equalsIgnoreCase(test));

        test = "My name is Lizzo\n" +
                "My age is 34\n" +
                "I am an MUSICIAN\n" +
                "I make these types of music: [R&B, Pop, Rap]\n" +
                "My current album is: Special\n" +
                "My recording company is: Atlantic Records";
        assertTrue(musician2.toString().equalsIgnoreCase(test));

        test = "My name is Maya Angelou\n" +
                "My age is 86\n" +
                "I am an POET\n" +
                "I make these types of poems: [Autobiographical Fiction]\n" +
                "My publishing company is: Random House";
        assertTrue(poet.toString().equalsIgnoreCase(test));
    }

    @Test
    public void testReceiveAward() {
        String [] testAwards = {"Pulitzer", "Tony"};
        poet.receiveAward("Tony");
        assertTrue(Arrays.equals(poet.getAwards(),testAwards));
    }

    @Test
    public void testGetAwards() {
        String [] testAwards = {"Academy Award", "Golden Globe"};
        assertTrue(Arrays.equals(denzel.getAwards(), testAwards));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadAge() {
        IArtist a = new Musician("Bruce Springsteen", 129, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadAge2() {
        IArtist a = new Musician("Bruce Springsteen", -1, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadName() {
        IArtist a = new Musician(null, 10, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadName2() {
        IArtist a = new Musician("", 10, genre2, awards4,
                "Only the Strong Survive", "Columbia Records");
    }
}