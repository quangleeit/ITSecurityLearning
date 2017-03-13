package com.quangleeit.itsecuritylearning.interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InterviewAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> mHeaderGroup;
    private HashMap<String, String> mDataChild;
    private List<String> arrQuest;
    private List<String> arrAnswer;
    private DbManager dbManager;

    public InterviewAdapter(Context context) {
        mContext = context;
        initData();
    }

    public void initData() {
        arrQuest = new ArrayList<>();
        arrAnswer = new ArrayList<>();
        mDataChild = new HashMap<>();
        dbManager = new DbManager(mContext);
        dbManager.getInterviewData();
        for (int i = 0; i < dbManager.getItemInterviewQuestions().size(); i++) {
            arrQuest.add(dbManager.getItemInterviewQuestions().get(i).getQuestionInterview());
            arrAnswer.add(dbManager.getItemInterviewQuestions().get(i).getAnswerInterview());
            //mDataChild.put(dbManager.getItemInterviewQuestions().get(i).getQuestionInterview(), dbManager.getItemInterviewQuestions().get(i).getAnswerInterview());
        }

        for (int i = 0; i < dbManager.getItemInterviewQuestions().size(); i++) {
            mDataChild.put(arrQuest.get(i), arrAnswer.get(i));
        }


    }


    @Override
    public int getGroupCount() {
        return arrQuest.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrQuest.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mDataChild.get(arrQuest.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(mContext);
            convertView = li.inflate(R.layout.interview_group_layout, parent, false);

        }

        TextView tvHeader = (TextView) convertView.findViewById(R.id.tv_header);
        tvHeader.setText(arrQuest.get(groupPosition));
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(mContext);
            convertView = li.inflate(R.layout.interview_row_layout, parent, false);
        }

        TextView txtAnswer = (TextView) convertView.findViewById(R.id.tv_question_interview);
        txtAnswer.setText(arrAnswer.get(groupPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
