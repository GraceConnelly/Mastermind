package com.ironyard.viewmodels;

import java.util.List;

/**
 * Created by graceconnelly on 1/23/17.
 */
public class ArrayViewModel {

    private int[] guess;
    private int[] indicator;

    public ArrayViewModel(int[] indicator) {
        this.indicator = indicator;
    }

    public int[] getGuess() {
        return guess;
    }

    public void setGuess(int[] guess) {
        this.guess = guess;
    }

    public int[] getIndicator() {
        return indicator;
    }

    public void setIndicator(int[] indicator) {
        this.indicator = indicator;
    }

}