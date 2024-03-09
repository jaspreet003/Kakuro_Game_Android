package model;

public class Player {

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



}
