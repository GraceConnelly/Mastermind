package com.ironyard.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by graceconnelly on 1/23/17.
 */
public class IndicatorTest {
    @Test
    public void checksCheckNumbers () throws Exception {
        assertArrayEquals(new int[]{2,2,0,0,}, Indicator.checkNumbers(new int[]{1,7,1,4},new int[] {2,7,4,4}));
    }


}