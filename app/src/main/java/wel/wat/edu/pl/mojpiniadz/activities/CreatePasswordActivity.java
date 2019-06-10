package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;
import wel.wat.edu.pl.mojpiniadz.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        add=(Button)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1=editText1.getText().toString();
                String text2=editText2.getText().toString();

                if(text1.equals("") || text2.equals("")){
                    Toast.makeText(CreatePasswordActivity.this,"Nie wprowadzono żadnych haseł",Toast.LENGTH_SHORT).show();
                }else{
                    if(text1.equals(text2)){
                        //saving password
                        SharedPreferences settings=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor= settings.edit();
                        editor.putString("password",text1);
                        editor.apply();
                        //enter the app
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(CreatePasswordActivity.this,"Hasła są różne!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
