package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.activities.incomes.IncomesListActivity;
/*
Ta atywność pozwala na zmianę dotychczasowego pinu. Żeby go zmienić należy wpisać obecny pin, później
nowy i powtórzyć. Jeśli któryś z warunków nie zostanie spełniony nie nastąpi zmiana pinu.

 */
public class Set_PINActivity extends AppCompatActivity {
EditText pass,oldpass,pass2;
Button add;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set__pin);
        oldpass=(EditText)findViewById(R.id.old_pass);
        pass=(EditText)findViewById(R.id.password_new);
        pass2=(EditText)findViewById(R.id.password_repeat);
        add=(Button)findViewById(R.id.change_pass);


        getSupportActionBar().setTitle("Ustaw kod PIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences settings= getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String passw2=pass2.getText().toString();
        String passw1=pass.getText().toString();
        String text=oldpass.getText().toString();

        if(text.equals(password)) {
//            Toast.makeText(getApplicationContext(), "Haslo poprawne",Toast.LENGTH_SHORT).show();
            if (passw1.equals("") || passw2.equals("")) {

            }else {
                if (passw1.equals(passw2)) {
                    SharedPreferences settings = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("password", passw1);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Hasla rozne, popraw je", Toast.LENGTH_SHORT).show();
                }

            }}
        else {
                Toast.makeText(getApplicationContext(), "Haslo niepoprawne", Toast.LENGTH_SHORT).show();
            }}


        });
    }
    }


