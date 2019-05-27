package wel.wat.edu.pl.mojpiniadz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import wel.wat.edu.pl.mojpiniadz.R;


public class SettingsActivity extends AppCompatActivity {

    LinearLayout currency_layout, categories_layout, set_pin_layout,personal_data_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        currency_layout=findViewById(R.id.currency_layout);
        categories_layout=findViewById(R.id.categories_layout);
        set_pin_layout=findViewById(R.id.set_pin_layout);
        personal_data_layout=findViewById(R.id.personal_data_layout);


        getSupportActionBar().setTitle("Ustawienia");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void click(View v) {
        Intent intent = new Intent();
        switch(v.getId()) {
            case R.id.currency_layout: // R.id.textView1
                intent = new Intent(this, CurrencyActivity.class);
                break;
            case R.id.categories_layout: // R.id.textView2
                intent = new Intent(this, CategoryActivity.class);
                break;
            case R.id.set_pin_layout: // R.id.textView2
                intent = new Intent(this, Set_PINActivity.class);
                break;
            case R.id.personal_data_layout: // R.id.textView2
                intent = new Intent(this, PersonalDataActivity.class);
                break;
        }
        startActivity(intent);
    }
}
