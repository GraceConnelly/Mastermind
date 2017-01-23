package com.ironyard.entities;

import com.ironyard.exceptions.CheckCodeOutOfBoundsException;

import javax.persistence.*;

/**
 * Created by graceconnelly on 1/22/17.
 */
@Entity
@Table(name = "board-check")
public class Indicators {
    @Id
    @GeneratedValue
    int id;

    @Column
    int checkSlot1;

    @Column
    int checkSlot2;

    @Column
    int checkSlot3;

    @Column
    int checkSlot4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheckSlot1() {
        return checkSlot1;
    }

    public void setCheckSlot1(int checkSlot1) {
        this.checkSlot1 = checkSlot1;
    }

    public int getCheckSlot2() {
        return checkSlot2;
    }

    public void setCheckSlot2(int checkSlot2) {
        this.checkSlot2 = checkSlot2;
    }

    public int getCheckSlot3() {
        return checkSlot3;
    }

    public void setCheckSlot3(int checkSlot3) {
        this.checkSlot3 = checkSlot3;
    }

    public int getCheckSlot4() {
        return checkSlot4;
    }

    public void setCheckSlot4(int checkSlot4) {
        this.checkSlot4 = checkSlot4;
    }
    private void checkCheckSlotValue (int checkSlotValue) throws CheckCodeOutOfBoundsException {
        if(checkSlotValue < 0 || checkSlotValue > 2){
            throw new CheckCodeOutOfBoundsException("The value of the set check is out of bounds.");
        }
    }
}