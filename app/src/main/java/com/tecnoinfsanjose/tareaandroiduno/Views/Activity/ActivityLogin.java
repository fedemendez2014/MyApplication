package com.tecnoinfsanjose.tareaandroiduno.Views.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.tecnoinfsanjose.tareaandroiduno.Views.Fragments.FragmentLogin;
import com.tecnoinfsanjose.tareaandroiduno.Views.Fragments.FragmentRegistrar;

import inicio.myapplication.R;

public class ActivityLogin extends Activity implements FragmentLogin.OnFragmentInteractionListener, FragmentRegistrar.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentLogin fragment = new FragmentLogin();
        fragmentManager.beginTransaction().replace(R.id.loginlayout, fragment).addToBackStack("jmr").commit();
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }

    }


}

