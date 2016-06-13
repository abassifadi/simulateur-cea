package com.example.fadi.simulateurcea;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalculateurFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalculateurFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateurFragement extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view ;
    private OnFragmentInteractionListener mListener;

    public CalculateurFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculateurFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculateurFragement newInstance(String param1, String param2) {
        CalculateurFragement fragment = new CalculateurFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calculateur_fragement, container, false);
        Button btn = (Button)v.findViewById(R.id.calculate_button);
        btn.setOnClickListener(this);
        //Adding Situation Familiale to Spinner Value
        Spinner spinner = (Spinner)v.findViewById(R.id.situation_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.situation_familiale, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //Ajouter Situation Professionnel
        Spinner spinner2 = (Spinner)v.findViewById(R.id.situation_pro_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.situation_professionel, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        view = v ;
        return v ;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
           if(v.getId()== R.id.calculate_button) {
               Spinner mySpinner=(Spinner) view.findViewById(R.id.situation_spinner);
               String text = mySpinner.getSelectedItem().toString();
               int nombreEnfant = Integer.parseInt(((EditText) view.findViewById(R.id.nbr_enfant)).getText().toString()) ;
               float RevenuBrut = Float.parseFloat(((EditText) view.findViewById(R.id.revenu_annuel_net_imposable_1)).getText().toString());
               float montantCEA = Float.parseFloat(((EditText) view.findViewById(R.id.montant_cea_1)).getText().toString());
               String statutPro = ((Spinner)view.findViewById(R.id.situation_pro_spinner)).getSelectedItem().toString();
               int enf1 = 1 , enf2 = 1 , chef = 1;
               if(nombreEnfant <2) {
                   enf1 = 1 ;
                   enf2 = 0 ;
               }
               if(text.equals("Celibataire")) {
                   chef = 0 ;
                   enf1 = 0 ;
                   enf2 = 0 ;
               }

               int lib;
               if(statutPro.equals("Profession Liberale"))
               {lib=1;}
               else
                   lib=0;



               double  revenu_net = this.assietteImpossable(RevenuBrut, chef, enf1, enf2);
               double Impôt_du_avant_cea = this.impot(revenu_net);
               double minimum_impôt = Impôt_du_avant_cea * 0.6 ;
               double RnCEA = revenu_net - montantCEA;
               if((montantCEA) > 5000) {
                   montantCEA = 5000 ;
               } else {
                   //montantCEA = (montantCEA/2) ;
               }

               double impotApresCEA = this.impot(revenu_net-montantCEA);
               double gainImpotAnuuel = Impôt_du_avant_cea - impotApresCEA;
               double gainPourcentage = (gainImpotAnuuel/Impôt_du_avant_cea)*100 ;
               ResultDialogFragement rv = ResultDialogFragement.newInstance(revenu_net,Impôt_du_avant_cea,minimum_impôt,impotApresCEA,gainImpotAnuuel,gainPourcentage);
               rv.show(getFragmentManager(), "Result Tag");

           }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private double assietteImpossable(float revenu_brut, float chef, float enf1, float enf2) {
        double sal_imposable = revenu_brut ;
        double pro = sal_imposable - sal_imposable*(0.1) ;
        double x = chef*(150.) + enf1*(90.) + enf2*(75.);
        double assiette_imp = pro - x ;
        return assiette_imp ;
    }


    double[][] Imps =

            {
                    {0, 1, 0},
                    {1500,  0.15, 1500*0},
                    {5000,  0.20, 5000*0.1050},
                    {10000, 0.25, 10000*0.1525},
                    {20000, 0.30, 20000*0.2012},
                    {50000, 0.35, 20000*0.2605}
            };


    public double impot (double revenu) {
        double [] marge = {1500., 5000., 10000., 20000., 50000., 50001.} ;
        double [] coef = {0.15, 0.20, 0.25, 0.30, 0.35} ;
        double s = 0;
        List<Double> t =new ArrayList<Double>()  ;
        revenu -= (revenu > 1500.) ? 1500. : 0 ;
        for (int i = 0 ; i < marge.length-1 ; i++) {
            if (revenu > 0) {
                t.add((revenu >= marge[i + 1] - marge[i]) ? (marge[i + 1] - marge[i]) * coef[i] : revenu * coef[i]);
                revenu -= (marge[i+1]-marge[i]) ;
            } else {
                break ;
            }
        }
        for (int i = 0 ; i < t.size() ; i++) {
            s += t.get(i) ;
        }
        return Math.round (s*1000) / 1000 ;
    }
}
