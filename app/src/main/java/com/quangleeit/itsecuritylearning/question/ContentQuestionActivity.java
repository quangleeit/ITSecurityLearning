package com.quangleeit.itsecuritylearning.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.quangleeit.itsecuritylearning.R;

public class ContentQuestionActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private QuestionAdapter questionAdapter;
    private Button btnNext;
    private int indexEnd;
    int score;
    int questId;
    int checked;


    public ContentQuestionActivity() {
        this.score = 0;
        this.checked = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_quest);

        questionAdapter = new QuestionAdapter(this, this);
        viewPager = (ViewPager) findViewById(R.id.view_pager_content_question);
        viewPager.setAdapter(questionAdapter);
        indexEnd = questionAdapter.getCount();

        // int position = getIntent().getIntExtra("KeyQuiz", -1);
        btnNext = (Button) findViewById(R.id.button_next);
        //btnPrivios = (Button) findViewById(R.id.button_privios);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checked != 0) {
                    questId++;
                    checked = 0;
                    viewPager.setCurrentItem(questId, true);
                    if (questId == indexEnd) {

                        Intent intent = new Intent(ContentQuestionActivity.this, ResultActivity.class);
                        //intent.putExtra("qid", Integer.toString(this.quizActivity.quesID));
                        intent.putExtra("score", Integer.toString(score));
                        intent.putExtra("total", Integer.toString(indexEnd));
                        intent.putExtra("wrong", Integer.toString(indexEnd-score));

                       // Toast.makeText(ContentQuestionActivity.this, (score/indexEnd)*10 +"", Toast.LENGTH_SHORT).show();
                        //intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                    }
                }
                else Toast.makeText(ContentQuestionActivity.this, "Please Check Any Option", Toast.LENGTH_SHORT).show();

            }
        });

//        btnPrivios.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                questId--;
//                viewPager.setCurrentItem(questId, true);
//            }
//        });


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
