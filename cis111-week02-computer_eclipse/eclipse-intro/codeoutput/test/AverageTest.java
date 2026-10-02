package edu.yeditepe.intro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AverageTest {
    @Test
    void averageOfThreeGrades() {
        int[] grades = {85, 90, 72};
        assertEquals(82.333, FixedAverage.average(grades), 0.001);
    }

    @Test
    void averageOfOneGrade() {
        assertEquals(50.0, FixedAverage.average(new int[] {50}), 0.001);
    }
}
