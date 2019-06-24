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
Klasa CategoryAdapter służy do wczytywania widoków, wczytuje jeden wiersz, później tworzy obiekt ViewHolder, który
przechowuje odwołania.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;

    public CategoryAdapter() {
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. utwórz inflater (narzędzie do wczytywania widoków stworzonych w XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 2. wczytaj widok jednego wiersza
        View rowView = inflater.inflate(R.layout.fragment_zarobki, parent, false);

        // 3. stwórz obiek ViewHolder, który będzie trzymać odwołania
        // do elementów jednego wiersza (np. nazwy)
        CategoryAdapter.ViewHolder viewHolder = new CategoryAdapter.ViewHolder(rowView);

        // 4. zwróć nowo utworzony obiekt
        return viewHolder;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        //bindowanie danych do konkretnego wiersza
        holder.name.setText(categories.get(position).name);
        holder.icon.setText(categories.get(position).icon);
        holder.assigment.setText(categories.get(position).assigment);
        holder.id.setText(String.valueOf(categories.get(position).id));
    }

    @Override
    public int getItemCount() {
        // w momencie tworzenia adaptera nie otrzymujemy zarobku
        // dlatego categories może być nullem
        if (categories != null) {
            return categories.size();
        }

        return 0;
    }

    public Category getCategory(int index) {
        return (categories != null) ? categories.get(index) : null;
    }

    /**
     * Holder dla widoków.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //widgety
        public TextView name;
        public TextView icon;
        public TextView assigment;
        public TextView id;

        public ViewHolder(View itemView) {
            super(itemView);
            //wyszukanie widgetów
            name = itemView.findViewById(R.id.valueRow);
            icon = itemView.findViewById(R.id.dateRow);
            assigment = itemView.findViewById(R.id.descriptionRow);
            id = itemView.findViewById(R.id.idRow);
        }
    }
}