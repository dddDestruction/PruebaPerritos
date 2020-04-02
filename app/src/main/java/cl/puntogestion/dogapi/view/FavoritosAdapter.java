package cl.puntogestion.dogapi.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import cl.puntogestion.dogapi.R;
import cl.puntogestion.dogapi.databinding.ItemImagenFavBinding;
import cl.puntogestion.dogapi.presenter.PresenterFav;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {
    private List<String> listaFav;

    private static final String TAG = "AAA";

    public FavoritosAdapter(List<String> listaFav) {
        this.listaFav = listaFav;
    }

    @NonNull
    @Override
    public FavoritosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "En onCreateViewHolder en FavoritosAdapter");
        ItemImagenFavBinding itemImagenFavBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_imagen_fav, parent, false);

        return new ViewHolder(itemImagenFavBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritosAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "En onBindViewHolder en FavoritosAdapter "+listaFav.get(position) + holder.itemImagenFavBinding.imageViewFav);
        //Picasso.get().load(listaFav.get(position)).into(holder.itemImagenFavBinding.imageViewFav);

        Glide.with(holder.itemImagenFavBinding.getRoot().getContext()) //3
                .load(listaFav.get(position))
                .centerCrop()
                .into(holder.itemImagenFavBinding.imageViewFav);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "En getItemCount en FavoritosAdapter Tamaño de lista " + listaFav.size());
        return listaFav.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ItemImagenFavBinding itemImagenFavBinding;
        public ViewHolder(@NonNull ItemImagenFavBinding itemImagenFavBinding) {
            super(itemImagenFavBinding.getRoot());
            this.itemImagenFavBinding = itemImagenFavBinding;
        }
    }

}
