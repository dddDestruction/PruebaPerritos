package cl.puntogestion.dogapi.view;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import cl.puntogestion.dogapi.R;

public class BotonFavoritosFragment extends Fragment {

    //Agregar parámetros
    private Button botonFavoritos;
    public BotonFavoritosFragment() {
        // Required empty public constructor
    }

    public static BotonFavoritosFragment newInstance() {
        BotonFavoritosFragment fragment = new BotonFavoritosFragment();
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
        Context context = container.getContext();
        botonFavoritos = new Button(context);
        botonFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( context,"Hice click para ver favoritos", Toast.LENGTH_LONG).show();
            }
        });
        return inflater.inflate(R.layout.fragment_boton_favoritos, container, false);
    }
}
