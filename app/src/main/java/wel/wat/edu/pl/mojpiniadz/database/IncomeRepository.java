package wel.wat.edu.pl.mojpiniadz.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;
/*
Ta klasa służy do deklaracji DAO, deklaracji i inicjalizacji baz danych, inicjalizacji DAO oraz do wypisania metod.
 */
class IncomeRepository {
    private LiveData<List<Income>> allIncomes;

    // TODO 2. Deklaracja DAO
    IncomeDao incomeDao;

    IncomeRepository(@NonNull Application application) {
        // TODO 1.  Deklaracja i inicjalizacja bazy danych
        PiniadzDatabase db = PiniadzDatabase.getDatabase(application);

        // TODO 3. Inicjalizacja DAO
        incomeDao = db.incomeDao();

        allIncomes = incomeDao.getAllIncomes();
    }


    // TODO 4. metody (np. insert, delete, itp.)
    public LiveData<List<Income>> getAllIncomes() {
        return allIncomes;
    }

    public void insert(final Income word) {
        new Thread(new Runnable() {
            public void run() {
                incomeDao.insert(word);
            }
        }).start();
    }

    public void delete(final Income word) {
        new Thread(new Runnable() {
            public void run() {
                incomeDao.delete(word);
            }
        }).start();
    }
}
