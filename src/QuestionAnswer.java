import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import java.io.IOException;
import java.io.PrintStream;


public class QuestionAnswer {

    //After each answer to the question, move on to the next one
    public void question1(PlayerConnection player) {
        Prompt prompt;
        try {
            prompt = new Prompt(player.getClientSocket().getInputStream(), new PrintStream(player.getClientSocket().getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] options = {"var myVariable = 10", "int myVariable = 10", "variable myVariable = 10","myVariable = 10"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What is the correct syntax to declare a variable in Java?");
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

        String[] options = {"void.", "null.", "return.", "none of the above."};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Which keyword is used to define a method that doesn't return any value in Java?");
        int answer = prompt.getUserInput(scanner);
        if (answer == 1) {
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

        String[] options = {"It restricts access to the class.", "It allows access to the class from anywhere.", "It allows access only within the same package.", "It allows access only within the same class."};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What is the purpose of the 'public' access modifier in Java?");
        int answer = prompt.getUserInput(scanner);
        if (answer == 2) {
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

        String[] options = {"MyClass.create();", "new MyClass = newObject;", "MyClass.createInstance();", "MyClass newObject = new MyClass();"};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("What is the correct way to create an instance of a class in Java?");
        int answer = prompt.getUserInput(scanner);
        if (answer == 4) {
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

        String[] options = {"It indicates that a variable or method is accessible from any class in the same package.", "It indicates that a variable or method cannot be modified.", "It indicates that a variable or method belongs to the class, not to instances of the class.", "It indicates that a variable or method can only be accessed within the same package."};
        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Which statement is true about arrays in Java?");
        int answers = prompt.getUserInput(scanner);
        if (answers == 3) {
            player.score++;
        }
    }
}