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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Listo");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        this.fragLista = ListDogFragment.newInstance(1);
        fragmentTransaction.add(R.id.frame_container, fragLista, "lista");
        fragmentTransaction.addToBackStack("lista").commit();
    }

    @Override
    public void onListFragmentInteraction(String raza) {
        Log.d(TAG, raza);
        FragmentTransaction fragmentTransactionListener = fragmentManager.beginTransaction();
        fragmentTransactionListener.remove(this.fragLista);
        DetailFragment fragment = DetailFragment.newInstance("hola", "como estas?");
        fragmentTransactionListener.add(R.id.frame_container, fragment, "detalle");
        fragmentTransactionListener.commit();
    }

    @Override
    public void onBackPressed()
    {
        if (fragmentManager.getPrimaryNavigationFragment() == this.fragLista){
            super.onBackPressed();
        }else{
            fragmentManager.popBackStack("lista", 0);
        }
    }
}
