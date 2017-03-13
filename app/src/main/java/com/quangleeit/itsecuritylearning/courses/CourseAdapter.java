package com.quangleeit.itsecuritylearning.courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.quangleeit.itsecuritylearning.DbManager;
import com.quangleeit.itsecuritylearning.R;

import java.util.ArrayList;


public class CourseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private DbManager dbManager;
    private ArrayList<ItemCourses> arrCourse;

    public CourseAdapter(Context context) {

        this.context = context;
        inflater = inflater.from(context);
        initArray();
    }

    public void initArray() {
        dbManager = new DbManager(context);
        arrCourse = new ArrayList<ItemCourses>();

        dbManager.getCourseData();
        for (int i=0; i< dbManager.getItemCourses().size(); i++){
            arrCourse.add(dbManager.getItemCourses().get(i));
        }
    }

    @Override
    public int getCount() {
        return arrCourse.size();
    }

    @Override
    public ItemCourses getItem(int position) {
        return arrCourse.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_courses, parent, false);
            TextView txt = (TextView) convertView.findViewById(R.id.txt_title_course);
            txt.setText(arrCourse.get(position).getTitle());

        }
        return convertView;
    }
}
