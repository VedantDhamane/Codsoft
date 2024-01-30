package JavaProgram;
import java.util.*;
class Question {
	String question;
	ArrayList<String> options;
	String correctAnswer;
	Question(String questions,ArrayList<String> options,String CorrectAns){
		this.question = questions;
		this.options = options;
		this.correctAnswer= CorrectAns;
	}
}
public class Quiz {
    private ArrayList<Question> questions;
    
    private int score;
    private int currentQuestionIndex;
    private final int timerDuration = 10; // Set the timer duration in seconds
    private String name;
    public void get_Student_Info()
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please Entere your Name=");
    	name = sc.nextLine();
    }
    
    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.currentQuestionIndex = 0;
    }
    
    public void displayQuestion() {
        Question question = questions.get(currentQuestionIndex);
        System.out.println("\n" + question.question);
        for (int i = 0; i < question.options.size(); i++) {
            System.out.println((i + 1) + ". " + question.options.get(i));
        }
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            displayQuestion();
            long startTime = System.currentTimeMillis();
            String userAnswer = scanner.nextLine().trim();
            long endTime = System.currentTimeMillis();

            if ((endTime - startTime) / 1000 > timerDuration) {
                System.out.println("Time's up! Moving to the next question.");
                continue;
            }

            try {
                int selectedOption = Integer.parseInt(userAnswer);
                if (selectedOption >= 1 && selectedOption <= question.options.size()) {
                    if (question.options.get(selectedOption - 1).equals(question.correctAnswer)) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Wrong! Correct answer: " + question.correctAnswer);
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + question.options.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            currentQuestionIndex++;
        }
        displayResult();
    }
    public void displayResult() {
        System.out.println("\nQuiz completed!");
        System.out.println(name+" final score: " + score + "/" + questions.size());

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + question.question);
            System.out.println("Correct answer: " + question.correctAnswer);
            System.out.println();
        }
    }
}
