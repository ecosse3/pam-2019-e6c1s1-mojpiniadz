package wel.wat.edu.pl.mojpiniadz.database;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

/*
Ta klasa służy do deklaracji DAO, deklaracji i inicjalizacji baz danych, inicjalizacji DAO oraz do wypisania metod.
 */
class ExpenseRepository {
    private LiveData<List<Expense>> allExpenses;

    // TODO 2. Deklaracja DAO
    ExpenseDao expenseDao;

    ExpenseRepository(@NonNull Application application) {
        // TODO 1.  Deklaracja i inicjalizacja bazy danych
        PiniadzDatabase db = PiniadzDatabase.getDatabase(application);

        // TODO 3. Inicjalizacja DAO
        expenseDao = db.expenseDao();

        allExpenses = expenseDao.getAllExpenses();
    }


    // TODO 4. metody (np. insert, delete, itp.)
    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

    public void insert(final Expense word) {
        new Thread(new Runnable() {
            public void run() {
                expenseDao.insert(word);
            }
        }).start();
    }

    public void delete(final Expense word) {
        new Thread(new Runnable() {
            public void run() {
                expenseDao.delete(word);
            }
        }).start();
    }
}
