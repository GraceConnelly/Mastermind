package com.ironyard.controllers;

import com.ironyard.entities.Indicator;
import com.ironyard.entities.Play;
import com.ironyard.services.IndicatorsRepository;
import com.ironyard.services.PlayRepository;
import com.ironyard.viewmodels.ArrayViewModel;
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

    private boolean reset = true;
    private Integer[] solution;

    @Autowired
    PlayRepository plays;

    @Autowired
    IndicatorsRepository indicators;

    @PostConstruct
    public void init() {
        if (reset){
            solution = PlayRepository.gameSolution();
            reset = false;
        }
    }

    @CrossOrigin
    @RequestMapping (path = "/", method = RequestMethod.POST)
    public ArrayViewModel homePage(@RequestBody int[] guess, int[] indicator) {
        init();
        indicator = IndicatorsRepository.checkNumbers(guess, solution);
        return new ArrayViewModel(indicator);
    }

    @CrossOrigin
    @RequestMapping (path = "/new-game",method = RequestMethod.POST)
    public String newGame () {
        reset = true;
        return "redirect:/";
    }

}
