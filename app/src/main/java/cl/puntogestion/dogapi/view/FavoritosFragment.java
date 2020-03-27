package cl.puntogestion.dogapi.view;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

import cl.puntogestion.dogapi.R;
import cl.puntogestion.dogapi.databinding.FragmentFavoritosBinding;

public class FavoritosFragment extends Fragment {
    RecyclerView recyclerView;
    private FragmentFavoritosBinding favoritosBinding;
    private static final String TAG = "AAA";
    //Agregar parámetros
    private Button botonFavoritos;
    public FavoritosFragment() {
        // Required empty public constructor
    }

    public static FavoritosFragment newInstance() {
        FavoritosFragment fragment = new FavoritosFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "En OnCreateView en FavoritosFragment");
        favoritosBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_favoritos, container, false);

        Context context = favoritosBinding.getRoot().getContext();
        recyclerView = (RecyclerView) favoritosBinding.getRoot().findViewById(R.id.recyclerViewFavoritos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        FavoritosAdapter myAdaptador = new FavoritosAdapter();
        myAdaptador.setListaFav();
        recyclerView.setAdapter(myAdaptador);
        return favoritosBinding.getRoot();
    }
}
