package cl.puntogestion.dogapi.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import cl.puntogestion.dogapi.R;


public class DogPhotoRecycleViewAdapter  extends RecyclerView.Adapter<DogPhotoRecycleViewAdapter.ViewHolderImages> {

    private ImageView imagenes;
    private final String TAG = "DDD";
    private List<String> mUrls;
    DetailFragment.OnLongClickPerritos mListener;

    public DogPhotoRecycleViewAdapter(List<String> mUrls, DetailFragment.OnLongClickPerritos mListener) {
        this.mUrls = mUrls;
        this.mListener = mListener;
    }

    @Override
    public String toString() {
        return "DogPhotoRecycleViewAdapter{" +
                "mUrls=" + mUrls +
                ", mListener=" + mListener +
                '}';
    }

    @NonNull
    @Override
    public DogPhotoRecycleViewAdapter.ViewHolderImages onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_imagenes, parent, false);
        return new ViewHolderImages(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogPhotoRecycleViewAdapter.ViewHolderImages holder, int position) {
        Log.d(TAG, "onBindDetail");
        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.perrito);

       Glide.with(holder.perrito.getContext()) //3
                .load(mUrls.get(position))
                .centerCrop()
                .into(holder.perrito);


    }

    @Override
    public int getItemCount() {
        return mUrls.size();
    }

    private String getUrl(int position){
        return position != RecyclerView.NO_POSITION ? mUrls.get(position) : "No";
    }

    public class ViewHolderImages extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        public final ImageView perrito;

        public ViewHolderImages(@NonNull View itemView) {
            super(itemView);
            perrito = itemView.findViewById(R.id.imageView);
            itemView.setOnLongClickListener(this);
            perrito.setOnLongClickListener(this);
        }

        @Override
        public String toString() {
            return "ViewHolderImages{" +
                    "perrito=" + perrito +
                    ", itemView=" + itemView +
                    '}';
        }

        @Override
        public boolean onLongClick(View v) {
            Log.d(TAG, "onLongClick entrando...");
            mListener.OnLongClickPerritos(getUrl(getAdapterPosition()));
            return false;
        }
    }

}
