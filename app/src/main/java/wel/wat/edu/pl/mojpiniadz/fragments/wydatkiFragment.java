package wel.wat.edu.pl.mojpiniadz.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.activities.record.AddRecordActivity;

/*
Ten fragment służy do wyświetlania wcześniej dodanych wydatków jeden pod drugim. Miały zostać wprowadzone
filtry tak, aby móc sterować widokiem dodania odpowiednich pól (dzień, tydzień, miesiąc) ale nie udało się
tego zrobić.
 */
public class wydatkiFragment extends Fragment {

    public wydatkiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wydatki, container, false);

        FloatingActionButton myFab = (FloatingActionButton) view.findViewById(R.id.add_record_fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRecordActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
