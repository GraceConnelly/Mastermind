package com.ironyard.controllers;

import com.ironyard.entities.Indicators;
import com.ironyard.entities.Play;
import com.ironyard.services.IndicatorsRepository;
import com.ironyard.services.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by graceconnelly on 1/22/17.
 */
@RestController

public class MastermindController {

    public static boolean notUnique(Integer[] solution, int colorCode){
        List<Integer> coll = Arrays.asList(solution);
        return (colorCode == 0 || coll.contains(colorCode));
    }

    public static Integer[] gameSolution() {
        Integer[] solution = new Integer[4];
        Arrays.fill(solution,new Integer(0));
        for (int i = 0; i < solution.length; i++) {
            int colorCode = (int) (Math.random() * 8) + 1;
            while (notUnique(solution, colorCode)) {
                colorCode = (int) (Math.random() * 8) + 1;
            }
            solution[i] = colorCode;
        }
        return solution;
    }
    @Autowired
    PlayRepository plays;

    @Autowired
    IndicatorsRepository checks;

    @PostConstruct
    public void init() {
        if (plays.count() == 0){
            Play blankPlays = new Play();
            for (int i = 0; i < 12; i++) {
                blankPlays.setPlaySlot1(0);
                blankPlays.setPlaySlot2(0);
                blankPlays.setPlaySlot3(0);
                blankPlays.setPlaySlot4(0);
                plays.save(blankPlays);
            }
            Indicators blankChecks = new Indicators();
            for (int i = 0; i < 11; i++) {
                blankChecks.setIndicator1(0);
                blankChecks.setIndicator2(0);
                blankChecks.setIndicator3(0);
                blankChecks.setIndicator4(0);
                checks.save(blankChecks);
            }
//            blankRows.
//            Play initalplay = new Play();
//            initalplay.setPlaySlot1();
        }
    }
    @CrossOrigin
    @RequestMapping (path = "/", method = RequestMethod.POST)

    public List<Play> getPlay() {
        return (List<Play>) plays.findAll();
    }
}
