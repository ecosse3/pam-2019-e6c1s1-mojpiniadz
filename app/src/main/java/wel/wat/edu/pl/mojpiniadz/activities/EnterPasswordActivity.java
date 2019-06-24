package wel.wat.edu.pl.mojpiniadz.activities;
import wel.wat.edu.pl.mojpiniadz.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
Ta aktywność pozwala na wpisanie hasłą i zweryfikowanie go. Jeśli jest poprawne, to zostaniemy przekierowani do
MainActivity, jeśli nie, zostanie wyświetlony Toast informujący o błędnym haśle.
 */
public class EnterPasswordActivity extends AppCompatActivity {
EditText editText;
Button login;
String password;
TextView hello;

    private static final String SHARED_PREF_NAME="username";
    private static final String KEY_NAME="key_username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
        editText=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        hello=(TextView)findViewById(R.id.Hello);

        displayName();

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
    private void displayName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(KEY_NAME, null);

        if (name != null) {
            hello.setText("Witaj " + name);
        }
    }
    }
