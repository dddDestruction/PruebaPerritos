package cl.puntogestion.dogapi.view;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cl.puntogestion.dogapi.R;
import cl.puntogestion.dogapi.model.BreedModel;
import cl.puntogestion.dogapi.presenter.IPresenterViewDetail;
import cl.puntogestion.dogapi.presenter.PresenterDetail;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment implements PresenterDetail.IPresenterViewImages, IPresenterViewDetail {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String raza;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnLongClickPerritos listener;
    RecyclerView recyclerView;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            Log.d("DDD", "la raza es " + mParam1);
            this.raza = mParam1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);

        Context context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewDetail);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        //Enlace entre vista y presentador
        PresenterDetail presentador = new PresenterDetail(this);
        presentador.setImodel(new BreedModel(presentador));
        presentador.loadBreedImages(raza);

        return view;
    }

    @Override
    public void notificar(List<String> lista) {
        Log.d("DDD", "En Adapter "+lista);
        DogPhotoRecycleViewAdapter myAdaptador = new DogPhotoRecycleViewAdapter(lista, listener);
        recyclerView.setAdapter(myAdaptador);
    }

    @Override
    public void showBreedImages(String breed) {

    }

    public interface OnLongClickPerritos {
        void OnLongClickPerritos(String urlImagen);
    }
}
