import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String test = "Hamlet likes ham with hams";
        String wordToFind = "Hamlet";
        String wordtoChange = "Leon";

        String expected = "Leon likes ham with hams";
        HamletParser hamletParser = new HamletParser();
        String actual = hamletParser.replace(wordToFind, wordtoChange, test);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testChangeHoratioToTariq() {
        String test = "Horatio likes ham with hams";
        String wordToFind = "Horatio";
        String wordtoChange = "Tariq";

        String expected = "Tariq likes ham with hams";
        HamletParser hamletParser = new HamletParser();
        String actual = hamletParser.replace(wordToFind, wordtoChange, test);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
    String test = "Horatio has a ratio of two";
    String wordToFind = "Horatio";
    Boolean expected = false;

    Boolean actual = hamletParser.find(test,wordToFind);

    Assert.assertEquals(expected ,actual);


    }

    @Test
    public void testFindHamlet() {
        String test = "Hamlet has a ratio of two";
        String wordToFind = "Hamlet";
        Boolean expected = false;

        Boolean actual = hamletParser.find(test,wordToFind);

        Assert.assertEquals(expected ,actual);


    }
}