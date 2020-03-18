package cl.puntogestion.dogapi.view;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private static final String ARG_PARAM1 = "raza";

    private String raza;
    private String subRaza;
    private OnLongClickPerritos listener;
    RecyclerView recyclerView;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String raza) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, raza);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            raza = getArguments().getString(ARG_PARAM1);
            Log.d("DDD", "la raza es En DetailFragment" + raza);
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
        TextView titulo = view.findViewById(R.id.raza);
        TextView subTitulo = view.findViewById(R.id.subraza);
        listener = (OnLongClickPerritos) context;
        //Enlace entre vista y presentador
        PresenterDetail presentador = new PresenterDetail(this);
        presentador.setImodel(new BreedModel(presentador));


        if (raza.contains(" ")){
            subRaza = raza.split(" ")[1];
            raza = raza.split(" ")[0];
            Log.d("DDD", "raza cortado " + raza);
            Log.d("DDD", "subRaza cortado " + subRaza);
            presentador.loadSubBreedImages(raza, subRaza);

            titulo.setText(raza);
            subTitulo.setText(subRaza);
        }else{
            presentador.loadBreedImages(raza);
            titulo.setText(raza);
            subTitulo.setText("");
        }


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
