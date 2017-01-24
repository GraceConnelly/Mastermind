package com.ironyard.entities;

import com.ironyard.exceptions.PlayCodeOutOfBoundsException;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by graceconnelly on 1/22/17.
 */
@Entity
@Table(name = "plays")
public class Play {
    @Id
    @GeneratedValue
    int id;

    @Column
    int playSlot1;

    @Column
    int playSlot2;

    @Column
    int playSlot3;

    @Column
    int playSlot4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaySlot1() {
        return playSlot1;
    }

    public void setPlaySlot1(int playSlot1) {
        this.playSlot1 = playSlot1;
    }

    public int getPlaySlot2() {
        return playSlot2;
    }

    public void setPlaySlot2(int playSlot2) {
        this.playSlot2 = playSlot2;
    }

    public int getPlaySlot3() {
        return playSlot3;
    }

    public void setPlaySlot3(int playSlot3) {
        this.playSlot3 = playSlot3;
    }

    public int getPlaySlot4() {
        return playSlot4;
    }

    public void setPlaySlot4(int playSlot4) {
        this.playSlot4 = playSlot4;
    }
    private void checkPlaySlotValue (int playSlotValue) throws PlayCodeOutOfBoundsException {
        if(playSlotValue < 0 || playSlotValue > 8){
            throw new PlayCodeOutOfBoundsException("The value of the set play is out of bounds.");
        }
    }
}
