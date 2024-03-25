package model;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kakuro_game_android.GameplayActivity;
import com.example.kakuro_game_android.R;

import java.util.ArrayList;

public class LevelAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Level> levelList;
    Level oneLevel;

    public LevelAdapter(Context context, ArrayList<Level> levelList){
        this.context = context;
        this.levelList = levelList;
    }

    @Override
    public int getCount() {
        return levelList.size();
    }

    @Override
    public Object getItem(int position) {
        return levelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.one_item, parent, false);
        }

        // Initialize TextViews by finding them in 'view'
        TextView tvLevelId = view.findViewById(R.id.item_name);
        TextView tvLevelDescription = view.findViewById(R.id.item_description);

        //initialize your 'playGameButton' from 'view'
        Button playGameButton = view.findViewById(R.id.button_play_game);

        //setup the level based on the position
        Level level = (Level) getItem(position);

        // Set the texts for TextViews
        tvLevelId.setText(String.valueOf(level.getLevelId()));
        tvLevelDescription.setText(level.getDescription());

        // Set the OnClickListener for your button
        playGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Correctly create an intent to start GameplayActivity
                Intent intent = new Intent(context, GameplayActivity.class);

                // passing the level ID
                intent.putExtra("levelId", level.getLevelId());

                context.startActivity(intent); // Use 'context' to start the Activity
            }
        });

        return view;
    }

}


