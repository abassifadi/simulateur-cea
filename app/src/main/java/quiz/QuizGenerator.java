package quiz;

import java.util.Vector;

/**
 * Created by Fadi on 6/1/2016.
 */
public class QuizGenerator {

    private Vector<Question> questions ;

/*
* Generating Quiz Questions
*
* */


  public QuizGenerator() {
      setQuestions(new Vector<Question>());
      //Creating first answer
      Vector<Answer> answers = new Vector<Answer>();
      Answer answer11 = new Answer("Compte Epargne En Action",true);
      Answer answer12 = new Answer("Compte Epargne Actif",false);
      answers.add(answer11);
      answers.add(answer12);
      Question question1 = new Question("L'abreviation CEA designe : ",answers);
      //Question 2
      Vector<Answer> answers2 = new Vector<Answer>();
      Answer answer21 = new Answer("60%",false);
      Answer answer22 = new Answer("70%",false);
      Answer answer23 = new Answer("80%",true);
      answers2.add(answer21);
      answers2.add(answer22);
      answers2.add(answer23);
      Question question2 = new Question("Pour un compte CEA le taux mininum du montant place en action cote : ",answers2);
      //Question 3
      Vector<Answer> answers3 = new Vector<Answer>();
      Answer answer31 = new Answer("10%",false);
      Answer answer32 = new Answer("15%",false);
      Answer answer33 = new Answer("20%",true);
      answers3.add(answer31);
      answers3.add(answer32);
      answers3.add(answer33);
      Question question3 = new Question("Pour un compte CEA le taux maximum du montant place en BTA : ",answers3);
      //Question 4
      Vector<Answer> answers4 = new Vector<Answer>();
      Answer answer41 = new Answer("40.000",false);
      Answer answer42 = new Answer("50.000",true);
      Answer answer43 = new Answer("60.000",false);
      Answer answer44 = new Answer("70.000",false);
      answers4.add(answer41);
      answers4.add(answer42);
      answers4.add(answer43);
      answers4.add(answer44);
      Question question4 = new Question("Le montant maximale qu'on peut investir en CEA est : ",answers4);
      getQuestions().add(question1);
      getQuestions().add(question2);
      getQuestions().add(question3);
      getQuestions().add(question4);
  }


    public Vector<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Vector<Question> questions) {
        this.questions = questions;
    }
}
