package com.ironyard.controllers;

import com.ironyard.entities.Indicators;
import com.ironyard.entities.Play;
import com.ironyard.services.IndicatorsRepository;
import com.ironyard.services.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by graceconnelly on 1/22/17.
 */
@RestController

public class MastermindController {
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
                blankChecks.setCheckSlot1(0);
                blankChecks.setCheckSlot2(0);
                blankChecks.setCheckSlot3(0);
                blankChecks.setCheckSlot4(0);
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
