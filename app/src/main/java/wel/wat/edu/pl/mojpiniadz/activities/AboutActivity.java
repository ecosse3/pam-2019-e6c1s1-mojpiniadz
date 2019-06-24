package wel.wat.edu.pl.mojpiniadz.activities;
/*
Ta aktywność słuzy do wyświetlenia informacji o aplikacji- do czego służy, kto ją stworzył. Podgląd znajduje się
w activity_about.xml
 */
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import wel.wat.edu.pl.mojpiniadz.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle(getString(R.string.about));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
