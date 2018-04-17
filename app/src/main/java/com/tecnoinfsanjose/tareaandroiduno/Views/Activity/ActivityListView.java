package com.tecnoinfsanjose.tareaandroiduno.Views.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.tecnoinfsanjose.tareaandroiduno.Clases.User;
import com.tecnoinfsanjose.tareaandroiduno.Clases.UserAdapter;
import com.tecnoinfsanjose.tareaandroiduno.Controllers.UserControler;

import java.util.List;

import inicio.myapplication.R;

public class ActivityListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.listview);
        List<User> items = new UserControler().dameuser();
        listView.setAdapter(new UserAdapter(this, items));
    }
}
