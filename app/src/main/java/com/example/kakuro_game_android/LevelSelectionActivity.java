package com.example.kakuro_game_android;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import model.Level;
import model.LevelAdapter;
import model.Player;

public class LevelSelectionActivity extends AppCompatActivity {

    ListView lvListView;
    ArrayList<Level> levelList;

    LevelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        initialize();

    }

    private void initialize() {
        levelList = new ArrayList<>();
        levelList.add(new Level(1,"Level 1", null,null));
        levelList.add(new Level(2,"Level 2", null,null));
        levelList.add(new Level(3,"Level 3", null,null));

        lvListView = findViewById(R.id.list_view);

        adapter = new LevelAdapter(this, levelList);
        lvListView.setAdapter(adapter);
    }
}