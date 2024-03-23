package model;

public class Grid {
    // Properties
    private int gridId;
    private int rows;
    private int columns;
    private String data;
    private String answerString;

    // Constructor
    public Grid() {
        this.gridId = 1;
        this.rows = 5;
        this.columns = 5;
//        this.data = "#,11.hSum,24.hSum,#,#;vSum.16,_,_,17.hSum,#;vSum.13,_,_,_,17.hSum;#,vSum.24,_,_,_;#,#,vSum.16,_,_;";
        this.data = "#,11.hSum,24.hSum,#,#;vSum.16,_,_,17.hSum,#;vSum.13,_,_,_,17.hSum;#,vSum.24,_,_,_;#,#,vSum.16,_,_;#,11.hSum,24.hSum,#,#;vSum.16,_,_,17.hSum,#;";

        this.answerString = "";
    }

    // Getters and Setters
    public int getGridId() {
        return gridId;
    }

    public void setGridId(int gridId) {
        this.gridId = gridId;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAnswerString() {
        return answerString;
    }

    public void setAnswerString(String answerString) {
        this.answerString = answerString;
    }
}

