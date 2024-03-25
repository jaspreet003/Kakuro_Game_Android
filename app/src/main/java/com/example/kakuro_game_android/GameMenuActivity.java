package com.example.kakuro_game_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import model.Account;
import model.GamePlay;
import model.Player;

public class GameMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Player player;

    Button howToPlayButton;
    Button previousGameButton;
    Button newGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        Account acc1 = new Account();
        GamePlay preGame1 = new GamePlay();

        player = new Player(null, "Test Player", "1", null);

        howToPlayButton = findViewById(R.id.howToPlay_button);
        previousGameButton = findViewById(R.id.previousGame_button);
        newGameButton = findViewById(R.id.newGame_button);

        if (player.getAccountId() == null || player.getPreviousGame() == null) {
            previousGameButton.setVisibility(View.GONE);
        }

        howToPlayButton.setOnClickListener(this);
        previousGameButton.setOnClickListener(this);
        newGameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.howToPlay_button){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BYX93SLkNrQ"));
            startActivity(intent);
        }
        else if (v.getId() == R.id.newGame_button) {
            Intent intent = new Intent(GameMenuActivity.this, LevelSelectionActivity.class);
            startActivity(intent);
        }
    }
}