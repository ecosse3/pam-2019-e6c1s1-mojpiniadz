package wel.wat.edu.pl.mojpiniadz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Set_PINActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__pin);

        getSupportActionBar().setTitle("Ustaw kod PIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
