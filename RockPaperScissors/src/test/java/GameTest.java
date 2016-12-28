import me.fernandodoming.rps.models.Game;
import me.fernandodoming.rps.models.Pick;
import me.fernandodoming.rps.models.Player;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

/**
 * Coded by Fernando on 22/12/2016.
 */
public class GameTest {

    @Test
    public void rockBeatsScissors() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.SCISSORS);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should beat scissors", Game.GameResult.WIN, round.play());
    }

    @Test
    public void paperBeatsRock() {
        Player p1 = new Player(Pick.PAPER);
        Player p2 = new Player(Pick.ROCK);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should beat scissors", Game.GameResult.WIN, round.play());
    }

    @Test
    public void scissorsBeatsPaper() {
        Player p1 = new Player(Pick.SCISSORS);
        Player p2 = new Player(Pick.PAPER);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should beat scissors", Game.GameResult.WIN, round.play());
    }

    @Test
    public void rockTie() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.ROCK);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should beat scissors", Game.GameResult.TIE, round.play());
    }

    @Test
    public void scissorsTie() {
        Player p1 = new Player(Pick.SCISSORS);
        Player p2 = new Player(Pick.SCISSORS);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should beat scissors", Game.GameResult.TIE, round.play());
    }

    @Test
    public void paperTie() {
        Player p1 = new Player(Pick.PAPER);
        Player p2 = new Player(Pick.PAPER);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should beat scissors", Game.GameResult.TIE, round.play());
    }

    @Test
    public void paperBeatsScissors() {
        Player p1 = new Player(Pick.PAPER);
        Player p2 = new Player(Pick.SCISSORS);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Paper should not beat scissors", Game.GameResult.LOSE, round.play());
    }

    @Test
    public void scissorBeatsRock() {
        Player p1 = new Player(Pick.SCISSORS);
        Player p2 = new Player(Pick.ROCK);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Scissors should not beat rock", Game.GameResult.LOSE, round.play());
    }

    @Test
    public void rockBeatsPaper() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.PAPER);
        Game round = new Game(new Player[] {p1, p2});

        assertEquals("Rock should not beat paper", Game.GameResult.LOSE, round.play());
    }

    @Test(expected = InvalidParameterException.class)
    public void tooManyPlayers() {
        Player p1 = new Player(Pick.ROCK);
        Player p2 = new Player(Pick.PAPER);
        Player p3 = new Player(Pick.ROCK);

        Game round = new Game(new Player[] {p1, p2, p3});
    }
}
