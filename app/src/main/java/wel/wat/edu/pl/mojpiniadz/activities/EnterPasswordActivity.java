package wel.wat.edu.pl.mojpiniadz.activities;
import wel.wat.edu.pl.mojpiniadz.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {
EditText editText;
Button login;
String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
        editText=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);

        SharedPreferences settings= getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=editText.getText().toString();

                if(text.equals(password)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Niepoprawne hasło.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
