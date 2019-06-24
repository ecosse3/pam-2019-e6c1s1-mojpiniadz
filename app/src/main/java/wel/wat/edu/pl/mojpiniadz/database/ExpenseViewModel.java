package wel.wat.edu.pl.mojpiniadz.database;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class ExpenseViewModel extends AndroidViewModel {


    private LiveData<List<Expense>> allExpenses;
    private ExpenseRepository repository;

    public void insert(final Expense word) {
        new Thread(new Runnable() {
            public void run() {
                repository.insert(word);
            }
        }).start();
    }

    public void delete(Expense word){
        repository.delete(word);
    }

    public ExpenseViewModel(@NonNull Application application) {
        super(application);

        repository = new ExpenseRepository(application);

        allExpenses = repository.getAllExpenses();
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

}