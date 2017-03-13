package com.quangleeit.itsecuritylearning.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;


public class QuizAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<ItemQuiz> arrQuiz;
    private DbManager dbManager;

    public QuizAdapter(Context context) {
        this.context = context;
        layoutInflater = layoutInflater.from(context);
        initArrayList();
    }

    public void initArrayList() {
        dbManager = new DbManager(context);
        dbManager.getQuizData();

        arrQuiz = new ArrayList<>();

        for (int i = 0; i < dbManager.getItemQuizs().size(); i++) {
            arrQuiz.add(dbManager.getItemQuizs().get(i));
        }

    }


    @Override
    public int getCount() {
        return arrQuiz.size();
    }

    public ArrayList<ItemQuiz> getQuizArrayList() {
        return arrQuiz;
    }

    @Override
    public ItemQuiz getItem(int position) {
        return arrQuiz.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_quiz, parent, false);
            TextView txtView = (TextView) convertView.findViewById(R.id.txt_title_quiz);
            txtView.setText(arrQuiz.get(position).getTitle());

//            TextView txtScore =  (TextView) convertView.findViewById(R.id.txt_title_quiz);
//            txtScore.setText(arrQuiz.get(position).getScore());

        }
        return convertView;
    }
}
