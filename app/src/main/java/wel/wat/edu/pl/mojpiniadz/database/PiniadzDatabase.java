package wel.wat.edu.pl.mojpiniadz.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
/*
Baza danych PiniadzBatabase.
 */
@Database(entities = {Income.class, Expense.class, Category.class}, version = 1)
public abstract class PiniadzDatabase extends RoomDatabase {

    private static PiniadzDatabase INSTANCE;

    public static PiniadzDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PiniadzDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PiniadzDatabase.class, "piniadz_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract IncomeDao incomeDao();
    public abstract ExpenseDao expenseDao();
    public abstract CategoryDao categoryDao();

}