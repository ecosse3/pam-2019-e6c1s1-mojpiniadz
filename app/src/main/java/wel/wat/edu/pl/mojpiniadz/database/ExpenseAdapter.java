package wel.wat.edu.pl.mojpiniadz.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import wel.wat.edu.pl.mojpiniadz.R;

import java.util.List;

/*
Klasa ExpenseAdapter służy do wczytywania widoków, wczytuje jeden wiersz, później tworzy obiekt ViewHolder, który
przechowuje odwołania.
 */
public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private List<Expense> expenses;

    public ExpenseAdapter() {
    }

    @NonNull
    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. utwórz inflater (narzędzie do wczytywania widoków stworzonych w XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 2. wczytaj widok jednego wiersza
        View rowView = inflater.inflate(R.layout.fragment_zarobki, parent, false);

        // 3. stwórz obiek ViewHolder, który będzie trzymać odwołania
        // do elementów jednego wiersza (np. nazwy)
        ExpenseAdapter.ViewHolder viewHolder = new ExpenseAdapter.ViewHolder(rowView);

        // 4. zwróć nowo utworzony obiekt
        return viewHolder;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ViewHolder holder, int position) {
        //bindowanie danych do konkretnego wiersza
        holder.value.setText(expenses.get(position).value);
        holder.date.setText(expenses.get(position).date);
        holder.description.setText(expenses.get(position).description);
        holder.id.setText(String.valueOf(expenses.get(position).id));
    }

    @Override
    public int getItemCount() {
        // w momencie tworzenia adaptera nie otrzymujemy zarobku
        // dlatego expenses może być nullem
        if (expenses != null) {
            return expenses.size();
        }

        return 0;
    }

    public Expense getExpense(int index) {
        return (expenses != null) ? expenses.get(index) : null;
    }

    /**
     * Holder dla widoków.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //widgety
        public TextView value;
        public TextView date;
        public TextView description;
        public TextView id;

        public ViewHolder(View itemView) {
            super(itemView);
            //wyszukanie widgetów
            value = itemView.findViewById(R.id.valueRow);
            date = itemView.findViewById(R.id.dateRow);
            description = itemView.findViewById(R.id.descriptionRow);
            id = itemView.findViewById(R.id.idRow);
        }
    }
}