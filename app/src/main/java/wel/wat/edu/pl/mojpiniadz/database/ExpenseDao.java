package wel.wat.edu.pl.mojpiniadz.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
/*
Tworzenie Dao - podstawowych funkcji możliwych do używania na naszej bazie danych.
 */

@Dao
public interface ExpenseDao {

    @Insert
    void insert(Expense word);

    @Delete
    void delete(Expense word);

    @Query("SELECT * from Expense")
    LiveData<List<Expense>> getAllExpenses();
}