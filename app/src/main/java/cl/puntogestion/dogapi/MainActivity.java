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

/*
La idea de este código es que se pueda navegar por la app correctament, es decir que cuando se precione una raza
aparezca sólo el fragmento detalle y al apretar "volver" que vuelva a la lista sin el fragmento detalle y luego se
cierre la aplicación.
 */
public class MainActivity extends AppCompatActivity implements ListDogFragment.OnListFragmentInteractionListener, DetailFragment.OnLongClickPerritos {
    //TAG de los Log.d para poder identificarlos
    private static final String TAG = "AAA";
    /*
    Se crea una isntancia del FragmentManager para ser utilizado en todos los métodos del MainActivity
    El FragmentManager es una clase que guarda los fragmentos que se agregan a él y las transacciones
     y permite realizar operaciones
    sobre ellos, tales como removerlos o reemplazar uno por otro en las actividades
    Las transacciones son operaciones de fagmentos que se ejecutan cuando se commitean, luego de eso no se pueden usar.

     */
    FragmentManager fragmentManager = getFragmentManager();
    //Se crean variables de fragmento de lista de razas y detalle de raza para utilizar las mismas en cada método de la actividad
    ListDogFragment fragLista;
    DetailFragment fragDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Listo");
        //En el siguiente log se busca saber la cantidad de transacciones agregadas al "BackStack".
        Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
        //Se inicia una nueva trasacción
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //Se crea una isntancia de fragmento de lista de raza y se asigna al atributo de clase
        this.fragLista = ListDogFragment.newInstance(1);
        //Se agrega el fragmento junto con el contenedor asociado y una tag para identificarlo al FragmentManager
        fragmentTransaction.add(R.id.frame_container, fragLista, "lista");
        //Se commitean las operaciones de la transacción y se agrega la misma al FragmentManager con .addToBackStack
        fragmentTransaction.commit();
        //Se busca saber si funciona el agregar al BackStack
        Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
    }

    //Este es el listener de la actividad, este método se ejecuta cuando se hace un click sobre una raza
    @Override
    public void onListFragmentInteraction(String raza) {
        Log.d(TAG, raza);
        //Se crea una nueva transacción
        FragmentTransaction fragmentTransactionListener = fragmentManager.beginTransaction();
        //Se elimina la el fragmento del FragmenManager
        fragmentTransactionListener.remove(this.fragLista);
        //Se crea un fragmento de Detalle de raza
        String subRaza = "";
        if (raza.contains(" ")){


            subRaza = raza.split(" ")[1];
            raza = raza.split(" ")[0];
            Log.d("DDD", "raza cortado " + raza);
            Log.d("DDD", "subRaza cortado " + subRaza);
            raza = raza + "/" + subRaza;
            Log.d("DDD", "concatenado " + raza);
        }
        fragDetalle = DetailFragment.newInstance(raza, subRaza);
        //Se agrega el fragmento al FragmentManager
        fragmentTransactionListener.add(R.id.frame_container, fragDetalle, "detalle");
        //Se Agrega la transacción al FragmentManager con el nombre "detalle" para identificarlo y se commitea
        fragmentTransactionListener.addToBackStack("detalle").commit();
    }
    /*
    Aquí se busca programar las acciones que se realizan por la app cuando se apreta el botón voler del celular
    Esta parte del código todavía no me queda muy claro como funciona.
    El método onBackPressed() es parte del ciclo de vida de las actividades por lo que se implementa a partir
    de la clase AppCompatActivity de la cual extiende esta clase, por eso tiene @Override encima.

     */
    @Override
    public void onBackPressed()
    {
        /*Crea variable entera con la cantidad de transacciones en el BackStack.
        La idea es que si tiene más de 0 es porque la applicación se encuentra mostrando el detalle de la raza
        por que ese fragmento se muestra después del otro, si el valor es 0 debería estar en el inicio
        por lo tanto se debería cerrar la aplicación
        */
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            Log.d(TAG, "En fragLista");
            //finish() es para cerrar la aplicación
            finish();
        } else {
            //En cualquier otro case se asume que se esta mostrando el fragmento detalle,.
            Log.d(TAG, "En detalle");
            //Se muestra vuelve a realizar la última transacción
            getFragmentManager().popBackStack();
            Log.d(TAG, "count" + getFragmentManager().getBackStackEntryCount());
        }
    }

    @Override
    public void OnLongClickPerritos(String urlImagen) {

    }
}
