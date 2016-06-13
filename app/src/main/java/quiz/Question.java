package quiz;

import java.util.Vector;

/**
 * Created by Fadi on 6/1/2016.
 */
public class Question {

    private String question ;
    private Vector<Answer> answers ;

    public Question(String s , Vector<Answer> answers) {
          this.setQuestion(s);
          this.setAnswers(answers);
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Vector<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Vector<Answer> answers) {
        this.answers = answers;
    }
}
