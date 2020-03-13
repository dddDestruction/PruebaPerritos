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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(String raza) {
        Log.d("AAAAAAAAAAA", raza);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetailFragment fragment = new DetailFragment();
        fragmentTransaction.add(R.id.fragment, fragment, "FRAGMENT_DE_DETALLE");
        fragmentTransaction.commit();
    }
}
