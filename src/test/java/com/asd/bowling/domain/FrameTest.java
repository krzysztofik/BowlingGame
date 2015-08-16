package com.asd.bowling.domain;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    Frame objectUnderTest;

    @Test
    public void scoreWhenNoThrows() {
        //given
        objectUnderTest = new Frame();

        //then
        assertThat(objectUnderTest.getScore()).isEqualTo(0);
    }

    @Test
    public void scoreAfterOneThrow() {
        //given
        objectUnderTest = new Frame();

        //when
        objectUnderTest.add(5);

        //then
        assertThat(objectUnderTest.getScore()).isEqualTo(5);
    }
}
