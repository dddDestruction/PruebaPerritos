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
import cl.puntogestion.dogapi.model.FirebaseModel;
import cl.puntogestion.dogapi.presenter.PresenterFav;

public class FavoritosFragment extends Fragment implements PresenterFav.IPresenterFavView {
    RecyclerView recyclerView;
    private FragmentFavoritosBinding favoritosBinding;
    private static final String TAG = "AAA";
    private PresenterFav presenter;

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
        presenter = new PresenterFav(this);
        presenter.setiFirebaseModel(new FirebaseModel(presenter));
        presenter.showFavBreedImages();
        Context context = favoritosBinding.getRoot().getContext();
        recyclerView = (RecyclerView) favoritosBinding.getRoot().findViewById(R.id.recyclerViewFavoritos);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));

        return favoritosBinding.getRoot();
    }

    @Override
    public void notificarFav(List<String> urls) {
        FavoritosAdapter myAdaptador = new FavoritosAdapter(urls);
        recyclerView.setAdapter(myAdaptador);
    }
}
