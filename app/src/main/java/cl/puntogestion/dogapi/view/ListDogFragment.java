package cl.puntogestion.dogapi.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cl.puntogestion.dogapi.model.BreedModel;
import cl.puntogestion.dogapi.presenter.Presenter;
import cl.puntogestion.dogapi.R;

public class ListDogFragment extends Fragment implements Presenter.IPresenterViewList {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListDogFragment() {
    }

    public static ListDogFragment newInstance(int columnCount) {
        ListDogFragment fragment = new ListDogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dog_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            mListener = (OnListFragmentInteractionListener) context;
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            Presenter presentador = new Presenter(this);
            presentador.setImodel(new BreedModel(presentador));
            presentador.loadBreeds();
        }
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void notificar(List<String> lista) {
        Log.d("Datos", ""+lista);
        MyDogRecyclerViewAdapter myAdaptador = new MyDogRecyclerViewAdapter(lista, mListener );
        recyclerView.setAdapter(myAdaptador);
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(String raza);
    }
}
