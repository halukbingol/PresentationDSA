import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class SortPropertyTest {
    @TestFactory
    Stream<DynamicTest> sortsLikeArraysSort() {
        Random random = new Random(2026);
        return IntStream.range(0, 200).mapToObj(n -> {
            int[] input = random.ints(random.nextInt(8), -9, 10).toArray();
            return DynamicTest.dynamicTest(Arrays.toString(input), () -> {
                int[] expected = input.clone();
                Arrays.sort(expected);
                int[] actual = input.clone();
                MySort.sort(actual);
                assertArrayEquals(expected, actual);
            });
        });
    }
}
