import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    protected JPanel gamePanel = new JPanel();
    protected JPanel northPanel = new JPanel();
    protected JPanel centerPanel = new JPanel();
    protected JPanel southPanel = new JPanel();
    protected JButton newGameButton = new JButton("New Game");
    protected JButton rockButton = new JButton(Choice.ROCK.getIcon());
    protected JButton paperButton = new JButton(Choice.PAPER.getIcon());
    protected JButton scissorsButton = new JButton(Choice.SCISSORS.getIcon());
    protected JLabel playerScoreLabel = new JLabel("Player Score: 0", JLabel.LEFT);
    protected JLabel computerScoreLabel = new JLabel("Computer Score: 0", JLabel.RIGHT);
    protected JLabel gameProcessLabel = new JLabel("Rock Paper Scissors!");
    protected JLabel playerNameLabel = new JLabel("Player ->", JLabel.LEFT);
    protected JLabel computerNameLabel = new JLabel("<- Computer", JLabel.RIGHT);
    protected JLabel playerChoiceLabel = new JLabel(new ImageIcon("src/icons/icons8_question_mark_126px.png"), JLabel.LEFT);
    protected JLabel computerChoiceLabel = new JLabel(new ImageIcon("src/icons/icons8_question_mark_126px.png"), JLabel.RIGHT);

    private final Controller controller = new Controller(this);

    private final Font font = new Font("DialogInput", Font.BOLD, 20);
    private final Font titleFont = new Font("DialogInput", Font.BOLD, 30);

    public View() {
        super("Rock Paper Scissors");

        gamePanel.setLayout(new BorderLayout());
        gameProcessLabel.setFont(titleFont);
        northPanel.add(gameProcessLabel);
        northPanel.setBorder(BorderFactory.createEmptyBorder(40, 10, 0, 10));
        gamePanel.add(northPanel, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(1, 4));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        playerNameLabel.setFont(font);
        centerPanel.add(playerNameLabel);

        JPanel playerChoicePanel = new JPanel();
        playerChoicePanel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        playerChoiceLabel.setBackground(Color.lightGray);
        playerChoiceLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        playerChoiceLabel.setOpaque(true);
        playerChoicePanel.add(playerChoiceLabel, c2);
        centerPanel.add(playerChoicePanel);

        JPanel computerChoicePanel = new JPanel();
        computerChoicePanel.setLayout(new GridBagLayout());
        computerChoiceLabel.setBackground(Color.lightGray);
        computerChoiceLabel.setOpaque(true);
        computerChoicePanel.add(computerChoiceLabel);
        computerChoiceLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        centerPanel.add(computerChoicePanel);

        computerNameLabel.setFont(font);

        centerPanel.add(computerNameLabel);
        gamePanel.add(centerPanel, BorderLayout.CENTER);

        playerScoreLabel.setFont(font);
        computerScoreLabel.setFont(font);


        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2));
        scorePanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        scorePanel.add(playerScoreLabel);
        scorePanel.add(computerScoreLabel);

        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(10, 0, 0, 0);
        southPanel.add(scorePanel, c);

        c.gridwidth = 1;
        rockButton.addActionListener(e -> controller.choiceMade(Choice.ROCK));
        southPanel.add(rockButton, c);
        c.gridwidth = GridBagConstraints.RELATIVE;
        paperButton.addActionListener(e -> controller.choiceMade(Choice.PAPER));
        southPanel.add(paperButton, c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        scissorsButton.addActionListener(e -> controller.choiceMade(Choice.SCISSORS));
        southPanel.add(scissorsButton, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.ipady = 32;
        newGameButton.setFont(font);
        newGameButton.addActionListener(e -> controller.newGame());
        southPanel.add(newGameButton, c);

        gamePanel.add(southPanel, BorderLayout.SOUTH);

        add(gamePanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 640);
        setLocationRelativeTo(null);
        setVisible(true);
        newGameButton.requestFocus();
    }


}
