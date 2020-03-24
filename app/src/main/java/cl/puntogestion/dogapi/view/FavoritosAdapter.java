package cl.puntogestion.dogapi.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import cl.puntogestion.dogapi.R;
import cl.puntogestion.dogapi.presenter.PresenterFav;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {
    private List<String> listaFav;
    private PresenterFav presenter = new PresenterFav();
    private static final String TAG = "AAA";
    @NonNull
    @Override
    public FavoritosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "En onCreateViewHolder en FavoritosAdapter");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_imagen_fav, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritosAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "En onBindViewHolder en FavoritosAdapter "+listaFav.get(position) + holder.imagenFav);
        Picasso.get().load(listaFav.get(position)).into(holder.imagenFav);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "En getItemCount en FavoritosAdapter Tamaño de lista " + listaFav.size());
        return listaFav.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imagenFav;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenFav = itemView.findViewById(R.id.imageViewFav);
        }
    }

    public void setListaFav() {
        Log.d(TAG, "En setListFav en FavoritosAdapter");
        this.listaFav = presenter.notificarFav();
    }
}
