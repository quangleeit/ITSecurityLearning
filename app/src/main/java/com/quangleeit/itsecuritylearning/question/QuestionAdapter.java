package com.quangleeit.itsecuritylearning.question;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;

import static com.quangleeit.itsecuritylearning.R.id.radioGroup;


public class QuestionAdapter extends PagerAdapter {

    private ContentQuestionActivity contenQuest;
    private ArrayList<ItemQuestion> arrQuestion;
    private LayoutInflater layoutInflater;
    private DbManager dbManager;
    private int yourAnwser;
    private View view;
    private ViewPagerHolder viewPagerHolder;
    private int keyQuiz;

    public QuestionAdapter(Context context, ContentQuestionActivity contenQuest) {
        this.contenQuest = contenQuest;
        layoutInflater = LayoutInflater.from(context);
        initData();
    }

    public void initData() {
        keyQuiz = contenQuest.getIntent().getIntExtra("KeyQuiz", -1);
        dbManager = new DbManager(contenQuest);
        dbManager.getQuestionData();
        arrQuestion = new ArrayList<ItemQuestion>();


        for (int i = 0; i < dbManager.getItemQuestions().size(); i++) {
            if (dbManager.getItemQuestions().get(i).getNumberQuiz() ==  keyQuiz)

                arrQuestion.add(dbManager.getItemQuestions().get(i));
        }
//        arrQuestion.add(new ItemQuestion(1, "Câu 1: Đây là câu hỏi số 1",
//                "Đây là đáp án", "Đây là đáp án","Đây là đáp án", "Đây là đáp án", "Đây là đáp án đúng"));
//        arrQuestion.add(new ItemQuestion(2, "Câu 2: Đây là câu hỏi số 2",
//                "Đây là đáp án", "Đây là đáp án","Đây là đáp án", "Đây là đáp án", "Đây là đáp án đúng"));
//        arrQuestion.add(new ItemQuestion(3, "Câu 3: Đây là câu hỏi số 3",
//                "Đây là đáp án", "Đây là đáp án","Đây là đáp án", "Đây là đáp án", "Đây là đáp án đúng"));
//        arrQuestion.add(new ItemQuestion(4, "Câu 4: Đây là câu hỏi số 4",
//                "Đây là đáp án", "Đây là đáp án","Đây là đáp án", "Đây là đáp án", "Đây là đáp án đúng"));
//        arrQuestion.add(new ItemQuestion(5, "Câu 5: Đây là câu hỏi số 5",
//                "Đây là đáp án", "Đây là đáp án","Đây là đáp án", "Đây là đáp án", "Đây là đáp án đúng"));
    }

    @Override
    public int getCount() {
        return arrQuestion.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (view.equals(object)) {
            return true;
        }
        return false;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        view = layoutInflater.inflate(R.layout.item_question, container, false);
        viewPagerHolder = new ViewPagerHolder();

        viewPagerHolder.tvQuestion = (TextView) view.findViewById(R.id.tv_question);

        viewPagerHolder.radioGroup = (RadioGroup) view.findViewById(radioGroup);

        viewPagerHolder.btnAnswerA = (RadioButton) view.findViewById(R.id.radioButtonA);

        viewPagerHolder.btnAnswerB = (RadioButton) view.findViewById(R.id.radioButtonB);

        viewPagerHolder.btnAnswerC = (RadioButton) view.findViewById(R.id.radioButtonC);

        viewPagerHolder.btnAnswerD = (RadioButton) view.findViewById(R.id.radioButtonD);


        viewPagerHolder.tvQuestion.setText(arrQuestion.get(position).getQuestion());
        viewPagerHolder.btnAnswerA.setText(arrQuestion.get(position).getAnswerA());
        viewPagerHolder.btnAnswerB.setText(arrQuestion.get(position).getAnswerB());
        viewPagerHolder.btnAnswerC.setText(arrQuestion.get(position).getAnswerC());
        viewPagerHolder.btnAnswerD.setText(arrQuestion.get(position).getAnswerD());

        viewPagerHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // viewPagerHolder.radioGroup.clearCheck();
                //RadioButton rb = (RadioButton) group.findViewById(checkedId);
                // if (null != rb && checkedId > -1) {

                // checkedId is the RadioButton selected
                contenQuest.checked = checkedId;
                switch (checkedId) {
                    case R.id.radioButtonA:

                        yourAnwser = 1;
                        Log.i("TAG", yourAnwser + "____________________________________________");
                        //     Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();
                        dbManager.getSqliteDb().execSQL("UPDATE Quiz SET score ='1' WHERE rowId=1 ");
                        break;
                    case R.id.radioButtonB:

                        yourAnwser = 2;
                        Log.i("TAG", yourAnwser + "____________________________________________");
                        //   Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.radioButtonC:

                        yourAnwser = 3;
                        Log.i("TAG", yourAnwser + "____________________________________________");
//                            Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.radioButtonD:

                        yourAnwser = 4;
                        Log.i("TAG", yourAnwser + "____________________________________________");
                        //   Toast.makeText(view.getContext(), yourAnwser + "", Toast.LENGTH_SHORT).show();

                        break;

                }
                if (yourAnwser == arrQuestion.get(position).getTrueAnswer()) {

                    contenQuest.score++;

                }
            }
            //}
        });

        container.addView(view);
        return view;

    }


    public class ViewPagerHolder {
        public TextView tvQuestion;
        public RadioGroup radioGroup;
        public RadioButton btnAnswerA, btnAnswerB, btnAnswerC, btnAnswerD, btnAnswer;


    }
}
