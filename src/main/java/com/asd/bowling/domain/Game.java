package com.asd.bowling.domain;


public class Game {

    private int[] gameThrows  = new int[21];
    private int currentThrow = 0;
    private int currentFrame = 1;
    private boolean firstThrowInFrame = true;

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        gameThrows[currentThrow++] = pins;
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if (firstThrowInFrame) {
            firstThrowInFrame = false;
        } else {
            firstThrowInFrame = true;
            currentFrame++;
        }
    }

    public int scoreForFrame(int frame) {
        int score = 0;
        int ball = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
            int firstTrowScore = gameThrows[ball++];
            int secondThrowScore = gameThrows[ball++];
            int frameScore = firstTrowScore + secondThrowScore;

            if (frameScore == 10) {
                score += frameScore + gameThrows[ball];
            } else {
                score += frameScore;
            }
        }
        return score;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }
}
