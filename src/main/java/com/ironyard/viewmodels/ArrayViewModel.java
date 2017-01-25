package com.ironyard.viewmodels;

import java.util.List;

/**
 * Created by graceconnelly on 1/23/17.
 */
public class ArrayViewModel {

    private static int STATIC_ID = 0;
    private int id = 0;
    private int[] guess;
    private int[] indicator;
    private Integer[] solution;


    public ArrayViewModel() {
        id = STATIC_ID++;
    }


    public ArrayViewModel( int[] guess, int[] indicator, Integer[] solution) {
        this();
        this.guess = guess;
        this.indicator = indicator;
        this.solution = solution;
    }

    public static int getStaticId() {
        return STATIC_ID;
    }

    public static void setStaticId(int staticId) {
        STATIC_ID = staticId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer[] getSolution() {
        return solution;
    }

    public void setSolution(Integer[] solution) {
        this.solution = solution;
    }
}