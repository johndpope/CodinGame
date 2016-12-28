import me.fernandodoming.rps.models.Game;
import me.fernandodoming.rps.models.Pick;
import me.fernandodoming.rps.models.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Coded by Fernando on 22/12/2016.
 */
public class PlayerTest {

    @Test
    public void rockBeatsScissors() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.SCISSORS);

        assertEquals("Rock should beat scissors", Game.GameResult.WIN, p1.playWith(p2));
    }

    @Test
    public void paperBeatsRock() {
        Player p1 = new Player(Pick.PAPER);
        Player p2 = new Player(Pick.ROCK);

        assertEquals("Rock should beat scissors", Game.GameResult.WIN, p1.playWith(p2));
    }

    @Test
    public void scissorsBeatsPaper() {
        Player p1 = new Player(Pick.SCISSORS);
        Player p2 = new Player(Pick.PAPER);

        assertEquals("Rock should beat scissors", Game.GameResult.WIN, p1.playWith(p2));
    }

    @Test
    public void rockTie() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.ROCK);

        assertEquals("Rock should beat scissors", Game.GameResult.TIE, p1.playWith(p2));
    }

    @Test
    public void scissorsTie() {
        Player p1 = new Player(Pick.SCISSORS);
        Player p2 = new Player(Pick.SCISSORS);

        assertEquals("Rock should beat scissors", Game.GameResult.TIE, p1.playWith(p2));
    }

    @Test
    public void paperTie() {
        Player p1 = new Player(Pick.PAPER);
        Player p2 = new Player(Pick.PAPER);

        assertEquals("Rock should beat scissors", Game.GameResult.TIE, p1.playWith(p2));
    }

    @Test
    public void paperBeatsScissors() {
        Player p1 = new Player(Pick.PAPER);
        Player p2 = new Player(Pick.SCISSORS);

        assertEquals("Paper should not beat scissors", Game.GameResult.LOSE, p1.playWith(p2));
    }

    @Test
    public void scissorBeatsRock() {
        Player p1 = new Player(Pick.SCISSORS);
        Player p2 = new Player(Pick.ROCK);

        assertEquals("Scissors should not beat rock", Game.GameResult.LOSE, p1.playWith(p2));
    }

    @Test
    public void rockBeatsPaper() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.PAPER);

        assertEquals("Rock should not beat paper", Game.GameResult.LOSE, p1.playWith(p2));
    }

    @Test
    public void setPick() {
        Player p1 = new Player();
        Pick pick = Pick.getRandom();
        p1.setPick(pick);

        assertEquals("Unexpected pick returned", p1.getPick(), pick);
    }
}
