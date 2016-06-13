package com.example.fadi.simulateurcea;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import adapter.AnswerAdapter;
import quiz.Answer;
import quiz.QuizGenerator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuizFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragement extends Fragment implements android.widget.CompoundButton.OnCheckedChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int count = 0 ;
    private int score = 0 ;
    View v ;
    QuizGenerator quiz ;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lv ;
    List<Answer> answers ;
    AnswerAdapter answerAdapter;
    private OnFragmentInteractionListener mListener;

    public QuizFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragement newInstance(String param1, String param2)  {
        QuizFragement fragment = new QuizFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quiz_fragement, container, false);
        quiz = new QuizGenerator();
        //Get Question  View
        TextView question = (TextView) v.findViewById(R.id.quiz_question);
        question.setText(quiz.getQuestions().elementAt(count).getQuestion());
        //Getting List View
        this.lv = (ListView)v.findViewById(R.id.quiz_answers);
        this.answers = quiz.getQuestions().elementAt(count).getAnswers() ;
        answerAdapter = new AnswerAdapter(this.answers, this.getActivity());
        answerAdapter.quizFragement = this ;
        lv.setAdapter(answerAdapter);
        return v ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int position = lv.getPositionForView(buttonView);
        Answer picked_answer = answers.get(position);
        System.out.println("----------" + picked_answer.isTrue() +"---------");
        this.count++ ;
        if(picked_answer.isTrue()==true) {

        this.score++ ;

        }
        else {
            Toast.makeText(this.getActivity(), (String) "Votre Reponse est fausse",
                    Toast.LENGTH_LONG).show();
        }
        if(quiz.getQuestions().size()<count+1) {
            TextView questionText = (TextView) v.findViewById(R.id.quiz_question);
            questionText.setText("Vous Avez Termine le Quiz. Bravo \n Votre Score est "+this.score+"/"+quiz.getQuestions().size());
            ListView answerList = (ListView) v.findViewById(R.id.quiz_answers);
            answerList.setAdapter(null);
        }
        else {
            TextView question = (TextView) v.findViewById(R.id.quiz_question);
            question.setText(quiz.getQuestions().elementAt(count).getQuestion());
            this.lv = (ListView)v.findViewById(R.id.quiz_answers);
            this.answers = quiz.getQuestions().elementAt(count).getAnswers() ;
            answerAdapter = new AnswerAdapter(this.answers, this.getActivity());
            answerAdapter.quizFragement = this ;
            lv.setAdapter(answerAdapter);

        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
