package com.ironyard.services;

import com.ironyard.entities.Indicator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by graceconnelly on 1/23/17.
 */
public class IndicatorsRepositoryTest {
    @Test
    public void checksCheckNumbers () throws Exception {
        assertArrayEquals(new int[] {2, 2, 0, 0}, IndicatorsRepository.checkNumbers(new int[] {1, 7, 1, 4}, new Integer[] {2, 7, 4, 4}));
        assertArrayEquals(new int[] {2, 2, 1, 1}, IndicatorsRepository.checkNumbers(new int[] {2, 7, 1, 4}, new Integer[] {1, 7, 2, 4}));
        assertArrayEquals(new int[] {2, 2, 0, 0}, IndicatorsRepository.checkNumbers(new int[] {5, 5, 5, 5}, new Integer[] {1, 5, 1, 5}));
        assertArrayEquals(new int[] {2, 1, 1, 0}, IndicatorsRepository.checkNumbers(new int[] {4, 2, 2, 1}, new Integer[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {2, 1, 1, 0}, IndicatorsRepository.checkNumbers(new int[] {4, 2, 2, 1}, new Integer[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {2, 1, 0, 0}, IndicatorsRepository.checkNumbers(new int[] {1, 3, 5, 7}, new Integer[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {2, 0, 0, 0}, IndicatorsRepository.checkNumbers(new int[] {5, 6, 7, 4}, new Integer[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {2, 0, 0, 0}, IndicatorsRepository.checkNumbers(new int[] {4, 4, 4, 4}, new Integer[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {2, 2, 2, 0}, IndicatorsRepository.checkNumbers(new int[] {8, 6, 1, 4}, new Integer[] {8, 6, 4, 4}));
    }
}