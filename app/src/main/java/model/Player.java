package model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Player {

    public interface OnPlayerCreatedListener {
        public void onSuccess();
        public void onError(String error);
    }

    private String accountId; // This is the Firebase Authentication User ID
    private String playerId;
    private String playerName;


    // Default constructor is required for Firebase
    public Player() {
    }

    // Constructor with parameters
    public Player(String accountId, String playerName, String playerId) {
        this.accountId = accountId;
        this.playerName = playerName;
        this.playerId = playerId;
    }

    // Getters and Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    // Static method to create and save a new player
    public static void createAndSavePlayer(final String username, final String accountId, final OnPlayerCreatedListener listener) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference playersRef = database.getReference("players");

        // Generating a new unique key for each player
        String playerId = playersRef.push().getKey();

        Player newPlayer = new Player(accountId, username, playerId);

        playersRef.child(playerId).setValue(newPlayer)
                .addOnSuccessListener(aVoid -> listener.onSuccess())
                .addOnFailureListener(e -> listener.onError(e.getMessage()));
    }




}

