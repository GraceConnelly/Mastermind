package com.ironyard.services;

import com.ironyard.entities.Indicator;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by graceconnelly on 1/22/17.
 */
public interface IndicatorsRepository extends CrudRepository<Indicator, Integer> {

    static int[] checkNumbers (int[]guess, Integer[]solution) {
        //http://stackoverflow.com/questions/1073919/how-to-convert-int-into-list integer-in-java
        //Uses int primitive specialization of stream to take in an array of int type and return the
        //values of the index as an int type. Then the stream is boxed up to an integer type.
        //the Integer stream is then collected into a list.
        List<Integer> collGuessed = IntStream.of(guess).boxed().collect(Collectors.toList());
        List<Integer> collSolution = Arrays.stream(solution).collect(Collectors.toList());
        List<Integer> indicator = new ArrayList<>();

        for (int i = 0; i < collGuessed.size(); i++) {
            if (collSolution.get(i) == collGuessed.get(i)) {
                indicator.add(2);
                collSolution.set(i, 0);
                collGuessed.set(i, 9);
                continue;
            }
        }
        for (int i = 0; i < collGuessed.size(); i++) {
            if (collSolution.contains(collGuessed.get(i))) {
                indicator.add(1);
                collSolution.set(collSolution.indexOf(collGuessed.get(i)), 0);
                collGuessed.set(i, 9);
                continue;
            }
        }
        Collections.sort(indicator,Collections.reverseOrder());
        while (indicator.size() < 4) {
            indicator.add(0);
        }
        //the code below put indicator into a stream and maps it to an int array. the indexes are mapped directly.
        //this code was re-purposed from notes in our practice problems
        return indicator.stream().mapToInt(i->i).toArray();
    }
}
