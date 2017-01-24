package com.ironyard.services;

import com.ironyard.entities.Play;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by graceconnelly on 1/22/17.
 */
public interface PlayRepository extends CrudRepository<Play, Integer> {

    //This code creates a random 4 int array
    static boolean notUnique(Integer[] solution, int colorCode){
        List<Integer> coll = Arrays.asList(solution);
        return (colorCode == 0 || coll.contains(colorCode));
    }

    static Integer[] gameSolution() {
        Integer[] solution = new Integer[4];
        Arrays.fill(solution,new Integer(0));
        for (int i = 0; i < solution.length; i++) {
            int colorCode = (int) (Math.random() * 8) + 1;
//            while (notUnique(solution, colorCode)) {
//                colorCode = (int) (Math.random() * 8) + 1;
//            }
            solution[i] = colorCode;
        }
        return solution;
    }
}
