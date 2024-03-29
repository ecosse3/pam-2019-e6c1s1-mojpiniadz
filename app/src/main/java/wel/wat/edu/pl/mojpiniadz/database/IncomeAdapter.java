package wel.wat.edu.pl.mojpiniadz.database;

import wel.wat.edu.pl.mojpiniadz.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/*
Klasa IncomeAdapter służy do wczytywania widoków, wczytuje jeden wiersz, później tworzy obiekt ViewHolder, który
przechowuje odwołania.
 */
public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder> {

    private List<Income> incomes;

    public IncomeAdapter() {
    }

    @NonNull
    @Override
    public IncomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. utwórz inflater (narzędzie do wczytywania widoków stworzonych w XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 2. wczytaj widok jednego wiersza
        View rowView = inflater.inflate(R.layout.fragment_zarobki, parent, false);

        // 3. stwórz obiek ViewHolder, który będzie trzymać odwołania
        // do elementów jednego wiersza (np. nazwy)
        IncomeAdapter.ViewHolder viewHolder = new IncomeAdapter.ViewHolder(rowView);

        // 4. zwróć nowo utworzony obiekt
        return viewHolder;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeAdapter.ViewHolder holder, int position) {
        //bindowanie danych do konkretnego wiersza
        holder.value.setText(incomes.get(position).value);
        holder.date.setText(incomes.get(position).date);
        holder.description.setText(incomes.get(position).description);
        holder.id.setText(String.valueOf(incomes.get(position).id));
    }

    @Override
    public int getItemCount() {
        // w momencie tworzenia adaptera nie otrzymujemy zarobku
        // dlatego incomes może być nullem
        if (incomes != null) {
            return incomes.size();
        }

        return 0;
    }

    public Income getIncome(int index) {
        return (incomes != null) ? incomes.get(index) : null;
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