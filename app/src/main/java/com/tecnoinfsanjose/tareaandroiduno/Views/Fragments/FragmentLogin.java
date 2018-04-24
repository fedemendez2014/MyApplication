package com.tecnoinfsanjose.tareaandroiduno.Views.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tecnoinfsanjose.tareaandroiduno.Controllers.UserControler;
import com.tecnoinfsanjose.tareaandroiduno.Views.Activity.ActivityHome;
import com.tecnoinfsanjose.tareaandroiduno.Views.Activity.ActivityListView;
import com.tecnoinfsanjose.tareaandroiduno.Views.Activity.ActivityLogin;

import inicio.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentLogin.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentLogin extends Fragment {

    private OnFragmentInteractionListener mListener;

    public FragmentLogin() {
        // Required empty public constructor
    }

    ProgressDialog mProgressBar;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        TextView ir = (TextView)view.findViewById(R.id.Registrar);
        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar = new ProgressDialog(getActivity());
                mProgressBar.setCancelable(false);
                mProgressBar.setTitle("CARGANDO");
                mProgressBar.setMessage("iniciando");
                mProgressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressBar.setMax(100);
                mProgressBar.setProgress(0);
                mProgressBar.show();
                ProcessData p = new ProcessData();
                p.execute(10);
            }
        });

        TextView ir2 = (TextView)view.findViewById(R.id.registrar2);
        ir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityLogin activity = (ActivityLogin) getActivity();
                Intent in = new Intent(activity,ActivityListView.class);
                startActivity(in);
            }
        });

        Button card = (Button)view.findViewById(R.id.button5);
        card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    TextView user = (TextView) getActivity().findViewById(
                            R.id.user);
                    TextView pass = (TextView) getActivity().findViewById(
                            R.id.pass);
                    UserControler control = new UserControler();
                    control.login(user.getText().toString(), pass.getText().toString());
                    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("key", "key");
                    editor.commit();

                    ActivityLogin activity = (ActivityLogin) getActivity();
                    Intent in = new Intent(activity, ActivityHome.class);
                    startActivity(in);
                }
                catch (Exception e){

                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public class ProcessData extends AsyncTask<Integer, String, String> {

        @Override
        protected String doInBackground(Integer... integers) {
            int progress = 0;
            int total = integers[0];
            while (progress <= total) {
                try {
                    Thread.sleep(500); // medio segundo
                } catch(InterruptedException e) {

                }
                String m = "Cargando componentes";
                this.publishProgress(String.valueOf(progress), String.valueOf(total), m);
                progress++;
            }
            return "DONE";
        }
        

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            Float progress = Float.valueOf(values[0]);
            Float total = Float.valueOf(values[1]);
            String message = values[2];

            mProgressBar.setProgress((int) ((progress / total) * 100));
            mProgressBar.setMessage(message);

            if (values[0].equals(values[1])) {
                mProgressBar.cancel();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                FragmentRegistrar fragment = new FragmentRegistrar();
                fragmentManager.beginTransaction().replace(R.id.loginlayout, fragment).addToBackStack("jmr").commit();
                transaction.commit();
            }
        }
    }
}
