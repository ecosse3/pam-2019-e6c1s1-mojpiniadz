package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import wel.wat.edu.pl.mojpiniadz.R;
/*
Ta aktywność daje możliwość zmieniania i dodawania kategorii, w których będziemy umieszczać nasze wpisy.
 */
public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportActionBar().setTitle("Kategorie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
