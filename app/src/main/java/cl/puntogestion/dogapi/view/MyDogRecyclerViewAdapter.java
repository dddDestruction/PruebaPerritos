package cl.puntogestion.dogapi.view;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import cl.puntogestion.dogapi.R;
import cl.puntogestion.dogapi.databinding.FragmentDogBinding;
import cl.puntogestion.dogapi.view.ListDogFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * Para crear un nuevo adapter
 * 1: extender de RecyclerView.Adapter o de alguna de sus subclases
 * 2: Definir el ViewHolder que será parte del adapter
 * 3: El ViewHolder debe extender de RecyclerView.ViewHolder
 * 3: implementar el método onCreateViewHolder
 *  3.A: asignar el layout utilizado en el viewHolder
 *  3.B: retornar una nueva instancia de ViewHolder
 * 4: implementar el método onBindViewHolder
 *  4.A: Dada la posición, obtener el valor a desplegar
 *  4.B: Asignar el valor dentro del viewHolder
 * 5: Implementar getItemCount devolviendo la cantidad de elementos disponibles
 *
 * 6: Definir el comportamiento del ViewHolder (asignar la información)
 */
public class MyDogRecyclerViewAdapter extends RecyclerView.Adapter<MyDogRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "MyDogRecyclerViewAdapte";
    private final List<String> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyDogRecyclerViewAdapter(List<String> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentDogBinding dogBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_dog, parent, false);
        return new ViewHolder(dogBinding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.dogBinding.itemNumber.setText(mValues.get(position));
        Log.i("Valor holderItem", holder.toString());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private String getId(int position){
        return position != RecyclerView.NO_POSITION ? mValues.get(position) : "No";
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final FragmentDogBinding dogBinding;

        public ViewHolder(FragmentDogBinding dogBinding) {
            super(dogBinding.getRoot());
            this.dogBinding = dogBinding;
            this.dogBinding.getRoot().setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + dogBinding.toString() + "'";
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick entrando...");
            mListener.onListFragmentInteraction(getId(getAdapterPosition()));
        }

    }
}
