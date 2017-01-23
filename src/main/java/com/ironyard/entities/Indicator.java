package com.ironyard.entities;

import com.ironyard.exceptions.CheckCodeOutOfBoundsException;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by graceconnelly on 1/22/17.
 */
@Entity
@Table(name = "indicators")
public class Indicator {
    @Id
    @GeneratedValue
    int id;

    @Column
    int indicator1;

    @Column
    int indicator2;

    @Column
    int indicator3;

    @Column
    int indicator4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndicator1() {
        return indicator1;
    }

    public void setIndicator1(int indicator1) {
        this.indicator1 = indicator1;
    }

    public int getIndicator2() {
        return indicator2;
    }

    public void setIndicator2(int indicator2) {
        this.indicator2 = indicator2;
    }

    public int getIndicator3() {
        return indicator3;
    }

    public void setIndicator3(int indicator3) {
        this.indicator3 = indicator3;
    }

    public int getIndicator4() {
        return indicator4;
    }

    public void setIndicator4(int indicator4) {
        this.indicator4 = indicator4;
    }
    private void checkCheckSlotValue (int checkSlotValue) throws CheckCodeOutOfBoundsException {
        if(checkSlotValue < 0 || checkSlotValue > 2){
            throw new CheckCodeOutOfBoundsException("The value of the set check is out of bounds.");
        }
    }
    public static int[] checkNumbers (int[]guess, int[]solutions) {
        //http://stackoverflow.com/questions/1073919/how-to-convert-int-into-list integer-in-java
        //uses streams to iterate through the boxed integer array and changes it to a list
        List<Integer> collGuessed = IntStream.of(guess).boxed().collect(Collectors.toList());
        List<Integer> collSolution = IntStream.of(solutions).boxed().collect(Collectors.toList());
        List<Integer> indicator = new ArrayList<>();

        for (int i = 0; i < collGuessed.size(); i++) {

            if (collSolution.get(i) == collGuessed.get(i)) {
                indicator.add(2);
                collSolution.set(collGuessed.indexOf(i), 0);
                continue;
            }
            if (collSolution.contains(i)) {
                indicator.add(1);
                collSolution.set(collSolution.indexOf(i), 0);
                continue;
            }
        }
        while (indicator.size() <= 4) {
            indicator.add(0);
        }

        return indicator.stream().mapToInt(i->i).toArray();
    }


}