package wel.wat.edu.pl.mojpiniadz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class SettingsActivity extends AppCompatActivity {

    TextView currency, categories,set_PIN,personal_data,about_prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        currency=findViewById(R.id.currency);
        categories=findViewById(R.id.categories);
        set_PIN=findViewById(R.id.set_PIN);
        personal_data=findViewById(R.id.personal_data);

        getSupportActionBar().setTitle("Ustawienia");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void click(View v) {
        Intent intent = new Intent();
        switch(v.getId()) {
            case R.id.currency: // R.id.textView1
                intent = new Intent(this, CurrencyActivity.class);
                break;
            case R.id.categories: // R.id.textView2
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.set_PIN: // R.id.textView2
                intent = new Intent(this, Set_PINActivity.class);
                break;
            case R.id.personal_data: // R.id.textView2
                intent = new Intent(this, PersonalDataActivity.class);
                break;
        }
        startActivity(intent);
    }
}
