public class ScoreBoard {

    private int playerScore;

    private int computerScore;

    public ScoreBoard() {
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public void addPlayerScore() {
        playerScore++;
    }

    public void addComputerScore() {
        computerScore++;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
