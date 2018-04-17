package com.tecnoinfsanjose.tareaandroiduno.Clases;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import inicio.myapplication.R;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private List<User> user;
    private static LayoutInflater inflater = null;

    public UserAdapter(Context context, List<User> user) {
        this.context = context;
        this.user = user;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return user.size();
    }

    @Override
    public Object getItem(int i) {
        return user.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        rowView = (rowView == null) ? inflater.inflate(R.layout.listview_item, null): rowView;
        TextView ivItem = (TextView) rowView.findViewById(R.id.textView13);
        TextView tvTitle = (TextView) rowView.findViewById(R.id.textView14);
        User user2 = user.get(i);
        tvTitle.setText(user2.getNombre());
        ivItem.setText(user2.getApellido());
        return rowView;
    }
}
