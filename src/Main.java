import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Main {
    private static final LinkedList<PlayerConnection> playersConnections = new LinkedList<>();
    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {

        QuizGame game = new QuizGame(playersConnections);

        try {
            ServerSocket serverSocket = new ServerSocket(9004);

            while (true) {
                if (playersConnections.size() >= MAX_PLAYERS) {
                    break;
                }
                Socket clientSocket = serverSocket.accept();

                PlayerConnection playerConnection = new PlayerConnection(clientSocket);
                playersConnections.add(playerConnection);

                Thread clientThread = new Thread(playerConnection);
                clientThread.start();
                //System.out.println(playersConnections.get(0).name);
                if (playersConnections.size() == MAX_PLAYERS) {

                    game.start();
                    game.endGame();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}