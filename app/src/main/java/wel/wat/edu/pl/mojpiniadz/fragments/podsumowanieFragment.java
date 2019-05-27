package wel.wat.edu.pl.mojpiniadz.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wel.wat.edu.pl.mojpiniadz.R;


public class podsumowanieFragment extends Fragment {

    public podsumowanieFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_podsumowanie, container, false);
    }

}
