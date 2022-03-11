package com.zenika.codingdojo;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.zenika.codingdojo.StreamDojo.*;
import static org.assertj.core.api.Assertions.assertThat;

class StreamDojoTest {

    Object[] objects = new Object[]{1, "2", 3, "Z"}; // {1, 3}
    Object[] objects2 = new Object[]{1, 4, "2", 3, "Z"}; // {1, 4, 3}
    Object[] objects3 = new Object[]{5, "2", 22, 3, "Z", 1, 4};// {5, 22, 3, 1, 4}


    @Test
    void test1() {
        assertThat(joinElement(objects)).isEqualTo("123Z");
    }

    @Test
    void test2() {
        assertThat(sum(objects)).isEqualTo(4);
    }

    @Test
    void test3() {
        assertThat(sum(objects2)).isEqualTo(8);
    }

    @Test
    void test4() {
        assertThat(maxOr0(objects)).isEqualTo(3);
    }

    @Test
    void test5() {
        assertThat(maxOr0(objects2)).isEqualTo(4);
    }

    @Test
    void test6() {
        assertThat(maxOr0(new Object[]{})).isZero();
    }

    @Test
    void test7() {
        assertThat(maxOr0(objects3)).isEqualTo(22);
    }

    @Test
    void test8() {
        assertThat(lastElement(objects)).isEqualTo("Z");
    }

    @Test
    void test9() {
        assertThat(lastElement(objects2)).isEqualTo("Z");
    }

    @Test
    void test10() {
        assertThat(lastElement(objects3)).isEqualTo(4);
    }

    @Test
    void test11() {
        assertThat(lastElement(new Object[]{})).isEqualTo("No Element Found");
    }

    private Object lastElement(Object[] o) {
        return Stream.of(o)
                .reduce((o1, o2) -> o2)
                .orElse("No Element Found");
    }

    private int maxOr0(Object[] objects) {
        return intStream(objects)
                .max()
                .orElse(0);
    }

    private int minOr0(Object[] objects) {
        return intStream(objects)
                .min()
                .orElse(0);
    }

    private int lastIntOr0(Object[] objects) {
        var x = intStream(objects)
                .reduce((i, i1) -> i1)
                .orElse(0);
        System.out.println(x);
        return  x;
    }
    /*
    Optional#orElse
    sO1 = "a", sO1'= eval(otherResult())
    if(sO1 != null)
       return s01
    return sO1'

    Optional#orElseGet
    s01 = "a"

    if(sO1 != null)
        return sO1
    return eval(otherResult)

     */



}
