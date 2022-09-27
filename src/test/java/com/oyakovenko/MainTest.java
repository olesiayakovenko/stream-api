package com.oyakovenko;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.oyakovenko.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGetNamesWithOddIndex() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Kate");
        names.add("Max");
        names.add("Samantha");
        names.add("Peter");
        names.add("Ivan");

        assertEquals("1. Anna, 3. Max, 5. Peter", getNamesWithOddIndex(names));
    }

    @Test
    void testGetReversedSortedStringsInUppercase() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("kate");
        names.add("Max");
        names.add("samantha");
        names.add("petER");
        names.add("Ivan");

        String[] expected = {"SAMANTHA", "PETER", "MAX", "KATE", "IVAN", "ANNA"};

        assertArrayEquals(expected, getReversedSortedStringsInUppercase(names).toArray());
    }

    @Test
    void testPrintSortedNumbersFromArray() {
        assertEquals("0, 1, 2, 4, 5", printSortedNumbersFromArray(new String[]{"1, 2, 0", "4, 5"}));
    }

    @Test
    void testGetLinearCongruentOscillator() {
        long a = 25214903917L;
        long c = 11L;
        long m = 281474976710656L;

        Long[] expected = {0L, 11L, 277363943098L, 11718085204285L, 49720483695876L, 102626409374399L,
                25707281917278L, 25979478236433L, 137139456763464L, 148267022728371L};

        assertArrayEquals(expected, getLinearCongruentOscillator(a, c, m).limit(10).toArray());
    }

    @Test
    void testZip() {
        Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9, 11, 13);
        Stream<Integer> stream2 = Stream.of(2, 4, 6, 8, 10, 12, 14, 15, 16);

        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        assertArrayEquals(expected, zip(stream1, stream2).toList().toArray());
    }
}