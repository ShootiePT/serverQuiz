import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuizGame {
    private LinkedList<PlayerConnection> playerConnections;
    private QuestionAnswer questionAnswer = new QuestionAnswer();
    private List<String> questions;
    private List<String> answers;
    private int currentQuestionIndex;
    //private final QuestionAnswer questionAnswer;

    public QuizGame(LinkedList<PlayerConnection> playerConnection) {
        this.playerConnections = playerConnection;
        // this.questionAnswer = questionAnswer;
    }

    public void sendQuestion() {

        List<Thread> threads = new ArrayList<>();

        for (PlayerConnection player : playerConnections) {
            Thread t = new Thread(() -> {
                //System.out.println(Thread.currentThread().getName());
                questionAnswer.question1(player);
            });
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void start() {
        while (true) {

            boolean allPlayersReady = true;

            for (int i = 0; i < playerConnections.size(); i++) {
                if (!playerConnections.get(i).isPlayerReady()) {
                    allPlayersReady = false;
                }
            }
            if (allPlayersReady) {
                sendQuestion();
                break;
            }
        }
    }

    public void endGame() throws IOException {
        while (true) {

            boolean badjoras = false;
            for (PlayerConnection player : playerConnections) {
                if (!player.gameEnd) {
                    player.gameEnd = true;
                    badjoras = player.gameEnd;
                }
            }
            if (badjoras) {
                sendScore();
                break;

            }
        }
    }

    public void sendScore() throws IOException {
        int highestScore = Integer.MIN_VALUE;
        List<PlayerConnection> winners = new ArrayList<>();

        for (PlayerConnection player : playerConnections) {
            int score = player.getScore();

            System.out.println(player.name + " got " + score + " points");

            if (score > highestScore) {
                highestScore = score;
                winners.clear();
                winners.add(player);
            } else if (score == highestScore) {
                winners.add(player);
            }
        }

        //Announcing the winner
        if (!winners.isEmpty()) {
            if (winners.size() == 1) {
                PlayerConnection winner = winners.get(0);
                for(PlayerConnection player : playerConnections) {
                    PrintWriter writer = new PrintWriter(player.getClientSocket().getOutputStream(), true);
                    writer.println("The winner is " + winner.name + " with a score of " + highestScore);
                }
            } else {
                for(PlayerConnection player : playerConnections) {
                    PrintWriter writer = new PrintWriter(player.getClientSocket().getOutputStream(), true);
                    writer.println("There are multiple winners with a score of " + highestScore + ":");
                }
                for (PlayerConnection winner : winners) {
                    for(PlayerConnection player : playerConnections) {
                        PrintWriter writer = new PrintWriter(player.getClientSocket().getOutputStream(), true);
                        writer.println(winner.name);
                    }
                }
            }
        } else {
            for(PlayerConnection player : playerConnections) {
                PrintWriter writer = new PrintWriter(player.getClientSocket().getOutputStream(), true);
                writer.println("No winner found.");
            }
        }

    }
}
