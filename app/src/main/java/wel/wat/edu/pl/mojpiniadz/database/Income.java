package wel.wat.edu.pl.mojpiniadz.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Income {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String value;
    public String description;
    public String date;
    public String time;
    public String payment_type;
    public String category;
}
