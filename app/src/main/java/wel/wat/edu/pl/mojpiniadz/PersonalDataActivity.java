package wel.wat.edu.pl.mojpiniadz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PersonalDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        getSupportActionBar().setTitle("Dane użytkownika");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
