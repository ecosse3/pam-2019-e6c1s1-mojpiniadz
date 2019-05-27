package wel.wat.edu.pl.mojpiniadz.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class IncomeViewModel extends AndroidViewModel {


    private LiveData<List<Income>> allIncomes;
    private IncomeRepository repository;

    public void insert(final Income word) {
        new Thread(new Runnable() {
            public void run() {
                repository.insert(word);
            }
        }).start();
    }

    public void delete(Income word){
        repository.delete(word);
    }

    public IncomeViewModel(@NonNull Application application) {
        super(application);

        repository = new IncomeRepository(application);

        allIncomes = repository.getAllIncomes();
    }

    public LiveData<List<Income>> getAllIncomes() {
        return allIncomes;
    }

}