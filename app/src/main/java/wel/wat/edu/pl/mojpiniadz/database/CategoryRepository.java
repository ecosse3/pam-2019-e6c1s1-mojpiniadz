package wel.wat.edu.pl.mojpiniadz.database;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

/*
Ta klasa służy do deklaracji DAO, deklaracji i inicjalizacji baz danych, inicjalizacji DAO oraz do wypisania metod.
 */
class CategoryRepository {
    private LiveData<List<Category>> allCategories;

    // TODO 2. Deklaracja DAO
    CategoryDao categoryDao;

    CategoryRepository(@NonNull Application application) {
        // TODO 1.  Deklaracja i inicjalizacja bazy danych
        PiniadzDatabase db = PiniadzDatabase.getDatabase(application);

        // TODO 3. Inicjalizacja DAO
        categoryDao = db.categoryDao();

        allCategories = categoryDao.getAllCategories();
    }


    // TODO 4. metody (np. insert, delete, itp.)
    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

    public void insert(final Category word) {
        new Thread(new Runnable() {
            public void run() {
                categoryDao.insert(word);
            }
        }).start();
    }

    public void delete(final Category word) {
        new Thread(new Runnable() {
            public void run() {
                categoryDao.delete(word);
            }
        }).start();
    }
}
