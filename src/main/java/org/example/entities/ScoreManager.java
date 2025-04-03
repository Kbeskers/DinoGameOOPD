package org.example.entities;

import org.example.ui.text.ScoreText;
import org.example.ui.text.HighScoreText;

import java.io.*;

public class ScoreManager {
    private final String SCORE_FILE = "highscore.txt";
    private int score;
    private int highScore;
    private final ScoreText scoreText;
    private final HighScoreText highScoreText;

    public ScoreManager(ScoreText scoreText, HighScoreText highScoreText) {
        this.scoreText = scoreText;
        this.highScoreText = highScoreText;
        this.score = 0;
        loadHighScore();
        updateScore();
        updateHighScore();
    }

    public void addPoints(int points) {
        score += points;
        updateScore();
        checkHighScore();
    }

    public void setScore(int score) {
        this.score = score;
        updateScore();
        checkHighScore();
    }

    private void checkHighScore() {
        if (score > highScore) {
            highScore = score;
            saveHighScore();
            updateHighScore();
        }
    }

    private void updateScore() {
        scoreText.setScoreText(score);
    }
    
    private void updateHighScore() {
        highScoreText.setHighScoreText(highScore);
    }

    private void loadHighScore() {
        File file = new File(SCORE_FILE);
        if (!file.exists()) {
            highScore = 0;
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String scoreStr = br.readLine();
            highScore = Integer.parseInt(scoreStr.trim());
        } catch (Exception e) {
            highScore = 0;
        }
    }

    private void saveHighScore() {
        try {
            FileWriter fw = new FileWriter(SCORE_FILE);
            fw.write(String.valueOf(highScore));
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving score");
        }
    }

    public int getScore() {
        return score;
    }
    
    public int getHighScore() {
        return highScore;
    }
}
