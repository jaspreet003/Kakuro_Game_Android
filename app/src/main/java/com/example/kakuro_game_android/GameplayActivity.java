package com.example.kakuro_game_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import model.DiagonalSumCellView;
import model.Grid;

public class GameplayActivity extends AppCompatActivity implements View.OnClickListener {
    private View previousCell = null;
    private TextView selectedNumberTextView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        Grid kakuroGrid = new Grid();
        generatePuzzleGrid(kakuroGrid);

        setupNumberSelection();

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
                params.rowSpec = GridLayout.spec(i, 1f); // row number
                params.columnSpec = GridLayout.spec(j, 1f); //column number
                params.setMargins(1, 1, 1, 1); // For cell borders

                String cellData = cells[j];
                if (cellData.equals("#")) {
                    // Null cell
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
                    gridLayout.addView(sumCellView);
                } else if (cellData.equals("_")) {
                    // Empty cell
                    TextView cellView = new TextView(this);
                    cellView.setLayoutParams(params);
                    cellView.setBackgroundResource(R.drawable.cell_background);
                    cellView.setGravity(Gravity.CENTER);
                    cellView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                    cellView.setTypeface(null, Typeface.BOLD);
                    cellView.setTextColor(Color.BLACK);

                    cellView.setOnClickListener(this);
                    cellView.setTag(R.drawable.cell_background); // Use tag to store the original background for easy reset
                    gridLayout.addView(cellView);
                }
            }
        }
    }

    private void setupNumberSelection() {
        int[] numberIds = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        for (int id : numberIds) {
            TextView numberView = findViewById(id);
            numberView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() instanceof Integer) { // Assuming all grid cells have a drawable tag
            handleCellClick(v); // This is a cell in the grid
        } else {
            handleNumberSelection((TextView) v); // This is a number in the palette
        }
    }

    private void handleCellClick(View cellView) {
        if (previousCell != null && previousCell != cellView) {
            int backgroundResource = (Integer) previousCell.getTag();
            previousCell.setBackgroundResource(backgroundResource);
        }
        cellView.setBackgroundColor(Color.GREEN); // Highlight the current cell
        previousCell = cellView;
    }


    private void handleNumberSelection(TextView numberTextView) {
        if (previousCell != null && previousCell.getTag() instanceof Integer) { // Again, checking if it's a cell in the grid
            ((TextView) previousCell).setText(numberTextView.getText().toString());
        } else {
            Toast.makeText(this, "Please select a cell to fill.", Toast.LENGTH_SHORT).show();
        }
    }
}


