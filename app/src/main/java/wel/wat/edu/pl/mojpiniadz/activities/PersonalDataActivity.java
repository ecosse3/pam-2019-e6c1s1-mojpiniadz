package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import wel.wat.edu.pl.mojpiniadz.R;
/*
Ta aktywność służy do wyboru nazwy naszego użytkownika, która potem używana jest do powitania podczas logowania.
Zostałą stworzona przez SharedPreferences. Zostały tu stworzone dwie metody: DisplayName i SaveName,
które służą odpowiednio do wyświetlania imienia w odpowiednich TextView oraz do zapisu aktualnego imienia.
Po zmianie imienia tylko nowe zostaje pamiętane.
 */

public class PersonalDataActivity extends AppCompatActivity {

   private EditText editText1;
   private Button add;
   private TextView v;

    private static final String SHARED_PREF_NAME="username";
    private static final String KEY_NAME="key_username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        editText1=(EditText)findViewById(R.id.add_name);
        add=(Button)findViewById(R.id.add_personal_data);
        v=(TextView)findViewById(R.id.text);


        displayName();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();

            }
        });
    }

    private void displayName(){
        SharedPreferences sp=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name= sp.getString(KEY_NAME, null);

        if(name != null ){
            v.setText("Witaj " + name);
        }

    }
    private void saveName(){
        String name=editText1.getText().toString().trim();

        if(name.isEmpty()){
            Toast.makeText(getApplicationContext(),"Uzupełnij obie informacje!", Toast.LENGTH_SHORT).show();
        }else {
            SharedPreferences sp= getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
            SharedPreferences.Editor e=sp.edit();
            e.putString(KEY_NAME, name);
            e.apply();
            editText1.setText("");


            displayName();
        }
    }
}



