package com.ironyard.controllers;

import com.ironyard.entities.Indicator;
import com.ironyard.entities.Play;
import com.ironyard.services.IndicatorsRepository;
import com.ironyard.services.PlayRepository;
import com.ironyard.viewmodels.BoardViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 * Created by graceconnelly on 1/22/17.
 */
@RestController

public class MastermindController {

    @Autowired
    PlayRepository plays;

    @Autowired
    IndicatorsRepository indicators;

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
            Indicator blankIndicators = new Indicator();
            for (int i = 0; i < 11; i++) {
                blankIndicators.setIndicator1(0);
                blankIndicators.setIndicator2(0);
                blankIndicators.setIndicator3(0);
                blankIndicators.setIndicator4(0);
                indicators.save(blankIndicators);
            }
            Integer[] gameSolution = Play.gameSolution();
//            blankRows.
//            Play initalplay = new Play();
//            initalplay.setPlaySlot1();
        }
    }

    @CrossOrigin
    @RequestMapping (path = "/", method = RequestMethod.POST)
    public BoardViewModel homePage(@RequestBody int[] guess) {
        Play thisPlay = new Play();
        thisPlay.setPlaySlot1(guess[0]);
        thisPlay.setPlaySlot2(guess[1]);
        thisPlay.setPlaySlot3(guess[2]);
        thisPlay.setPlaySlot4(guess[3]);
        plays.save(thisPlay);


//    public BoardViewModel homePage(@RequestBody Play newPlay) {

        return new BoardViewModel((List)plays.findAll());


////        plays.update(numberGuess, currentRound);
////        Indicator.resolveUpdateIndicators();
    //  SIMPLIFIED POST!!
    //public Play homePage() {
    }
}
