package com.tecnoinfsanjose.tareaandroiduno.Views.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tecnoinfsanjose.tareaandroiduno.Clases.User;
import com.tecnoinfsanjose.tareaandroiduno.Controllers.UserControler;
import com.tecnoinfsanjose.tareaandroiduno.Persistencia.PersistenciaDB;
import com.tecnoinfsanjose.tareaandroiduno.Views.Fragments.FragmentCancelarEmpleado;
import com.tecnoinfsanjose.tareaandroiduno.Views.Fragments.FragmentConfirmarCliente;
import com.tecnoinfsanjose.tareaandroiduno.Views.Fragments.FragmentHomeCliente;
import com.tecnoinfsanjose.tareaandroiduno.Views.Fragments.FragmentHomeEmpleado;

import java.util.List;

import inicio.myapplication.R;

public class ActivityHome extends AppCompatActivity implements FragmentHomeEmpleado.OnFragmentInteractionListener,FragmentCancelarEmpleado.OnFragmentInteractionListener,FragmentHomeCliente.OnFragmentInteractionListener,FragmentConfirmarCliente.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<User> items = new UserControler().dameuser();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        for(User u: PersistenciaDB.userlist) {
            if(u.getCorreo().equals("c") || u.getCorreo().equals("e")){
                if(u.getRol() == "Cliente"){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    FragmentHomeCliente fragment = new FragmentHomeCliente();
                    fragmentManager.beginTransaction().replace(R.id.layouthome, fragment).addToBackStack("jmr").commit();
                    transaction.commit();
                }
                else{
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    FragmentHomeEmpleado fragment = new FragmentHomeEmpleado();
                    fragmentManager.beginTransaction().replace(R.id.layouthome, fragment).addToBackStack("jmr").commit();
                    transaction.commit();
                }
                }
            }
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
