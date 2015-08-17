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
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame) {
            if (pins == 10) {
                currentFrame++;
            }
            else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            currentFrame++;
        }
        currentFrame = Math.min(11, currentFrame);
    }

    public int scoreForFrame(int frame) {
        int score = 0;
        int ball = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
            int firstThrowScore = gameThrows[ball++];
            //strike
            if (firstThrowScore == 10) {
                score += 10 + gameThrows[ball] + gameThrows[ball + 1];
            } else {
                int secondThrowScore = gameThrows[ball++];
                int frameScore = firstThrowScore + secondThrowScore;
                //spare
                if (frameScore == 10) {
                    score += frameScore + gameThrows[ball];
                } else {
                    score += frameScore;
                }
            }
        }
        return score;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }
}
