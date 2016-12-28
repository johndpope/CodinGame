package me.fernandodoming.rps.models;

import java.security.InvalidParameterException;

/**
 * Coded by Fernando on 28/12/2016.
 */
public class Game {
    private Player[] players = new Player[2];

    public Game(Player[] players) {
        if (players.length > 2) {
            throw new InvalidParameterException("Too many players for this game");
        }
        this.players = players;
    }

    /* Play the round.
     * The returned result is the result for the Player at index 0, as
      * there are only 2 players, knowing the result of the first one
      * automatically gives you the result for the other one */
    public GameResult play() {
        return players[0].playWith(players[1]);
    }

    /* A game returns a result that can either be WIN, LOSE or TIE */
    public enum GameResult {
        WIN, LOSE, TIE
    }
}
