package wel.wat.edu.pl.mojpiniadz.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IncomeDao {

    @Insert
    void insert(Income word);

    @Delete
    void delete(Income word);

    @Query("SELECT * from Income")
    LiveData<List<Income>> getAllIncomes();
}