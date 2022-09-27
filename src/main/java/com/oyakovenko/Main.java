package com.oyakovenko;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    /**
     * Extracts names from the list under an odd index.
     *
     * @param names the list of names.
     * @return the String with names under an odd index.
     */
    public static String getNamesWithOddIndex(List<String> names) {
        return IntStream
                .range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> String.format("%d. %s", i + 1, names.get(i)))
                .collect(Collectors.joining(", "));
    }

    /**
     * Converts strings from the list to uppercase and sorts in descending order.
     *
     * @param names the list of strings.
     * @return reversed sorted list of strings in uppercase.
     */
    public static List<String> getReversedSortedStringsInUppercase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /**
     * Extracts all numbers from an array of strings, sorts, converts to a comma-separated String and print it.
     *
     * @param array string array.
     * @return a comma-separated String of sorted numbers from the array.
     */
    public static String printSortedNumbersFromArray(String[] array) {
        String numbers = Arrays
                .stream(array)
                .flatMap(a -> Stream.of(a.split("\\D+")))
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(numbers);
        return numbers;
    }

    /**
     * Creates linear congruent oscillator (a sequence of pseudo randomized numbers)
     * by the formula x[n + 1] = (a * x[n] + c) % m.
     *
     * @param a multiplier.
     * @param c increase.
     * @param m module.
     * @return infinite stream of random numbers.
     */
    public static Stream<Long> getLinearCongruentOscillator(long a, long c, long m) {
        return Stream.iterate(0L, x -> (a * x + c) % m);
    }

    /**
     * Mixes elements from two streams, stopping when one of the streams runs out of elements.
     *
     * @param first  the first stream.
     * @param second the second stream.
     * @return stream with mixed elements.
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterable<T> iterable = () -> new Iterator<>() {
            final Iterator<T> i1 = first.iterator();
            final Iterator<T> i2 = second.iterator();

            boolean nextFirst;

            @Override
            public boolean hasNext() {
                return i1.hasNext() && i2.hasNext();
            }

            @Override
            public T next() {
                nextFirst = !nextFirst;
                return nextFirst ? i1.next() : i2.next();
            }
        };

        return StreamSupport.stream(iterable.spliterator(), false);
    }
}