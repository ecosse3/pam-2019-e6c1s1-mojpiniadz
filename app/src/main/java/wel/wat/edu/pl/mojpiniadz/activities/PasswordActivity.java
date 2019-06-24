package wel.wat.edu.pl.mojpiniadz.activities;
import wel.wat.edu.pl.mojpiniadz.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
/*
W tej aktywności sprawdzane jest czy stworzone zostało hasło, czy nie i odesłąnie do odpowiedniej drugiej aktywności.
Jeśli nie zostało stworzone hasło, to zostaniemy przekierowani do CreatePasswordActivity, jeśli zostało stworzone
to do EnterPasswordActivity. To działanie ma na celu jednokrotne wprowadzenie hasła przez użytkownika, a
później pozwala na logowanie wykorzytsując wcześniej utworzone hasło.
 */

public class PasswordActivity extends AppCompatActivity {

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        SharedPreferences settings= getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(password.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                    startActivity(intent);
                    finish();
                } else{
                    Intent intent = new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0);
    }
}
