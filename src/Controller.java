import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Controller {

    private View view;
    private ScoreBoard scoreBoard = new ScoreBoard();

    private boolean playing;
    public Controller(View view) {
        this.view = view;
        playing = false;
    }

    public void choiceMade(Choice userChoice) {
        if (!playing) {
            playing = true;
            view.playerChoiceLabel.setIcon(userChoice.getIcon());
            Choice computerChoice = getRandomComputerChoice();
            view.computerChoiceLabel.setIcon(computerChoice.getIcon());
            int result = calculateResult(userChoice, computerChoice);
            displayResult(result);
            updateGameScore();
        }
    }

    private void updateGameScore() {
        int pScore = scoreBoard.getPlayerScore();
        int cScore = scoreBoard.getComputerScore();
        view.playerScoreLabel.setText("Player Score: " + pScore);
        view.computerScoreLabel.setText("Computer Score: " + cScore);
    }

    private void displayResult(int result) {
        switch (result) {
            case 1 -> {
                view.gameProcessLabel.setText("You won!");
                view.playerChoiceLabel.setBackground(Color.green);
                view.computerChoiceLabel.setBackground(Color.red);
                scoreBoard.addPlayerScore();
            }
            case -1 -> {
                view.gameProcessLabel.setText("You lost!");
                view.playerChoiceLabel.setBackground(Color.red);
                view.computerChoiceLabel.setBackground(Color.green);
                scoreBoard.addComputerScore();
            }
            case 0 -> view.gameProcessLabel.setText("It's a tie!");
        }
    }

    private int calculateResult(Choice userChoice, Choice computerChoice) {
        if (userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) {
            return 1;
        } else if (userChoice == Choice.PAPER && computerChoice == Choice.ROCK) {
            return 1;
        } else if (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) {
            return 1;
        } else if (userChoice == computerChoice) {
            return 0;
        } else {
            return -1;
        }
    }

    private Choice getRandomComputerChoice() {
        Random r = new Random();
        int num = r.nextInt(Choice.values().length);
        return Choice.values()[num];
    }

    public void newGame() {
        //reset gameboard and wait for input
        view.gameProcessLabel.setText("Rock Paper Scissors!");
        view.playerChoiceLabel.setIcon(new ImageIcon("src/icons/icons8_question_mark_126px.png"));
        view.computerChoiceLabel.setIcon(new ImageIcon("src/icons/icons8_question_mark_126px.png"));
        view.playerChoiceLabel.setBackground(Color.lightGray);
        view.computerChoiceLabel.setBackground(Color.lightGray);
        playing = false;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
    }
}
