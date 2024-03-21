package com.example.kakuro_game_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

import model.Grid;

public class GameplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        Grid kakuroGrid = new Grid(); // Your constructor that sets up the grid
        generatePuzzleGrid(kakuroGrid);
    }

    private void generatePuzzleGrid(Grid kakuroGrid) {
        GridLayout gridLayout = findViewById(R.id.kakuroGrid);
        String data = kakuroGrid.getData();
        String[] rows = data.split(";");

        for (int i = 0; i < rows.length; i++) {
            String[] cells = rows[i].split(",");

            for (int j = 0; j < cells.length; j++) {
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = GridLayout.LayoutParams.WRAP_CONTENT;
                params.height = GridLayout.LayoutParams.WRAP_CONTENT;
                params.rowSpec = GridLayout.spec(i, 1f);
                params.columnSpec = GridLayout.spec(j, 1f);

                params.setMargins(1, 1, 1, 1); // For cell borders

                TextView cellView = new TextView(this);
                cellView.setLayoutParams(params);
                cellView.setGravity(Gravity.CENTER);
                cellView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18); // Set your desired size
                cellView.setTypeface(cellView.getTypeface(), Typeface.BOLD); // Optional: make text bold

                String cellData = cells[j];
                if (cellData.equals("#")) {
                    // Null cell, set background color to black
                    cellView.setBackgroundColor(Color.BLACK);
                } else if (cellData.contains(".")) {
                    // Sum cell, extract and set the sums
                    String[] parts = cellData.split("\\.");
                    String vSum = parts[0].equals("vSum") ? "" : parts[0];
                    String hSum = parts[1].equals("hSum") ? "" : parts[1];
                    // You need a way to display vSum and hSum diagonally divided
                    // Here you might want to use a custom drawable or a custom TextView
                    cellView.setText(String.format("%s|%s", vSum, hSum)); // Temporary representation
                    cellView.setBackgroundColor(Color.LTGRAY); // Sum cells with a different color
                } else if (cellData.equals("_")) {
                    // Empty cell, set background color to white and make it clickable
                    cellView.setBackgroundColor(Color.WHITE);
                    // You can set an OnClickListener here to handle user input
                }

                gridLayout.addView(cellView);
            }
        }
    }
}