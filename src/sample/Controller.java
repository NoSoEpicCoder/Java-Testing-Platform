package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import java.lang.reflect.Array;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleGroup;

/**
 * @author Kevin Gilbert
 *
 * Knowledge test created using JavaFX for the frontend. The backend has the questions and answers stored in Arrays.
 *
 * @ TODO: 2019-03-18 Allow questions and answers to be red from an input file. Length of the test will depend on the number of questions stored on file.
 * @ TODO: 2019-03-18 Show test results in a new window instead of console.
 */
public class Controller {

    @FXML private Label questionLabel, questionNum, resultLabel;
    @FXML private RadioButton answer1, answer2, answer3, answer4, answer5;
    @FXML private Button nextButton;
    final private ToggleGroup group = new ToggleGroup();
    private int counter = 0;
    private int finalScore = 0;

    private String[] questions = {"Who is the President of Canada?", "What year did Hurricane Jeanne occur?", "Which planet is closest to the Sun?",
            "At what temperature are Celsius and Fahrenheit equal?", "Which of the following is the longest running animated show?", "What is Canada’s national sport?",
            "What is the average lifespan of a dog?", "Which country is the most populated in the world?", "What year did the iPhone come out?", "What is the most deadly animal in the world?"};
    private String[] answers1 = {"Stephen Harper", "Justin Trudeau", "Pierre Elliott Trudeau", "Queen Elizabeth", "President? Not in Canada"};
    private String[] answers2 = {"2005", "2004", "2007", "1994", "2010"};
    private String[] answers3 = {"Mars", "Earth", "Mercury", "Neptune", "Saturn"};
    private String[] answers4 = {"0", "-15", "36", "-40", "7"};
    private String[] answers5 = {"Rugrats", "The Simpsons", "Pokemon", "South Park", "King Of The Hill"};
    private String[] answers6 = {"Curling", "Hockey", "Lacrosse", "Figure Skating", "Cross-Country Ski"};
    private String[] answers7 = {"8 years", "5 years", "10 years", "50 years", "16 years"};
    private String[] answers8 = {"India", "Brazil", "Russia", "United States", "China"};
    private String[] answers9 = {"2001", "2010", "2007", "2008", "2005"};
    private String[] answers10 = {"Fly", "Crocodile", "Cow", "Pufferfish", "Mosquito"};
    private String[][] answers = {answers1, answers2, answers3, answers4, answers5, answers6, answers7, answers8, answers9, answers10};
    private String[] results = new String[11];
    private String[] correctAnswers = {"earth", "president? not in canada", "2004", "mercury", "-40", "the simpsons", "lacrosse", "10 years", "china", "2007", "mosquito"};

    private void checkResult() {
        //Loops through every result and compares them with the correct answer
        for (int i = 0; i < 11; i++) {
            if ((results[i].equalsIgnoreCase(correctAnswers[i]))) {
                finalScore++;
            }
        }
        System.out.print("Your score is " + finalScore + "/11");
    }

    //Action event called when the next question button is pressed
    private EventHandler<ActionEvent> next = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {

            //Adding the answers chosen by user to an array
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();
            results[counter] = toggleGroupValue.toLowerCase();

            if (counter != 10) {
                questionNum.setText("Question " + (counter + 1));
                questionLabel.setText(Array.get(questions, counter).toString());

                answer1.setText(answers[counter][0]);
                answer2.setText(answers[counter][1]);
                answer3.setText(answers[counter][2]);
                answer4.setText(answers[counter][3]);
                answer5.setText(answers[counter][4]);

                counter++;
            } else {
                checkResult();
            }
        }
    };

    @FXML
    public void initialize() {

        answer1.setToggleGroup(group);
        answer2.setToggleGroup(group);
        answer3.setToggleGroup(group);
        answer4.setToggleGroup(group);
        answer5.setToggleGroup(group);
        nextButton.setOnAction(next);
    }
}