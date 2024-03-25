package model;

public class GamePlay {
 private Level level;
 private String[] playerAnswer;
 private int gamePlayId;

    public GamePlay(Level level, String[] playerAnswer, int gamePlayId) {
        this.level = level;
        this.playerAnswer = playerAnswer;
        this.gamePlayId = gamePlayId;
    }

    public GamePlay() {
    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String[] getPlayerAnswer() {
        return playerAnswer;
    }

    public void setPlayerAnswer(String[] playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    public int getGamePlayId() {
        return gamePlayId;
    }

    public void setGamePlayId(int gamePlayId) {
        this.gamePlayId = gamePlayId;
    }
}
