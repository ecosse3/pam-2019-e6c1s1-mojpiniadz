package wel.wat.edu.pl.mojpiniadz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        getSupportActionBar().setTitle("Waluty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
