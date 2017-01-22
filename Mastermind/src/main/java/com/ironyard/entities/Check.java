package com.ironyard.entities;

import com.ironyard.Exceptions.CheckCodeOutOfBoundsException;

/**
 * Created by graceconnelly on 1/22/17.
 */
public class Check {
    private int checkSlot1;
    private int checkSlot2;
    private int checkSlot3;
    private int checkSlot4;

    public Check() {
    }

    public Check(int slot1, int slot2, int slot3, int slot4) throws CheckCodeOutOfBoundsException{
        this.setCheckSlot1(slot1);
        this.setCheckSlot2(slot2);
        this.setCheckSlot3(slot3);
        this.setCheckSlot4(slot4);
    }

    public int getCheckSlot1() {
        return checkSlot1;
    }

    public void setCheckSlot1(int checkSlot1) throws CheckCodeOutOfBoundsException  {
        checkCheckSlotValue(checkSlot1);
        this.checkSlot1 = checkSlot1;
    }

    public int getCheckSlot2() {
        return checkSlot2;
    }

    public void setCheckSlot2(int checkSlot2) throws CheckCodeOutOfBoundsException  {
        checkCheckSlotValue(checkSlot2);
        this.checkSlot2 = checkSlot2;
    }

    public int getCheckSlot3() {
        return checkSlot3;
    }

    public void setCheckSlot3(int checkSlot3) throws CheckCodeOutOfBoundsException {
        checkCheckSlotValue(checkSlot3);
        this.checkSlot3 = checkSlot3;
    }

    public int getCheckSlot4() {
        return checkSlot4;
    }

    public void setCheckSlot4(int checkSlot4) throws CheckCodeOutOfBoundsException {
        checkCheckSlotValue(checkSlot4);
        this.checkSlot4 = checkSlot4;
    }

    private void checkCheckSlotValue (int checkSlotValue) throws CheckCodeOutOfBoundsException{
        if(checkSlotValue < 0 || checkSlotValue > 2){
            throw new CheckCodeOutOfBoundsException("The value of the set check is out of bounds.");
        }
    }
}
