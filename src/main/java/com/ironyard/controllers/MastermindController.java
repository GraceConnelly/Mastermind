package com.ironyard.controllers;

import com.ironyard.entities.Indicator;
import com.ironyard.entities.Play;
import com.ironyard.services.IndicatorsRepository;
import com.ironyard.services.PlayRepository;
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
            int currentRound = 0;
//            blankRows.
//            Play initalplay = new Play();
//            initalplay.setPlaySlot1();
        }
    }

//    @CrossOrigin
//    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public String mastermind(Model model) {
//        model.addAttribute("play",plays.findAll());
//        model.addAttribute("indicators",indicators.findAll());
//        //model.addAttribute("round",round);
//        return "mastermind";
//    }

    @CrossOrigin
    @RequestMapping (path = "/", method = RequestMethod.POST)
    public List<Play> homePage() {
        return (List)plays.findAll();

////        servlet.service("numberGuess",
////                model.addAttribute("play",plays.findAll()),
////                model.addAttribute("indicators",indicators.findAll());
//
////        plays.update(numberGuess, currentRound);
////        Indicator.resolveUpdateIndicators();
//        return new Indicator();
    }
}
