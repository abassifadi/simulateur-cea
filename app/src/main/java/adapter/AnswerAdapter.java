package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.fadi.simulateurcea.MainActivity;
import com.example.fadi.simulateurcea.QuizFragement;
import com.example.fadi.simulateurcea.R;

import java.util.List;

import quiz.Answer;

/**
 * Created by Fadi on 6/1/2016.
 */

public class AnswerAdapter extends ArrayAdapter<Answer> {

    private List<Answer> answers ;
    private Context context ;
    public QuizFragement quizFragement ;
    public AnswerAdapter(List<Answer> answers, Context context) {
        super(context, R.layout.answer_layout , answers);
        this.answers = answers ;
        this.context = context ;
    }

    private class AnswerHolder {
        public TextView answer ;
        public CheckBox checked ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView ;
        AnswerHolder holder = new AnswerHolder() ;
        if(convertView == null){
            System.out.println("***********Convert View Null********");
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate( R.layout.answer_layout, null);
            holder.answer = (TextView)v.findViewById(R.id.answer_text);
            holder.checked = (CheckBox)v.findViewById(R.id.answer_checked);




            //holder.checked.setOnCheckedChangeListener((MainActivity)activity);
        }
        else {
            holder = (AnswerHolder)v.getTag();
        }

        Answer answer = answers.get(position);
//        holder.answer.setText(answer.getAnswer());
        ((TextView) v.findViewById(R.id.answer_text)).setText(answer.getAnswer());
        ((CheckBox)v.findViewById(R.id.answer_checked)).setChecked(false);
        ((CheckBox)v.findViewById(R.id.answer_checked)).setOnCheckedChangeListener(quizFragement);
        //holder.checked.setChecked(false);
        //holder.checked.setTag(answer);
        return v;
    }
}
