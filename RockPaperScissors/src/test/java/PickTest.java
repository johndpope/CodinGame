/**
 * Coded by Fernando on 22/12/2016.
 */

import me.fernandodoming.rps.models.Pick;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PickTest {

    @Test
    public void rockBeatsScissors() {
        Pick rock = Pick.ROCK;
        Pick scissors = Pick.SCISSORS;

        assertEquals("Rock should beat scissors", true, rock.beats(scissors));
    }

    @Test
    public void paperBeatsRock() {
        Pick rock = Pick.ROCK;
        Pick paper = Pick.PAPER;

        assertEquals("Paper should beat rock", true, paper.beats(rock));
    }

    @Test
    public void scissorsBeatsPaper() {
        Pick paper = Pick.PAPER;
        Pick scissors = Pick.SCISSORS;

        assertEquals("Rock should beat scissors", true, scissors.beats(paper));
    }

    @Test
    public void tie() {
        Pick rock = Pick.ROCK;
        Pick anotherRock = Pick.ROCK;

        assertEquals("Rock should not beat rock", false, rock.beats(anotherRock));
    }

    @Test
    public void paperBeatsScissors() {
        Pick paper = Pick.PAPER;
        Pick scissors = Pick.SCISSORS;

        assertEquals("Paper should not beat scissors", false, paper.beats(scissors));
    }

    @Test
    public void pickRockFromRawValue() {
        assertEquals(Pick.ROCK, Pick.valueOf(1));
    }

    @Test
    public void pickFromInvalidRawValue() {
        assertEquals(null, Pick.valueOf(7));
    }

    @Test
    public void pickRandom() {
        assertNotNull("A random pick should not return null", Pick.getRandom());
    }

}
