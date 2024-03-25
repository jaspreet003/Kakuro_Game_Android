package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        View oneItem = null;
        TextView tvLevelId, tvLevelDescription;
        Button viewRankButton, playGameButton;

        LayoutInflater inflater = LayoutInflater.from(context);
        oneItem = inflater.inflate(R.layout.one_item, (ViewGroup) convertView,false);

        tvLevelId = oneItem.findViewById(R.id.item_name);
        tvLevelDescription = oneItem.findViewById(R.id.item_description);
        viewRankButton = oneItem.findViewById(R.id.button_view_rank);
        playGameButton = oneItem.findViewById(R.id.button_play_game);

        oneLevel = (Level) getItem(position);
        tvLevelId.setText(String.valueOf(oneLevel.getLevelId()));
        tvLevelDescription.setText(oneLevel.getDescription());

        return oneItem;
    }
}


