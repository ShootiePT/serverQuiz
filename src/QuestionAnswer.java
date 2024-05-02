import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import java.io.IOException;
import java.io.PrintStream;


public class QuestionAnswer {


    public void question1(PlayerConnection player) {
        Prompt prompt;
        try {
            prompt = new Prompt(player.getClientSocket().getInputStream(), new PrintStream(player.getClientSocket().getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"define", "classe", "declare","struct"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What is used to define a class in Java?");
        int answer = prompt.getUserInput(scanner);
        if (answer == 2) {
            player.score++;
        }

        question2(player);
    }

    public void question2(PlayerConnection player) {
        Prompt prompt;
        try {
            prompt = new Prompt(player.getClientSocket().getInputStream(), new PrintStream(player.getClientSocket().getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"10", "11", "12", "13"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What is the output of the following code snippet? \n int x = 5; \n" +
                "System.out.println(x++ + ++x);");
        int answer = prompt.getUserInput(scanner);
        if (answer == 4) {
            player.score++;
        }

        question3(player);
    }
    public void question3(PlayerConnection player) {
        Prompt prompt;
        try {
            prompt = new Prompt(player.getClientSocket().getInputStream(), new PrintStream(player.getClientSocket().getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"System.read()", "System.input()", "Scanner.read()", "Scanner.nextLine()"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Which keyword is used to read input from the keyboard in Java?");
        int answer = prompt.getUserInput(scanner);
        if (answer == 4) {
            player.score++;
        }

        question4(player);
    }

    public void question4(PlayerConnection player) {
        Prompt prompt;
        try {
            prompt = new Prompt(player.getClientSocket().getInputStream(), new PrintStream(player.getClientSocket().getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"double", "char", "int", "String"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What data type is used to store whole numbers in Java?");
        int answer = prompt.getUserInput(scanner);
        if (answer == 3) {
            player.score++;
        }

        question5(player);
    }
    public void question5(PlayerConnection player) {
        Prompt prompt;
        try {
            prompt = new Prompt(player.getClientSocket().getInputStream(), new PrintStream(player.getClientSocket().getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"Arrays can have a fixed size only.", "Arrays can store elements of different data types.", "Elements in an array must be of the same data type.", "Arrays cannot be accessed using indexes."};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Which statement is true about arrays in Java?");
        int answers = prompt.getUserInput(scanner);
        if (answers == 3) {
            player.score++;
        }
    }
}