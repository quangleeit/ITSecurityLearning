package com.quangleeit.itsecuritylearning.courses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.quangleeit.itsecuritylearning.R;


public class CoursesListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private TabLayout tabLayout;
    //private ViewPager viewPager;
    private ListView listCourse;
    TextView txt;

    DatabaseReference dref;
    //    ArrayList<String> list = new ArrayList<String>();
//    ArrayAdapter adapter;
    private CourseAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        View v = layoutInflater.inflate(R.layout.fragment_item_favorite, container, false);

        mAdapter = new CourseAdapter(getContext());
        //viewPager = (ViewPager) v.findVById(R.id.viewpager);
        listCourse = (ListView) v.findViewById(R.id.listCourse);
        listCourse.setOnItemClickListener(this);
        // mAdapter.notifyDataSetChanged();


//        adapter = new ArrayAdapter(v.getContext(), android.R.layout.simple_list_item_1, list);
//        adapter.notifyDataSetChanged();


        // adapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_dropdown_item_1line, list);

        listCourse.setAdapter(mAdapter);

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
        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        // tabLayout.setupWithViewPager(viewPager);
        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this.getActivity(), Course.class);
        startActivity(intent);
//        Toast.makeText(this.getActivity(), arrCourse.get(position).getTitle().toString(), Toast.LENGTH_SHORT).show();
//        Log.d("TAG", "___________________________");
    }
}
