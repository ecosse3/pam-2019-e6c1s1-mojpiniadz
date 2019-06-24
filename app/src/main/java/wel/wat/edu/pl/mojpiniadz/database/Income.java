package wel.wat.edu.pl.mojpiniadz.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
/*
Publiczna klasa Income ma za zadanie przechowywać zmienne, które będą przechowywały później
dane wpisywane przez użytkownika. Deklarujemy tu wszystkie potrzebne zmienne i pamiętamy, żeby
były publiczne.
 */

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
