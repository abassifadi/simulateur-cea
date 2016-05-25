package com.example.fadi.simulateurcea;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultDialogFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultDialogFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultDialogFragement extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int revenuAnnuelNetImposable;

    //Adding Method To Pass Data
    static ResultDialogFragement newInstance(int revenuAnnuelNetImposable) {
        ResultDialogFragement f = new ResultDialogFragement();
        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("revenuAnnuelNetImposable", revenuAnnuelNetImposable);
        f.setArguments(args);

        return f;
    }


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ResultDialogFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultDialogFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultDialogFragement newInstance(String param1, String param2) {
        ResultDialogFragement fragment = new ResultDialogFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        revenuAnnuelNetImposable = getArguments().getInt("revenuAnnuelNetImposable");

    }


    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Revenu Net Imosable
        TextView tv = (TextView) view.findViewById(R.id.revenu_annuel_net_imposable);
        tv.setText(""+this.revenuAnnuelNetImposable);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result_dialog_fragement, container);
        return v ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
