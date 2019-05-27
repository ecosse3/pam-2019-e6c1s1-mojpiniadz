package wel.wat.edu.pl.mojpiniadz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

<<<<<<< HEAD:app/src/main/java/wel/wat/edu/pl/mojpiniadz/fragments/zarobkiFragment.java
import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.activities.record.AddRecordActivity;

=======
>>>>>>> master:app/src/main/java/wel/wat/edu/pl/mojpiniadz/zarobkiFragment.java

public class zarobkiFragment extends Fragment {

    public zarobkiFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zarobki, container, false);

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
