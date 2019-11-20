package ohtu;

public class TennisGame {
        
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private String[] points;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.points = new String[]{"Love","Fifteen","Thirty","Forty"};
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    private String tieState() {
        if (player1Score > 3) {
            return "Deuce";
        }

        return points[player1Score] + "-All";
    }

    private String advantageOrWinState() {
        int point = Math.abs(player1Score - player2Score);
        String winner = player1Score > player2Score ? player1Name : player2Name;

        if (point >= 2) {
            return "Win for " + winner;
        } else {
            return "Advantage " + winner;
        }
    }

    private String gameState() {
        return points[player1Score]+"-"+points[player2Score];
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return tieState();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return advantageOrWinState();
        } else {
            return gameState();
        }
    }
}