package wel.wat.edu.pl.mojpiniadz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.database.Income;
import wel.wat.edu.pl.mojpiniadz.database.IncomeViewModel;

public class AddRecordActivity extends AppCompatActivity {

    IncomeViewModel incomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        getSupportActionBar().setTitle("Dodaj nowy rekord");

        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
    }

    public void addIncome(View view) {
        //1. odwołanie do widgetów
        TextInputEditText valueWidget = findViewById(R.id.value);
        TextInputEditText dateWidget = findViewById(R.id.date);
        TextInputEditText descriptionWidget = findViewById(R.id.description);

        //2. weryfikacja zawartości pól tekstowych
        if (valueWidget.getText().toString().contains(""))
            Toast.makeText(getApplicationContext(), "Podaj kwotę!", Toast.LENGTH_SHORT).show();
        if (dateWidget.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), "Podaj autora!", Toast.LENGTH_SHORT).show();
        if (descriptionWidget.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), "Podaj opis!", Toast.LENGTH_SHORT).show();

        //3. utworzenie nowej recenzji
        Income newIncome = new Income();
        newIncome.date = dateWidget.getText().toString();
        newIncome.value = valueWidget.getText().toString();
        newIncome.description = descriptionWidget.getText().toString();

        //4. pobranie ReviewDao i dodanie do bazy danych nowej recenzji
        incomeViewModel.insert(newIncome);

        //5. wyświetlenie w Toast id nowej recenzji
        Toast.makeText(getApplicationContext(), "Dodano nowy wpis!", Toast.LENGTH_SHORT).show();
    }
}
