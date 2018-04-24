package com.tecnoinfsanjose.tareaandroiduno.Views.Fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tecnoinfsanjose.tareaandroiduno.Controllers.UserControler;
import com.tecnoinfsanjose.tareaandroiduno.Views.Activity.ActivityLogin;

import java.util.ArrayList;
import java.util.List;

import inicio.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRegistrar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentRegistrar extends Fragment {

    private OnFragmentInteractionListener mListener;
    Spinner spinner;
    EditText txt1;
    EditText txt2;
    EditText txt3;
    EditText txt4;
    EditText txt5;
    EditText txt6;
    EditText txt7;
    EditText txt8;
    EditText txt9;


    public FragmentRegistrar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
      View view = inflater.inflate(R.layout.fragment_registrar, container, false);
        spinner = (Spinner) view.findViewById(R.id.spinner2);
        List<String> list = new ArrayList<>();
        list.add("Cliente");
        list.add("Empleado");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button t =(Button)view.findViewById(R.id.button3);
        t.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ActivityLogin activity = (ActivityLogin) getActivity();
                activity.onBackPressed();
            }
        });

        Button confirmar =(Button)view.findViewById(R.id.button4);
        confirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //MANEJO ERRORES
                try{
                    UserControler controller = new UserControler();
                    txt1 = (EditText) getActivity().findViewById(
                            R.id.correo);
                    txt2 = (EditText) getActivity().findViewById(
                            R.id.nombre);
                    txt3 = (EditText)getActivity().findViewById(
                            R.id.apellido);
                    txt4 = (EditText)getActivity().findViewById(
                            R.id.password);
                    txt5 = (EditText)getActivity().findViewById(
                            R.id.password2);
                    txt6 = (EditText)getActivity().findViewById(
                            R.id.documento);
                    txt7 = (EditText)getActivity().findViewById(
                            R.id.telefono);
                    txt8 = (EditText)getActivity().findViewById(
                            R.id.direccion);
                    txt9 = (EditText)getActivity().findViewById(
                            R.id.ciudad);
                    spinner = (Spinner) getActivity().findViewById(
                            R.id.spinner2);

                    controller.registrar(txt1.getText().toString(),
                                         txt2.getText().toString()
                            ,txt3.getText().toString()
                            ,txt4.getText().toString()
                            ,txt6.getText().toString()
                            ,txt7.getText().toString()
                            ,txt8.getText().toString()
                            ,txt9.getText().toString()
                            ,spinner.getSelectedItem().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("EXITO");
                    builder.setMessage("Registrado con exito");
                    builder.setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            FragmentLogin fragment = new FragmentLogin();
                            fragmentManager.beginTransaction().replace(R.id.loginlayout, fragment).addToBackStack("jmr").commit();
                            transaction.commit();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
                catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("ERROR");
                    builder.setMessage(e.getMessage());
                    builder.setNegativeButton("CERRAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
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




}
