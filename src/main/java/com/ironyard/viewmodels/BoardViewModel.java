package com.ironyard.viewmodels;

import com.ironyard.entities.Play;

import java.util.List;

/**
 * Created by graceconnelly on 1/23/17.
 */
public class BoardViewModel {
    private static int STATIC_ID = 0;

    private List<Play> plays;
    private int id;

    public BoardViewModel() {
        id = STATIC_ID++;
    }

    public BoardViewModel (List<Play> plays) {
        this();
        this.plays = plays;
    }

    public static int getStaticId() {
        return STATIC_ID;
    }

    public static void setStaticId(int staticId) {
        STATIC_ID = staticId;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
