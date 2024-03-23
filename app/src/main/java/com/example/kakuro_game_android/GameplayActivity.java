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
//    private TextView selectedNumberTextView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        Grid kakuroGrid = new Grid();
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
                    EditText cellView = new EditText(this);
                    cellView.setInputType(InputType.TYPE_CLASS_NUMBER);
                    cellView.setLayoutParams(params);
                    cellView.setBackgroundResource(R.drawable.cell_background);

                    cellView.setOnClickListener(this);

                    cellView.setTag(R.drawable.cell_background);
                    gridLayout.addView(cellView);
                }
            }
        }
    }

/*    private void setupNumberSelection() {
        int[] numberIds = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        for (int id : numberIds) {
            TextView numberView = findViewById(id);
            numberView.setOnClickListener(this);
        }
    }*/

    @Override
    public void onClick(View v) {

        if (previousCell != null && previousCell != v) {
            int backgroundResource = (Integer) previousCell.getTag();
            previousCell.setBackgroundResource(backgroundResource);
        }

        v.setBackgroundColor(Color.GREEN); // Highlight the current cell

        previousCell = v;
    }
}


