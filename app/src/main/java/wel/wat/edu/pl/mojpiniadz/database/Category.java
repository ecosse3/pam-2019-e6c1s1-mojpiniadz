package wel.wat.edu.pl.mojpiniadz.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
/*
Publiczna klasa Category ma za zadanie przechowywać zmienne, które będą przechowywały później
dane wpisywane przez użytkownika. Deklarujemy tu wszystkie potrzebne zmienne i pamiętamy, żeby
były publiczne.
 */

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String icon;
    public String assigment;
}
