package wel.wat.edu.pl.mojpiniadz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class zarobkiFragment extends Fragment {

    public zarobkiFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment_zarobki,container,false);
        // Inflate the layout for this fragment
        return rootView;
    }

}
