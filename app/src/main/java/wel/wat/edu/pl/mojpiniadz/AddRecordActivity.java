package wel.wat.edu.pl.mojpiniadz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        getSupportActionBar().setTitle("Dodaj nowy rekord");
    }
}
