package cl.puntogestion.dogapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import cl.puntogestion.dogapi.view.ListDogFragment;
import cl.puntogestion.dogapi.view.MyDogRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements ListDogFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(List<String> lista) {

    }
}
