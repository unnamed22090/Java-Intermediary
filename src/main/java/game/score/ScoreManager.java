package game.score;

import java.io.*;
import java.time.LocalDateTime;

public class ScoreManager {
    private final String pathFile;

    public ScoreManager() {
        pathFile = "D:\\game.score.txt";
    }

    public ScoreManager(String pathFile) {
        this.pathFile = pathFile;
    }

    public void saveScore(String mode, String username, int score, long timeInUsedBySecond) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(this.pathFile, true));
            LocalDateTime now = LocalDateTime.now();

            String text = String.format("%s|%s|%d|%d|%s", mode, username, score, timeInUsedBySecond, now.toString()) + "%n";
            file.append(text);
            file.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void showScore() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(this.pathFile));
        String line = file.readLine(); // Get first line
        while (line != null) {
            System.out.println(line); // Show text in line
            line = file.readLine(); // Read for next line
        }
    }

    public void clearScore() {
        File file = new File(this.pathFile);
        file.delete();
    }
}
