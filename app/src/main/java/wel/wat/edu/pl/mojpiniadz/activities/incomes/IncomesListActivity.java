package wel.wat.edu.pl.mojpiniadz.activities.incomes;

import wel.wat.edu.pl.mojpiniadz.R;
import wel.wat.edu.pl.mojpiniadz.database.Income;
import wel.wat.edu.pl.mojpiniadz.database.IncomeAdapter;
import wel.wat.edu.pl.mojpiniadz.database.IncomeViewModel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IncomesListActivity extends AppCompatActivity {

    private IncomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomes_list);

        // TODO Deklaracja i inicjalizacja ViewModel
        final IncomeViewModel incomeViewModel;
        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);

        final Observer<List<Income>> nameObserver = new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
                adapter.setIncomes(incomes);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        incomeViewModel.getAllIncomes().observe(this, nameObserver);

        // znajdź RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // ustawienie sposobu rozmieszczenia elementów
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // utworzenie adaptera
        // zwróć uwagę, że recenzje nie są przekazywane do adaptera przez konstruktor
        // recenzje zostaną przekazane później za pomocą setReviews(...)
        adapter = new IncomeAdapter();

        // połączenie adaptera z RecyclerView
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Income toDelete = adapter.getIncome(position);
                incomeViewModel.delete(toDelete);
                Toast.makeText(getApplicationContext(), "Usunięto!", Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper;
        itemTouchHelper = new ItemTouchHelper(simpleCallback);

        itemTouchHelper.attachToRecyclerView(recyclerView);

    }
}
