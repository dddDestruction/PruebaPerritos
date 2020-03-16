package cl.puntogestion.dogapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import cl.puntogestion.dogapi.view.DetailFragment;
import cl.puntogestion.dogapi.view.ListDogFragment;
import cl.puntogestion.dogapi.view.MyDogRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements ListDogFragment.OnListFragmentInteractionListener {

    private static final String TAG = "AAA";
    FragmentManager fragmentManager = getFragmentManager();
    ListDogFragment fragLista;
    DetailFragment fragDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Listo");
        Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        this.fragLista = ListDogFragment.newInstance(1);
        fragmentTransaction.add(R.id.frame_container, fragLista, "lista");
        fragmentTransaction.addToBackStack("lista").commit();
        Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
    }

    @Override
    public void onListFragmentInteraction(String raza) {
        Log.d(TAG, raza);
        FragmentTransaction fragmentTransactionListener = fragmentManager.beginTransaction();
        fragmentTransactionListener.remove(this.fragLista);
        fragDetalle = DetailFragment.newInstance("hola", "como estas?");
        fragmentTransactionListener.add(R.id.frame_container, fragDetalle, "detalle");
        fragmentTransactionListener.addToBackStack("detalle").commit();
        Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
    }

    @Override
    public void onBackPressed()
    {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            Log.d(TAG, "En fragLista");
            finish();
        } else {
            Log.d(TAG, "En detalle");
            Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(this.fragDetalle);
            fragmentTransaction.commit();
            getFragmentManager().popBackStack();
        }
    }
}
