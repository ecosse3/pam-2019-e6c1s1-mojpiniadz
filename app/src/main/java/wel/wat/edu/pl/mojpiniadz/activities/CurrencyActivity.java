package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import wel.wat.edu.pl.mojpiniadz.R;
/*
Ta aktywność została stworzona do przewalutowywania swoich wydatków, zarobków i podsumowania. Miały znajdować się
tu waluty, które moglibyśmy dodawać, zmieniać ich kurs itd. Niestety nie udało nam się do tego dotrzeć.
 */
public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        getSupportActionBar().setTitle("Waluty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
