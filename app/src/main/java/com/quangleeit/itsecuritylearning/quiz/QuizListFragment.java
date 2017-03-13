package com.quangleeit.itsecuritylearning.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.quangleeit.itsecuritylearning.R;
import com.quangleeit.itsecuritylearning.question.ContentQuestionActivity;

import static com.quangleeit.itsecuritylearning.R.id.list_quiz;


public class QuizListFragment extends Fragment implements AdapterView.OnItemClickListener {
    // private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ListView listQuiz;
    private QuizAdapter quizAdapter;
    DatabaseReference dref;
    //private ArrayList<ItemQuiz> arrQuiz;
    //ArrayList<String> list = new ArrayList<String>();
    //ArrayAdapter adapter;
   // private DbManager dbManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_quiz, container, false);

        quizAdapter = new QuizAdapter(getContext());
        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listQuiz = (ListView) v.findViewById(list_quiz);
        listQuiz.setOnItemClickListener(this);
        listQuiz.setAdapter(quizAdapter);


//        adapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_dropdown_item_1line, list);
//
//        listCourse.setAdapter(adapter);

        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        dref.child("S").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                list.add(dataSnapshot.getValue().toString());
//                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        // tabLayout.setupWithViewPager(viewPager);
        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this.getActivity(), ContentQuestionActivity.class);
        intent.putExtra("KeyQuiz", position+1);
        startActivity(intent);
//        Toast.makeText(this.getActivity(), arrQuiz.get(position).getTitle().toString(), Toast.LENGTH_SHORT).show();

    }
}
