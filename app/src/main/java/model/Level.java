package model;

public class Level {
    private int levelId;
    private String description;
    private Grid grid;
    private Player[] rank;

    public Level(int levelId, String description, Grid grid, Player[] rank) {
        this.levelId = levelId;
        this.description = description;
        this.grid = grid;
        this.rank = rank;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Player[] getRank() {
        return rank;
    }

    public void setRank(Player[] rank) {
        this.rank = rank;
    }
}
