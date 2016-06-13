package quiz;

/**
 * Created by Fadi on 6/1/2016.
 */
public class Answer {

    private String answer ;
    private boolean isTrue ;

    public Answer(String answer , boolean isTrue) {
        this.setAnswer(answer);
        this.setIsTrue(isTrue);
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
}
