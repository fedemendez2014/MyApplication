package com.tecnoinfsanjose.tareaandroiduno;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inicio.myapplication.R;

public class ActivityHome extends AppCompatActivity implements FragmentHomeCliente.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentHomeCliente fragment = new FragmentHomeCliente();
        fragmentManager.beginTransaction().replace(R.id.layouthome, fragment).addToBackStack("jmr").commit();
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
