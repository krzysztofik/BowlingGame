package com.asd.bowling.domain;


public class Scorer {

    private int ball;
    private int[] gameThrows  = new int[21];
    private int currentThrow = 0;

    public void addThrow(int pins) {
        gameThrows[currentThrow++] = pins;
    }

    public int scoreForFrame(int frame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
            if (strike()) {
                score += 10 + nextTwoBalls();
                ball++;
            } else if (spare()) {
                score += 10 + nextBallForSpare();
                ball+=2;
            } else {
                score += twoBallsInFrame();
                ball+=2;
            }
        }
        return score;
    }

    private int nextTwoBalls() {
        return gameThrows[ball+1] + gameThrows[ball+2];
    }

    private boolean strike() {
        return gameThrows[ball] == 10;
    }

    private int twoBallsInFrame() {
        return gameThrows[ball] + gameThrows[ball+1];
    }

    private boolean spare() {
        return (gameThrows[ball] + gameThrows[ball+1]) == 10;
    }

    private int nextBallForSpare(){
        return gameThrows[ball+2];
    }
}
