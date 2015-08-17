package com.asd.bowling.domain;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class GameTest {

    static final int STRIKE = 10;

    Game game;

    @Before
    public void setup() {
        //given
        game = new Game();
    }

    @Ignore
    @Test
    public void oneThrow() {
        //when
        game.add(5);

        //then
        assertThat(game.score()).isEqualTo(5); // we try to get score for incomplete frame, should we allow for it?
    }

    @Test
    public void twoThrowsNoMark() {
        //when
        game.add(5);
        game.add(4);

        //then
        assertThat(game.score()).isEqualTo(9);;
    }

    @Test
    public void fourThrowsNoMark() {
        //when
        game.add(5);
        game.add(4);
        game.add(7);
        game.add(2);

        //then
        assertThat(game.score()).isEqualTo(18);
        assertThat(game.scoreForFrame(1)).isEqualTo(9);
        assertThat(game.scoreForFrame(2)).isEqualTo(18);
    }

    @Test
    public void simpleSpare() {
        //when
        game.add(3);
        game.add(7);
        game.add(3);

        //then
        assertThat(game.scoreForFrame(1)).isEqualTo(13);
    }

    @Test
    public void simpleFrameAfterSpare() {
        //when
        game.add(3);
        game.add(7);
        game.add(3);
        game.add(2);

        //then
        assertThat(game.scoreForFrame(1)).isEqualTo(13);
        assertThat(game.scoreForFrame(2)).isEqualTo(18);
        assertThat(game.score()).isEqualTo(18);
    }

    @Test
    public void simpleStrike() {
        //when
        game.add(STRIKE);
        game.add(3);
        game.add(6);

        //then
        assertThat(game.scoreForFrame(1)).isEqualTo(19);
        assertThat(game.score()).isEqualTo(28);
    }

    @Test
    public void perfectGame() {
        for (int i=0; i<12; i++) {
            game.add(10);
        }

        assertThat(game.score()).isEqualTo(300);
    }

    @Test
    public void spareInLastFrame() {
        for (int i=0; i<9; i++) {
            game.add(0);
            game.add(0);
        }

        game.add(2);
        game.add(8);
        game.add(10);

        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void simpleGame() {

        game.add(1);
        game.add(4);
        game.add(4);
        game.add(5);
        game.add(6);
        game.add(4);
        game.add(5);
        game.add(5);
        game.add(10);
        game.add(0);
        game.add(1);
        game.add(7);
        game.add(3);
        game.add(6);
        game.add(4);
        game.add(10);
        game.add(2);
        game.add(8);
        game.add(6);

        assertThat(game.score()).isEqualTo(133);

    }

    @Test
    public void heartBreak() {
        for (int i=0; i<11; i++) {
            game.add(10);
        }
        game.add(9);

        assertThat(game.score()).isEqualTo(299);
    }

    @Test
    public void strikesWithSpareInLastFrame() {
        for (int i=0; i<9; i++) {
            game.add(10);
        }
        game.add(9);
        game.add(1);
        game.add(1);

        assertThat(game.score()).isEqualTo(270);
    }


}
