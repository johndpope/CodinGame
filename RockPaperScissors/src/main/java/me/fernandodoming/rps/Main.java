package me.fernandodoming.rps;

import me.fernandodoming.rps.models.Game;
import me.fernandodoming.rps.models.Pick;
import me.fernandodoming.rps.models.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Coded by Fernando on 22/12/2016.
 */
public class Main {

    private static int N_GAMES = 100;

    public static void main(String[] args) {
        Map<Game.GameResult, Integer> p1Score = new HashMap<>();
        p1Score.put(Game.GameResult.WIN, 0);
        p1Score.put(Game.GameResult.LOSE, 0);
        p1Score.put(Game.GameResult.TIE, 0);

        Player p1 = new Player();
        Player p2 = new Player();

        // Play 100 times
        for (int i = 0; i < N_GAMES; i++) {
            // p1 always chooses paper
            p1.setPick(Pick.PAPER);
            // p2 always chooses randomly
            p2.setPick(Pick.getRandom());
            Game round = new Game(new Player[] {p1, p2});

            Game.GameResult result = round.play();
            p1Score.put(result, p1Score.get(result) + 1);
        }

        System.out.println("Player A wins " + p1Score.get(Game.GameResult.WIN) + " of " + N_GAMES + " games");
        System.out.println("Player B wins " + p1Score.get(Game.GameResult.LOSE) + " of " + N_GAMES + " games");
        System.out.println("Tie: " + p1Score.get(Game.GameResult.TIE) + " of " + N_GAMES + " games");
    }
}
