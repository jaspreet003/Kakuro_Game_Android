package com.example.kakuro_game_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import model.DiagonalSumCellView;
import model.Grid;

public class GameplayActivity extends AppCompatActivity implements View.OnClickListener {

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
                params.width = 0;
                params.height = 0;
                params.rowSpec = GridLayout.spec(i, 1f);
                params.columnSpec = GridLayout.spec(j, 1f);
                params.setMargins(1, 1, 1, 1); // For cell borders

                String cellData = cells[j];
                if (cellData.equals("#")) {
                    // Null cell, set background color to black
                    TextView cellView = new TextView(this);
                    cellView.setLayoutParams(params);
                    cellView.setBackgroundResource(R.drawable.null_cell_background);
                    gridLayout.addView(cellView);
                } else if (cellData.contains(".")) {
                    // Sum cell, extract and set the sums
                    String[] parts = cellData.split("\\.");
                    String vSum = parts[0].equals("vSum") ? "" : parts[0];
                    String hSum = parts[1].equals("hSum") ? "" : parts[1];

                    DiagonalSumCellView sumCellView = new DiagonalSumCellView(this, hSum, vSum);

                    sumCellView.setBackgroundResource(R.drawable.null_cell_background);
                    sumCellView.setLayoutParams(params);
                    gridLayout.addView(sumCellView); // Make sure to add sumCellView, not cellView
                } else if (cellData.equals("_")) {
                    // Empty cell, set background color to white and make it clickable
                    TextView cellView = new TextView(this);
                    cellView.setLayoutParams(params);
                    cellView.setBackgroundResource(R.drawable.cell_background);

                    cellView.setOnClickListener(this);
                    // You can set an OnClickListener here to handle user input
                    gridLayout.addView(cellView);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        v.setBackgroundColor(Color.GREEN);
    }

}