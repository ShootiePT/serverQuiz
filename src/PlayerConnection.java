import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;

public class PlayerConnection implements Runnable {
    private final Socket clientSocket;
    public String name;
    private InputStream in;
    private PrintStream out;
    public boolean gameEnd = false;
    public int score;

    private boolean isPlayerReady;

    public boolean isPlayerReady() {
        return isPlayerReady;
    }

    public PlayerConnection(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    public int getScore() {
        return score;
    }

    @Override
    public void run() {

        //BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        try {
            setStreams();
            setName();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setName() throws IOException {
        Prompt prompt = new Prompt(in, out);
        StringInputScanner setName = new StringInputScanner();
        setName.setMessage("What is your name ?");
        name = prompt.getUserInput(setName);
        isPlayerReady = true;
        //System.out.println("Hello " + name);
    }

    public void setStreams() throws IOException{
        in = clientSocket.getInputStream();
        out = new PrintStream(clientSocket.getOutputStream());
    }
}
