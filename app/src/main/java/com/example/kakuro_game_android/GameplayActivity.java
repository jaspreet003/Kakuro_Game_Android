package com.example.kakuro_game_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

import model.Grid;

public class GameplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        GridLayout gridLayout = findViewById(R.id.kakuroGrid);
        Grid kakuroGrid = new Grid();

        for(int i = 0; i <kakuroGrid.getRows();i++){
            for(int j = 0;j < kakuroGrid.getColumns();j++){

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 0;
                params.height = 0;
                params.rowSpec = GridLayout.spec(i, 1f);
                params.columnSpec = GridLayout.spec(j, 1f);
                params.setMargins(1, 1, 1, 1); // For cell borders

                TextView cellView = new TextView(this);
                cellView.setLayoutParams(params);

                // Set the cell based on the type
                // e.g., if cell type is null, set background to black
                // if cell type is clue, set text to the clue value
                // if cell type is empty, set background to white and make it clickable/editable
                // This will depend on your Grid class's implementation

                gridLayout.addView(cellView);
            }
        }
    }
}