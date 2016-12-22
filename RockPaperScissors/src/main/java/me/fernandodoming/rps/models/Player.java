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

    public GameResult playWith(Player another) {
        if (another == null) return null;
        if (another.getPick() == this.pick) return GameResult.TIE;

        if (this.pick.beats( another.getPick() )) {
            return GameResult.WIN;
        } else {
            return GameResult.LOSE;
        }
    }
}
