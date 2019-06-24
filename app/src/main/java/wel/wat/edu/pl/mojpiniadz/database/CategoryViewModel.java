package wel.wat.edu.pl.mojpiniadz.database;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class CategoryViewModel extends AndroidViewModel {


    private LiveData<List<Category>> allCategories;
    private CategoryRepository repository;

    public void insert(final Category word) {
        new Thread(new Runnable() {
            public void run() {
                repository.insert(word);
            }
        }).start();
    }

    public void delete(Category word){
        repository.delete(word);
    }

    public CategoryViewModel(@NonNull Application application) {
        super(application);

        repository = new CategoryRepository(application);

        allCategories = repository.getAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }

}