package wel.wat.edu.pl.mojpiniadz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);

        getSupportActionBar().setTitle("Dodaj wydatek");
    }
}
