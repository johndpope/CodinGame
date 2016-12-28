package me.fernandodoming.rps.models;

/**
 * Coded by Fernando on 22/12/2016.
 */
public class Player {
    private Pick pick;

    /* Constructors */

    public Player(Pick pick) {
        this.pick = pick;
    }

    public Player() {}

    /* Public methods */

    public void setPick(Pick pick) {
        this.pick = pick;
    }

    public Pick getPick() {
        return pick;
    }

    public Game.GameResult playWith(Player another) {
        if (another == null) return null;
        if (another.getPick() == this.pick) return Game.GameResult.TIE;

        if (this.pick.beats( another.getPick() )) {
            return Game.GameResult.WIN;
        } else {
            return Game.GameResult.LOSE;
        }
    }
}
