package com.example.fadi.simulateurcea;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

import map.Intermediare;
import map.IntermediareGenerator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GMapFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GMapFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GMapFragement extends Fragment implements OnMapReadyCallback,LocationListener,GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int REQUEST_CODE_LOCATION = 2;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Location myLocation = null ;
    GoogleApiClient myApiClient = null ;
    GoogleMap gMap = null ;

    private OnFragmentInteractionListener mListener;

    public GMapFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GMapFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static GMapFragement newInstance(String param1, String param2) {
        GMapFragement fragment = new GMapFragement();
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
        this.myApiClient = new GoogleApiClient.Builder(this.getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        myApiClient.connect();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gmap_fragement, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_frg);
        fragment.getMapAsync(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

          this.gMap =  googleMap ;
            if (myLocation == null)
            {
                      myLocation = new Location("");
                      myLocation.setLatitude(36.8429350);
                      myLocation.setLongitude(10.1967230);
                      System.out.println("**************Here***************");
            }
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        new LatLng(myLocation.getLatitude(), myLocation.getLongitude()), 13));

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(myLocation.getLatitude(), myLocation.getLongitude()))      // Sets the center of the map to location user
                        .zoom(17)                   // Sets the zoom
                        .bearing(90)                // Sets the orientation of the camera to east
                        .tilt(40)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                googleMap.addMarker(new MarkerOptions().position(new LatLng(myLocation.getLatitude(), myLocation.getLongitude())).title("Marker"));
                IntermediareGenerator intermediaterGen  = new IntermediareGenerator();
                Vector<Intermediare> intermediaireList = intermediaterGen.getIntermedaires();
        Location locationB = new Location("point");
        Location nerest = new Location("Nearest") ;
        nerest.setLatitude(intermediaireList.elementAt(0).getLatitude());
        nerest.setLongitude(intermediaireList.elementAt(0).getLongitude());
        float distance =0;
        for (Intermediare i: intermediaireList)

        {
            locationB.setLatitude(i.getLatitude());
            locationB.setLongitude(i.getLongitude());
            distance = myLocation.distanceTo(locationB);
            if(distance< myLocation.distanceTo(nerest))
            {  //googleMap.addMarker(new MarkerOptions().position(new LatLng(i.getLatitude(), i.getLongitude())).title(i.getNom()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                nerest.setLatitude(i.getLatitude());
                nerest.setLongitude(i.getLongitude());
            }
        }

        googleMap.addMarker(new MarkerOptions().position(new LatLng(nerest.getLatitude(), nerest.getLongitude())).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
              //  googleMap.addMarker(new MarkerOptions().position(new LatLng(36.843340, 10.197796)).title("TSI").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                //googleMap.addMarker(new MarkerOptions().position(new LatLng(36.849016, 10.195920)).title("Tunisie Valeurs").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(36.843340, 10.197796)).title("TSI").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


    }

    @Override
    public void onConnected(Bundle bundle) {

        if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Request missing location permission.
            ActivityCompat.requestPermissions(this.getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_LOCATION);
        }
         myLocation =
                LocationServices.FusedLocationApi.getLastLocation(this.myApiClient);
        System.out.println("***********Location Set************** ");
        //System.out.println("***********Location To String : "+myLocation.toString());


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

        GoogleMap map = ((SupportMapFragment) this.getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.map_frg)).getMap();

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(myLocation.getLatitude(), myLocation.getLongitude()), 13));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(myLocation.getLatitude(), myLocation.getLongitude()))      // Sets the center of the map to location user
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(40)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

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
