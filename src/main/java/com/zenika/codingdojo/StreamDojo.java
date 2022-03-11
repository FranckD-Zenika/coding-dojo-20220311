package com.zenika.codingdojo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDojo {

    public static Object joinElement(Object[] objects) {

        return Stream.of(objects)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static int sum(Object[] objects) {
        return intStream(objects).sum();
    }

    public static IntStream intStream(Object[] o) {
        return Stream.of(o)
                .filter(Integer.class::isInstance)
                .mapToInt(Integer.class::cast);
    }
    private StreamDojo() {}

}
