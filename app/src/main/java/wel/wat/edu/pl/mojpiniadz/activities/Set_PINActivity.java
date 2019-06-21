package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.activities.incomes.IncomesListActivity;

public class Set_PINActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__pin);

        getSupportActionBar().setTitle("Ustaw kod PIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }
}
