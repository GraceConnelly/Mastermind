package com.ironyard.entities;
import com.ironyard.Exceptions.PlayCodeOutOfBoundsException;

/**
 * Created by graceconnelly on 1/22/17.
 */
public class Play {
    private int playSlot1;
    private int playSlot2;
    private int playSlot3;
    private int playSlot4;

    public Play() {
    }

    public Play(int playSlot1, int playSlot2, int playSlot3, int playSlot4) {
        this.playSlot1 = playSlot1;
        this.playSlot2 = playSlot2;
        this.playSlot3 = playSlot3;
        this.playSlot4 = playSlot4;
    }

    public int getPlaySlot1() {
        return playSlot1;
    }

    public void setPlaySlot1(int playSlot1) throws PlayCodeOutOfBoundsException {
        this.playSlot1 = playSlot1;
    }

    public int getPlaySlot2() {
        return playSlot2;
    }

    public void setPlaySlot2(int playSlot2) throws PlayCodeOutOfBoundsException {
        checkPlaySlotValue(playSlot2);
        this.playSlot2 = playSlot2;
    }

    public int getPlaySlot3() {
        return playSlot3;
    }

    public void setPlaySlot3(int playSlot3) throws PlayCodeOutOfBoundsException {
        checkPlaySlotValue(playSlot3);
        this.playSlot3 = playSlot3;
    }

    public int getPlaySlot4() {
        return playSlot4;
    }

    public void setPlaySlot4(int playSlot4) throws PlayCodeOutOfBoundsException {
        checkPlaySlotValue(playSlot4);
        this.playSlot4 = playSlot4;
    }

    private void checkPlaySlotValue (int playSlotValue) throws PlayCodeOutOfBoundsException {
        if(playSlotValue < 0 || playSlotValue > 8){
            throw new PlayCodeOutOfBoundsException("The value of the set play is out of bounds.");
        }
    }
}
